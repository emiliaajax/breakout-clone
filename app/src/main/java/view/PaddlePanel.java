package view;

import javax.swing.JPanel;

import model.Paddle;

import java.awt.Color;
import java.awt.Graphics;

public class PaddlePanel extends JPanel {
  private Paddle paddle;

  public PaddlePanel(Paddle paddle) {
    this.paddle = paddle;
  }

  @Override
  public void paintComponent(Graphics graphics) {
    graphics.setColor(Color.BLACK);
    graphics.fillRect(paddle.getXPos(), paddle.getYPos(), paddle.getWidth(), paddle.getHeight());
  }
}
