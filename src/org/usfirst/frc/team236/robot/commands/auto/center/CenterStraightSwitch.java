package org.usfirst.frc.team236.robot.commands.auto.center;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.commands.auto.FollowProfile;
import org.usfirst.frc.team236.robot.commands.auto.PreAuto;
import org.usfirst.frc.team236.robot.commands.drive.StraightDrive;
import org.usfirst.frc.team236.robot.commands.launcher.SpitUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterStraightSwitch extends CommandGroup {
	/**
	 * Start in line with the right switch plate.
	 * 
	 * Drive straight forward and shoot cube.
	 */

	public CenterStraightSwitch() {
		// "4" below is a timeout for this command - it means the command will end after
		// those many seconds at most
		addParallel(new PreAuto());
		//addSequential(new MotionMagic(AutoMap.DIST_FENCE, AutoMap.MM_END_MARGIN, 100, 100), 4);
		addSequential(new FollowProfile(Robot.straightSwitch, true), 6);

		addParallel(new StraightDrive(-.40),1);
		addSequential(new SpitUpAndShoot());
	}

	@Override
	public String toString() {
		return "Right switch: straight ahead";
	}
}
