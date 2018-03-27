package org.usfirst.frc.team236.robot.commands.auto.right;

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
public class RightLongScalePathfinder extends CommandGroup {

	public RightLongScalePathfinder() {
		addParallel(new PreAuto());
		addSequential(new FollowTrajectory(Robot.rightLongScale));

		addSequential(new Turn(90, 3, RobotMap.DriveMap.TURN_PARAMS_90));
		addSequential(new SpinUpAndShoot());
	}
	
	public String toString() {
		return "Right long scale: pathfinder";
	}
}
