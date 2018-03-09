package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
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
public class CenterLeftSwitchPathfinder extends Command {

	Trajectory.Config config;
	Trajectory center, left, right;
	TankModifier modifier;
	EncoderFollower leftFollower, rightFollower;
	
	int i;
	
	public CenterLeftSwitchPathfinder() {
		requires(Robot.drive);
		
		config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, .02, 50, 100, 500);
		center = Pathfinder.generate(AutoMap.CENTER_LEFT_SWITCH, config);
		modifier = new TankModifier(center);
		modifier.modify(RobotMap.DriveMap.WHEEL_TRACK);
		
		left = modifier.getLeftTrajectory();
		right = modifier.getRightTrajectory();
		
		leftFollower = new EncoderFollower(left);
		rightFollower = new EncoderFollower(right);
		
		leftFollower.configureEncoder(0, RobotMap.DriveMap.PULSE_PER_ROTATION, RobotMap.DriveMap.DIAMETER);
		rightFollower.configureEncoder(0, RobotMap.DriveMap.PULSE_PER_ROTATION, RobotMap.DriveMap.DIAMETER);
		
		// PID constants
		//leftFollower.configurePIDVA(kp, ki, kd, kv, ka);
		//rightFollower.configurePIDVA(kp, ki, kd, kv, ka);
	}

	protected void initialize() {
		Robot.drive.stop();
		Robot.drive.resetEncoders();
		Robot.drive.navx.reset();

		i = 0;
	}

	protected void execute() {
		i++;
		double leftSpeed = leftFollower.calculate(Robot.drive.getLeftEncoder());
		double rightSpeed = rightFollower.calculate(Robot.drive.getRightEncoder());
		
		double heading = Robot.drive.navx.getAngle();
		double setHeading = Pathfinder.r2d(leftFollower.getHeading());
		double dAngle = Pathfinder.boundHalfDegrees(setHeading - heading);
		double turnAdjustment = RobotMap.DriveMap.kTurn * dAngle;
		
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
