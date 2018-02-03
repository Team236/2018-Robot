package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.commands.DriveWithJoysticks;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	public TalonSRX leftFrontMaster, leftRearSlave;
	public TalonSRX rightFrontMaster, rightRearSlave;
	// public TalonSRX leftMiddleSlave, rightMiddleSlave;
	
	public Drive() {
		leftFrontMaster = new TalonSRX(RobotMap.DriveMap.ID_LEFT_FRONT);
		rightFrontMaster = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_FRONT);
		leftRearSlave = new TalonSRX(RobotMap.DriveMap.ID_LEFT_REAR);
		rightRearSlave = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_REAR);
		// leftMiddleSlave = new TalonSRX(RobotMap.DriveMap.ID_LEFT_MIDDLE);
		// rightMiddleSlave = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_MIDDLE);
		
		
		leftRearSlave.set(ControlMode.Follower, leftFrontMaster.getDeviceID());
		rightRearSlave.set(ControlMode.Follower, rightFrontMaster.getDeviceID());
		// leftMiddleSlave.set(ControlMode.Follower, leftFrontMaster.getDeviceID());
		// rightMiddleSlave.set(ControlMode.Follower, rightFrontMaster.getDeviceID());
		
		
		// set "true" if needed to make encoder reading positive when TalonSRX blinks green
		leftFrontMaster.setSensorPhase(true);
		rightFrontMaster.setSensorPhase(false);
		
		
		
	}
	
	public void setLeftSpeed(double speed) {
		leftFrontMaster.set(ControlMode.PercentOutput, speed);
	}
	
	public void setRightSpeed(double speed) {
		rightFrontMaster.set(ControlMode.PercentOutput, speed);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
    	
    }
}

