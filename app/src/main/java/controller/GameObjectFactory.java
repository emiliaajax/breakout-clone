package controller;

import model.Ball;

public class GameObjectFactory {
  public Ball createBall() {
    return new Ball();
  }
}
