package org.usfirst.frc.team236.robot.commands.intake;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Intake extends Command {

	public Intake() {
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

		SmartDashboard.putBoolean("Initial Intake Sensor value in Intake ", Robot.intake.intakeSensor.get());	
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		SmartDashboard.putBoolean("Intake Sensor value ", Robot.intake.intakeSensor.get());
		System.out.print("intake sensor value ");
		System.out.println(Robot.intake.intakeSensor.get());
		
		if (!Robot.intake.intakeSensor.get()) {
		Robot.intake.leftIntake.set(RobotMap.IntakeMap.INTAKE_SPEED);
		Robot.intake.rightIntake.set(RobotMap.IntakeMap.INTAKE_SPEED);
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
