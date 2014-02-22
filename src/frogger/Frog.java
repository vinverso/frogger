package frogger;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
//
//how you win, how to loose, and the appearance, and have it speed up each time, also stop the frog from being able to jump off the screen left
//right and bottom. add pause button.
//

public class Frog extends Sprite {

	public enum Orientation {
		UP, DOWN, LEFT, RIGHT
	}

	Image frog;
	private boolean alive = true;
	Orientation orientation;
	View view;
	String keyPressed;
	String fileName = "frog-up.png";
	int yStart = 111;
	int xStart = 350;

	public Frog(View view) {
		this.view = view;
		this.orientation = Orientation.UP;
		setX(xStart);
		setY(yStart);
	}

	/**
	 * updates the position or the orientation of the frog
	 */
	@Override
	void update() {
		if (isJumpingOutofBounds())
			return; // if the frog tries to jump out of bounds, we don't let him
		if (this.keyPressed.equals("u")) {
			switch (orientation) {
			case UP:
				this.incrY(-22);
				orientation = Orientation.UP;
				break;
			case DOWN:
				this.incrY(+22);
				orientation = Orientation.DOWN;
				break;
			case RIGHT:
				this.incrX(+22);
				orientation = Orientation.RIGHT;
				break;
			case LEFT:
				this.incrX(-22);
				orientation = Orientation.LEFT;
				break;
			default:
				break;
			}
			this.setImageOrientation();
			return;
		}

		if (this.keyPressed == "d") {
			switch (orientation) {
			case UP:
				orientation = Orientation.DOWN;
				break;
			case DOWN:
				orientation = Orientation.UP;
				break;
			case RIGHT:
				orientation = Orientation.LEFT;
				break;
			case LEFT:
				orientation = Orientation.RIGHT;
				break;
			default:
				break;
			}
			this.setImageOrientation();
			return;
		}

		if (this.keyPressed == "l") {
			switch (orientation) {
			case UP:
				orientation = Orientation.LEFT;
				break;
			case DOWN:
				orientation = Orientation.RIGHT;
				break;
			case RIGHT:
				orientation = Orientation.UP;
				break;
			case LEFT:
				orientation = Orientation.DOWN;
				break;
			default:
				break;
			}
			this.setImageOrientation();
			return;
		}

		if (this.keyPressed == "r") {
			switch (orientation) {
			case UP:
				orientation = Orientation.RIGHT;
				break;
			case DOWN:
				orientation = Orientation.LEFT;
				break;
			case RIGHT:
				orientation = Orientation.DOWN;
				break;
			case LEFT:
				orientation = Orientation.UP;
				break;
			default:
				break;
			}
			this.setImageOrientation();
			return;
		}
	}

	/**
	 * checks if the frog is trying to jump out of bounds
	 * @return returns boolean true if trying to jump out
	 * of bounds, false if not
	 */
	public boolean isJumpingOutofBounds() {
		if ((this.getX() == (350 - (16 * 22)))
				&& (this.getOrientation().equals("LEFT"))
				&& this.keyPressed.equals("u"))
			return true;
		if ((this.getX() == (350 + (14 * 22)))
				&& (this.getOrientation().equals("RIGHT"))
				&& this.keyPressed.equals("u"))
			return true;
		if ((this.getY() == (111)) && (this.getOrientation().equals("DOWN"))
				&& this.keyPressed.equals("u"))
			return true;
		return false;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * set the orientation fo the frog
	 * @return return string representation of 
	 * orientation
	 */
	public String getOrientation() {
		switch (orientation) {
		case UP:
			return "UP";
		case DOWN:
			return "DOWN";
		case LEFT:
			return "LEFT";
		case RIGHT:
			return "RIGHT";
		default:
			return "Invalid Orientation";
		}
	}

	/**
	 * set enum orientation
	 * @param orientation
	 */
	public void setOrientation(String orientation) {
		if (orientation.equals("UP"))
			this.orientation = Orientation.UP;
		if (orientation.equals("DOWN"))
			this.orientation = Orientation.DOWN;
		if (orientation.equals("LEFT"))
			this.orientation = Orientation.LEFT;
		if (orientation.equals("RIGHT"))
			this.orientation = Orientation.RIGHT;
	}

	/**
	 * set the image orientation
	 */
	public void setImageOrientation() {
		switch (orientation) {
		case UP:
			this.fileName = "frog-up.png";
			break;
		case DOWN:
			this.fileName = "frog-down.png";
			break;
		case LEFT:
			this.fileName = "frog-left.png";
			break;
		case RIGHT:
			this.fileName = "frog-right.png";
			break;
		default:
			break;
		}
	}

	@Override
	public Image loadImage() {
		try {
			frog = ImageIO.read(new File(this.fileName));
		} catch (IOException exc) {
			System.out.println("Can't load image.");
		}
		return frog;
	}

	public void setKeyPressed(String keyPressed) {
		this.keyPressed = keyPressed;
	}

}
