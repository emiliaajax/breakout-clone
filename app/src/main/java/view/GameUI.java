package view;

import javax.swing.JFrame;

public class GameUI {
  public JFrame frame;

  public GameUI(JFrame frame) {
      this.frame = frame;
      initUI();
  }

  private void initUI() {
    frame.setBounds(30, 30, 800, 600);
    frame.setTitle("Breakout");
    frame.setResizable(false);
    frame.setVisible(true);
  }

  public JFrame getFrame() {
    return frame;
  }
}
