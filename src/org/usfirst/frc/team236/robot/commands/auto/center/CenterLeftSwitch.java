package org.usfirst.frc.team236.robot.commands.auto.center;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.auto.FollowProfile;
import org.usfirst.frc.team236.robot.commands.auto.GyroDrive;
import org.usfirst.frc.team236.robot.commands.auto.PreAuto;
import org.usfirst.frc.team236.robot.commands.auto.Turn;
import org.usfirst.frc.team236.robot.commands.drive.StraightDrive;
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
		addParallel(new PreAuto());
		//addSequential(new MotionMagic(AutoMap.SWITCH_CROSS1, AutoMap.MM_END_MARGIN));
		addSequential(new FollowProfile(Robot.crossSwitch1, RobotMap.DriveMap.DRIVE_PARAMS, true));

		addSequential(new Turn(-90, 5, DriveMap.TURN_PARAMS_90));

		//addSequential(new MotionMagic(AutoMap.SWITCH_CROSS2, AutoMap.MM_END_MARGIN));
		addSequential(new FollowProfile(Robot.crossSwitch2, RobotMap.DriveMap.DRIVE_PARAMS, true));

		addSequential(new Turn(90, 5, DriveMap.TURN_PARAMS_90));

		// "3" below is a timeout for this command - it means the command will end after
		// those many seconds at most
		//addSequential(new MotionMagic(AutoMap.SWITCH_CROSS3, AutoMap.MM_END_MARGIN), 3);
		//addSequential(new StraightDrive(-.4), 1.4);
		addSequential(new GyroDrive(.04, 40, -.5), 1.5);
		addSequential(new StraightDrive(-.40),1);

		//addParallel(new StraightDrive(-.40),1);
		addSequential(new SpitUpAndShoot());
	}

	@Override
	public String toString() {
		return "Center to left switch";
	}
}
