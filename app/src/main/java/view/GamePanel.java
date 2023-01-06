package view;

import model.Ball;
import model.Brick;
import model.Paddle;

public class GamePanel {
  private Ball ball;
  private Brick brick;
  private Paddle paddle;

  public GamePanel (Ball ball, Brick brick, Paddle paddle) {
    this.ball = ball;
    this.brick = brick;
    this.paddle = paddle;
  }
}
