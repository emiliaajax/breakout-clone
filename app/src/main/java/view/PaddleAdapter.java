package view;

import java.awt.event.KeyAdapter;

import model.Paddle;

public class PaddleAdapter extends KeyAdapter {
  private Paddle paddle;

  public PaddleAdapter(Paddle paddle) {
    this.paddle = paddle;
  }
}
