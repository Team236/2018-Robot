package org.usfirst.frc.team236.robot.commands.auto.right;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.RobotMap.DriveMap;
import org.usfirst.frc.team236.robot.commands.auto.MotionMagic;
import org.usfirst.frc.team236.robot.commands.auto.Turn;
import org.usfirst.frc.team236.robot.commands.drive.StraightDrive;
import org.usfirst.frc.team236.robot.commands.intake.Eject;
import org.usfirst.frc.team236.robot.commands.intake.Intake;
import org.usfirst.frc.team236.robot.commands.intake.Raise;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScaleAndSwitch extends CommandGroup {

	public RightScaleAndSwitch() {
		addSequential(new RightScale());

		addSequential(new Turn(AutoMap.TURN_NULL_TO_CUBE, DriveMap.TURN_MARGIN, DriveMap.TURN_PARAMS_90));

		addParallel(new MotionMagic(AutoMap.DIST_SCALE_TO_CUBE, 3));
		addSequential(new Intake());
		
		addSequential(new Raise(), 1);

		addSequential(new StraightDrive(.3), 1);

		addSequential(new Eject(), .5);
	}

	@Override
	public String toString() {
		return "Right scale and switch";
	}
}
