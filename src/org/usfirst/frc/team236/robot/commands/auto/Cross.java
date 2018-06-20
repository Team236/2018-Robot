package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Cross extends CommandGroup {
	/**
	 * Cross the auto line
	 */
	public Cross() {
		//addSequential(new StraightDrive(-.5), 3);
		addParallel(new PreAuto());
		addSequential(new FollowProfile(Robot.outer, RobotMap.DriveMap.DRIVE_PARAMS, true));
	}

	@Override
	public String toString() {
		return "Cross";
	}
}