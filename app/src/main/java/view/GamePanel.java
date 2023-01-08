package view;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
  private BallView ballView;
  private BrickView[] brickViews;
  private PaddleView paddleView;

  public GamePanel(BallView ballView, BrickView[] brickViews, PaddleView paddleView) {
    this.ballView = ballView;
    this.brickViews = brickViews;
    this.paddleView = paddleView;
  }

  @Override public void paintComponent(Graphics graphics) {
    ballView.paint(graphics);
    for (int i = 0; i < brickViews.length; i++) {
      brickViews[i].paint(graphics);
    }
    paddleView.paint(graphics);
  }
}
