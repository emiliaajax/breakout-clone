package view;

import javax.swing.JPanel;

import model.Paddle;

public class PaddlePanel extends JPanel {
  private Paddle paddle;

  public PaddlePanel(Paddle paddle) {
    this.paddle = paddle;
  }
}
