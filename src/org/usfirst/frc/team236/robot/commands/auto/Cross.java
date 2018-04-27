package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.commands.drive.StraightDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Cross extends CommandGroup {
	/**
	 * Cross the auto line
	 */
	public Cross() {
		addSequential(new StraightDrive(-1.0), 3);
	}

	@Override
	public String toString() {
		return "Cross";
	}
}