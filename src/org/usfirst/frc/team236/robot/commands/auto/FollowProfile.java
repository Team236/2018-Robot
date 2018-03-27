package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import lib.motionProfile.DriveParameters;
import lib.motionProfile.Element;
import lib.motionProfile.TrapProfile;

/**
 *
 */
public class FollowProfile extends Command {

	TrapProfile profile;
	DriveParameters params;
	boolean reverse;
	double endPos, margin, leftDistToEnd, rightDistToEnd;
	int i = 0;

	public FollowProfile(TrapProfile _p, DriveParameters _params, boolean _rev, double _margin) {
		requires(Robot.drive);

		this.profile = _p;
		this.params = _params;
		this.reverse = _rev;
		this.margin = _margin;
		this.endPos = profile.getLast().position;
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
		double l_v = params.kV * e.speed;
		double l_a = params.kA * e.acceleration;
		// Calculate corrections
		double l_error = (e.position - Robot.drive.getLeftDistance());
		double l_p = params.kP * l_error;
		leftDistToEnd = Robot.drive.getLeftDistance() - endPos;
		
		// Repeat for right side
		// Calculate feedforwards
		double r_v = params.kV * e.speed;
		double r_a = params.kA * e.acceleration;
		// Calculate corrections
		double r_error = (e.position - Robot.drive.getLeftDistance());
		double r_p = params.kP * r_error;
		rightDistToEnd = Robot.drive.getRightDistance() - endPos;
		
		Robot.drive.setLeftSpeed(l_v + l_a + l_p);
		Robot.drive.setRightSpeed(r_v + r_a + r_p);
		
		i++;
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
