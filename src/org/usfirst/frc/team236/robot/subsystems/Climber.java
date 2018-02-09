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
	/*
	 * When left and right are used in reference to the climber, they are used
	 * from the perspective of the shooter - that is, looking out the back of
	 * the robot. This is because, when climbing on the scale from the side,
	 * the operator will raise the scissors on either the left or the right.
	 * From this perspective the left and right are aligned, so raising the
	 * scissors on the left or right side of the climber is correlated with
	 * climbing on the left or right side of the scale.
	 * 
	 * In addition, left, in reference to the scissors, is negative, and right
	 * is positive. This is because of how the thumbstick operates - left is
	 * negative, and right is positive.
	 */
	public SpeedController leftWinch, rightWinch, scissors;
	public DigitalInput leftLimit, rightLimit;

	public Climber() {
		// May remove one - these can be run off a y-cable
		leftWinch = new VictorSP(RobotMap.ClimberMap.PWM_LEFT);
		rightWinch = new VictorSP(RobotMap.ClimberMap.PWM_RIGHT);

		scissors = new VictorSP(RobotMap.ClimberMap.PWM_SCISSORS);

		leftLimit = new DigitalInput(RobotMap.ClimberMap.DIO_LEFT);
		rightLimit = new DigitalInput(RobotMap.ClimberMap.DIO_RIGHT);

		leftWinch.setInverted(RobotMap.ClimberMap.INV_WINCH_LEFT);
		rightWinch.setInverted(RobotMap.ClimberMap.INV_WINCH_RIGHT);
		scissors.setInverted(RobotMap.ClimberMap.INV_SCISSORS);
	}

	public void setWinchSpeed(double speed) {
		if (speed >= 0) {
			leftWinch.set(speed);
			rightWinch.set(speed);
		}
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
