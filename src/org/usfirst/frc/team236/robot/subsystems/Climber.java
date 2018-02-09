package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	public SpeedController leftWinch, rightWinch, scissors;
	public DigitalInput leftLimit, rightLimit;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public Climber() {
		leftWinch = new VictorSP(RobotMap.ClimberMap.PWM_LEFT);
		rightWinch = new VictorSP(RobotMap.ClimberMap.PWM_RIGHT);
		scissors = new VictorSP(RobotMap.ClimberMap.PWM_SCISSORS);
		leftLimit = new DigitalInput(RobotMap.ClimberMap.DIO_LEFT);
		rightLimit = new DigitalInput(RobotMap.ClimberMap.DIO_RIGHT);
	}
	public void raiseWinch() {
		leftWinch.set(1);
		rightWinch.set(1);

	}

	public void stopWinch() {
		leftWinch.set(0);
		rightWinch.set(0);
	}

	public void moveScissors() {
		// may need to insert deadband into x-axis of controller
		if (!leftLimit.get() || !rightLimit.get()) {
			scissors.set(0);
		} else {
			scissors.set(Robot.oi.controller.getRightX());
		}
	}

	public void stopScissors() {
		scissors.set(0);
	}

	public void initDefaultCommand() {
	}
}
