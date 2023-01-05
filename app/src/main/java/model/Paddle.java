package model;

public class Paddle {
  private int width;
  private int height;
  private int xPos;
  private int yPos;

  public Paddle() {
    width = 150;
    height = 20;
    xPos = 325;
    yPos = 20;
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
}
