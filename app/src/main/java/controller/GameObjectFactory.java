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
    int row = 1;
    int index = 1;

    for (int i = 0; i < numberOfBricks; i++) {
      bricks[i] = new Brick();
      bricks[i].setXPos(index * bricks[i].getWidth());
      bricks[i].setYPos(row * bricks[i].getHeight());
      if (bricks[i].getXPos() >= 640) {
        row++;
        index = 0;
      }
      index++;
    }

    return bricks;
  }
}
