public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
				  double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	
	public double calcDistance(Planet p){
		double dx = p.xxPos - xxPos;
		double dy = p.yyPos - yyPos;
		double distance = Math.pow(dx * dx + dy * dy, 0.5);
		return distance;
	}

	public double calcForceExertedBy(Planet p){
		double G = 6.67e-11;
		double distance = this.calcDistance(p);
		double F = G * mass * p.mass / (distance * distance);
		return F;
	}

	public double calcForceExertedByX(Planet p){
		double F = this.calcForceExertedBy(p);
		double r = this.calcDistance(p);
		double dx = p.xxPos - xxPos;
		double Fx = F * dx / r;
		return Fx;
	}
	
	public double calcForceExertedByY(Planet p){
        double F = this.calcForceExertedBy(p);  
        double r = this.calcDistance(p);
        double dy = p.yyPos - yyPos;
        double Fy = F * dy / r;
		return Fy;
    }

	public double calcNetForceExertedByX(Planet[] allPlanets){
		double netFx = 0.0;
		for(int i = 0; i < allPlanets.length; i++){
			if(!(this.equals(allPlanets[i]))){
				netFx += this.calcForceExertedByX(allPlanets[i]);
			}
		}
		return netFx;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
        double netFy = 0.0;
        for(int i = 0; i < allPlanets.length; i++){
            if(!(this.equals(allPlanets[i]))){   
                netFy += this.calcForceExertedByY(allPlanets[i]);
            }
        }
		return netFy;
    }
	
	public void update(double dt, double fX, double fY){
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel += dt * aX;
		yyVel += dt * aY;
		xxPos += dt * xxVel;
		yyPos += dt * yyVel;
	}
	
	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	} 		 		
}	

