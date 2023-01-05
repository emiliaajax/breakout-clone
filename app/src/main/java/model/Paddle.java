package model;

public class Paddle {
  private int width;
  private int height;
  private int xPos;

  public Paddle() {
    width = 150;
    height = 20;
    xPos = 325;
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
}
