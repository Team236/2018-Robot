package org.usfirst.frc.team236.robot;

public class RobotMap {
	
	public static final int ANALOG_PRESSURE_SENSOR = 0;

	public static class DriveMap {
		public static final int ID_LEFT_FRONT = 2; //2, testbed: 8
		public static final int ID_RIGHT_FRONT = 1; //1, testbed: 7
		public static final int ID_LEFT_MIDDLE = 4;
		public static final int ID_RIGHT_MIDDLE = 3;
		public static final int ID_LEFT_REAR = 10; //10, testbed: 5
		public static final int ID_RIGHT_REAR = 9; //9, testbed: 6

		public static final double DIAMETER = 3.96; // wheel diameter in inches
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
		
		public static final double WINCH_SPEED = 0.5;
	}

}
