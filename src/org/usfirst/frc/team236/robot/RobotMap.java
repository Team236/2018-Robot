package org.usfirst.frc.team236.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.pid.PIDParameters;

public class RobotMap {

	public static class DriveMap {
		public static final int ID_LEFT_FRONT = 8;
		public static final int ID_RIGHT_FRONT = 7;
		public static final int ID_LEFT_REAR = 5;
		public static final int ID_RIGHT_REAR = 6;

		public static final double DIAMETER = 3.92; // wheel diameter in inches
		public static final double CIRCUMFERENCE = DIAMETER * Math.PI;
		public static final double PULSE_PER_ROTATION = 512;
		public static final double DISTANCE_PER_PULSE = CIRCUMFERENCE / PULSE_PER_ROTATION;

	}

	public static class JoystickMap {
		public static final int USB_LEFT = 0;
		public static final int USB_RIGHT = 1;
		public static final int USB_CONTROLLER = 2;
	}

	public static class ControllerMap {
		public static final int RAISE_INTAKE = 4;
		public static final int LOWER_INTAKE = 1;
		public static final int INTAKE_CUBE = 3;
		public static final int EJECT_CUBE = 2;
		public static final int FEED_CUBE = 6;

	}

	public static class IntakeMap {
		public static final int DIO_SENSOR = 4;
		// public static final int FEED_SENSOR_DIO = 1;
		public static final int SOL_FWD = 0;
		public static final int SOL_REV = 1;
		public static final int PWM_LEFT_INTAKE = 0;
		public static final int PWM_RIGHT_INTAKE = 1;
		public static final double INTAKE_SPEED = 1;
		public static final double EJECT_SPEED = -1;
		public static final double FEED_SPEED = 0.4;
		public static final boolean INV_LEFT = false;
		public static final boolean INV_RIGHT = false;

	}

	public static class LauncherMap {
		public static final int SOL_FWD = 2;
		public static final int SOL_REV = 3;
		public static final int PWM_TOP_RIGHT = 2;
		public static final int PWM_TOP_LEFT = 4;
		public static final int PWM_BOTTOM_RIGHT = 3;
		public static final int PWM_BOTTOM_LEFT = 5;
		public static final int PWM_SPITTER = 6;
		public static final double LAUNCH_SPEED = 0.9;
		public static final double SPIT_SPEED = 0.6;

	}

	public static class ClimberMap {
		public static final int PWM_LEFT = 7; // port number for winch motor
		public static final int PWM_RIGHT = 8; // port number for winch motor
		public static final int PWM_SCISSORS = 9; // port number for climber motor
		public static final int DIO_LEFT = 6;
		public static final int DIO_RIGHT = 7;
	}

	public static class AutoMap {
		public static final double STRAIGHT_DISTANCE1 = 60;
		public static final double STRAIGHT_DISTANCE2 = 60;

		public static final double TURN_DEGREES = 90;
		public static final double TURN_DEGREES2 = -90;
		public static final double TURN_MARGIN = 5.0;
		public static final double MTN_MAG_END_MARGIN = 6;

		public static final double P_TURN = SmartDashboard.getNumber("P", 0);
		public static final double I_TURN = SmartDashboard.getNumber("I", 0);
		public static final double D_TURN = SmartDashboard.getNumber("D", 0);
		public static final PIDParameters TURN_PARAMS = new PIDParameters(P_TURN, I_TURN, D_TURN, 1 / 100.0);

		public static final int M_MAGIC_CV = 1280;
		public static final int M_MAGIC_ACCL = 2560;
	}

}
