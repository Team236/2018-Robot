package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightLongScale extends CommandGroup {
	/**
	 * Start from left side of the field, cross field to deliver into right plate of
	 * the scale.
	 */
	public RightLongScale() {
		addParallel(new PreAuto());
		addSequential(new MotionMagic(AutoMap.DIST_PLATFORM_ZONE, 6));

		addSequential(new Turn(-90, 5, DriveMap.TURN_PARAMS_90));

		addSequential(new MotionMagic(AutoMap.DIST_CROSS_FIELD, AutoMap.MM_END_MARGIN));

		addSequential(new Turn(90, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_90));

		addSequential(new MotionMagic(AutoMap.DIST_PLATFORM_ZONE_TO_NULL_TERRITORY, AutoMap.MM_END_MARGIN));

		addSequential(new Turn(45, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_45));

		addSequential(new SpinUpAndShoot());
	}

	@Override
	public String toString() {
		return "Right long scale";
	}
}
