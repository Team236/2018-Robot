package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.commands.drive.StraightDrive;
import org.usfirst.frc.team236.robot.commands.launcher.SpitUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterLeftSwitchPathfinder extends CommandGroup {
	/**
	 * Start from right side of field, aligned with the alliance wall partition.
	 * 
	 * Drive straight forward, turn left, drive to left switch plate, turn right,
	 * and drive forward while delivering cube to switch plate.
	 */
	public CenterLeftSwitchPathfinder() {
		addParallel(new PreAuto());
		addSequential(new FollowTrajectory(Robot.centerLeftSwitch));

		addParallel(new StraightDrive(-.20),1);
		addSequential(new SpitUpAndShoot());
	}

	@Override
	public String toString() {
		return "Center to left switch: pathfinder";
	}
}
