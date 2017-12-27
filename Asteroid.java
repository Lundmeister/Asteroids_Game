import java.util.ArrayList;

import processing.core.PApplet;

public class Asteroid {
	
	ArrayList<Asteroid> asteroidList = new ArrayList<Asteroid>();
	
	float xPos;
	float yPos;
	float xDir;
	float yDir;
	float diameter;
	
	Asteroid (float initX, float initY, float initDirX, float initDirY, float initDiam) {
		xPos = initX;
		yPos = initY;
		xDir = initDirX;
		yDir = initDirY;
		diameter = initDiam;
	} //end constructor
	
	void display (PApplet proc) {
		proc.fill (127,127,127);
		proc.ellipse (xPos, yPos, diameter, diameter);
	} //end display
	
	void moveAsteroid (PApplet proc) {
		xPos = xPos + xDir *3;
		yPos = yPos + yDir *3;
		if (xPos < -35) {
			xPos = 1035;
		} //end if
		if (xPos > 1035) {
			xPos = -35;
		} //end if
		if (yPos < -35) {
			yPos = 765;
		} //end if
		if (yPos > 765) {
			yPos = -35;
		} //end if
	} //end moveAsteroid
	
	void asteroidGotHit (PApplet proc) {
		xPos = proc.random(100,900);
		yPos = proc.random(100,300);
	} //end asteroidGotHit
	
	float getXPos() {
    	return xPos;
    } //end getXPos
    float getYPos() {
    	return yPos;
    } //end getYPos
	
} //end class