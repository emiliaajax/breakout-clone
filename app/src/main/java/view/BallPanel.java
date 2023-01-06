package view;

import model.Ball;
import java.awt.Graphics;

public class BallPanel {
  private Ball ball;

  public BallPanel(Ball ball) {
    this.ball = ball;
  }

  public void paintComponent(Graphics graphics) {
    graphics.fillOval(ball.getXPos(), ball.getYPos(), ball.getWidth(), ball.getHeight());
  }
}
