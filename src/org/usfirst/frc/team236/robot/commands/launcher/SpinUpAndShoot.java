package org.usfirst.frc.team236.robot.commands.launcher;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import lib.commands.WaitCommand;

/**
 *
 */
public class SpinUpAndShoot extends CommandGroup {

    public SpinUpAndShoot() {
    	addParallel(new WaitCommand(RobotMap.LauncherMap.SPINUP_TIME, new Shoot(), RobotMap.LauncherMap.SHOOT_TIME));
    	
    	addSequential(new SpinUp(), RobotMap.LauncherMap.SPINUP_TIME + RobotMap.LauncherMap.SHOOT_TIME);
    }
}
