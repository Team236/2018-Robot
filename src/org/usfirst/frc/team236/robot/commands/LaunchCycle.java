package org.usfirst.frc.team236.robot.commands;

import com.ctre.phoenix.time.StopWatch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LaunchCycle extends CommandGroup {

    public LaunchCycle() {
    	addSequential(new StartLaunch());
    	addSequential(new Wait(0.5));
    	addSequential(new Extend());
    	addSequential(new Wait(1));
    	addSequential(new Retract());
    	addSequential(new StopLaunch());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
