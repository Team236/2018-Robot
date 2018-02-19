package org.usfirst.frc.team236.robot.commands.climber;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import lib.oi.LogitechF310;
import lib.oi.LogitechF310.Axes;

/**
 *
 */
public class RaiseWinchWithTrigger extends Command {

	public RaiseWinchWithTrigger() {
		requires(Robot.climber);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.climber.setWinchSpeed(Math.abs(Robot.oi.controller.getRawAxis(Axes.RT)));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.climber.stopWinch();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
