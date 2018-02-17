package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.intake.Intake;
import org.usfirst.frc.team236.robot.commands.launcher.Shoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScale2Cube extends CommandGroup {

    public LeftScale2Cube() {
    	addSequential(new LeftScale());
    	
    	addSequential(new Turn(-50, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_45));
    	
    	addSequential(new MotionMagic(AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN2));
    	
    	// addParallel(new Intake());
    	
    	addSequential(new Wait(1));
    	
    	addSequential(new MotionMagic(-AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN2));
    	
    	addSequential(new Turn(50, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS45));
    	
    	addSequential(new SpinUp());
    	
    	addSequential(new Wait(2));
    	
    	addSequential(new Shoot());
      }
}
