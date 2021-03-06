package org.usfirst.frc.team236.robot.subsystems;

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
	public SpeedController lowerMotor, upperMotor;
	public DigitalInput topLimit, bottomLimit;

	public Climber() {
		lowerMotor = new VictorSP(RobotMap.ClimberMap.PWM_LOWER);
		upperMotor = new VictorSP(RobotMap.ClimberMap.PWM_UPPER);

		topLimit = new DigitalInput(RobotMap.ClimberMap.DIO_LIMIT_TOP);
		bottomLimit = new DigitalInput(RobotMap.ClimberMap.DIO_LIMIT_BOTTOM);

		lowerMotor.setInverted(RobotMap.ClimberMap.INV_LOWER);
	}

	public void setSpeed(double speed) {
		if (isTopLimit() && speed > 0) {
			speed = 0;
		} else if (isBottomLimit() && speed < 0) {
			speed = 0;
		}

		lowerMotor.set(speed);
		upperMotor.set(speed);
	}

	public void stop() {
		setSpeed(0);
	}

	public boolean isTopLimit() {
		return topLimit.get();
	}

	public boolean isBottomLimit() {
		return bottomLimit.get();
	}

	public void initDefaultCommand() {
	}
}
