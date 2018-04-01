package org.usfirst.frc.team236.robot.commands.launcher;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinDown extends Command {
	
	public SpinDown() {
		requires(Robot.launcher);
	}
	
	protected void initialize() {
		Robot.launcher.stopLaunch();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		Robot.launcher.stopLaunch();
	}

	protected void interrupted() {
		end();
	}
}
