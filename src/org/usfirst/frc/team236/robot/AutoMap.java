
package org.usfirst.frc.team236.robot;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;
import lib.motionProfile.ProfileParameters;

public class AutoMap {
	public static final double M_MAGIC_K_P = 0.6;
	public static final double M_MAGIC_K_I = 0;
	public static final double M_MAGIC_K_D = 0;
	public static final double M_MAGIC_K_F_L = 1.8;
	public static final double M_MAGIC_K_F_R = 1.9;
	//public static final double M_MAGIC_K_F_L = 1.7;
	//public static final double M_MAGIC_K_F_R = 1.7;
	
	public static final double SWITCH_CROSS1 = -42; // 48
	public static final double SWITCH_CROSS2 = -102; // 108
	public static final double SWITCH_CROSS3 = -67; // 24+

	public static final double DIST_FENCE = -102; // 102
	public static final double DIST_FENCE_ALIGNMENT = -30;
	public static final double DIST_PAST_SWITCH = -140; // 168
	public static final double DIST_SIDE_FENCE = -30; // 21+

	public static final double DIST_NULL_TERRITORY = -256; // desired distance is 252.5
	public static final double TURN_NULL_TO_CUBE = 90;

	public static final double DIST_PLATFORM_ZONE = -220;
	public static final double DIST_CROSS_FIELD = -240; // 186 with bump, try 210
	public static final double DIST_PLATFORM_ZONE_TO_NULL_TERRITORY = -54; // 37

	public static final double DIST_PLATFORM_ZONE_DIRECT = -248;//-220
	public static final double DIST_CROSS_FIELD_DIRECT = 255; //303 -240, 186 with bump, try 210

	public static final double DIST_AUTO_LINE = -150;

	public static final double DIST_SCALE_TO_CUBE = 70; // 70

	public static final double MM_END_MARGIN = 10;

	public static final ProfileParameters TO_NULL = new ProfileParameters(-DIST_NULL_TERRITORY, 100, 100, 0, 3);
	public static final ProfileParameters STRAIGHT_SWITCH = new ProfileParameters(-DIST_FENCE, 50, 50, 0, 4);
	public static final ProfileParameters TO_CUBE1 = new ProfileParameters(-DIST_SCALE_TO_CUBE, 50, 100, 0, 4);

	public static final ProfileParameters OUTER = new ProfileParameters(-DIST_PAST_SWITCH, 150, 300, 0, 8, 1 / 100.0);

	public static final ProfileParameters CROSS_SWITCH_1 = new ProfileParameters(-SWITCH_CROSS1, 48, 100, 0, 3);
	public static final ProfileParameters CROSS_SWITCH_2 = new ProfileParameters(-SWITCH_CROSS2, 48, 100, 0, 3);

	public static final ProfileParameters TO_PLATFORM_ZONE = new ProfileParameters(-DIST_PLATFORM_ZONE_DIRECT, 75, 150, 0, 5);
	public static final ProfileParameters CROSS_FIELD = new ProfileParameters(-DIST_CROSS_FIELD_DIRECT, 75, 150, 0, 10);

	public static class Paths {
		
		private static final Waypoint[] CENTER_LEFT_SWITCH_POINTS = new Waypoint[] {
				new Waypoint(1.5*12, 18*12, 0),
				//new Waypoint(5*12, 13*12, Pathfinder.d2r(110)),
				new Waypoint(10.5*12, 9*12, 0)
		};

		private static final Waypoint[] LEFT_LONG_SCALE_POINTS = new Waypoint[] {
				new Waypoint(1.5*12, 23*12, 0),
				new Waypoint(14*12, 23*12, 0),
				new Waypoint(20*12, 17*12, Pathfinder.d2r(90)),
				new Waypoint(20*12, 10*12, Pathfinder.d2r(90)),
				new Waypoint(24*12, 2.5*12, Pathfinder.d2r(155))
		};

		private static final Waypoint[] RIGHT_LONG_SCALE_POINTS = new Waypoint[] {
				new Waypoint(1.5*12, 4*12, 0),
				new Waypoint(14*12, 4*12, 0),
				new Waypoint(20*12, 10*12, Pathfinder.d2r(90)),
				new Waypoint(20*12, 17*12, Pathfinder.d2r(90)),
				new Waypoint(24*12, 24.5*12, Pathfinder.d2r(25))
		};
		
		public static final ProfileSettings CENTER_LEFT_SWITCH = new ProfileSettings(CENTER_LEFT_SWITCH_POINTS, "Center left sw", 12, 120, 1000);
		public static final ProfileSettings LEFT_LONG_SCALE = new ProfileSettings(LEFT_LONG_SCALE_POINTS, "Left long sc", 12, 120, 1000);
		public static final ProfileSettings RIGHT_LONG_SCALE = new ProfileSettings(RIGHT_LONG_SCALE_POINTS, "Right long sc", 12, 120, 1000);
	}
}
