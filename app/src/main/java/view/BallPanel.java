package view;

import model.Ball;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BallPanel extends JPanel {
  private Ball ball;

  public BallPanel(Ball ball) {
    this.ball = ball;
  }

  @Override
  public void paintComponent(Graphics graphics) {
    graphics.setColor(Color.BLUE);
    graphics.fillOval(ball.getXPos(), ball.getYPos(), ball.getWidth(), ball.getHeight());
  }
}
