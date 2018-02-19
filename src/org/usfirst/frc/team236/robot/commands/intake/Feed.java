package org.usfirst.frc.team236.robot.commands.intake;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Feed extends Command {

	public Feed() {
		requires(Robot.intake);
		requires(Robot.launcher);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.intake.leftIntake.set(RobotMap.IntakeMap.FEED_SPEED);
		Robot.intake.rightIntake.set(RobotMap.IntakeMap.FEED_SPEED);
		
		Robot.launcher.setLaunchSpeed(-0.25);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
		//return Robot.intake.feedSensor.get();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.intake.stop();
		Robot.launcher.stopLaunch();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
