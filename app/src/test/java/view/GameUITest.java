package view;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameUITest {
  class JFrameStub extends JFrame {
    public int x;
    public int y;
    public int width;
    public int height;
    public String title;
    public boolean resizable;
    public boolean visible;
    public String EXIT_ON_CLOSE = "Exited";

    public JFrameStub() {
      super();
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
    }

    @Override
    public void setTitle(String title) {
      this.title = title;
    }

    @Override
    public void setResizable(boolean resizable) {
      this.resizable = resizable;
    }

    @Override
    public void setVisible(boolean visible) {
      this.visible = visible;
    }
  }

  @Test void constructor () {
    assertDoesNotThrow(() -> new GameUI(new JFrameStub()));
  }

  @Test void shouldReturnTenForWidthOfFrameAfterInitUI () {
    GameUI sut = new GameUI(new JFrameStub());
    int expected = 600;
    int actual = sut.frame.width;

    assertEquals(expected, actual);
  }
}
