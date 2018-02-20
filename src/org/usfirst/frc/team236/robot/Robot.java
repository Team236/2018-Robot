package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.commands.auto.LeftScale2Cube;
import org.usfirst.frc.team236.robot.subsystems.Climber;
import org.usfirst.frc.team236.robot.subsystems.Drive;
import org.usfirst.frc.team236.robot.subsystems.Intake;
import org.usfirst.frc.team236.robot.subsystems.Launcher;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
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

	public static double P_TURN;
	public static double I_TURN;
	public static double D_TURN;

	private Compressor compressor;
	public PowerDistributionPanel pdp;
	public AnalogInput pressureSensor;
	public UsbCamera camera;

	// Declare auto command
	Command autoCommand;

	private static final boolean isDebug = false;
	private static final boolean isPowerDebug = false;

	@Override
	public void robotInit() {
		oi = new OI();

		compressor = new Compressor();
		compressor.start();

		if (isPowerDebug) {
			pdp = new PowerDistributionPanel();
		}

		pressureSensor = new AnalogInput(RobotMap.ANALOG_PRESSURE_SENSOR);

		try {
			camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setVideoMode(new VideoMode(VideoMode.PixelFormat.kMJPEG, 320, 240, 30));
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
		postFieldLayout();
	}

	@Override
	public void autonomousInit() {
		drive.resetEncoders();
		drive.navx.reset();

		// autonomousCommand = new AutoMotnMagic(RobotMap.AutoMap.STRAIGHT_DISTANCE1,
		// RobotMap.AutoMap.MM_END_MARGIN1);
		// autonomousCommand = new Turn(-45, AutoMap.TURN_MARGIN,
		// AutoMap.TURN_PARAMS_90);
		// autonomousCommand = new LeftSwitchFromRight();
		// autonomousCommand = new RightSwitch();
		// autonomousCommand = new LeftSwitchInner();
		// autonomousCommand = new LeftSwitchOuter();
		// autonomousCommand = new RightScale();
		// autonomousCommand = new LeftScale();
		// autonomousCommand = new Cross();
		// autonomousCommand = new ScaleCrossLtoR();
		autonomousCommand = new LeftScale2Cube();
		// autonomousCommand = new RightScale2Cube();

		// schedule the autonomous command (example)
		// if (autonomousCommand != null) {
		autonomousCommand.start();

		// }
		postFieldLayout();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

		if (isDebug) {
			SmartDashboard.putNumber("Left Distance", drive.getLeftDistance());
			SmartDashboard.putNumber("Right Distance", drive.getRightDistance());

			SmartDashboard.putNumber("Left Speed", drive.leftFrontMaster.getSelectedSensorVelocity(0));
			SmartDashboard.putNumber("Right Speed", drive.rightFrontMaster.getSelectedSensorVelocity(0));
		}
		SmartDashboard.putNumber("Match Time", DriverStation.getInstance().getMatchTime());
	}

	@Override
	public void teleopInit() {
		if (autoCommand != null) {
			autoCommand.cancel();
		}

		drive.resetEncoders();
		drive.navx.reset();

		postFieldLayout();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		if (isDebug) {
			SmartDashboard.putNumber("Left Distance", drive.getLeftDistance());
			SmartDashboard.putNumber("Right Distance", drive.getRightDistance());

			SmartDashboard.putNumber("Left Speed", drive.leftFrontMaster.getSelectedSensorVelocity(0));
			SmartDashboard.putNumber("Right Speed", drive.rightFrontMaster.getSelectedSensorVelocity(0));

			SmartDashboard.putNumber("Gyro Angle", drive.navx.getAngle());
		}

		SmartDashboard.putBoolean("Intake cube", intake.isCube());

		SmartDashboard.putNumber("Match Time", DriverStation.getInstance().getMatchTime());

		SmartDashboard.putNumber("Pressure", pressureSensor.getAverageVoltage() * (110.0 / 2.75));

		SmartDashboard.putNumber("Match Time", DriverStation.getInstance().getMatchTime());
		
		if (isPowerDebug) {
			SmartDashboard.putNumber("Battery Voltage", pdp.getVoltage());
			SmartDashboard.putNumber("Battery Current", pdp.getTotalCurrent());
			SmartDashboard.putNumber("Battery Power", pdp.getTotalPower());
			SmartDashboard.putNumber("Battery Energy", pdp.getTotalEnergy());
		}
	}

	@Override
	public void testPeriodic() {
	}

	public static void postFieldLayout() {
		// Blue is true
		boolean ourBool;
		String gameData;
		try {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
		
			Alliance color = DriverStation.getInstance().getAlliance();
	
			// Set our boolean to correct alliance
			if (color == Alliance.Blue) {
				ourBool = true;
			} else {
				ourBool = false;
			}
			
			ourBool = true;
	
			// Set near switch colors
			if (gameData.charAt(0) == 'L') {
				SmartDashboard.putBoolean("NSL", ourBool);
				SmartDashboard.putBoolean("NSR", !ourBool);
			} else if (gameData.charAt(0) == 'R') {
				SmartDashboard.putBoolean("NSL", !ourBool);
				SmartDashboard.putBoolean("NSR", ourBool);
			}
	
			// Set scale colors
			if (gameData.charAt(1) == 'L') {
				SmartDashboard.putBoolean("SL", ourBool);
				SmartDashboard.putBoolean("SR", !ourBool);
			} else if (gameData.charAt(1) == 'R') {
				SmartDashboard.putBoolean("SL", !ourBool);
				SmartDashboard.putBoolean("SR", ourBool);
			}
	
			// Set far switch colors
			if (gameData.charAt(2) == 'L') {
				SmartDashboard.putBoolean("FSL", ourBool);
				SmartDashboard.putBoolean("FSR", !ourBool);
			} else if (gameData.charAt(2) == 'R') {
				SmartDashboard.putBoolean("FSL", !ourBool);
				SmartDashboard.putBoolean("FSR", ourBool);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("String machine broke");
		}
	}
}
