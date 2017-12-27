import java.util.ArrayList;

import processing.core.PApplet;

public class Torpedo {
    
    ArrayList<Torpedo> torpedoList = new ArrayList<Torpedo>();
    
    float xPos;
    float yPos;
    float xDir;
    float yDir;
    float angle;
    
    Torpedo (float initX, float initY, float initAngle) {
        xPos = initX;
        yPos = initY;
        angle = initAngle;
    } //end constructor
    
    void display (PApplet proc) {
        proc.fill(255,0,0);
        proc.ellipse(xPos,yPos,5,5);
    } //end display
    
    void moveTorpedo (PApplet proc) {
        xPos = xPos + (float)Math.cos(angle-proc.PI/2)*10;
        yPos = yPos + (float)Math.sin(angle-proc.PI/2)*10;
    } //end moveTorpedo
    
    float getXPos() {
    	return xPos;
    } //end getXPos
    float getYPos() {
    	return yPos;
    } //end getYPos
    
    
} //end class