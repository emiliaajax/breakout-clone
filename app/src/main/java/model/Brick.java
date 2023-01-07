package model;

public class Brick {
	private int width;
	private int height;
	private int xPos;
	private int yPos;
	private boolean destroyed;

	public Brick () {
		width = 80;
		height = 40;
		xPos = 360;
		yPos = 100;
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

	public void setYPos(int newYPos) {
		yPos = newYPos;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void destroy() {
		destroyed = true;
	}
}
