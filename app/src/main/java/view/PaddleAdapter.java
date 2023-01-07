package view;

import java.awt.event.KeyAdapter;

import model.Paddle;
import java.awt.event.KeyEvent;

public class PaddleAdapter extends KeyAdapter {
  private Paddle paddle;

  public PaddleAdapter(Paddle paddle) {
    this.paddle = paddle;
  }

  @Override
  public void keyPressed(KeyEvent event) {
    paddle.onKeyPress(event);
  }
}
