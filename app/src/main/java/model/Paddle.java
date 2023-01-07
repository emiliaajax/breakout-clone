package model;

import java.awt.event.KeyEvent;

import utils.FrameCommons;

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
    yPos = 520;
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

  public void move() {
    if (isRightWall()) {
      stopMovingRight();
    } else if (isLeftWall()) {
      stopMovingLeft();
    } else {
      movePaddle();
    }
  }

  public void onKeyPress(KeyEvent event) {
    if (isLeftArrowKey(event)) {
      moveLeft();
    }

    if (isRightArrowKey(event)) {
      moveRight();
    }
  }

  public void onKeyRelease(KeyEvent event) {
    if (isLeftArrowKey(event) || isRightArrowKey(event)) {
      stopMoving();
    }
  }

  public void reset() {
    xPos = 325;
    yPos = 520;
    xDir = 0;
  }

  private boolean isRightWall() {
    return xPos >= FrameCommons.WIDTH - width;
  }

  private boolean isLeftWall() {
    return xPos <= 0;
  }

  private void stopMovingLeft() {
    xPos = 0;
    xDir = 0;
  }

  private void stopMovingRight() {
    xPos = FrameCommons.WIDTH - width;
    xDir = 0;
  }

  private void stopMoving() {
    xDir = 0;
  }

  private void movePaddle() {
    xPos += xDir;
  }

  void moveLeft() {
    xDir = -5;
  }

  void moveRight() {
    xDir = 5;
  }

  private boolean isLeftArrowKey(KeyEvent event) {
    return event.getKeyCode() == KeyEvent.VK_LEFT;
  }

  private boolean isRightArrowKey(KeyEvent event) {
    return event.getKeyCode() == KeyEvent.VK_RIGHT;
  }
}
