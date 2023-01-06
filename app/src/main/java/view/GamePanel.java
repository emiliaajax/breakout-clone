package view;

public class GamePanel {
  private BallView ballView;
  private BrickView brickView;
  private PaddleView paddleView;

  public GamePanel(BallView ballView, BrickView brickView, PaddleView paddleView) {
    this.ballView = ballView;
    this.brickView = brickView;
    this.paddleView = paddleView;
  }
}
