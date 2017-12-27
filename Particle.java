import processing.core.PApplet;

public class Particle {

	float xPos;
	float yPos;
	float xDir;
	float yDir;
	float lifeSpan = 120;

	Particle(float xPosInit, float yPosInit, float xDirInit, float yDirInit) {
		xPos = xPosInit;
		yPos = yPosInit;
		xDir = xDirInit;
		yDir = yDirInit;
	} // end constructor

	void update() {
		xPos = xPos + xDir;
		yPos = yPos + yDir;
		lifeSpan = lifeSpan - 1;
	} // end update

	void display(PApplet proc) {
		proc.fill(0,0,0, lifeSpan);
		proc.stroke(215, 0, 0, lifeSpan);
		proc.ellipse(xPos, yPos, 5, 5);
	} // end display
	
	boolean isAlive() {
		return (lifeSpan > 0);		//looks back at lifeSpan, evaluates if true or false, returns true
	} //end isAlive

} // end class Particle