package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.commands.launcher.Shoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScale extends CommandGroup {

    public LeftScale() {
    	addSequential(new AutoMotnMagic(RobotMap.AutoMap.SCALE_DIST, RobotMap.AutoMap.MM_END_MARGIN3));
    	
    	addSequential(new Turn(RobotMap.AutoMap.TURN_45_CW, RobotMap.AutoMap.TURN_MARGIN, RobotMap.AutoMap.TURN_PARAMS45));
    	
    	addSequential(new SpinUp());
    	
    	addSequential(new Wait(2));
    	
    	addSequential(new Shoot());
       
    }
}
