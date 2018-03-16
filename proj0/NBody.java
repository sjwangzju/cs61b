
public class NBody{
	
	public static double readRadius(String filename){
		In in = new In(filename);
		int num = in.readInt();
		double rad = in.readDouble();
		return rad;
	}
	
	public static Planet[] readPlanets(String filename){
		In in = new In(filename);
        int num = in.readInt();
        double rad = in.readDouble();
		Planet[] planets = new Planet[num];
		
		for(int i = 0; i < num; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return planets;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = NBody.readRadius(filename);
		Planet[] planets = NBody.readPlanets(filename);
		int num = planets.length;
		
		StdDraw.setXscale(-radius, radius);
		StdDraw.setYscale(-radius, radius);
		StdDraw.picture(0.5, 0.5, "./images/starfield.jpg");
		for(int i = 0; i < num; i++){
			planets[i].draw();
		}
		StdDraw.show();
		StdDraw.pause(1000);
		StdDraw.enableDoubleBuffering();
		double time = 0;
		while(time < T){
			double[] xForces = new double[num];
			double[] yForces = new double[num];
			for(int i = 0; i < num; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for(int i = 0; i < num; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0.5, 0.5, "./images/starfield.jpg");
       		for(int i = 0; i < num; i++){
            	planets[i].draw();
       	 	}
			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for(int i = 0; i < planets.length; i++){
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
							planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, 
							planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}
	}
	
}
