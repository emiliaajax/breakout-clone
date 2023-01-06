package view;

import javax.swing.JPanel;

import model.Brick;

public class BrickPanel extends JPanel {
  private Brick brick;

  public BrickPanel(Brick brick) {
    this.brick = brick;
  }
}
