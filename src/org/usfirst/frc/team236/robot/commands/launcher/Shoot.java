package org.usfirst.frc.team236.robot.commands.launcher;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot extends Command {

	public Shoot() {
		// requires(Robot.launcher);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.launcher.extend();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.launcher.retract();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.launcher.retract();
	}
}
