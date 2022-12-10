package model;

public class Ball {
  private int width;
  private int height;
  private int xDir;
  private int yDir;
  private int x;

  public Ball () {
    width = 10;
    height = 10;
    xDir = 1;
    yDir = -1;
    x = 50;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getHorizontalDirection() {
    return xDir;
  }

  public int getVerticalDirection() {
    return yDir;
  }

  public int getXPos() {
    return x;
  }
}
