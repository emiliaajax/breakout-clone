package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameUITest {
  private static final int X_POS = 30;
  private static final int Y_POS = 30;
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;
  private static final String TITLE = "Breakout";

  private JFrame mockFrame;
  private GamePanel mockGamePanel;
  private PaddleAdapter mockPaddleAdapter;

  @BeforeEach void setUp() {
    mockFrame = mock(JFrame.class);
    mockGamePanel = mock(GamePanel.class);
    mockPaddleAdapter = mock(PaddleAdapter.class);

    new GameUI(mockFrame, WIDTH, HEIGHT, mockPaddleAdapter, mockGamePanel);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new GameUI(mockFrame, WIDTH, HEIGHT, mockPaddleAdapter, mockGamePanel));
  }

  @Test void testInitUI_createsFrame() {
    verify(mockFrame).setBounds(X_POS, Y_POS, WIDTH, HEIGHT);
    verify(mockFrame).setTitle(TITLE);
    verify(mockFrame).setResizable(false);
    verify(mockFrame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Test void testInitUI_addPanelToFrame() {
    verify(mockFrame).add(mockGamePanel);
  }

  @Test void testInitUI_setVisibilityToTrue() {
    verify(mockFrame).setVisible(true);
  }

  @Test void testRepaint_repaintGamePanel() {
    GameUI sut = new GameUI(mockFrame, WIDTH, HEIGHT, mockPaddleAdapter, mockGamePanel);
    sut.repaint();
    verify(mockGamePanel).repaint();
  }
}
