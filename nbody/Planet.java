import java.lang.Math;

public class Planet{
	/** the positon, velocity, mass and image variables. */
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

	/** Constructor that initializes all the variables. */
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/** Copy constructor. */
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	/** Calculate the distance between caller and another planet. */
	public double calcDistance(Planet p){
		return Math.sqrt(Math.pow((this.xxPos - p.xxPos), 2) + Math.pow((this.yyPos - p.yyPos), 2));
	}
	
	/** Calclate the force between two planets. */
	public double calcForceExertedBy(Planet p){
		return 6.67e-11 * this.mass * p.mass / (Math.pow(this.calcDistance(p), 2));
	}
	
	/** Calculate the x-component of force. */
	public double calcForceExertedByX(Planet p){
		return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
	}
	
	/** Calculate the y-component of force. */
	public double calcForceExertedByY(Planet p){
			return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
		}
		
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double ans = 0.0;
		for (int i = 0; i < allPlanets.length; i++){
			if (this.equals(allPlanets[i]))
				continue;
			else
				ans += this.calcForceExertedByX(allPlanets[i]);
		}
		return ans;
	}
	
	public double calcNetForceExertedByY(Planet[] allPlanets){
		double ans = 0.0;
		for (int i = 0; i < allPlanets.length; i++){
			if (this.equals(allPlanets[i]))
				continue;
			else
				ans += this.calcForceExertedByY(allPlanets[i]);
		}
		return ans;
	}
	
	public void update(double dt, double fX, double fY){
		double ax = fX / this.mass;
		double ay = fY / this.mass;
		this.xxVel = this.xxVel + dt * ax;
		this.yyVel = this.yyVel + dt * ay;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}
}
