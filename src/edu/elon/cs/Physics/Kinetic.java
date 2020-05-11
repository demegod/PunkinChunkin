package edu.elon.cs.Physics;

public class Kinetic {

	public static double earthG = -9.81;
	public static double moonG = -1.625;
	public static double marsG = -3.75;
	
	public static double distanceTraveled(double velocity, double time, double acceleration)
	{
		double distance = (velocity*time) + (1/2)*acceleration*(Math.sqrt(time));
		return distance;
	}
	public static double finalVelocity(double velocity, double time, double acceleration)
	{
		double finalV = velocity + (acceleration*time);
		return finalV;
	}
}