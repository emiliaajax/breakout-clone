package view;

import model.Paddle;

import java.awt.Color;
import java.awt.Graphics;

public class PaddleView {
  private Paddle paddle;

  public PaddleView(Paddle paddle) {
    this.paddle = paddle;
  }

  public void paint(Graphics graphics) {
    graphics.setColor(Color.BLACK);
    graphics.fillRect(paddle.getXPos(), paddle.getYPos(), paddle.getWidth(), paddle.getHeight());
  }
}
