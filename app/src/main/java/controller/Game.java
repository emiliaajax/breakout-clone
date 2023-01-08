package controller;

import java.util.Timer;
import java.util.TimerTask;

import model.Ball;
import model.Brick;
import model.Paddle;
import view.GameUI;

public class Game {
  private Ball ball;
  private Brick brick;
  private Paddle paddle;
  private GameUI gameUI;
  private Timer timer;

  public Game(Ball ball, Brick brick, Paddle paddle, GameUI gameUI, Timer timer) {
    this.ball = ball;
    this.brick = brick;
    this.paddle = paddle;
    this.gameUI = gameUI;

    this.timer = timer;
  }

  public void start() {
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        ball.move();
        paddle.move();
        gameUI.repaint();
        checkCollision();
      }
    }, 0, 10);
  }

  void checkCollision() {
    checkCollisionWithPaddle();
    checkCollisionWithBrick();
  }

  private void checkCollisionWithPaddle() {
    if (ball.getYPos() == paddle.getYPos() - ball.getHeight() && ball.getXPos() >= paddle.getXPos() && ball.getXPos() <= paddle.getXPos() + paddle.getWidth()) {
      ball.changeYDir();
    }
  }

  private void checkCollisionWithBrick() {
    if (isCollidingOnTopOfBrick() || isCollidingWithBottomOfBrick()) {
      ball.changeYDir();
    }

    if (isCollidingWithLeftSideOfBrick()) {
      ball.changeXDir();
    }
  }

  private boolean isCollidingOnTopOfBrick() {
    return isOnBrickTopYPosition() && isWithinBrickWidth();
  }

  private boolean isCollidingWithBottomOfBrick() {
    return isOnBrickBottomYPosition() && isWithinBrickWidth();
  }

  private boolean isCollidingWithLeftSideOfBrick() {
    return isOnBrickLeftXPosition() && isWithinBrickHeight();
  }

  private boolean isWithinBrickWidth() {
    return ball.getXPos() >= brick.getXPos() && ball.getXPos() <= brick.getXPos() + brick.getWidth();
  }

  private boolean isOnBrickTopYPosition() {
    return ball.getYPos() == brick.getYPos() - ball.getHeight();
  }

  private boolean isOnBrickBottomYPosition() {
    return ball.getYPos() == brick.getYPos() + brick.getHeight();
  }

  private boolean isWithinBrickHeight() {
    return ball.getYPos() >= brick.getYPos() && ball.getYPos() <= brick.getYPos() + brick.getHeight();
  }

  private boolean isOnBrickLeftXPosition() {
    return ball.getXPos() + ball.getWidth() == brick.getXPos();
  }
}
