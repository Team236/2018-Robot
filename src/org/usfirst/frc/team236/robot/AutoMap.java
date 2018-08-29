
package org.usfirst.frc.team236.robot;

import lib.motionProfile.ProfileParameters;

public class AutoMap {	
	public static final double SWITCH_CROSS1 = -42; // 48
	public static final double SWITCH_CROSS2 = -108; // 108
	public static final double SWITCH_CROSS3 = -67; // 24+

	public static final double DIST_FENCE = -102; // 102
	public static final double DIST_FENCE_ALIGNMENT = -30;
	public static final double DIST_PAST_SWITCH = -140; // 168
	public static final double DIST_SIDE_FENCE = -30; // 21+

	public static final double DIST_NULL_TERRITORY = -256; // desired distance is 252.5
	public static final double TURN_NULL_TO_CUBE = 95;

	public static final double DIST_PLATFORM_ZONE = -220;
	public static final double DIST_CROSS_FIELD = -240; // 186 with bump, try 210
	public static final double DIST_PLATFORM_ZONE_TO_NULL_TERRITORY = -54; // 37

	public static final double DIST_PLATFORM_ZONE_DIRECT = -248;//-220
	public static final double DIST_CROSS_FIELD_DIRECT = 255; //303 -240, 186 with bump, try 210

	public static final double DIST_AUTO_LINE = -150;

	public static final double DIST_SCALE_TO_CUBE = 70; // 70

	public static final double MM_END_MARGIN = 10;

	public static final ProfileParameters TO_NULL = new ProfileParameters(-DIST_NULL_TERRITORY, 100, 100, 0, 3);
	public static final ProfileParameters STRAIGHT_SWITCH = new ProfileParameters(-DIST_FENCE, 50, 50, 0, 5);
	public static final ProfileParameters TO_CUBE1 = new ProfileParameters(-DIST_SCALE_TO_CUBE, 50, 100, 0, 4);

	//public static final ProfileParameters OUTER = new ProfileParameters(-DIST_PAST_SWITCH, 150, 300, 0, 8, 1 / 100.0);
	public static final ProfileParameters OUTER = new ProfileParameters(-DIST_PAST_SWITCH, 100, 200, 0, 8);

	public static final ProfileParameters CROSS_SWITCH_1 = new ProfileParameters(-SWITCH_CROSS1, 50, 100, 0, 3);
	public static final ProfileParameters CROSS_SWITCH_2 = new ProfileParameters(-SWITCH_CROSS2, 100, 200, 0, 5);

	public static final ProfileParameters TO_PLATFORM_ZONE = new ProfileParameters(-DIST_PLATFORM_ZONE_DIRECT, 75, 150, 0, 5);
	public static final ProfileParameters CROSS_FIELD = new ProfileParameters(-DIST_CROSS_FIELD_DIRECT, 75, 150, 0, 10);
}
