package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

public class GameUITest {
  class JFrameStub extends JFrame {}

  @Test void constructor () {
    assertDoesNotThrow(() -> new GameUI(new JFrameStub()));
  }
}
