package org.usfirst.frc.team236.robot;

import jaci.pathfinder.Waypoint;

public class ProfileSettings {

	public Waypoint[] waypoints;
	public double maxV, maxA, maxJ;
	public String name;

	public ProfileSettings(Waypoint[] points, String _name, double _v, double _a, double _j) {
		this.waypoints = points;

		this.maxV = _v;
		this.maxA = _a;
		this.maxV = _j;

		this.name = _name;
	}

	@Override
	public String toString() {
		return name;
	}

	public void generate() {

	}
}
