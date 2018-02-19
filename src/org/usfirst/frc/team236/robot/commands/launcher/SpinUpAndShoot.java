package org.usfirst.frc.team236.robot.commands.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import lib.commands.WaitCommand;

/**
 *
 */
public class SpinUpAndShoot extends CommandGroup {

    public SpinUpAndShoot() {
    	addParallel(new WaitCommand(1.5, new Shoot(), 1));
    	
    	addSequential(new SpinUp(), 2.5);
    }
}
