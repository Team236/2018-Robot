package org.usfirst.frc.team236.robot.commands.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FullShoot extends CommandGroup {

	public FullShoot() {
		addSequential(new Shoot(), .25);
	}
}
