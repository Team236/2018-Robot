/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team236.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	public Joystick leftStick;
	public Joystick rightStick;
	public Joystick controller;
	
	public OI() {
		leftStick = new Joystick(RobotMap.JoystickMap.LEFT_PORT);
		rightStick = new Joystick(RobotMap.JoystickMap.RIGHT_PORT);
		controller = new Joystick(RobotMap.JoystickMap.CONTROLLER_PORT);
	}

}
