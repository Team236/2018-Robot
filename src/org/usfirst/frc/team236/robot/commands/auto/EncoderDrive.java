package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderDrive extends Command {

	public static final double MARGIN = 1;

	double leftDistance, rightDistance;
	double leftSpeed, rightSpeed;

	public EncoderDrive(double _leftDistance, double _leftSpeed, double _rightDistance, double _rightSpeed) {
		requires(Robot.drive);

		this.leftDistance = _leftDistance;
		this.rightDistance = _rightDistance;
		this.leftSpeed = _leftSpeed;
		this.rightSpeed = _rightSpeed;
	}

	protected void initialize() {
		Robot.drive.resetEncoders();
	}

	protected void execute() {
		Robot.drive.setLeftSpeed(leftSpeed);
		Robot.drive.setRightSpeed(rightSpeed);
	}

	protected boolean isFinished() {
		double leftError = Math.abs(Robot.drive.getLeftDistance() - leftDistance);
		double rightError = Math.abs(Robot.drive.getRightDistance() - rightDistance);
		
		return (leftError < MARGIN) && (rightError < MARGIN);
	}

	protected void end() {
		Robot.drive.stop();
	}

	protected void interrupted() {
		end();
	}
}
