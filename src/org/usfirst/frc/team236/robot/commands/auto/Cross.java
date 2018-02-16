package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Cross extends CommandGroup {
	/**
	 * Cross the auto line
	 */
    public Cross() {
    	addSequential(new MotionMagic(AutoMap.DIST_AUTO_LINE, AutoMap.MM_END_MARGIN3));
    }
}
