package org.usfirst.frc.team236.robot;

import lib.pid.PIDParameters;

public class RobotMap {

	public static final int ANALOG_PRESSURE_SENSOR = 0;
	public static final int PWM_FLAG = 6;

	public static class DriveMap {
		// Talon IDs
		public static final int ID_LEFT_FRONT = 2; // 2, testbed: 8
		public static final int ID_RIGHT_FRONT = 1; // 1, testbed: 7
		public static final int ID_LEFT_MIDDLE = 4;
		public static final int ID_RIGHT_MIDDLE = 3;
		public static final int ID_LEFT_REAR = 10; // 10, testbed: 5
		public static final int ID_RIGHT_REAR = 9; // 9, testbed: 6

		public static final double DIAMETER = 3.96; // wheel diameter in inches
		public static final double CIRCUMFERENCE = DIAMETER * Math.PI;
		public static final double PULSE_PER_ROTATION = 512;
		public static final double DISTANCE_PER_PULSE = CIRCUMFERENCE / PULSE_PER_ROTATION;
		
		// Voltage settings
		public static final boolean IS_VOLTAGE_COMP = false;
		public static final double VOLTAGE_SATURATION = 12.5;
		
		// Current limiting settings
		public static final boolean IS_CURRENT_LIMIT = false;
		public static final int PEAK_CURRENT = 45;
		public static final int CONTINUOUS_CURRENT = 30;

		// Default cruise velocity and acceleration
		// TESTBED 2/10- on carpet for 252 and 101, F = 1.5, P = 0.01, I = 0, D = 0
		// TESTBED CV = 1280, ACCEL = 1280 Margin = 20
		public static final int M_MAGIC_CV = 200;
		public static final int M_MAGIC_ACCL = 1000;

		// Linear motion magic parameters
		public static final double M_MAGIC_K_P = 0.3;
		public static final double M_MAGIC_K_I = 0.0;
		public static final double M_MAGIC_K_D = 0.0;
		public static final double M_MAGIC_K_F_R = 1.2;
		public static final double M_MAGIC_K_F_L = 1.2;

		// Turn PID parameters
		// public static final double P_TURN = SmartDashboard.getNumber("P", 0);
		// public static final double I_TURN = SmartDashboard.getNumber("I", 0);
		// public static final double D_TURN = SmartDashboard.getNumber("D", 0);
		// public static final PIDParameters TURN_PARAMS = new PIDParameters(P_TURN,
		// I_TURN, D_TURN, 1 / 100.0);
		public static final PIDParameters TURN_PARAMS_45 = new PIDParameters(0.06, 0.00, -0.003, 1 / 100.0);
		public static final PIDParameters TURN_PARAMS_90 = new PIDParameters(0.007, 0.001, -0.000, 1 / 100.0); // P =
																												// .028
		public static final double TURN_MARGIN = 3.0;
		// TESTBED 2/10- on carpet for 45 and 30 deg, P = 0.019, I = 0, D = -0.0001,
		// fresh battery 57 deg
		// TESTBED 2/10- on carpet for -45 deg, P = 0.06, needs more tuning short by a
		// few degrees
		// TESTBED 2/10 on carpet for +/-90 deg, P = 0.0147, D = -0.003
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
		public static final int FEED_SENSOR_DIO = 1;

		public static final int SOL_FWD = 0;
		public static final int SOL_REV = 1;

		public static final int PWM_LEFT_INTAKE = 0;
		public static final int PWM_RIGHT_INTAKE = 1;

		public static final double INTAKE_SPEED = 1;
		public static final double EJECT_SPEED = -.5;
		public static final double FEED_SPEED = 0.75;
		public static final boolean INV_LEFT = true;
		public static final boolean INV_RIGHT = false;

	}

	public static class LauncherMap {
		public static final int SOL_FWD = 2;
		public static final int SOL_REV = 3;

		public static final int PWM_TOP_RIGHT = 2;
		public static final int PWM_TOP_LEFT = 4;
		public static final int PWM_BOTTOM_RIGHT = 3;
		public static final int PWM_BOTTOM_LEFT = 5;

		public static final double LAUNCH_SPEED = 0.95;
		public static final double SPIT_SPEED = 0.5;
		public static final double FEED_SPEED = -0.75;
	}

	public static class ClimberMap {
		public static final int PWM_LEFT = 7; // port number for winch motor
		public static final int PWM_RIGHT = 8; // port number for winch motor
		public static final int PWM_SCISSORS = 9; // port number for climber motor

		public static final boolean INV_WINCH_LEFT = false; // Positive pulls strap in
		public static final boolean INV_WINCH_RIGHT = false; // Positive pulls strap in
		public static final boolean INV_SCISSORS = false; // Positive is to the right

		public static final int DIO_LEFT = 6;
		public static final int DIO_RIGHT = 7;

		public static final double WINCH_SPEED = 0.5;
	}

}
