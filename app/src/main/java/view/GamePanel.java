package view;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
  private BallView ballView;
  private BrickView brickView;
  private PaddleView paddleView;

  public GamePanel(BallView ballView, BrickView brickView, PaddleView paddleView) {
    this.ballView = ballView;
    this.brickView = brickView;
    this.paddleView = paddleView;
  }

  @Override public void paintComponent(Graphics graphics) {
    ballView.paint(graphics);
    brickView.paint(graphics);
    paddleView.paint(graphics);
  }
}
