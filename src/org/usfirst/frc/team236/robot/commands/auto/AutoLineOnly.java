package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLineOnly extends CommandGroup {

    public AutoLineOnly() {
    	addSequential(new AutoMotnMagic(AutoMap.STRAIGHT_DIST, AutoMap.MM_END_MARGIN3));
    }
}
