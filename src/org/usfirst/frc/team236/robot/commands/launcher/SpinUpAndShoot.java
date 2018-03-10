package org.usfirst.frc.team236.robot.commands.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import lib.commands.WaitCommand;

/**
 *
 */
public class SpinUpAndShoot extends CommandGroup {

    public SpinUpAndShoot() {
    	addParallel(new WaitCommand(.50, new Shoot(), .5));
    	
    	addSequential(new SpinUp(), 1.00);
    }
}
