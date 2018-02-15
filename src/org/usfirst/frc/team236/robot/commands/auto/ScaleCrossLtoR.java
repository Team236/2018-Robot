package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.launcher.Shoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScaleCrossLtoR extends CommandGroup {

    public ScaleCrossLtoR() {
    	addSequential(new MotionMagic(AutoMap.SCALE_CROSS1, AutoMap.MM_END_MARGIN3));
    	
    	addSequential(new Turn(AutoMap.TURN_90_CW, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS90));
    	
    	addSequential(new MotionMagic(AutoMap.SCALE_CROSS2, AutoMap.MM_END_MARGIN2));
    	
    	addSequential(new Turn(AutoMap.TURN_90_CCW, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_90));
    	
    	addSequential(new MotionMagic(AutoMap.SCALE_CROSS3, AutoMap.MM_END_MARGIN1));
    	
    	addSequential(new Turn(AutoMap.TURN_45_CCW, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS45));
    	
    	addSequential(new SpinUp());
    	
    	addSequential(new Wait(2));
    	
    	addSequential(new Shoot());
    }
}
