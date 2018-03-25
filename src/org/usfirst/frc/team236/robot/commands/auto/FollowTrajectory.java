package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class FollowTrajectory extends Command {

	Trajectory.Config config;
	Trajectory center, left, right;
	TankModifier modifier;
	EncoderFollower leftFollower, rightFollower;

	boolean isReverse;
	int reverseMultiplier = 1;

	double heading, setHeading, dAngle, turnAdjustment;
	double leftSpeed, rightSpeed;
	
	public FollowTrajectory(Trajectory _traj) {
		this(_traj, false);
	}

	public FollowTrajectory(Trajectory _traj, boolean _isReverse) {
		requires(Robot.drive);

		center = _traj;
		isReverse = _isReverse;

		if (isReverse) {
			reverseMultiplier = -1;
		}

		TankModifier modifier = new TankModifier(center);
		modifier.modify(RobotMap.DriveMap.WHEEL_TRACK);

		left = modifier.getLeftTrajectory();
		right = modifier.getRightTrajectory();

		leftFollower = new EncoderFollower(left);
		rightFollower = new EncoderFollower(right);

		leftFollower.configureEncoder(0, RobotMap.DriveMap.PULSE_PER_ROTATION, RobotMap.DriveMap.DIAMETER);
		rightFollower.configureEncoder(0, RobotMap.DriveMap.PULSE_PER_ROTATION, RobotMap.DriveMap.DIAMETER);

		// PID constants
		//@formatter:off
		leftFollower.configurePIDVA(
				RobotMap.DriveMap.Pathfinder.kP, 
				RobotMap.DriveMap.Pathfinder.kI, 
				RobotMap.DriveMap.Pathfinder.kD, 
				RobotMap.DriveMap.Pathfinder.kV, 
				RobotMap.DriveMap.Pathfinder.kA
		);
		rightFollower.configurePIDVA(
				RobotMap.DriveMap.Pathfinder.kP, 
				RobotMap.DriveMap.Pathfinder.kI, 
				RobotMap.DriveMap.Pathfinder.kD, 
				RobotMap.DriveMap.Pathfinder.kV, 
				RobotMap.DriveMap.Pathfinder.kA
		);
		//@formatter:on
	}

	protected void initialize() {
		Robot.drive.stop();
		Robot.drive.resetEncoders();
		Robot.drive.navx.reset();

	}

	protected void execute() {
		if (isReverse) {
			rightSpeed = leftFollower.calculate(-Robot.drive.getLeftEncoder());
			leftSpeed = rightFollower.calculate(-Robot.drive.getRightEncoder());
		} else {
			leftSpeed = leftFollower.calculate(Robot.drive.getLeftEncoder());
			rightSpeed = rightFollower.calculate(Robot.drive.getRightEncoder());
		}

		heading = Robot.drive.navx.getAngle();
		setHeading = Pathfinder.r2d(leftFollower.getHeading());
		dAngle = Pathfinder.boundHalfDegrees(setHeading - heading);
		turnAdjustment = RobotMap.DriveMap.Pathfinder.kTurn * dAngle;

		Robot.drive.setLeftSpeed(leftSpeed + turnAdjustment);
		Robot.drive.setRightSpeed(rightSpeed - turnAdjustment);
	}

	protected boolean isFinished() {
		return leftFollower.isFinished() && rightFollower.isFinished();
	}

	protected void end() {
		Robot.drive.stop();
	}

	protected void interrupted() {
		end();
	}
}
