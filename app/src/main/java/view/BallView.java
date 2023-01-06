package view;

import model.Ball;

import java.awt.Color;
import java.awt.Graphics;

public class BallView {
  private Ball ball;

  public BallView(Ball ball) {
    this.ball = ball;
  }

  public void paint(Graphics graphics) {
    graphics.setColor(Color.BLUE);
    graphics.fillOval(ball.getXPos(), ball.getYPos(), ball.getWidth(), ball.getHeight());
  }
}
