package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.launcher.Shoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchInner extends CommandGroup {

    public LeftSwitchInner() {
    	addSequential(new MotionMagic(AutoMap.SWITCH_DIST1, AutoMap.MM_END_MARGIN2));
    	
    	addSequential(new Wait(2));
    	
    	addSequential(new Turn(AutoMap.TURN_30_CW, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS45));
    	
    	addSequential(new Wait(2));
    	
    	//"4" below is a timeout for this command - it means the command will end after those many seconds at most
    	addSequential(new MotionMagic(AutoMap.SWITCH_DIST2, AutoMap.MM_END_MARGIN1), 4);
    	
    	addSequential(new SpinUp());
    	
    	addSequential(new Wait(2));
    	
    	addSequential(new Shoot());

    }
}
