public class Point {

	private static double x;
	private static double y; 
	
	public Point()
	{
		x = 0;
		y = 0;
	}
	public Point(double setX,double setY)
	{
		x = setX;
		y = setY;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public String toString()
	{
		return ("Point[x=" + x + ",y=" + y + "]");
	}
}