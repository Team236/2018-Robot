package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.intake.Feed;
import org.usfirst.frc.team236.robot.commands.intake.Lower;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftLongScale extends CommandGroup {
	/**
	 * Start from left side of the field, cross field to deliver into right
	 * plate of the scale.
	 */
    public LeftLongScale() {
    	addParallel(new Lower());
    	addParallel(new Feed(), .5);
    	addSequential(new MotionMagic(AutoMap.DIST_PLATFORM_ZONE, AutoMap.MM_END_MARGIN3));
    	
    	addSequential(new Turn(90, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_90));
    	
    	addSequential(new MotionMagic(AutoMap.DIST_CROSS_FIELD, AutoMap.MM_END_MARGIN3));
    	
    	addSequential(new Turn(-90, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_90));
    	
    	addSequential(new MotionMagic(AutoMap.DIST_PLATFORM_ZONE_TO_NULL_TERRITORY, AutoMap.MM_END_MARGIN1));
    	
    	addSequential(new Turn(-45, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_45));
    	
    	addSequential(new SpinUpAndShoot());
    }
}
