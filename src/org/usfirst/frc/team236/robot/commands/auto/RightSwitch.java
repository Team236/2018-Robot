package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.commands.launcher.Shoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitch extends CommandGroup {

    public RightSwitch() {
    	addSequential(new AutoMotnMagic(RobotMap.AutoMap.SWITCH_DIST1, RobotMap.AutoMap.MM_END_MARGIN2));
    	
    	addSequential(new SpinUp());
    	
    	addSequential(new Wait(2));
    	
    	addSequential(new Shoot());
        
    }
}
