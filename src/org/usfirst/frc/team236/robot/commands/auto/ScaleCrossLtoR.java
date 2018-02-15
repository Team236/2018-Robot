package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.commands.launcher.Shoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScaleCrossLtoR extends CommandGroup {

    public ScaleCrossLtoR() {
    	addSequential(new AutoMotnMagic(RobotMap.AutoMap.SCALE_CROSS1, RobotMap.AutoMap.MM_END_MARGIN3));
    	
    	addSequential(new Turn(RobotMap.AutoMap.TURN_90_CW, RobotMap.AutoMap.TURN_MARGIN, RobotMap.AutoMap.TURN_PARAMS90));
    	
    	addSequential(new AutoMotnMagic(RobotMap.AutoMap.SCALE_CROSS2, RobotMap.AutoMap.MM_END_MARGIN2));
    	
    	addSequential(new Turn(RobotMap.AutoMap.TURN_90_CCW, RobotMap.AutoMap.TURN_MARGIN, RobotMap.AutoMap.TURN_PARAMS_90));
    	
    	addSequential(new AutoMotnMagic(RobotMap.AutoMap.SCALE_CROSS3, RobotMap.AutoMap.MM_END_MARGIN1));
    	
    	addSequential(new Turn(RobotMap.AutoMap.TURN_45_CCW, RobotMap.AutoMap.TURN_MARGIN, RobotMap.AutoMap.TURN_PARAMS45));
    	
    	addSequential(new SpinUp());
    	
    	addSequential(new Wait(2));
    	
    	addSequential(new Shoot());
    }
}
