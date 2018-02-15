package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.launcher.Shoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScale extends CommandGroup {

    public RightScale() {
    	addSequential(new AutoMotnMagic(AutoMap.SCALE_DIST, AutoMap.MM_END_MARGIN3));
    	
    	addSequential(new Turn(AutoMap.TURN_45_CCW, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS45));
    	
    	addSequential(new SpinUp());
    	
    	addSequential(new Wait(2));
    	
    	addSequential(new Shoot());
       
    }
}
