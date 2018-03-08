package org.usfirst.frc.team236.robot.commands.drive;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubedDriveWithJoysticks extends Command {

	public CubedDriveWithJoysticks() {
		requires(Robot.drive);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.drive.setLeftSpeed(Math.pow(-Robot.oi.leftStick.getY(), 3));
		Robot.drive.setRightSpeed(Math.pow(-Robot.oi.rightStick.getY(), 3));
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drive.stop();
	}

	protected void interrupted() {
		end();
	}
}
