package org.usfirst.frc.team236.robot.commands.launcher;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinUpNoStop extends Command {
	
	public double speed = RobotMap.LauncherMap.LAUNCH_SPEED;

	public SpinUpNoStop() {
		requires(Robot.launcher);
	}
	
	public SpinUpNoStop(double _speed) {
		this();
		this.speed = _speed;
	}

	protected void initialize() {
		Robot.launcher.setLaunchSpeed(RobotMap.LauncherMap.LAUNCH_SPEED);
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
