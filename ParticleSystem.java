
import java.util.ArrayList;
//import java.util.Iterator;

import processing.core.PApplet;
public class ParticleSystem {
	ArrayList<Particle> particleList = new ArrayList<Particle>();

	float xOrigin;
	float yOrigin;
	int numParticles;
	int lifeSpan;

	ParticleSystem(float xInit, float yInit, int numInit, int lifeInit) {
		xOrigin = xInit;
		yOrigin = yInit;
		numParticles = numInit;
		lifeSpan = lifeInit;

	} // end constructor
	void addParticle() {
		particleList.add(new Particle(xOrigin, yOrigin,
						(float) Math.random()*2 -1 , (float) Math.random()*2 -1));
	} // end addParticle

	void display(PApplet proc) {
		for (Particle theParticle: particleList) {
		theParticle.display(proc);
		} // end for
	} // end display

	void update() {
		lifeSpan--;
		if (lifeSpan>0) {
			addParticle();
		} // end if
		for (int index = particleList.size() -1; index >=0; index --){
			Particle theParticle = particleList.get(index);
			theParticle.update();
			if (! theParticle.isAlive()) {
				particleList.remove(index);
		} //end for					
	} //end update
} // end class ParticleSystem
}