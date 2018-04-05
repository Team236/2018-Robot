
package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.commands.climber.ClimberWithThumbstick;
import org.usfirst.frc.team236.robot.commands.intake.Eject;
import org.usfirst.frc.team236.robot.commands.intake.EjectWithTrigger;
import org.usfirst.frc.team236.robot.commands.intake.Feed;
import org.usfirst.frc.team236.robot.commands.intake.Intake;
import org.usfirst.frc.team236.robot.commands.intake.IntakeWithTrigger;
import org.usfirst.frc.team236.robot.commands.intake.Lower;
import org.usfirst.frc.team236.robot.commands.intake.Raise;
import org.usfirst.frc.team236.robot.commands.intake.RaiseAndLower;
import org.usfirst.frc.team236.robot.commands.launcher.FullShoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;
import org.usfirst.frc.team236.robot.commands.launcher.SpitUp;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import lib.oi.LogitechF310;
import lib.oi.Thrustmaster;
import lib.oi.triggers.JoystickPOV;
import lib.oi.triggers.JoystickPOV.Direction;

public class OI {
	// Sam's classes (Thrustmaster and Logitech310), otherwise need Joystick Class
	public Thrustmaster leftStick;
	public Thrustmaster rightStick;
	public LogitechF310 controller;

	public JoystickButton raise;
	public JoystickButton lower;
	public JoystickButton intake;
	public JoystickButton eject;
	public JoystickButton feed;

	public JoystickButton launch;
	public JoystickButton spit;

	public JoystickButton startLaunch;
	public JoystickButton leftPress;
	public JoystickButton rightPress;

	public OI() {
		/*
		@formatter:off
		// Only need code below if using Joystick Class (not Sam's classes)
		leftStick = new Joystick(RobotMap.JoystickMap.USB_LEFT);
		rightStick = new Joystick(RobotMap.JoystickMap.USB_RIGHT);
		controller = new Joystick(RobotMap.JoystickMap.USB_CONTROLLER);
		
		raise = new JoystickButton(controller, RobotMap.ControllerMap.RAISE_INTAKE);
		lower = new JoystickButton(controller, RobotMap.ControllerMap.LOWER_INTAKE);
		intake = new JoystickButton(controller,	RobotMap.ControllerMap.INTAKE_CUBE);
		eject = new JoystickButton(controller, RobotMap.ControllerMap.EJECT_CUBE);
		feed = new JoystickButton(controller, RobotMap.ControllerMap.FEED_CUBE);
		
		raise.whenPressed(new RaiseIntake()); 
		lower.whenPressed(new lowerIntake());
		intake.whileHeld(new IntakeCube());
		eject.whileHeld(new EjectCube());
		feed.whileHeld(new FeedCube());
		@formatter:off
		 */

		leftStick = new Thrustmaster(RobotMap.JoystickMap.USB_LEFT);
		rightStick = new Thrustmaster(RobotMap.JoystickMap.USB_RIGHT);
		controller = new LogitechF310(RobotMap.JoystickMap.USB_CONTROLLER);

		// INTAKE
		// raise/lower
		JoystickPOV raise = new JoystickPOV(leftStick, Direction.UP);
		JoystickPOV lower = new JoystickPOV(leftStick, Direction.DOWN);
		raise.whenPressed(new Raise());
		lower.whenPressed(new Lower());
		
		rightStick.middle.whileHeld(new Intake());
		leftStick.middle.whileHeld(new Eject());
		
		controller.a.whileHeld(new IntakeWithTrigger());
		controller.y.whileHeld(new EjectWithTrigger());
		controller.x.whileHeld(new Feed());
		controller.b.whileHeld(new RaiseAndLower());

		// SHOOTER
		rightStick.trigger.whenPressed(new FullShoot());
		leftStick.trigger.whileHeld(new Eject());

		controller.lb.whileHeld(new SpitUp());
		controller.rb.whileHeld(new SpinUp());

		// CLIMBER
		controller.rightPress.whileHeld(new ClimberWithThumbstick());
	}

}
