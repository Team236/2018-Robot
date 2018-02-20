package org.usfirst.frc.team236.robot;

import lib.pid.PIDParameters;

public class AutoMap {
	public static final double TURN_MARGIN = 3.0;

	// public static final double P_TURN = SmartDashboard.getNumber("P", 0);
	// public static final double I_TURN = SmartDashboard.getNumber("I", 0);
	// public static final double D_TURN = SmartDashboard.getNumber("D", 0);
	// public static final PIDParameters TURN_PARAMS = new PIDParameters(P_TURN, I_TURN, D_TURN, 1 / 100.0);
	public static final PIDParameters TURN_PARAMS_45 = new PIDParameters(0.06, 0.00, -0.003, 1 / 100.0);
	public static final PIDParameters TURN_PARAMS_90 = new PIDParameters(0.01, 0.0005, -0.000, 1 / 100.0); //P = .028
	// public static final PIDParameters TURN_PARAMS_60 = new PIDParameters(0.0, 0.00, 0.0, 1 / 100.0);
	// TESTBED 2/10- on carpet for 45 and 30 deg, P = 0.019, I = 0, D = -0.0001, fresh battery 57 deg
	// TESTBED 2/10- on carpet for -45 deg, P = 0.06, needs more tuning short by a few degrees
	// TESTBED 2/10 on carpet for +/-90 deg, P = 0.0147, D = -0.003

	public static final double SWITCH_CROSS1 = -48; // 48
	public static final double SWITCH_CROSS2 = -108; // 108
	public static final double SWITCH_CROSS3 = -24; // 24+

	public static final double DIST_FENCE = -100; // 102
	public static final double DIST_FENCE_ALIGNMENT = -30;
	public static final double DIST_PAST_SWITCH = -140; // 168
	public static final double DIST_SIDE_FENCE = -30; // 21+

	public static final double DIST_NULL_TERRITORY = -256; // desired distance is 252.5

	public static final double DIST_PLATFORM_ZONE = -209.5;
	public static final double DIST_CROSS_FIELD = -186; // 186 with bump, try 210
	public static final double DIST_PLATFORM_ZONE_TO_NULL_TERRITORY = -37; // 37

	public static final double DIST_AUTO_LINE = -150;

	public static final double DIST_SCALE_TO_CUBE = 80; // 70

	public static final double MM_END_MARGIN1 = 2; // SW cross 3 - margin 1 > 24
	public static final double MM_END_MARGIN2 = 5;
	public static final double MM_END_MARGIN3 = 10;

	public static final double M_MAGIC_K_P = 0.3;
	public static final double M_MAGIC_K_I = 0.0;
	public static final double M_MAGIC_K_D = 0.0;
	public static final double M_MAGIC_K_F_L = 1.2;
	public static final double M_MAGIC_K_F_R = 1.2;
	// TESTBED 2/10- on carpet for 252 and 101, F = 1.5, P = 0.01, I = 0, D = 0
	// TESTBED CV = 1280, ACCEL = 1280 Margin = 20

	public static final int M_MAGIC_CV = 500;
	public static final int M_MAGIC_ACCL = 1000;
}
