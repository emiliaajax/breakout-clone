package view;

import javax.swing.JFrame;

import model.Paddle;

public class GameUI {
  private JFrame frame;
  private int width;
  private int height;
  private Paddle paddle;
  private GamePanel gamePanel;

  public GameUI(JFrame frame, int width, int height, Paddle paddle, GamePanel gamePanel) {
    this.frame = frame;
    this.width = width;
    this.height = height;
    this.gamePanel = gamePanel;
    this.paddle = paddle;

    initUI();
  }

  public void repaint() {
    gamePanel.repaint();
  }

  private void initUI() {
    createFrame();
    frame.add(gamePanel);
    frame.setVisible(true);
  }

  private void createFrame() {
    frame.setBounds(30, 30, width, height);
    frame.setTitle("Breakout");
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
