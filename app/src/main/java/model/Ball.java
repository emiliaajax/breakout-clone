package model;

public class Ball {
  private int x;
  private int y;
  private int xDir;

  public Ball () {
    x = 10;
    y = 10;
    xDir = 1;
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
}
