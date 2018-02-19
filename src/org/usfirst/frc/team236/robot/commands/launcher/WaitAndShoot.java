package org.usfirst.frc.team236.robot.commands.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import lib.commands.Wait;

/**
 */
public class WaitAndShoot extends CommandGroup {

    public WaitAndShoot() {
        addSequential(new Wait(2));
        addSequential(new Shoot(), 1);
    }
}
