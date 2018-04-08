package org.usfirst.frc.team236.robot.commands.launcher;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinUp extends Command {
	
	public double speed = RobotMap.LauncherMap.LAUNCH_SPEED;

	public SpinUp() {
		requires(Robot.launcher);
	}
	
	public SpinUp(double _speed) {
		this();
		this.speed = _speed;
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.launcher.setStage2Speed(speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.launcher.stopLaunch();
	}

	protected void interrupted() {
		end();
	}
}
