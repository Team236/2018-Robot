package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OppositeSwitch extends CommandGroup {

    public OppositeSwitch() {
    	addSequential(new AutoMotnMagic(RobotMap.AutoMap.STRAIGHT_DISTANCE1, RobotMap.AutoMap.MM_END_MARGIN1));
    	
    	addSequential(new Turn(RobotMap.AutoMap.TURN_DEGREES, RobotMap.AutoMap.TURN_MARGIN, RobotMap.AutoMap.TURN_PARAMS90));
    	
    	addSequential(new AutoMotnMagic(RobotMap.AutoMap.STRAIGHT_DISTANCE2, RobotMap.AutoMap.MM_END_MARGIN2));
    	
    	addSequential(new Turn(RobotMap.AutoMap.TURN_DEGREES2, RobotMap.AutoMap.TURN_MARGIN, RobotMap.AutoMap.TURN_PARAMS90));
    	
    	addSequential(new AutoMotnMagic(RobotMap.AutoMap.STRAIGHT_DISTANCE3, RobotMap.AutoMap.MM_END_MARGIN3));
    	
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
