package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScale2Cube extends CommandGroup {

    public RightScale2Cube() {
    	addSequential(new RightScale());
    	
    	addSequential(new Turn(70, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_90));
    	
    	addSequential(new MotionMagic(AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN2));
    	
    	// addParallel(new Intake());
    	
    	addSequential(new Wait(1));
    	
    	addSequential(new MotionMagic(-AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN2));
    	
    	addSequential(new Turn(-70, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_90));
    	
    	addSequential(new SpinUpAndShoot());
    }
}
