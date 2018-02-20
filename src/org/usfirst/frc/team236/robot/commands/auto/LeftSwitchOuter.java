package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.launcher.SpitUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchOuter extends CommandGroup {
	/**
	 * Start aligned with the left switch plate.
	 * 
	 * Drive forward to fence and deliver cube to left switch plate.
	 */
    public LeftSwitchOuter() {
    	addParallel(new PreAuto());
    	addSequential(new MotionMagic(AutoMap.DIST_PAST_SWITCH, AutoMap.MM_END_MARGIN3));
    	
    	addSequential(new Turn(90, 15, AutoMap.TURN_PARAMS_90));
    	
    	//"4" below is a timeout for this command - it means the command will end after those many seconds at most
    	addSequential(new MotionMagic(AutoMap.DIST_SIDE_FENCE, AutoMap.MM_END_MARGIN1), 2);
    	
    	addSequential(new SpitUpAndShoot());
    	
    	addSequential(new MotionMagic(-AutoMap.DIST_SIDE_FENCE, AutoMap.MM_END_MARGIN1), 2);
    	
    	addSequential(new Turn(-90, 20, AutoMap.TURN_PARAMS_90));
    	
    	addSequential(new MotionMagic(-72, 10), 4);
    }
}
