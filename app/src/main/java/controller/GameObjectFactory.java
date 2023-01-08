package controller;

import model.Ball;
import model.Paddle;

public class GameObjectFactory {
  public Ball createBall() {
    return new Ball();
  }

  public Paddle createPaddle() {
    return new Paddle();
  }
}
