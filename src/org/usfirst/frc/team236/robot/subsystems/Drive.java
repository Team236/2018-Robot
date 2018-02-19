package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.commands.DriveWithJoysticks;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import lib.pid.PIDSource;
import lib.pid.PIDOutput;

/**
 *
 */
public class Drive extends Subsystem implements PIDSource, PIDOutput {

	public TalonSRX leftFrontMaster, leftRearSlave;
	public TalonSRX rightFrontMaster, rightRearSlave;
	public TalonSRX leftMiddleSlave, rightMiddleSlave;

	public AHRS navx;

	public Drive() {
		navx = new AHRS(SPI.Port.kMXP);

		leftFrontMaster = new TalonSRX(RobotMap.DriveMap.ID_LEFT_FRONT);
		rightFrontMaster = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_FRONT);
		leftRearSlave = new TalonSRX(RobotMap.DriveMap.ID_LEFT_REAR);
		rightRearSlave = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_REAR);
		leftMiddleSlave = new TalonSRX(RobotMap.DriveMap.ID_LEFT_MIDDLE);
		rightMiddleSlave = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_MIDDLE);
		
		//leftFrontMaster.configContinuousCurrentLimit(80, 10);
		//leftFrontMaster.enableCurrentLimit(true);
		//leftFrontMaster.configPeakCurrentLimit(0, 10);
		
		//rightFrontMaster.configContinuousCurrentLimit(80, 10);
		//rightFrontMaster.enableCurrentLimit(true);
		//rightFrontMaster.configPeakCurrentLimit(0, 10);

		leftRearSlave.set(ControlMode.Follower, leftFrontMaster.getDeviceID());
		rightRearSlave.set(ControlMode.Follower, rightFrontMaster.getDeviceID());
		leftMiddleSlave.set(ControlMode.Follower, leftFrontMaster.getDeviceID());
		rightMiddleSlave.set(ControlMode.Follower, rightFrontMaster.getDeviceID());

		// set "true" if needed to make encoder reading positive when TalonSRX blinks
		// green
		leftFrontMaster.setSensorPhase(false);
		rightFrontMaster.setSensorPhase(true);
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

	public void pidSet(double speed) {
		setLeftSpeed(speed);
		setRightSpeed(-speed);
	}

	// autonomous
	public void resetEncoders() {
		leftFrontMaster.setSelectedSensorPosition(0, 0, 0);
		rightFrontMaster.setSelectedSensorPosition(0, 0, 0);
	}
	
	public void setkPMM(double MMkP) {
		rightFrontMaster.config_kP(0, MMkP, 0);
		leftFrontMaster.config_kP(0, MMkP, 0);
	}
	
	public void setkIMM(double MMkI) {
		rightFrontMaster.config_kI(0, MMkI, 0);
		leftFrontMaster.config_kI(0, MMkI, 0);
	}
	
	public void setkDMM(double MMkD) {
		rightFrontMaster.config_kD(0, MMkD, 0);
		leftFrontMaster.config_kD(0, MMkD, 0);
	}
	
	public void setkFMM_L(double MMkFL) {
		leftFrontMaster.config_kF(0, MMkFL, 0);
	}
	
	public void setkFMM_R(double MMkFR) {
		rightFrontMaster.config_kF(0, MMkFR, 0);
	}

	public void setMotnCV(int vcruise) {
		rightFrontMaster.configMotionCruiseVelocity(vcruise, 0);
		leftFrontMaster.configMotionCruiseVelocity(vcruise, 0);
	}

	public void setMotnAccel(int accel) {
		rightFrontMaster.configMotionAcceleration(accel, 0);
		leftFrontMaster.configMotionAcceleration(accel, 0);
	}

	public void setRightDistMotion(double distance) {
		rightFrontMaster.set(ControlMode.MotionMagic, distance);
	}

	public void setLeftDistMotion(double distance) {
		leftFrontMaster.set(ControlMode.MotionMagic, distance);
	}

	public double getRightDistance() {
		return rightFrontMaster.getSelectedSensorPosition(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE;
	}
	
	public double getLeftDistance() {
		return leftFrontMaster.getSelectedSensorPosition(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE;
	}

	public double getRightSpeed() {
		return rightFrontMaster.getSelectedSensorVelocity(0);
	}

	public void stop() {
		leftFrontMaster.set(ControlMode.PercentOutput, 0);
		rightFrontMaster.set(ControlMode.PercentOutput, 0);
	}

	public int getLeftEncoder() {
		return leftFrontMaster.getSelectedSensorPosition(0);
	}

	public int getRightEncoder() {
		return rightFrontMaster.getSelectedSensorPosition(0);
	}

	@Override
	public double pidGet() {
		return navx.getAngle();
	}
}
