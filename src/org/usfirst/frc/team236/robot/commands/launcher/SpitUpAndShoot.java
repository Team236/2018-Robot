package org.usfirst.frc.team236.robot.commands.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import lib.commands.WaitCommand;

/**
 *
 */
public class SpitUpAndShoot extends CommandGroup {

    public SpitUpAndShoot() {
    	addParallel(new WaitCommand(.25, new Shoot(), 1));
    	
    	addSequential(new SpitUp(), 1.25);
    }
}
