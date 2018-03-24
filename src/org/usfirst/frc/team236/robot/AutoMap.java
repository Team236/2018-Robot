
package org.usfirst.frc.team236.robot;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class AutoMap {
	public static final double SWITCH_CROSS1 = -42; // 48
	public static final double SWITCH_CROSS2 = -108; // 108
	public static final double SWITCH_CROSS3 = -67; // 24+

	public static final double DIST_FENCE = -110; // 102
	public static final double DIST_FENCE_ALIGNMENT = -30;
	public static final double DIST_PAST_SWITCH = -140; // 168
	public static final double DIST_SIDE_FENCE = -30; // 21+

	public static final double DIST_NULL_TERRITORY = -256; // desired distance is 252.5
	public static final double TURN_NULL_TO_CUBE = 80;

	public static final double DIST_PLATFORM_ZONE = -220;
	public static final double DIST_CROSS_FIELD = -240; // 186 with bump, try 210
	public static final double DIST_PLATFORM_ZONE_TO_NULL_TERRITORY = -54; // 37

	public static final double DIST_PLATFORM_ZONE_DIRECT = -190; // -196, -220
	public static final double DIST_CROSS_FIELD_DIRECT = 303; //-240, 186 with bump, try 210

	public static final double DIST_AUTO_LINE = -150;

	public static final double DIST_SCALE_TO_CUBE = 66; // 70

	public static final double MM_END_MARGIN = 10;
	
	public static class Paths {
		
		public static final Waypoint[] CENTER_LEFT_SWITCH = new Waypoint[] {
				new Waypoint(1.5*12, 18*12, 0),
				//new Waypoint(5*12, 13*12, Pathfinder.d2r(110)),
				new Waypoint(10.5*12, 9*12, 0)
		};

		public static final Waypoint[] LEFT_LONG_SCALE = new Waypoint[] {
				new Waypoint(1.5*12, 23*12, 0),
				new Waypoint(14*12, 23*12, 0),
				new Waypoint(20*12, 17*12, Pathfinder.d2r(90)),
				new Waypoint(20*12, 10*12, Pathfinder.d2r(90)),
				new Waypoint(24*12, 2.5*12, Pathfinder.d2r(155))
		};

		public static final Waypoint[] RIGHT_LONG_SCALE = new Waypoint[] {
				new Waypoint(1.5*12, 4*12, 0),
				new Waypoint(14*12, 4*12, 0),
				new Waypoint(20*12, 10*12, Pathfinder.d2r(90)),
				new Waypoint(20*12, 17*12, Pathfinder.d2r(90)),
				new Waypoint(24*12, 24.5*12, Pathfinder.d2r(25))
		};
		
	}
}
