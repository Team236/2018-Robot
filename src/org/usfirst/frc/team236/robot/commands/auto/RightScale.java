package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.launcher.Shoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScale extends CommandGroup {
	/**
	 * Start all the way to the right portal.
	 * 
	 * Drive straight forward to null territory, turn 45 degrees, and deliver
	 * cube onto right scale plate.
	 */
    public RightScale() {
    	addSequential(new MotionMagic(AutoMap.DIST_NULL_TERRITORY, AutoMap.MM_END_MARGIN3));
    	
    	addSequential(new Turn(-45, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_45));
    	
    	addSequential(new SpinUp(), 1);
    	
    	addSequential(new Wait(2));
    	
    	addSequential(new Shoot(), 1);
       
    }
}
