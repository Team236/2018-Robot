package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MotionMagic extends Command {

	private double distance;
	private double margin;
	private double error;

	public MotionMagic(double _distance, double _margin) {
		requires(Robot.drive);

		this.distance = _distance;
		this.margin = _margin;

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

		Robot.drive.resetEncoders();

		Robot.drive.setMotnCV(AutoMap.M_MAGIC_CV);
		Robot.drive.setMotnAccel(AutoMap.M_MAGIC_ACCL);

		Robot.drive.setkPMM(AutoMap.M_MAGIC_K_P);
		Robot.drive.setkIMM(AutoMap.M_MAGIC_K_I);
		Robot.drive.setkDMM(AutoMap.M_MAGIC_K_D);
		Robot.drive.setkFMM_L(AutoMap.M_MAGIC_K_F_R);
		Robot.drive.setkFMM_R(AutoMap.M_MAGIC_K_F_R);
		
		System.out.print("Initializing Motion Magic");

		Robot.drive.setRightDistMotion(distance / RobotMap.DriveMap.DISTANCE_PER_PULSE);
		Robot.drive.setLeftDistMotion(distance / RobotMap.DriveMap.DISTANCE_PER_PULSE);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// double currentDistance = -Robot.drive.getLeftDistance() *
		// RobotMap.DriveMap.DISTANCE_PER_PULSE;
		double currentDistance = Robot.drive.getRightDistance();
		error = Math.abs(distance - currentDistance);
		SmartDashboard.putNumber("currentdistance ", currentDistance);
		// SmartDashboard.putNumber("distance ", distance);
		SmartDashboard.putNumber("MM Error", error);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		boolean inSpeedMargin = Robot.drive.getRightSpeed() < 1.0;
		boolean inDistMargin = error < margin;

		// SmartDashboard.putNumber("Speed", Robot.drive.getRightSpeed());
		// SmartDashboard.putNumber("MM error = ", error);
		return ((inSpeedMargin) && (inDistMargin));
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.stop();
		System.out.println("Motn Magic Is Finished");

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
