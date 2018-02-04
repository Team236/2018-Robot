package org.usfirst.frc.team236.robot.commands;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartLaunch extends Command {
	// private int i;

    public StartLaunch() {
    	requires(Robot.launcher);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// i = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.launcher.setLaunchSpeed();
    	// i++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
       //  return (i/50) > 2; // time out after 2 seconds
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.launcher.stopLaunch();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.launcher.stopLaunch();
    }
}
