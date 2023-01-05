package model;

public class Brick {
	private int width;
	private int height;
	private int xPos;
	private int yPos;
	private boolean destroyed;

	public Brick () {
		width = 30;
		height = 20;
		xPos = 0;
		yPos = 0;
		destroyed = false;
	}

	public int getWidth() {
    return width;
  }

	public int getHeight() {
    return height;
  }

	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setXPos(int newXPos) {
		xPos = newXPos;
	}

	public boolean isDestroyed() {
		return destroyed;
	}
}
