package org.usfirst.frc.team236.robot.commands.auto.right;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.auto.FollowProfile;
import org.usfirst.frc.team236.robot.commands.auto.PreAuto;
import org.usfirst.frc.team236.robot.commands.auto.Turn;
import org.usfirst.frc.team236.robot.commands.launcher.SpinDown;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpAndShoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpNoStop2;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScale extends CommandGroup {
	/**
	 * Start all the way to the right portal.
	 * 
	 * Drive straight forward to null territory, turn 45 degrees, and deliver cube
	 * onto right scale plate.
	 */
	public RightScale() {
		addParallel(new PreAuto());
		//addSequential(new MotionMagic(AutoMap.DIST_NULL_TERRITORY, AutoMap.MM_END_MARGIN));
		addSequential(new FollowProfile(Robot.scale, true));

		addParallel(new SpinUpNoStop2(0.95));
		addSequential(new Turn(-60, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_45));

		addSequential(new SpinUpAndShoot());
		
		addSequential(new SpinDown());
	}

	@Override
	public String toString() {
		return "Right scale";
	}
}
