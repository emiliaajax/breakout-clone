package view;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameUITest {
  class JFrameStub extends JFrame {
    public JFrameStub() {
      super();
    }
  }

  @Test void constructor () {
    assertDoesNotThrow(() -> new GameUI(new JFrameStub()));
  }
}
