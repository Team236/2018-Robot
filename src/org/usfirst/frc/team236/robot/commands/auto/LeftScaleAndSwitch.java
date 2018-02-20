package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.commands.intake.Eject;
import org.usfirst.frc.team236.robot.commands.intake.IntakeAndFeed;
import org.usfirst.frc.team236.robot.commands.intake.Raise;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScaleAndSwitch extends CommandGroup {

    public LeftScaleAndSwitch() {
        addSequential(new LeftScale());
        addSequential(new Turn(AutoMap.TURN_NULL_TO_CUBE, AutoMap.TURN_MARGIN, AutoMap.TURN_PARAMS_90));
        
        addParallel(new IntakeAndFeed());
        addSequential(new MotionMagic(AutoMap.DIST_SCALE_TO_CUBE, 3));
        
        addSequential(new Raise(), .5);
        addSequential(new Eject(), .5);
    }
}
