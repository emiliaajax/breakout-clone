package model;

public class Brick {
	private int width;
	private int height;
	private int xPos;
	private int yPos;

	public Brick () {
		width = 30;
		height = 20;
		xPos = 0;
		yPos = 0;
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
}
