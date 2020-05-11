import edu.elon.cs.Physics.Kinetic;
import java.util.ArrayList;
import java.awt.Point;

public class FlyingPumpkin {

	public double positionX;
	public double positionY;
	public double velocityX;
	public double velocityY;
	
	public FlyingPumpkin(int x)
	{
		positionX = x;
		positionY = 0;
	}
	private void move(double time, double gravity)
	{
		positionX = Kinetic.distanceTraveled(velocityX, time, 0);
		positionY = Kinetic.distanceTraveled(velocityY, time, gravity);
		velocityY = Kinetic.distanceTraveled(velocityY, time, gravity);
	}
	public ArrayList<Point> launch(double alpha, double velocity, double time, double gravity)
	{
		ArrayList<Point> launch = new ArrayList<Point>();
		Point p = new Point();
		launch.add(p);
		velocityX = velocity * (Math.cos(alpha));
		velocityY = velocity * (Math.sin(alpha));
		Math.toRadians(alpha);
		move(time, gravity);
		for (int i =0; i < launch.size(); i++){
			launch.add(p);
		}
		return launch;
	}
	
}
