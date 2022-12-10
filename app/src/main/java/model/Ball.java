package model;

public class Ball {
  private int x;
  private int y;
  private int xDir;
  private int yDir;

  public Ball () {
    x = 10;
    y = 10;
    xDir = 1;
    yDir = -1;
  }

  public int getWidth() {
    return x;
  }

  public int getHeight() {
    return y;
  }

  public int getHorizontalDirection() {
    return xDir;
  }

  public int getVerticalDirection() {
    return yDir;
  }
}
