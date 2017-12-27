import java.util.ArrayList;

import processing.core.PApplet;

public class Triangle {
	
	ArrayList<Triangle> triangleList = new ArrayList<Triangle>();
	
    float xPos;
    float yPos;
    float size;
    float angle = 0;
    int red = 255;
    int green = 255;
    int blue = 255;
    
    boolean rotatingRight;
    boolean rotatingLeft;
    boolean movingForward;
    
    Triangle(float initX, float initY, float initSize) {
        xPos = initX;
        yPos = initY;
        size = initSize;
    } //end constructor
    
    void display(PApplet proc) {
        proc.pushMatrix();
            proc.translate(xPos,yPos);
            proc.rotate(angle);
            proc.fill(red,green,blue);
            proc.triangle(-size, size, 0, -size, size, size);
        proc.popMatrix();
        if (rotatingRight) {
        	rotateRight();
        	rotatingLeft = false;
        } //end if
        if (rotatingLeft) {
        	rotateLeft();
        	rotatingRight = false;
        } //end if
        if (movingForward) { 
        	moveForward();
        } //end if
    } //end display
    
    void rotateRight() {
        angle = angle + (float)0.1;
    } //end rotateRight
    
    void rotateLeft() {
        angle = angle - (float)0.1;
    } //end rotateLeft
    
    void moveForward() {
    	xPos += Math.cos(angle-Math.PI/2)*5;
    	yPos += Math.sin(angle-Math.PI/2)*5;
    } //end move
    
    float getAngle () {
        return angle;
    } //end getAngle
    
    float getXPos () {
    	return xPos;
    } //end getX
    
    float getYPos () {
    	return yPos;
    } //end getY
    
} //end class
