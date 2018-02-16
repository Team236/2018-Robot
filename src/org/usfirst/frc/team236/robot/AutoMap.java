package org.usfirst.frc.team236.robot;

import lib.pid.PIDParameters;

public class AutoMap {
	public static final double TURN_MARGIN = 20.0;

	// public static final double P_TURN = SmartDashboard.getNumber("P", 0);
	// public static final double I_TURN = SmartDashboard.getNumber("I", 0);
	// public static final double D_TURN = SmartDashboard.getNumber("D", 0);
	// public static final PIDParameters TURN_PARAMS = new PIDParameters(P_TURN, I_TURN, D_TURN, 1 / 100.0);
	public static final PIDParameters TURN_PARAMS45 = new PIDParameters(0.019, 0.00, -0.0001, 1 / 100.0);
	public static final PIDParameters TURN_PARAMS_45 = new PIDParameters(0.06, 0.00, 0.000, 1 / 100.0);
	public static final PIDParameters TURN_PARAMS90 = new PIDParameters(0.0147, 0.00, -0.003, 1 / 100.0);
	public static final PIDParameters TURN_PARAMS_90 = new PIDParameters(0.0147, 0.00, -0.003, 1 / 100.0);
	// TESTBED 2/10- on carpet for 45 and 30 deg, P = 0.019, I = 0, D = -0.0001, fresh battery 57 deg
	// TESTBED 2/10- on carpet for -45 deg, P = 0.06, needs more tuning short by a few degrees
	// TESTBED 2/10 on carpet for +/-90 deg, P = 0.0147, D = -0.003
	
	public static final double SWITCH_CROSS1 = -48;
	public static final double SWITCH_CROSS2 = -108;
	public static final double SWITCH_CROSS3 = -32;
	
	public static final double SWITCH_DIST1 = -105;
	public static final double SWITCH_DIST2 = -30;
	public static final double SWITCH_DIST3 = -168;
	public static final double SWITCH_DIST4 = -30;
	
	public static final double SCALE_DIST = -252.5;
	
	public static final double SCALE_CROSS1 = -209.5;
	public static final double SCALE_CROSS2 = -186; //with bump
	public static final double SCALE_CROSS3 = -37;
	
	public static final double STRAIGHT_DIST = -150;
	
	public static final double MM_END_MARGIN1 = 15;
	public static final double MM_END_MARGIN2 = 20; //40
	public static final double MM_END_MARGIN3 = 40; //60
	
	public static final double M_MAGIC_K_P = 0.01;
	public static final double M_MAGIC_K_I = 0.0;
	public static final double M_MAGIC_K_D = 0.0;
	public static final double M_MAGIC_K_F = 1.5;
	// TESTBED 2/10- on carpet for 252 and 101, F = 1.5, P = 0.01, I = 0, D = 0
	// TESTBED CV = 1280, ACCEL = 1280 Margin = 20

	public static final int M_MAGIC_CV = 1280;
	public static final int M_MAGIC_ACCL = 1280;
}