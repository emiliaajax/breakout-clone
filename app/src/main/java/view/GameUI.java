package view;

import javax.swing.JFrame;
import utils.FrameCommons;

public class GameUI {
  public JFrame frame;

  public GameUI(JFrame frame) {
      this.frame = frame;
      initUI();
  }

  private void initUI() {
    frame.setBounds(30, 30, FrameCommons.WIDTH, FrameCommons.HEIGHT);
    frame.setTitle("Breakout");
    frame.setResizable(false);
    frame.setVisible(true);
  }

  public JFrame getFrame() {
    return frame;
  }
}
