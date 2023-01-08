package controller;

import model.Ball;
import model.Brick;
import model.Paddle;
import view.BallView;
import view.BrickView;
import view.PaddleView;

public class GameViewFactory {
  public BallView createBallView(Ball ball) {
    return new BallView(ball);
  }

  public PaddleView createPaddleView(Paddle paddle) {
    return new PaddleView(paddle);
  }

  public BrickView[] createBrickViews(Brick[] bricks) {
    BrickView[] brickViews = new BrickView[bricks.length];
    for (int i = 0; i < bricks.length; i++) {
      brickViews[i] = new BrickView(bricks[i]);
    }
    return brickViews;
  }
}
