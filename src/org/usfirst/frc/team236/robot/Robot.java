package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.commands.auto.AutoMotnMagic;
import org.usfirst.frc.team236.robot.commands.auto.LeftSwitch;
import org.usfirst.frc.team236.robot.commands.auto.OppositeSwitch;
import org.usfirst.frc.team236.robot.commands.auto.RightScale;
import org.usfirst.frc.team236.robot.commands.auto.Turn;
import org.usfirst.frc.team236.robot.subsystems.Climber;
import org.usfirst.frc.team236.robot.subsystems.Drive;
import org.usfirst.frc.team236.robot.subsystems.Intake;
import org.usfirst.frc.team236.robot.subsystems.Launcher;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.pid.PIDParameters;

public class Robot extends TimedRobot {
	Command autonomousCommand;

	// Declare OI
	public static OI oi;

	public static Drive drive = new Drive();
	public static Intake intake = new Intake();
	public static Launcher launcher = new Launcher();
	public static Climber climber = new Climber();
	
	public static double P_TURN;
	public static double I_TURN;
	public static double D_TURN;

	private Compressor compressor;
	
	public UsbCamera camera;

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
		
		try {
			camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setVideoMode(new VideoMode(VideoMode.PixelFormat.kYUYV, 320, 240, 30));
		} catch (Exception e) {
			System.out.println("Camera capture failed");
			System.out.println(e.getStackTrace());
			
			SmartDashboard.putString("Camera capture failed", "failed");
			
		}

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

		// P_TURN = SmartDashboard.getNumber("P", 0);
		// I_TURN = SmartDashboard.getNumber("I", 0);
		// D_TURN = SmartDashboard.getNumber("D", 0);
		
		// autonomousCommand = chooser.getSelected();
		// autonomousCommand = new AutoMotnMagic(RobotMap.AutoMap.STRAIGHT_DISTANCE1, RobotMap.AutoMap.MM_END_MARGIN1);
		// autonomousCommand = new Turn(RobotMap.AutoMap.SCALE_TURN2,RobotMap.AutoMap.TURN_MARGIN, RobotMap.AutoMap.TURN_PARAMS_45);
		// autonomousCommand = new OppositeSwitch();
		// autonomousCommand = new RightSwitch();
		// autonomousCommand = new LeftSwitch();
		// autonomousCommand = new RightScale();
		// autonomousCommand = new LeftScale();

		// schedule the autonomous command (example)
		// if (autonomousCommand != null) {
		autonomousCommand.start();
		
		// }
		postFieldLayout();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

		SmartDashboard.putNumber("left Encoder value: ",
				drive.getLeftDistance());
		SmartDashboard.putNumber("Right Encoder value: ",
				drive.getRightDistance());
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

		postFieldLayout();
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
		SmartDashboard.putBoolean("Intake Sensor value in robot ", intake.intakeSensor.get());

	}

	@Override
	public void testPeriodic() {
	}
	
	public static void postFieldLayout() {
		// Blue is true
		boolean ourBool;
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		Alliance color = DriverStation.getInstance().getAlliance();
		
		// Set our boolean to correct alliance
		if (color == Alliance.Blue) {
			ourBool = true;
		} else {
			ourBool = false;
		}

		// Set near switch colors
		if (gameData.charAt(0) == 'L') {
			SmartDashboard.putBoolean("near switch left", ourBool);
			SmartDashboard.putBoolean("near switch right", !ourBool);
		} else if (gameData.charAt(1) == 'R') {
			SmartDashboard.putBoolean("near switch left", !ourBool);
			SmartDashboard.putBoolean("near switch right", ourBool);
		}
		
		// Set scale colors
		if (gameData.charAt(1) == 'L') {
			SmartDashboard.putBoolean("scale left", ourBool);
			SmartDashboard.putBoolean("scale right", !ourBool);
		} else if (gameData.charAt(1) == 'R') {
			SmartDashboard.putBoolean("scale left", !ourBool);
			SmartDashboard.putBoolean("scale right", ourBool);
		}
	
		// Set far switch colors
		if (gameData.charAt(2) == 'L') {
			SmartDashboard.putBoolean("far switch left", ourBool);
			SmartDashboard.putBoolean("far switch right", !ourBool);
		} else if (gameData.charAt(0) == 'R') {
			SmartDashboard.putBoolean("far switch left", !ourBool);
			SmartDashboard.putBoolean("far switch right", ourBool);
		}
	}
}
