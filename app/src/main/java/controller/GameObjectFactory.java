package controller;

import model.Ball;
import model.Brick;
import model.Paddle;

public class GameObjectFactory {
  public Ball createBall() {
    return new Ball();
  }

  public Paddle createPaddle() {
    return new Paddle();
  }

  public Brick[] createBricks(int numberOfBricks) {
    Brick[] bricks = new Brick[numberOfBricks];

    for (int i = 0; i < numberOfBricks; i++) {
      bricks[i] = new Brick();
    }

    return bricks;
  }
}
