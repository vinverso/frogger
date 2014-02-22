package frogger;

import java.awt.Image;
import java.util.Observable;

public abstract class Sprite extends Observable {
	int x;
	int y;
	int dx;
	int dy;

	abstract void update();

	abstract Image loadImage();

	public int getDx() {
		return dx;
	}

	public void incrX(int dx) {
		x += new Integer(dx);
	}

	public int getDy() {
		return dy;
	}

	public void incrY(int dy) {
		y += new Integer(dy);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
