package org.usfirst.frc.team236.robot.commands.auto.left;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.auto.MotionMagic;
import org.usfirst.frc.team236.robot.commands.auto.Turn;
import org.usfirst.frc.team236.robot.commands.intake.IntakeAndFeed;
import org.usfirst.frc.team236.robot.commands.launcher.SpinDown;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpAndShoot;
import org.usfirst.frc.team236.robot.commands.launcher.SpinUpNoStop2;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScale2Cube extends CommandGroup {

	public LeftScale2Cube() {
		addSequential(new LeftScale());

		addSequential(new Turn(-AutoMap.TURN_NULL_TO_CUBE, 5, DriveMap.TURN_PARAMS_90));

		addParallel(new MotionMagic(AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN));
		addSequential(new IntakeAndFeed());

		addParallel(new IntakeAndFeed());
		addSequential(new MotionMagic(-AutoMap.DIST_SCALE_TO_CUBE, AutoMap.MM_END_MARGIN), 2);

		addParallel(new SpinUpNoStop2(0.95));
		addSequential(new Turn(90, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_90));
		
		addSequential(new SpinUpAndShoot(0.95));
		
		addSequential(new SpinDown());
	}

	@Override
	public String toString() {
		return "Left scale: 2 cube";
	}
}
