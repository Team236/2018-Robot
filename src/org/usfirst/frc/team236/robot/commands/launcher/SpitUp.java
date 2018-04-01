package org.usfirst.frc.team236.robot.commands.launcher;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpitUp extends Command {
	
	public double speed = RobotMap.LauncherMap.SPIT_SPEED;

	public SpitUp() {
		requires(Robot.launcher);
	}
	
	public SpitUp(double _speed) {
		this();
		this.speed = _speed;
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.launcher.setLaunchSpeed(RobotMap.LauncherMap.SPIT_SPEED);
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
