package view;

import javax.swing.JFrame;

import model.Ball;
import model.Brick;
import model.Paddle;

public class GameUI {
  private JFrame frame;
  private int width;
  private int height;
  private Ball ball;
  private Brick brick;
  private Paddle paddle;
  private GamePanel gamePanel;

  public GameUI(JFrame frame, int width, int height, 
      Ball ball, Brick brick, Paddle paddle, GamePanel gamePanel) {
    this.frame = frame;
    this.width = width;
    this.height = height;
    this.ball = ball;
    this.brick = brick;
    this.paddle = paddle;
    this.gamePanel = gamePanel;
  }
}
