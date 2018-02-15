package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.commands.launcher.Shoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchOuter extends CommandGroup {

    public LeftSwitchOuter() {
    	addSequential(new AutoMotnMagic(RobotMap.AutoMap.SWITCH_DIST3, RobotMap.AutoMap.MM_END_MARGIN3));
    	
    	addSequential(new Turn(RobotMap.AutoMap.TURN_90_CW, RobotMap.AutoMap.TURN_MARGIN, RobotMap.AutoMap.TURN_PARAMS90));
    	
    	//"4" below is a timeout for this command - it means the command will end after those many seconds at most
    	addSequential(new AutoMotnMagic(RobotMap.AutoMap.SWITCH_DIST4, RobotMap.AutoMap.MM_END_MARGIN1), 4);
    	
    	addSequential(new SpinUp());
    	
    	addSequential(new Wait(2));
    	
    	addSequential(new Shoot());
       
    }
}
