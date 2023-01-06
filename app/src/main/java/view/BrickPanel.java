package view;

import javax.swing.JPanel;

import model.Brick;

import java.awt.Color;
import java.awt.Graphics;

public class BrickPanel extends JPanel {
  private Brick brick;

  public BrickPanel(Brick brick) {
    this.brick = brick;
  }

  @Override
  public void paintComponent(Graphics graphics) {
    graphics.setColor(Color.GREEN);
    graphics.fillRect(brick.getXPos(), brick.getYPos(), brick.getWidth(), brick.getHeight());
  }
}
