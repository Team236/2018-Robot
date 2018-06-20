package org.usfirst.frc.team236.robot.commands.drive;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnWithJoysticks extends Command {

    public TurnWithJoysticks() {
    	requires(Robot.drive);
    }

    protected void initialize() {
    	Robot.drive.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x = Robot.oi.rightStick.getX() * 0.75;
    	Robot.drive.setLeftSpeed(x);
    	Robot.drive.setRightSpeed(-x);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
