package model;

public class Ball {
  private int width;
  private int height;
  private int xDir;
  private int yDir;
  private int x;
  private int y;

  public Ball () {
    width = 10;
    height = 10;
    xDir = 1;
    yDir = -1;
    x = 50;
    y = 50;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getXDirection() {
    return xDir;
  }

  public int getYDirection() {
    return yDir;
  }

  public int getXPos() {
    return x;
  }

  public int getYPos() {
    return y;
  }
}
