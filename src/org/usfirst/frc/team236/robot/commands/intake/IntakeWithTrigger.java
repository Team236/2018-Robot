package org.usfirst.frc.team236.robot.commands.intake;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeWithTrigger extends Command {
	
	double speed;

	public IntakeWithTrigger() {
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		speed = Robot.oi.controller.getRightTrigger();
		
		if (speed < .01) {
			speed = RobotMap.IntakeMap.INTAKE_SPEED;
		}
		
		SmartDashboard.putNumber("Intake speed", speed);
		
		if (!Robot.intake.intakeSensor.get()) {
			Robot.intake.leftIntake.set(speed);
			Robot.intake.rightIntake.set(speed);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.intake.intakeSensor.get();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.intake.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
