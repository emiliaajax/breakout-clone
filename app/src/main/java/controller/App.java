/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package controller;

import javax.swing.JFrame;

import model.Ball;
import model.Brick;
import model.Paddle;
import utils.FrameCommons;
import view.BallView;
import view.BrickView;
import view.GamePanel;
import view.GameUI;
import view.PaddleView;

public class App {
  public static void main(String[] args) {
    JFrame frame = new JFrame();

    Ball ball = new Ball();
    Brick brick = new Brick();
    Paddle paddle = new Paddle();

    BallView ballView = new BallView(ball);
    BrickView brickView = new BrickView(brick);
    PaddleView paddleView = new PaddleView(paddle);

    GamePanel gamePanel = new GamePanel(ballView, brickView, paddleView);
    GameUI gameUI = new GameUI(frame, FrameCommons.WIDTH, FrameCommons.HEIGHT, gamePanel);
  }
}
