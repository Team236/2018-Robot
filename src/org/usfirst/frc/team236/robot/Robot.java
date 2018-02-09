/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.commands.AutoMotnMagic;
import org.usfirst.frc.team236.robot.subsystems.Climber;
import org.usfirst.frc.team236.robot.subsystems.Drive;
import org.usfirst.frc.team236.robot.subsystems.Intake;
import org.usfirst.frc.team236.robot.subsystems.Launcher;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	Command autonomousCommand;

	// Declare OI
	public static OI oi;

	public static Drive drive = new Drive();
	public static Intake intake = new Intake();
	public static Launcher launcher = new Launcher();
	public static Climber climber = new Climber();

	private Compressor compressor;

	// Declare auto command
	Command autoCommand;

	@Override
	public void robotInit() {
		oi = new OI();

		compressor = new Compressor();
		compressor.start();
		
		SmartDashboard.putNumber("P", 0);
		SmartDashboard.putNumber("I", 0);
		SmartDashboard.putNumber("D", 0);

	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		drive.resetEncoders();
		drive.navx.reset();

		// autonomousCommand = chooser.getSelected();
		// autonomousCommand = new AutoDriveStraight(12);
		autonomousCommand = new AutoMotnMagic(RobotMap.AutoMap.STRAIGHT_DISTANCE1);
		// autonomousCommand = new
		// Turn(RobotMap.AutoMap.TURN_DEGREES,RobotMap.AutoMap.TURN_MARGIN);
		// autonomousCommand = new AutoDriveTurn();
		// autonomousCommand = new AutoDriveTurnDrive();

		// schedule the autonomous command (example)
		// if (autonomousCommand != null) {
		autonomousCommand.start();
		// }
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("left Encoder value: ",
				drive.leftFrontMaster.getSelectedSensorPosition(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE);
		SmartDashboard.putNumber("Right Encoder value: ",
				drive.rightFrontMaster.getSelectedSensorPosition(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE);
		SmartDashboard.putNumber("Left speed: ", drive.leftFrontMaster.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Right speed: ", drive.rightFrontMaster.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("gyroangle", drive.navx.getAngle());
	}

	@Override
	public void teleopInit() {
		// if (autoCommand != null) {
			// autoCommand.cancel();
		drive.resetEncoders();
		drive.navx.reset();
		// }
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putBoolean("left limit ", Robot.climber.leftLimit.get());
    	SmartDashboard.putBoolean("right limit ", Robot.climber.rightLimit.get());
    	
    	SmartDashboard.putNumber("left Encoder value: ",
    			drive.leftFrontMaster.getSelectedSensorPosition(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE);
    	SmartDashboard.putNumber("Right Encoder value: ",
    			drive.rightFrontMaster.getSelectedSensorPosition(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE);
    	SmartDashboard.putNumber("Left speed: ", drive.leftFrontMaster.getSelectedSensorVelocity(0));
    	SmartDashboard.putNumber("Right speed: ", drive.rightFrontMaster.getSelectedSensorVelocity(0));
    	SmartDashboard.putNumber("gyroangle", drive.navx.getAngle());
	}

	@Override
	public void testPeriodic() {
	}
}
