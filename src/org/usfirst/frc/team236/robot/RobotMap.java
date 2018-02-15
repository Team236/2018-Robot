package org.usfirst.frc.team236.robot;

import lib.pid.PIDParameters;

public class RobotMap {

	public static class DriveMap {
		public static final int ID_LEFT_FRONT = 8; //2
		public static final int ID_RIGHT_FRONT = 7; //1
		// public static final int ID_LEFT_MIDDLE = 4
		// public static final int ID_RIGHT_MIDDLE = 3
		public static final int ID_LEFT_REAR = 5; //10
		public static final int ID_RIGHT_REAR = 6; //9

		public static final double DIAMETER = 3.94; // wheel diameter in inches
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
		public static final int FEED_SENSOR_DIO = 1;
		
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
		
		public static final boolean INV_WINCH_LEFT = false; // Positive pulls strap in
		public static final boolean INV_WINCH_RIGHT = false; // Positive pulls strap in
		public static final boolean INV_SCISSORS = false; // Positive is to the right

		public static final int DIO_LEFT = 6;
		public static final int DIO_RIGHT = 7;
		
		public static final double WINCH_SPEED = 1.0;
	}

	public static class AutoMap {
		public static final double TURN_90_CCW = -90;
		public static final double TURN_90_CW = 90;
		public static final double TURN_30_CW = 30;
		public static final double TURN_30_CCW = -30;
		public static final double TURN_45_CW = 45;
		public static final double TURN_45_CCW = -45;
		
		public static final double TURN_MARGIN = 20.0;

		// public static final double P_TURN = SmartDashboard.getNumber("P", 0);
		// public static final double I_TURN = SmartDashboard.getNumber("I", 0);
		// public static final double D_TURN = SmartDashboard.getNumber("D", 0);
		// public static final PIDParameters TURN_PARAMS = new PIDParameters(P_TURN, I_TURN, D_TURN, 1 / 100.0);
		public static final PIDParameters TURN_PARAMS45 = new PIDParameters(0.019, 0.00, -0.0001, 1 / 100.0);
		public static final PIDParameters TURN_PARAMS_45 = new PIDParameters(0.06, 0.00, 0.000, 1 / 100.0);
		public static final PIDParameters TURN_PARAMS90 = new PIDParameters(0.0147, 0.00, -0.003, 1 / 100.0);
		public static final PIDParameters TURN_PARAMS_90 = new PIDParameters(0.0147, 0.00, -0.003, 1 / 100.0);
		// TESTBED 2/10- on carpet for 45 and 30 deg, P = 0.019, I = 0, D = -0.0001, fresh battery 57 deg
		// TESTBED 2/10- on carpet for -45 deg, P = 0.06, needs more tuning short by a few degrees
		// TESTBED 2/10 on carpet for +/-90 deg, P = 0.0147, D = -0.003
		
		public static final double SWITCH_CROSS1 = -48;
		public static final double SWITCH_CROSS2 = -108;
		public static final double SWITCH_CROSS3 = -32;
		
		public static final double SWITCH_DIST1 = -105;
		public static final double SWITCH_DIST2 = -30;
		public static final double SWITCH_DIST3 = -168;
		public static final double SWITCH_DIST4 = -30;
		
		public static final double SCALE_DIST = -252.5;
		
		public static final double SCALE_CROSS1 = -209.5;
		public static final double SCALE_CROSS2 = -186; //with bump
		public static final double SCALE_CROSS3 = -37;
		
		public static final double STRAIGHT_DIST = -150;
		
		public static final double MM_END_MARGIN1 = 15;
		public static final double MM_END_MARGIN2 = 20; //40
		public static final double MM_END_MARGIN3 = 40; //60
		
		public static final double M_MAGIC_K_P = 0.01;
		public static final double M_MAGIC_K_I = 0.0;
		public static final double M_MAGIC_K_D = 0.0;
		public static final double M_MAGIC_K_F = 1.5;
		// TESTBED 2/10- on carpet for 252 and 101, F = 1.5, P = 0.01, I = 0, D = 0
		// TESTBED CV = 1280, ACCEL = 1280 Margin = 20

		public static final int M_MAGIC_CV = 1280;
		public static final int M_MAGIC_ACCL = 1280;
	}

}
