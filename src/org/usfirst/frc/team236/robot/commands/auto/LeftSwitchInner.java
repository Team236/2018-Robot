package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.intake.Feed;
import org.usfirst.frc.team236.robot.commands.intake.Lower;
import org.usfirst.frc.team236.robot.commands.launcher.SpitUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchInner extends CommandGroup {
	/**
	 * Start all the way to the left portal.
	 * 
	 * Drive forward past auto line, turn right, and drive forward and deliver
	 * cube onto left switch plate.
	 */
    public LeftSwitchInner() {
    	addParallel(new Lower());
    	addParallel(new Feed(), .5);
    	addSequential(new MotionMagic(AutoMap.DIST_FENCE, AutoMap.MM_END_MARGIN));
    	    	
    	addSequential(new Turn(30, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_45));
    	    	
    	//"4" below is a timeout for this command - it means the command will end after those many seconds at most
    	addSequential(new MotionMagic(AutoMap.DIST_FENCE_ALIGNMENT, AutoMap.MM_END_MARGIN), 4);
    	
    	addSequential(new SpitUpAndShoot());
    }

    @Override
    public String toString() {
    	return "Left switch: inner";
    }
}
