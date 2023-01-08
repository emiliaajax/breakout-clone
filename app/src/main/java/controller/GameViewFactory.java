package controller;

import model.Ball;
import model.Paddle;
import view.BallView;
import view.PaddleView;

public class GameViewFactory {
  public BallView createBallView(Ball ball) {
    return new BallView(ball);
  }

  public PaddleView createPaddleView(Paddle paddle) {
    return new PaddleView(paddle);
  }
}
