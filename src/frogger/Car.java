package frogger;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Car extends Sprite {
	int width = 74;
	Random r = new Random();
	String carImage;
	String orientation;
	Image car;
	int vel;
	int currentSpeedOfGame;
	int widthOfGame = 700;
	int heightOfGame = 175;

	public Car(int currentSpeedOfGame) {
		this.currentSpeedOfGame = currentSpeedOfGame;
		this.setOrientation(r.nextInt(2));
		this.getRandomCarImage();
		this.setInitialPosition(orientation);
		this.setInitialVelocity(currentSpeedOfGame);
	}
	
	/**
	 * randomly loads one of five different types of cars
	 */
	public void getRandomCarImage() {
		int carNum = r.nextInt(6); 
		if (carNum == 0 && orientation.equals("left"))
			carImage = new String("aqua-car-left.png");
		if (carNum == 0 && orientation.equals("right"))
			carImage = new String("aqua-car-right.png");
		if (carNum == 1 && orientation.equals("left"))
			carImage = new String("blue-car-left.png");
		if (carNum == 1 && orientation.equals("right"))
			carImage = new String("blue-car-right.png");
		if (carNum == 2 && orientation.equals("left"))
			carImage = new String("green-car-left.png");
		if (carNum == 2 && orientation.equals("right"))
			carImage = new String("green-car-right.png");
		if (carNum == 3 && orientation.equals("left"))
			carImage = new String("red-car-left.png");
		if (carNum == 3 && orientation.equals("right"))
			carImage = new String("red-car-right.png");
		if (carNum == 4 && orientation.equals("left"))
			carImage = new String("white-car-left.png");
		if (carNum == 4 && orientation.equals("right"))
			carImage = new String("white-car-right.png");
		if (carNum == 5 && orientation.equals("left"))
			carImage = new String("yellow-car-left.png");
		if (carNum == 5 && orientation.equals("right"))
			carImage = new String("yellow-car-right.png");
	}

	/**
	 * increments the car's position or re-sets it if its position if
	 * it has gone out of bounds
	 */
	@Override
	void update() { 
		if (this.isOutOfBounds()) {
			if (orientation.equals("left")) {
				setX(600 + width);
			}
			if (orientation.equals("right")) {
				setX(-width);
			}
			return;
		}
		if (orientation.equals("left"))
			this.incrX(-vel);
		if (orientation.equals("right"))
			this.incrX(vel);
	}

	@Override
	Image loadImage() {
		try {
			car = ImageIO.read(new File(carImage));
		} catch (IOException exc) {
			System.out.println(carImage);
			System.out.println("Can't load image.");
		}
		return car;
	}

	/**
	 * tells us whether the car has gone off the screen
	 * @return returns true or false depending on if the car 
	 * is out of bounds or not
	 */
	boolean isOutOfBounds() {
		if ((this.getX() >= (605 + width) && orientation.equals("right"))
				|| (this.getX() <= (-width - 5) && orientation.equals("left"))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * sets te orientation of the car
	 * @param i the orientation of the car,
	 * represented by 1 or 0
	 */
	public void setOrientation(int i) {
		if (i == 0)
			this.orientation = "left";
		if (i == 1)
			this.orientation = "right";
	}

	public void setInitialPosition(String orientation) {
		if (orientation.equals("right")) {
			this.setX(-width);
			this.setY(heightOfGame / 6 + width / 2 + 7);
		}
		if (orientation.equals("left")) {
			this.setX(600 + width);
			this.setY(heightOfGame - heightOfGame + width / 2 - 5);
		}
	}

	/**
	 * set the initial velocity of the car
	 * @param currentSpeedOfGame the current speed of the game
	 */
	public void setInitialVelocity(int currentSpeedOfGame) {
		vel = currentSpeedOfGame;
	}

	/**
	 * set the speed of the car
	 * @param speedOfCar the current speed of the game
	 */
	public void setSpeed(int speedOfCar) {
		vel = speedOfCar;
	}
}
