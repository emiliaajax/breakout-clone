package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Graphics;

public class GamePanelTest {
  private BallView mockBallView;
  private BrickView mockBrickView;
  private PaddleView mockPaddleView;
  private Graphics mockGraphics;
  private GamePanel sut;

  @BeforeEach void setUp() {
    mockBallView = mock(BallView.class);
    mockBrickView = mock(BrickView.class);
    mockPaddleView = mock(PaddleView.class);
    mockGraphics = mock(Graphics.class);
    sut = new GamePanel(mockBallView, mockBrickView, mockPaddleView);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new GamePanel(mockBallView, mockBrickView, mockPaddleView));
  }

  @Test void verifyThatComponentsArePainted() {
    sut.paintComponent(mockGraphics);

    verify(mockBallView).paint(mockGraphics);
    verify(mockBrickView).paint(mockGraphics);
    verify(mockPaddleView).paint(mockGraphics);
  }
}
