package org.usfirst.frc.team236.robot.commands.auto.left;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.auto.FollowProfile;
import org.usfirst.frc.team236.robot.commands.auto.GyroDrive;
import org.usfirst.frc.team236.robot.commands.auto.MotionMagic;
import org.usfirst.frc.team236.robot.commands.auto.PreAuto;
import org.usfirst.frc.team236.robot.commands.auto.Turn;
import org.usfirst.frc.team236.robot.commands.launcher.SpinDown;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpNoStop2;
import org.usfirst.frc.team236.robot.commands.launcher.SpitUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchOuter extends CommandGroup {
	/**
	 * Start aligned with the left switch plate.
	 * 
	 * Drive forward to fence and deliver cube to left switch plate.
	 */
	public LeftSwitchOuter() {
		addParallel(new PreAuto());
		//addSequential(new MotionMagic(AutoMap.DIST_PAST_SWITCH, AutoMap.MM_END_MARGIN));
		addSequential(new FollowProfile(Robot.outer, true));

		addSequential(new Turn(90, 15, DriveMap.TURN_PARAMS_90));

		// "4" below is a timeout for this command - it means the command will end after
		// those many seconds at most
		//addSequential(new MotionMagic(AutoMap.DIST_SIDE_FENCE, AutoMap.MM_END_MARGIN), 2);

		addParallel(new SpinUpNoStop2());
		addSequential(new GyroDrive(.04, AutoMap.DIST_SIDE_FENCE, -0.5), 2);

		addSequential(new SpitUpAndShoot());
		
		addSequential(new SpinDown());

		//addSequential(new MotionMagic(-AutoMap.DIST_SIDE_FENCE, AutoMap.MM_END_MARGIN), 2);
		addSequential(new GyroDrive(-AutoMap.DIST_SIDE_FENCE));

		addSequential(new Turn(-90, 20, DriveMap.TURN_PARAMS_90));

		addSequential(new MotionMagic(-72, 10), 4);
	}

	@Override
	public String toString() {
		return "Left switch: outer";
	}
}
