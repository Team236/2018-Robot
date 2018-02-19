package org.usfirst.frc.team236.robot.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeAndFeed extends CommandGroup {

    public IntakeAndFeed() {
    	addSequential(new Intake());
    	addSequential(new Feed(), 1);
    }
}
