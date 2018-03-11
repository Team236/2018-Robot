package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.commands.intake.Feed;
import org.usfirst.frc.team236.robot.commands.intake.Lower;
import org.usfirst.frc.team236.robot.commands.intake.Raise;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PreAuto extends CommandGroup {

	public PreAuto() {
		addSequential(new Raise());
		addSequential(new Wait(.5));
		addSequential(new Lower());
		addSequential(new Wait(.5));
		addSequential(new Feed(), 1);
	}
}
