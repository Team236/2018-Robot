package org.usfirst.frc.team236.robot.commands.launcher;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinUpNoStop1 extends Command {
	
	public double speed = RobotMap.LauncherMap.LAUNCH_SPEED;

	public SpinUpNoStop1() {
		requires(Robot.launcher);
	}
	
	public SpinUpNoStop1(double _speed) {
		this();
		this.speed = _speed;
	}

	protected void initialize() {
		Robot.launcher.setStage1Speed(speed);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
