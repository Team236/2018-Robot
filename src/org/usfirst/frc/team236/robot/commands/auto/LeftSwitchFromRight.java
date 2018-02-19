package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.intake.Lower;
import org.usfirst.frc.team236.robot.commands.launcher.Shoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchFromRight extends CommandGroup {
	/**
	 * Start from right side of field, aligned with the alliance wall partition.
	 * 
	 * Drive straight forward, turn left, drive to left switch plate, turn
	 * right, and drive forward while delivering cube to switch plate.
	 */
    public LeftSwitchFromRight() {
    	addParallel(new Lower());
    	addSequential(new MotionMagic(AutoMap.SWITCH_CROSS1, AutoMap.MM_END_MARGIN1));
    	
    	addSequential(new Turn(-90, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_90));
    	
    	addSequential(new MotionMagic(AutoMap.SWITCH_CROSS2, AutoMap.MM_END_MARGIN2));
    	
    	addSequential(new Turn(90, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_90));
   
    	// "3" below is a timeout for this command - it means the command will end after those many seconds at most
    	addSequential(new MotionMagic(AutoMap.SWITCH_CROSS3, AutoMap.MM_END_MARGIN1), 3);
    	
    	addSequential(new SpinUp());
    	
    	addSequential(new Wait(2));
    	
    	addSequential(new Shoot());
    }
}
