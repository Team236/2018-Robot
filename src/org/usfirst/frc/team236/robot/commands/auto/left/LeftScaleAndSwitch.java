package org.usfirst.frc.team236.robot.commands.auto.left;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.auto.MotionMagic;
import org.usfirst.frc.team236.robot.commands.auto.Turn;
import org.usfirst.frc.team236.robot.commands.intake.Eject;
import org.usfirst.frc.team236.robot.commands.intake.Intake;
import org.usfirst.frc.team236.robot.commands.intake.Raise;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScaleAndSwitch extends CommandGroup {

	public LeftScaleAndSwitch() {
		addSequential(new LeftScale());

		addSequential(new Turn(-AutoMap.TURN_NULL_TO_CUBE, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_90));

		addParallel(new MotionMagic(AutoMap.DIST_SCALE_TO_CUBE, 3));
		addSequential(new Intake());

		addSequential(new Raise(), 1);

		addSequential(new Eject(), .5);
	}

	@Override
	public String toString() {
		return "Left scale and switch";
	}
}
