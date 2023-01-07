package controller;

import java.util.Timer;

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
    ball.move();
    paddle.move();

    gameUI.repaint();
  }
}
