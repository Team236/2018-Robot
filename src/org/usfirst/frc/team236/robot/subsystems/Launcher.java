package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Launcher extends Subsystem {
	public SpeedController topRight, topLeft, bottomRight, bottomLeft;
	public SpeedController spit;
	public DoubleSolenoid shoot;
	
	
	public Launcher() {
		topRight = new VictorSP(RobotMap.LauncherMap.PWM_TOP_RIGHT);
		topLeft = new VictorSP(RobotMap.LauncherMap.PWM_TOP_LEFT);
		bottomRight = new VictorSP(RobotMap.LauncherMap.PWM_BOTTOM_RIGHT);
		bottomLeft = new VictorSP(RobotMap.LauncherMap.PWM_BOTTOM_LEFT);
		spit = new VictorSP(RobotMap.LauncherMap.PWM_SPITTER);
		shoot = new DoubleSolenoid(RobotMap.LauncherMap.SOL_FWD, RobotMap.LauncherMap.SOL_REV);
		
	}
	
	public void extend() {
		shoot.set(Value.kForward);
	}
	
	public void retract() {
		shoot.set(Value.kReverse);
	}
	
	public void setLaunchSpeed() {
		topRight.set(RobotMap.LauncherMap.LAUNCH_SPEED);
		topLeft.set(RobotMap.LauncherMap.LAUNCH_SPEED);
		bottomRight.set(RobotMap.LauncherMap.LAUNCH_SPEED);
		bottomLeft.set(RobotMap.LauncherMap.LAUNCH_SPEED);
	}
	
	public void setSpitSpeed() {
		spit.set(RobotMap.LauncherMap.SPIT_SPEED);
	}
	
	public void stopLaunch() {
		topRight.set(0);
		topLeft.set(0);
		bottomRight.set(0);
		bottomLeft.set(0);
	}
	
	public void stopSpit() {
		spit.set(0);
		shoot.set(Value.kReverse);
	}
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

