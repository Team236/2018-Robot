package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public DigitalInput intakeSensor;
	public DigitalInput feedSensor;
	public DoubleSolenoid intakeSolenoid;

	public SpeedController leftIntake;
	public SpeedController rightIntake;

	public Intake() {

		intakeSensor = new DigitalInput(RobotMap.IntakeMap.DIO_SENSOR);
		// feedSensor = new DigitalInput(RobotMap.IntakeMap.FEED_SENSOR_DIO);
		intakeSolenoid = new DoubleSolenoid(RobotMap.IntakeMap.SOL_FWD, RobotMap.IntakeMap.SOL_REV);

		leftIntake = new VictorSP(RobotMap.IntakeMap.PWM_LEFT_INTAKE);
		rightIntake = new VictorSP(RobotMap.IntakeMap.PWM_RIGHT_INTAKE);
		leftIntake.setInverted(RobotMap.IntakeMap.INV_LEFT);
		rightIntake.setInverted(RobotMap.IntakeMap.INV_RIGHT);
	}

	public void setSpeed(double speed) {
		leftIntake.set(speed);
		rightIntake.set(speed);
	}

	public void stop() {
		setSpeed(0);
	}

	public void raise() {
		intakeSolenoid.set(Value.kForward);
	}

	public void lower() {
		intakeSolenoid.set(Value.kReverse);
	}

	public void initDefaultCommand() {
	}
}
