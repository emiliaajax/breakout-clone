package model;

public class Ball {
  private int width;
  private int height;
  private int xDir;
  private int yDir;

  public Ball () {
    width = 10;
    height = 10;
    xDir = 1;
    yDir = -1;
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
}
