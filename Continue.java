import processing.core.PApplet;

public class Continue {
	float xPos;
	float yPos;
	Continue(float initX, float initY) {
		xPos = initX;
		yPos = initY;
	} //end constructor
	
	void display(PApplet proc) {
		proc.fill(255,255,255);
		proc.rect(xPos, yPos, 200, 50);
		proc.fill(0,0,0);
		proc.textSize(32);
		proc.text("Continue?", xPos + 20, yPos + 35);
	} //end display
	
	float getXPos() {
		return xPos;
	} //end getX
	
	float getYPos() {
		return yPos;
	} //end getY
	
} //end class
