package model;

import utils.FrameCommons;

public class Ball {
  private int width;
  private int height;
  private int xDir;
  private int yDir;
  private int x;
  private int y;

  public Ball () {
    width = 20;
    height = 20;
    xDir = 1;
    yDir = -1;
    x = 390;
    y = 450;
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

  public void move () {
    moveBall();

    if (isWall()) {
      changeXDir();
    }
  
    if (isCeiling()) { 
      changeYDir();
    }
  }

  private boolean isWall() {
    return x <= 0 || x == FrameCommons.WIDTH - width;
  }

  private boolean isCeiling() {
    return y <= 0;
  }

  private void moveBall() {
    x += xDir;
    y += yDir;
  }

  public void changeXDir() {
    xDir = xDir * -1;
  }

  public void changeYDir() {
    yDir = yDir * -1;
  }

  public void reset() {
    resetPosition();
    resetDirection();
  }

  private void resetPosition() {
    x = 390;
    y = 450;
  }

  private void resetDirection() {
    xDir = 1;
    yDir = -1;
  }
}
