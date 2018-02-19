package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.intake.IntakeAndFeed;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpAndShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScale2Cube extends CommandGroup {

	public LeftScale2Cube() {
		addSequential(new LeftScale());

		addSequential(new Turn(-90, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_90));

		addParallel(new IntakeAndFeed());
		addSequential(new MotionMagic(AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN2));

		addParallel(new IntakeAndFeed());
		addSequential(new MotionMagic(-AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN2), 2);

		addSequential(new Turn(90, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_90));

		addSequential(new SpinUpAndShoot());
	}
}
