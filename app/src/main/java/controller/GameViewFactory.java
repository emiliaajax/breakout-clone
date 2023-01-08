package controller;

import model.Ball;
import view.BallView;

public class GameViewFactory {
  public BallView createBallView(Ball ball) {
    return new BallView(ball);
  }
}
