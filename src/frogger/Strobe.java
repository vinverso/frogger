package frogger;

import java.util.TimerTask;

import javax.swing.JTextField;

public class Strobe extends TimerTask {
	View view;
	Cast cast;
	Frog frog;
	double minuteOfGame = new Double(0);
	int speedOfCar;
	Car car1 = new Car(speedOfCar);
	Car car2 = new Car(speedOfCar);
	Car car3 = new Car(speedOfCar);
	Car car4 = new Car(speedOfCar);
	Car car5 = new Car(speedOfCar);
	private int numOfWins = 0;
	Frogger frogger;

	public Strobe(View view, Cast cast, Frog frog, Frogger frogger) {
		this.view = view;
		this.cast = cast;
		this.frog = frog;
		this.frogger = frogger;
	}

	// cancel the strobe / timer task
	public void cancelStrobe() {
		this.cancel();
	}

	/**
	 * tells us if the frog got accross based
	 * on its position
	 * @return returns true if frog got across, false if not
	 */
	public boolean didFrogWin() {
		if (frog.getY() == (111 - (5 * 22))) {
			this.numOfWins += 1;
			frog.setX(350); // if the frog got across, put him back at start
			frog.setY(111);
			frogger.notifyDisplay(numOfWins);
			return true;
		}
		frogger.notifyDisplay(numOfWins);
		return false;
	}

	/**
	 * this method is in charge of calling repaint
	 * checking if the frog made it across, checking if 
	 * the frog is hit, and updating the speed of game
	 */
	@Override
	public void run() {
		this.isFrogIsHit(); // will stop this strobe / timer task if the frog is
							// hit
		this.didFrogWin();
		this.addCarsAfterDelay();
		this.updateSpeed();
		for (Sprite s : cast.getCastList()) {
			if (s instanceof Car) {
				((Car) s).setSpeed(speedOfCar);
				s.update();
			}
		}
		minuteOfGame += new Double(.0006);
		view.repaint();
	}

	/**
	 * changes the current speed of the game
	 */
	private void updateSpeed() {
		if (minuteOfGame >= 0 && minuteOfGame <= 1) {
			speedOfCar = 1;
		}
		if (minuteOfGame > 1 && minuteOfGame <= 2) {
			speedOfCar = 2;
		}
		if (minuteOfGame > 2 && minuteOfGame <= 3) {
			speedOfCar = 3;
		}
		if (minuteOfGame > 3 && minuteOfGame <= 4) {
			speedOfCar = 4;
		}
		if (minuteOfGame > 4 && minuteOfGame <= 5) {
			speedOfCar = 5;
		}
		if (minuteOfGame > 5 && minuteOfGame <= 6) {
			speedOfCar = 6;
		}
		if (minuteOfGame > 6 && minuteOfGame <= 7) {
			speedOfCar = 7;
		}
		if (minuteOfGame > 7 && minuteOfGame <= 8) {
			speedOfCar = 8;
		}
	}

	public double getMinuteOfGame() {
		return minuteOfGame;
	}

	/**
	 * adds cars to the cast after a delay
	 */
	public void addCarsAfterDelay() {
		if (minuteOfGame >= .05 && minuteOfGame < .0506) {
			cast.addSprite(car1);
		}
		if (minuteOfGame > .1 && minuteOfGame <= .1006) {
			cast.addSprite(car2);
		}
		if (minuteOfGame > .2 && minuteOfGame <= .2006) {
			cast.addSprite(car3);
		}
		if (minuteOfGame > .25 && minuteOfGame <= .2506) {
			cast.addSprite(car4);
		}
		if (minuteOfGame > .3 && minuteOfGame <= .3006) {
			cast.addSprite(car5);
		}
	}

	/**
	 * tells us if the frog has been hit
	 * @return returns true if frog is hit, false if not
	 */
	public boolean isFrogIsHit() {
		for (Sprite s : cast.getCastList()) {
			if (!(s instanceof Frog)) {
				if ((-25 <= (frog.getY() - s.getY()) && (frog.getY() - s.getY()) <= 25)
						&& ((frog.getX() - s.getX()) <= 75 && (frog.getX() - s
								.getX()) >= -30)) {
					this.cancelStrobe();
					return true;
				}
			}
		}
		return false;
	}
	
}
