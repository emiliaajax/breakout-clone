package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameUITest {
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;

  private JFrame mockFrame;
  private GamePanel mockGamePanel;
  private GameUI sut;

  @BeforeEach void setUp() {
    mockFrame = mock(JFrame.class);
    mockGamePanel = mock(GamePanel.class);

    sut = new GameUI(mockFrame, WIDTH, HEIGHT, mockGamePanel);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new GameUI(mockFrame, WIDTH, HEIGHT, mockGamePanel));
  }

  @Test void testInitUI_createsFrame() {
    sut.initUI();

    verify(mockFrame).setBounds(30, 30, 800, 600);
    verify(mockFrame).setTitle("Breakout");
    verify(mockFrame).setResizable(false);
    verify(mockFrame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Test void testInitUI_addPanelToFrame() {
    sut.initUI();

    verify(mockFrame).add(mockGamePanel);
  }
}
