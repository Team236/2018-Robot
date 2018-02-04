/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team236.robot;

public class RobotMap {

	public static class DriveMap {
		public static final int ID_LEFT_FRONT = 8;
		public static final int ID_RIGHT_FRONT = 7;
		public static final int ID_LEFT_REAR = 5;
		public static final int ID_RIGHT_REAR = 6;

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
		public static final double FEED_SPEED = 1;
		public static final boolean INV_LEFT = false;
		public static final boolean INV_RIGHT = false;

	}

}
