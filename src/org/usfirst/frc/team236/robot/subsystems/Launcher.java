package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Launcher extends Subsystem {
	/*
	 * Make sure we wire these all to spin in the same direction because
	 * there's no way we're running through 5 inversions. Positive shoots.
	 */
	public SpeedController topRight, topLeft, bottomRight, bottomLeft;
	public DoubleSolenoid shoot;

	public Launcher() {
		topRight = new VictorSP(RobotMap.LauncherMap.PWM_TOP_RIGHT);
		topLeft = new VictorSP(RobotMap.LauncherMap.PWM_TOP_LEFT);
		bottomRight = new VictorSP(RobotMap.LauncherMap.PWM_BOTTOM_RIGHT);
		bottomLeft = new VictorSP(RobotMap.LauncherMap.PWM_BOTTOM_LEFT);
		shoot = new DoubleSolenoid(RobotMap.LauncherMap.SOL_FWD, RobotMap.LauncherMap.SOL_REV);
	}

	public void extend() {
		shoot.set(Value.kReverse);
	}

	public void retract() {
		shoot.set(Value.kForward);
	}
	
	public void setStage1Speed(double speed) {
		bottomLeft.set(speed);
		bottomRight.set(speed);
	}
	
	public void setStage2Speed(double speed) {
		topLeft.set(speed);
		topRight.set(speed);
	}

	public void setLaunchSpeed(double speed) {
		this.setStage1Speed(speed);
		this.setStage2Speed(speed);
	}

	public void stopLaunch() {
		setLaunchSpeed(0);
	}

	public void initDefaultCommand() {
	}
}
