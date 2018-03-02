package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.intake.IntakeAndFeed;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScale2Cube extends CommandGroup {

	public LeftScale2Cube() {
		addSequential(new LeftScale());

		addSequential(new Turn(-AutoMap.TURN_NULL_TO_CUBE, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_90));

		addParallel(new IntakeAndFeed());
		addSequential(new MotionMagic(AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN));

		addParallel(new IntakeAndFeed());
		addSequential(new MotionMagic(-AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN), 2);

		addSequential(new Turn(90, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_90));

		addSequential(new SpinUpAndShoot());
	}

	@Override
	public String toString() {
		return "Left scale: 2 cube";
	}
}
