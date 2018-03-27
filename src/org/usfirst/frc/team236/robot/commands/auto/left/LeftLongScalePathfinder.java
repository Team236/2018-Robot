package org.usfirst.frc.team236.robot.commands.auto.left;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.commands.auto.FollowTrajectory;
import org.usfirst.frc.team236.robot.commands.auto.PreAuto;
import org.usfirst.frc.team236.robot.commands.auto.Turn;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftLongScalePathfinder extends CommandGroup {

	public LeftLongScalePathfinder() {
		addParallel(new PreAuto());
		addSequential(new FollowTrajectory(Robot.leftLongScale));

		addSequential(new Turn(-90, 3, RobotMap.DriveMap.TURN_PARAMS_90));
		addSequential(new SpinUpAndShoot());
	}
	
	public String toString() {
		return "Left long scale: pathfinder";
	}
}
