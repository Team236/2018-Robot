package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.launcher.Shoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScale extends CommandGroup {
	/**
	 * Start all the way to the left portal.
	 * 
	 * Drive straight forward to null territory, turn 45 degrees right, and
	 * deliver cube onto left scale plate.
	 */

    public LeftScale() {
    	addSequential(new MotionMagic(AutoMap.DIST_NULL_TERRITORY, AutoMap.MM_END_MARGIN3));
    	
    	addSequential(new Turn(45, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS45)); // could angle robot and turn 60
    	
    	addSequential(new SpinUp(), 1);
    	
    	// addSequential(new Wait(2));
    	
    	addSequential(new Shoot(), 1);
       
    }
}
