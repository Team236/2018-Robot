package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.commands.auto.CenterLeftSwitch;
import org.usfirst.frc.team236.robot.commands.auto.CenterStraightSwitch;
import org.usfirst.frc.team236.robot.commands.auto.Cross;
import org.usfirst.frc.team236.robot.commands.auto.LeftLongScale;
import org.usfirst.frc.team236.robot.commands.auto.LeftScale2Cube;
import org.usfirst.frc.team236.robot.commands.auto.LeftScaleAndSwitch;
import org.usfirst.frc.team236.robot.commands.auto.LeftSwitchOuter;
import org.usfirst.frc.team236.robot.commands.auto.RightLongScale;
import org.usfirst.frc.team236.robot.commands.auto.RightScale2Cube;
import org.usfirst.frc.team236.robot.commands.auto.RightScaleAndSwitch;
import org.usfirst.frc.team236.robot.commands.auto.RightSwitchOuter;
import org.usfirst.frc.team236.robot.subsystems.Climber;
import org.usfirst.frc.team236.robot.subsystems.Drive;
import org.usfirst.frc.team236.robot.subsystems.Intake;
import org.usfirst.frc.team236.robot.subsystems.Launcher;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.commands.DoNothing;

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
	public Servo flag;

	// Declare auto command
	Command autoCommand;

	private static final boolean isDebug = true;
	private static final boolean isPowerDebug = false;

	private static DigitalInput leftSide, rightSide;
	private static DigitalInput noSwitch, noScale, sw3;

	@Override
	public void robotInit() {
		oi = new OI();

		compressor = new Compressor();
		compressor.start();

		if (isPowerDebug) {
			pdp = new PowerDistributionPanel();
		}

		// Create auto switches
		leftSide = new DigitalInput(3);
		rightSide = new DigitalInput(5);
		noSwitch = new DigitalInput(0);
		noScale = new DigitalInput(1);
		sw3 = new DigitalInput(2);

		pressureSensor = new AnalogInput(RobotMap.ANALOG_PRESSURE_SENSOR);
		flag = new Servo(RobotMap.PWM_FLAG);

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
		postFieldLayout();

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
		// autonomousCommand = new LeftScale2Cube();
		// autonomousCommand = new RightScale2Cube();

		autonomousCommand = getAutoFromSwitches();
		SmartDashboard.putString("Auto", autonomousCommand.toString());

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
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
		
		flag.set(oi.controller.getLeftX());

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

	public static Command getAutoFromSwitches() {
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		// String gameData = gameData.substring(0, 3); // First two characters of game
		// data
		// Test bed is reading True when toggles switches are "off"
		// Test bed 3-way toggle reads "True" on both Left and Right when in the middle
		// Test bed 3-way Left toggle reads "False" and Right reads "True", when
		// switched to the left
		// Test bed 3-way Right toggle reads "False" and Left reads "True", when
		// switched to the right

		if (leftSide.get() && rightSide.get()) {
			// Toggle switch in center
			if (gameData.equals("RRR") || gameData.equals("RLR")) {
				return new CenterStraightSwitch();
			} else if (gameData.equals("LRL") || gameData.equals("LLL")) {
				return new CenterLeftSwitch();
			}
		}

		if (leftSide.get()) {
			// Starting on left side
			if (!noScale.get() && !noSwitch.get()) {
				return new Cross();
			}

			if (gameData.equals("RRR")) {
				if (!noScale.get()) {
					return new Cross(); // TODO long switch
				}
				if (!noSwitch.get()) {
					return new LeftLongScale();
				}
				return new Cross();
			}
			if (gameData.equals("RLR")) {
				if (!noScale.get()) {
					return new Cross(); // TODO long switch
				}
				if (!noSwitch.get()) {
					return new LeftScale2Cube();
				}
				return new LeftScale2Cube();
			}
			if (gameData.equals("LRL")) {
				if (!noScale.get()) {
					return new LeftSwitchOuter();
				}
				if (!noSwitch.get()) {
					return new LeftLongScale();
				}
				return new LeftSwitchOuter();
			}
			if (gameData.equals("LLL")) {
				if (!noScale.get()) {
					return new LeftSwitchOuter();
				}
				if (!noSwitch.get()) {
					return new LeftScale2Cube();
				}
				return new LeftScaleAndSwitch();
			}
		}

		if (rightSide.get()) {
			// Starting on right side
			if (!noScale.get() && !noSwitch.get()) {
				return new Cross();
			}

			if (gameData.equals("RRR")) {
				if (!noScale.get()) {
					return new RightSwitchOuter();
				}
				if (!noSwitch.get()) {
					return new RightScale2Cube();
				}
				return new RightScaleAndSwitch();
			}
			if (gameData.equals("RLR")) {
				if (!noScale.get()) {
					return new RightSwitchOuter();
				}
				if (!noSwitch.get()) {
					return new RightLongScale();
				}
				return new RightSwitchOuter();
			}
			if (gameData.equals("LRL")) {
				if (!noScale.get()) {
					return new Cross(); // TODO long switch
				}
				if (!noSwitch.get()) {
					return new RightScale2Cube();
				}
				return new RightScale2Cube();
			}
			if (gameData.equals("LLL")) {
				if (!noScale.get()) {
					return new Cross(); // TODO long switch
				}
				if (!noSwitch.get()) {
					return new RightLongScale();
				}
				return new Cross();
			}
		}

		return new DoNothing();
	}
}
