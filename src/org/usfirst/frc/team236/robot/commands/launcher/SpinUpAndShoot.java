package org.usfirst.frc.team236.robot.commands.launcher;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import lib.commands.Wait;
import lib.commands.WaitCommand;

/**
 *
 */
public class SpinUpAndShoot extends CommandGroup {
	
	public SpinUpAndShoot(double speed) {
		/*
		addParallel(new WaitCommand(RobotMap.LauncherMap.SPINUP_TIME, new Shoot(), RobotMap.LauncherMap.SHOOT_TIME));

		addSequential(new SpinUp(speed), RobotMap.LauncherMap.SPINUP_TIME + RobotMap.LauncherMap.SHOOT_TIME);
		*/
		addSequential(new SpinUpNoStop(speed));
		addSequential(new Wait(RobotMap.LauncherMap.SPINUP_TIME));
		
		addSequential(new Shoot(), RobotMap.LauncherMap.SHOOT_TIME);
		addSequential(new SpinDown());
	}
	
	public SpinUpAndShoot() {
		this(RobotMap.LauncherMap.LAUNCH_SPEED);
	}
}
