package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.intake.Lower;
import org.usfirst.frc.team236.robot.commands.launcher.Shoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScale2Cube extends CommandGroup {

	public LeftScale2Cube() {
		addParallel(new Lower());
		addSequential(new LeftScale());

		addSequential(new Wait(2));

		addSequential(new Turn(-90, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_90));

		addSequential(new MotionMagic(AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN2));

		// addParallel(new Intake());

		addSequential(new Wait(1));

		addSequential(new MotionMagic(-AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN2), 2);

		addSequential(new Wait(1));

		addSequential(new Turn(90, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_90));

		addSequential(new SpinUp());

		addSequential(new Wait(2));

		addSequential(new Shoot());
	}
}
