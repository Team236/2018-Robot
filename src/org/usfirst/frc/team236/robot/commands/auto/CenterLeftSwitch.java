package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.intake.Feed;
import org.usfirst.frc.team236.robot.commands.intake.Lower;
import org.usfirst.frc.team236.robot.commands.launcher.SpitUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterLeftSwitch extends CommandGroup {
	/**
	 * Start from right side of field, aligned with the alliance wall partition.
	 * 
	 * Drive straight forward, turn left, drive to left switch plate, turn right,
	 * and drive forward while delivering cube to switch plate.
	 */
	public CenterLeftSwitch() {
		addParallel(new Lower());
		addParallel(new Feed(), .5);
		addSequential(new MotionMagic(AutoMap.SWITCH_CROSS1, AutoMap.MM_END_MARGIN));

		addSequential(new Turn(-90, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_90));

		addSequential(new MotionMagic(AutoMap.SWITCH_CROSS2, AutoMap.MM_END_MARGIN));

		addSequential(new Turn(90, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_90));

		// "3" below is a timeout for this command - it means the command will end after
		// those many seconds at most
		addSequential(new MotionMagic(AutoMap.SWITCH_CROSS3, AutoMap.MM_END_MARGIN), 3);

		addSequential(new SpitUpAndShoot());
	}

	@Override
	public String toString() {
		return "Right to left switch";
	}
}
