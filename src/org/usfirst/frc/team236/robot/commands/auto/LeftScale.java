package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScale extends CommandGroup {
	/**
	 * Start all the way to the left portal.
	 * 
	 * 
	 * Drive straight forward to null territory, turn 45 degrees right, and deliver
	 * cube onto left scale plate.
	 */

	public LeftScale() {
		addParallel(new PreAuto());
		addSequential(new MotionMagic(AutoMap.DIST_NULL_TERRITORY, AutoMap.MM_END_MARGIN, 350, 800));

		addSequential(new Turn(60, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_45)); // could angle robot and turn 60

		addSequential(new SpinUpAndShoot());
	}

	@Override
	public String toString() {
		return "Left scale";
	}
}
