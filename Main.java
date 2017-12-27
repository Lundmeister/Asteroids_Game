import java.util.ArrayList;
import java.util.Iterator;

import processing.core.PApplet;

public class Main extends PApplet {

	ArrayList<Torpedo> torpedoList = new ArrayList<Torpedo>();
	ArrayList<Asteroid> asteroidList = new ArrayList<Asteroid>();
	ArrayList<ParticleSystem> particleList = new ArrayList<ParticleSystem>();
	ArrayList<Triangle> triangleList = new ArrayList<Triangle>();
	Continue continueButton;
	int score = 0;
	boolean shipDestroyed = false;

	public void setup() {
		size(1000, 800);
		triangleList.add(new Triangle(width / 2, height / 2, 20));
		continueButton = new Continue(width / 2 - 100, height / 2 + 100);
	} // end setup

	public void draw() {
		background(0, 0, 0);
		if (!shipDestroyed) {
			for (Triangle triangleSystem : triangleList) {
				triangleSystem.display(this);
			} // end for
			destroyAsteroid();
			if (asteroidList.size() < 6) {
				
				asteroidList.add(new Asteroid(random(100, 900), random(100, 800), random(-2, 2), random(-2, 2),
						random(70, 140)));
			
				Iterator<Asteroid> asteroidIt = asteroidList.iterator();
				
				for (Triangle triangleSystem : triangleList) {
					while (asteroidIt.hasNext()) {
						Asteroid theAsteroid = asteroidIt.next();
						if (distance(theAsteroid.getXPos(), theAsteroid.getYPos(),
									triangleSystem.getXPos(), triangleSystem.getYPos()) < 400) {
							asteroidIt.remove();
						} // end if
					} // end while
				} // end for
			} // end if
		} // end if
		if (shipDestroyed) {
			continueButton.display(this);
		} // end if

		for (Torpedo torpedoSystem : torpedoList) {
			if (!shipDestroyed) {
				torpedoSystem.display(this);
				torpedoSystem.moveTorpedo(this);
			} // end if
		} // end for
		for (Asteroid asteroidSystem : asteroidList) {
			asteroidSystem.display(this);
			if (!shipDestroyed) {
				asteroidSystem.moveAsteroid(this);
			} // end if
		} // end for
		for (ParticleSystem particleSystem : particleList) {
			particleSystem.display(this);
			particleSystem.update();
		} // end for
		crash();
		fill(255, 255, 255);
		textSize(24);
		text("Score:" + score, 800, 50);
	} // end
		// draw

	public void keyPressed() {
		for (Triangle triangleSystem : triangleList) {
			if (!shipDestroyed) {
				if (key == CODED) {
					if (keyCode == RIGHT) {
						triangleSystem.rotatingRight = true;
						triangleSystem.rotatingLeft = false;
					} // end if
					if (keyCode == LEFT) {
						triangleSystem.rotatingLeft = true;
						triangleSystem.rotatingRight = false;
					} // end if
					if (keyCode == UP) {
						triangleSystem.movingForward = true;
					} // end if
				} // end if
			} // end if
			if (key == ' ') {
				torpedoList.add(
						new Torpedo(triangleSystem.getXPos(), triangleSystem.getYPos(), triangleSystem.getAngle()));
			} // end if
		} // end for
	} // end keyPressed

	public void keyReleased() {
		for (Triangle triangleSystem : triangleList) {
			if (key == CODED) {
				if (keyCode == RIGHT) {
					triangleSystem.rotatingRight = false;
				} // end if
				if (keyCode == LEFT) {
					triangleSystem.rotatingLeft = false;
				} // end if
				if (keyCode == UP) {
					triangleSystem.movingForward = false;
				} // end if
			} // end if
		} // end for
	} // end keyReleased

	public void destroyAsteroid() {
		for (Asteroid asteroidSystem : asteroidList)
			for (Torpedo torpedoSystem : torpedoList) {
				if (distance(asteroidSystem.getXPos(), asteroidSystem.getYPos(), torpedoSystem.getXPos(),
						torpedoSystem.getYPos()) <= (asteroidSystem.diameter / 2) + 5) {
					particleList.add(new ParticleSystem(asteroidSystem.getXPos(), asteroidSystem.getYPos(), 100, 60));
					asteroidSystem.asteroidGotHit(this);
					score = score + 1;
				} // end if
			} // end for

	} // end destroyAsteroid

	public void crash() {
		for (Asteroid asteroidSystem : asteroidList)
			for (Triangle triangleSystem : triangleList) {
				if (distance(asteroidSystem.getXPos(), asteroidSystem.getYPos(), triangleSystem.getXPos(),
						triangleSystem.getYPos()) <= (asteroidSystem.diameter / 2) + 10) {
					textSize(36);
					fill(255, 0, 0);
					text("You Lose", width / 2 - 80, height / 2);
					asteroidSystem.asteroidGotHit(this);
					particleList.add(new ParticleSystem(triangleSystem.getXPos(), triangleSystem.getYPos(), 700, 60));
					shipDestroyed = true;
				} // end if
			} // end for
	} // end crash

	float distance(float x1, float y1, float x2, float y2) {
		return sqrt((sq(x1 - x2) + sq(y1 - y2)));
	} // end distance

	public void mousePressed() {
		if (mouseX > continueButton.getXPos() && mouseX < continueButton.getXPos() + 200
				&& mouseY > continueButton.getYPos() && mouseY < continueButton.getYPos() + 50) {
			loop();
			score = 0;
			shipDestroyed = false;
		} // end if

	} // end mousePressed

} // end class
