package org.usfirst.frc.team236.robot.commands.climber;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ScissorsWithThumbstick extends Command {

	public static final double SCALE_FACTOR = 1.0;

	public ScissorsWithThumbstick() {
		requires(Robot.climber);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// LEFT IS NEGATIVE
	// RIGHT IS POSITIVE
	protected void execute() {
		double speed = Robot.oi.controller.getLeftX() * SCALE_FACTOR;
		boolean isLeft = Robot.climber.isLeftLimit();
		boolean isRight = Robot.climber.isRightLimit();
		// Trim out illegal inputs based on limit switches
		/*
		if (isLeft && speed < 0) {
			speed = 0;
		} else if (isRight && speed > 0) {
			speed = 0;
		}
		*/

		Robot.climber.setScissorSpeed(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.climber.stopScissors();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
