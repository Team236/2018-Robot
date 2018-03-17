package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.drive.StraightDrive;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftLongScaleDirect extends CommandGroup {
	/**
	 * Start from left side of the field, cross field to deliver into right plate of
	 * the scale. Crosses over the platform and corrects in null territory.
	 */
	public LeftLongScaleDirect() {
		addParallel(new PreAuto());
		addSequential(new MotionMagic(AutoMap.DIST_PLATFORM_ZONE_DIRECT, 6, 350, 1000));

		addSequential(new Turn(-113.5, 5, DriveMap.TURN_PARAMS_90));

		addSequential(new MotionMagic(AutoMap.DIST_CROSS_FIELD_DIRECT, AutoMap.MM_END_MARGIN), 7);
		
		addSequential(new StraightDrive(0, -0.5), 0.3);

		addSequential(new SpinUpAndShoot());
	}

	@Override
	public String toString() {
		return "Left long scale direct";
	}
}
