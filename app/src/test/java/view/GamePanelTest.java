package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamePanelTest {
  private BallView mockBallView;
  private BrickView mockBrickView;
  private PaddleView mockPaddleView;

  @BeforeEach void setUp() {
    mockBallView = mock(BallView.class);
    mockBrickView = mock(BrickView.class);
    mockPaddleView = mock(PaddleView.class);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new GamePanel(mockBallView, mockBrickView, mockPaddleView));
  }
}
