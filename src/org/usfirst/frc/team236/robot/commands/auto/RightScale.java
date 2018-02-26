package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpAndShoot;

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
    	addParallel(new PreAuto());
    	addSequential(new MotionMagic(AutoMap.DIST_NULL_TERRITORY, AutoMap.MM_END_MARGIN));
    	
    	addSequential(new Turn(-45, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_45));
    	
    	addSequential(new SpinUpAndShoot());
    }
}
