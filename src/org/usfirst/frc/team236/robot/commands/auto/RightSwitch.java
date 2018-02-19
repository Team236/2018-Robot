package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;
import org.usfirst.frc.team236.robot.commands.launcher.WaitAndShoot;

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
    	addSequential(new MotionMagic(AutoMap.DIST_FENCE, AutoMap.MM_END_MARGIN2), 4);
    	
    	addParallel(new WaitAndShoot());
    	addSequential(new SpinUp(), 3);
    }
}
