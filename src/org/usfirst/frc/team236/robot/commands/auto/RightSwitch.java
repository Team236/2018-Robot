package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.intake.Feed;
import org.usfirst.frc.team236.robot.commands.intake.Lower;
import org.usfirst.frc.team236.robot.commands.launcher.SpitUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitch extends CommandGroup {
	/**
	 * Start in line with the right switch plate.
	 * 
	 * Drive straight forward and shoot cube.
	 */

    public RightSwitch() {
    	//"4" below is a timeout for this command - it means the command will end after those many seconds at most
    	addParallel(new Lower());
    	addParallel(new Feed(), .5);
    	addSequential(new MotionMagic(AutoMap.DIST_FENCE, AutoMap.MM_END_MARGIN2), 4);
    	
    	addSequential(new SpitUpAndShoot());
    }
}
