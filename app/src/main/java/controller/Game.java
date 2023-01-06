package controller;

import model.Ball;
import model.Brick;
import model.Paddle;
import view.GameUI;

public class Game {
  private Ball ball;
  private Brick brick;
  private Paddle paddle;
  private GameUI gameUI;

  public Game(Ball ball, Brick brick, Paddle paddle, GameUI gameUI) {
    this.ball = ball;
    this.brick = brick;
    this.paddle = paddle;
    this.gameUI = gameUI;
  }

  public void start() {
    ball.move();
    paddle.move();
    gameUI.repaint();
  }
}
