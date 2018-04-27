package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.motionProfile.DriveParameters;
import lib.motionProfile.Element;
import lib.motionProfile.ProfileParameters;
import lib.motionProfile.TrapProfile;

/**
 *
 */
public class FollowProfile extends Command {

	TrapProfile profile;
	DriveParameters params;
	boolean reverse;
	int reverseMultiplier = 1;
	double endPos, margin, leftDistToEnd, rightDistToEnd;
	public static boolean isDebug = true;
	int i = 0;

	public FollowProfile(TrapProfile _p, DriveParameters _params, boolean _rev) {
		requires(Robot.drive);

		this.profile = _p;
		this.params = _params;
		this.reverse = _rev;
		this.margin = profile.margin;
		this.endPos = profile.getLast().position;

		if (reverse) {
			this.reverseMultiplier = -1;
		}
	}
	
	public FollowProfile(TrapProfile _p) {
		this(_p, RobotMap.DriveMap.DRIVE_PARAMS, false);
	}
	
	public FollowProfile(TrapProfile _p, boolean _rev) {
		this(_p, RobotMap.DriveMap.DRIVE_PARAMS, _rev);
	}

	public FollowProfile(ProfileParameters _params, DriveParameters _driveParams, boolean _rev) {
		this(new TrapProfile(_params), _driveParams, _rev);
	}

	protected void initialize() {
		Robot.drive.stop();
		Robot.drive.resetEncoders();
		i = 0;
	}

	protected void execute() {
		// Constrain i within bounds of profile
		if (i < 0) {
			i = 0;
		} else if (i >= profile.length()) {
			i = profile.length() - 1;
		}

		// Get element from profile
		Element e = profile.get(i);

		// Calculate feedforwards
		double l_v = params.kV_l * e.speed;
		double l_a = params.kA_l * e.acceleration;
		// Calculate corrections
		double l_error = (reverseMultiplier * e.position - Robot.drive.getLeftDistance());
		double l_p = params.kP * l_error;
		leftDistToEnd = reverseMultiplier * Robot.drive.getLeftDistance() - endPos;

		// Repeat for right side
		// Calculate feedforwards
		double r_v = params.kV_r * e.speed;
		double r_a = params.kA_r * e.acceleration;
		// Calculate corrections
		double r_error = (reverseMultiplier * e.position - Robot.drive.getRightDistance());
		double r_p = params.kP * r_error;
		rightDistToEnd = reverseMultiplier * Robot.drive.getRightDistance() - endPos;

		Robot.drive.setLeftSpeed(reverseMultiplier * (l_v + l_a + l_p));
		Robot.drive.setRightSpeed(reverseMultiplier * (r_v + r_a + r_p));


		i++;
		
		if (isDebug) {
			SmartDashboard.putNumber("Left v", l_v);
			SmartDashboard.putNumber("Right v", r_v);

			SmartDashboard.putNumber("Left a", l_a);
			SmartDashboard.putNumber("Right a", r_a);

			SmartDashboard.putNumber("Right profile error", r_error);
			SmartDashboard.putNumber("Left profile error", l_error);

			SmartDashboard.putNumber("Left p", l_p);
			SmartDashboard.putNumber("Right p", r_p);
		}
	}

	protected boolean isFinished() {
		boolean isLeftFinished = Math.abs(leftDistToEnd) < margin;
		boolean isRightFinished = Math.abs(rightDistToEnd) < margin;

		return isLeftFinished && isRightFinished && (i == profile.length());
	}

	protected void end() {
		Robot.drive.stop();
	}

	protected void interrupted() {
		end();
	}
}
