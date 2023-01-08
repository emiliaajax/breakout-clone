package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Graphics;

public class GamePanelTest {
  private BallView mockBallView;
  private BrickView[] mockBrickViews;
  private BrickView mockBrickView;
  private PaddleView mockPaddleView;
  private Graphics mockGraphics;
  private GamePanel sut;

  @BeforeEach void setUp() {
    mockBallView = mock(BallView.class);
    mockBrickView = mock(BrickView.class);
    mockPaddleView = mock(PaddleView.class);
    mockGraphics = mock(Graphics.class);

    mockBrickViews = new BrickView[10];
    for (int i = 0; i < mockBrickViews.length; i++) {
      mockBrickViews[i] = mock(BrickView.class);
    }

    mockBrickView = mockBrickViews[0];

    sut = new GamePanel(mockBallView, mockBrickViews, mockPaddleView);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new GamePanel(mockBallView, mockBrickViews, mockPaddleView));
  }

  @Test void verifyThatComponentsArePainted() {
    sut.paintComponent(mockGraphics);

    verify(mockBallView).paint(mockGraphics);
    verify(mockBrickView).paint(mockGraphics);
    verify(mockPaddleView).paint(mockGraphics);
  }
}
