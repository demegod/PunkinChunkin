import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import edu.elon.cs.Physics.*;

public class Launcher{
	
	public static final int X = 0;
	public static final int Y = 1;
	
	public static void main(String[] args) {
		System.out.println("PUNKIN CHUNKIN!!");
		Scanner in = new Scanner(System.in);
		System.out.println("What is the launch location: Earth, the Moon, or Mars?: ");
		String location = in.nextLine();
		double gravity = 0;
		if (location == "earth"){
			gravity = Kinetic.earthG;
		}
		else if (location == "the Moon"){
			gravity = Kinetic.moonG;
		}
		else if (location == "Mars"){
			gravity = Kinetic.marsG;
		}
		System.out.println("What is the angle of launch?: ");
		double alpha = in.nextInt();
		System.out.println("What is the initial velocity?: ");
		double velocity = in.nextInt();
		System.out.println("What is the time interval?: ");
		double time = in.nextInt();
		System.out.println("How many lines are in the display?: ");
		int lines = in.nextInt();
		FlyingPumpkin.launch(alpha, velocity, time, gravity);
		ArrayList<Point> launch = new ArrayList<Point>();
		System.out.print(Launcher.display(launch, lines));
	}


	public static boolean display(ArrayList<Point> pts, int numLines) {
		// determine spans
		int yspan = numLines;
		int xspan = ((yspan - 1) * 24 / 10) + 1;
		
		// determine maximums
		int maxX = max(pts, X);
		int maxY = max(pts, Y);
		int max = Math.max(maxX,  maxY);
		
		// quit if necessary
		if (maxX < 1 || maxY < 1 || xspan < 1 || yspan < 1) {
			if (maxX < 1) System.out.println("Problem with x dimension values: all are below 1");
			if (maxY < 1) System.out.println("Problem with y dimension values: all are below 1");
			if (xspan < 1) System.out.println("Problem with xspan: must be greater than 0");
			if (yspan < 1) System.out.println("Problem with yspan: must be greater than 0");
			System.out.println("Quitting: cannot display trajectory");
			return true;
		}
		
		// clear display array
		char[][] spots = new char[xspan][yspan];
		for (int x = 0; x < spots.length; x++) {
			for (int y = 0; y < spots[0].length; y++) {
				spots[x][y] = ' ';
			}
		}
		
		// fill display array with trajectory
		for (Point p : pts) {
			int x = (int)((double)p.getX() / max * (spots.length-1));
			int y = (int)((double)p.getY() / max * (spots[0].length-1));
			if (x < 0) x = 0;
			if (y < 0) y = 0;
			spots[x][y] = '@';
		}
		
		// set y axis pad
		String ypad = "";
		for (int i = 0; i < ("" + max).length(); i++) {
			ypad += " ";
		}
		ypad += "|";

		// print display array
		System.out.print(max + "|");
		for (int y = spots[0].length - 1; y >= 0; y--) {			
			for (int x = 0; x < spots.length; x++) {
				System.out.print(spots[x][y]);
			}
			System.out.println();
			System.out.print(ypad);
		}
		for (int x = 0; x < spots.length; x++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.printf("%" + (ypad.length() + spots.length) + "d", max);
		return false;
	}	

	public static int max(ArrayList<Point> pts, int dim) {
		if (pts == null || pts.size() < 1) return 0;
		int max = 0;
		for (Point p : pts) {
			int v = 0;
			if (dim == X) v = (int) p.getX();
			else if (dim == Y) v = (int) p.getY();
			if (v > max) max = v;
		}
		return max;
	}	

}
