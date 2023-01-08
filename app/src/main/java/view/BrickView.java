package view;

import model.Brick;

import java.awt.Color;
import java.awt.Graphics;

public class BrickView {
  private Brick brick;

  public BrickView(Brick brick) {
    this.brick = brick;
  }

  public void paint(Graphics graphics) {
    if (!brick.isDestroyed()) {
      graphics.setColor(Color.GREEN);
      graphics.fillRect(brick.getXPos(), brick.getYPos(), brick.getWidth(), brick.getHeight());
      graphics.setColor(Color.BLACK);
      graphics.drawRect(brick.getXPos(), brick.getYPos(), brick.getWidth(), brick.getHeight());
    }
  }
}
