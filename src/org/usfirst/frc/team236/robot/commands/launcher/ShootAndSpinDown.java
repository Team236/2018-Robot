package org.usfirst.frc.team236.robot.commands.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import lib.commands.Wait;

/**
 *
 */
public class ShootAndSpinDown extends CommandGroup {

    public ShootAndSpinDown() {
        addSequential(new FullShoot());
        addSequential(new Wait(.25));
        addSequential(new SpinDown());
    }
}
