package org.usfirst.frc.team236.robot.commands.auto.left;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.auto.FollowProfile;
import org.usfirst.frc.team236.robot.commands.auto.MotionMagic;
import org.usfirst.frc.team236.robot.commands.auto.PreAuto;
import org.usfirst.frc.team236.robot.commands.auto.Turn;
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
		//addSequential(new MotionMagic(AutoMap.DIST_PLATFORM_ZONE_DIRECT, 6, 450, 500));
		addSequential(new FollowProfile(Robot.toPlatform, true));

		addSequential(new Turn(-100, 5, DriveMap.TURN_PARAMS_90));

		addSequential(new MotionMagic(AutoMap.DIST_CROSS_FIELD_DIRECT, AutoMap.MM_END_MARGIN), 7);
		//addSequential(new FollowProfile(Robot.crossField));
		
		addSequential(new StraightDrive(-.25, -0.5), 0.4);
		addSequential(new SpinUpNoStop2());

		addSequential(new SpinUpAndShoot());
	}

	@Override
	public String toString() {
		return "Left long scale direct";
	}
}
