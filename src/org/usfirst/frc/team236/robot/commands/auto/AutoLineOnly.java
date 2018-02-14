package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLineOnly extends CommandGroup {

    public AutoLineOnly() {
    	addSequential(new AutoMotnMagic(RobotMap.AutoMap.STRAIGHT_DIST, RobotMap.AutoMap.MM_END_MARGIN3));
    }
}
