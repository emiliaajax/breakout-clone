package model;

import java.awt.event.KeyEvent;

public class Paddle {
  private int width;
  private int height;
  private int xPos;
  private int yPos;
  private int xDir;

  public Paddle() {
    width = 150;
    height = 20;
    xPos = 325;
    yPos = 20;
    xDir = 0;
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

  public int getXDirection() {
    return xDir;
  }

  public void onKeyPress(KeyEvent event) {
    if (event.getKeyCode() == KeyEvent.VK_LEFT) {
      moveLeft();
    }
  }

  private void moveLeft() {
    xDir = -1;
  }
}
