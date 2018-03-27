package org.usfirst.frc.team236.robot.commands.auto.right;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.auto.MotionMagic;
import org.usfirst.frc.team236.robot.commands.auto.Turn;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import lib.commands.Wait;

/**
 *
 */
public class RightScale2Cube extends CommandGroup {

	public RightScale2Cube() {
		addSequential(new RightScale());

		addSequential(new Turn(70, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_90));

		addSequential(new MotionMagic(AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN));

		// addParallel(new Intake());

		addSequential(new Wait(1));

		addSequential(new MotionMagic(-AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN));

		addSequential(new Turn(-70, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_90));

		addSequential(new SpinUpAndShoot());
	}

	@Override
	public String toString() {
		return "Right scale: 2 cubes";
	}
}
