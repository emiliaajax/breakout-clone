package view;

import model.Ball;
import model.Brick;
import model.Paddle;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamePanelTest {
  private Ball mockBall;
  private Brick mockBrick;
  private Paddle mockPaddle;

  @BeforeEach void setUp() {
    mockBall = mock(Ball.class);
    mockBrick = mock(Brick.class);
    mockPaddle = mock(Paddle.class);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new GamePanel(mockBall, mockBrick, mockPaddle));
  }
}
