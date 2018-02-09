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

	public void setWinchSpeed(double speed) {
		leftWinch.set(speed);
		rightWinch.set(speed);
	}

	public void stopWinch() {
		setWinchSpeed(0);
	}

	public void setScissorSpeed(double speed) {
		scissors.set(speed);
	}

	public void stopScissors() {
		setScissorSpeed(0);
	}
	
	public boolean isLeftLimit() {
		return leftLimit.get();
	}

	public boolean isRightLimit() {
		return rightLimit.get();
	}

	public void initDefaultCommand() {
	}
}
