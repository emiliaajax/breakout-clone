package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Ball;
import model.Brick;
import model.Paddle;

public class GameUITest {
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;

  private JFrame mockFrame;
  private Ball mockBall;
  private Brick mockBrick;
  private Paddle mockPaddle;
  private GamePanel mockGamePanel;
  private GameUI sut;

  @BeforeEach void setUp() {
    mockFrame = mock(JFrame.class);
    mockBall = mock(Ball.class);
    mockBrick = mock(Brick.class);
    mockPaddle = mock(Paddle.class);
    mockGamePanel = mock(GamePanel.class);

    sut = new GameUI(mockFrame, WIDTH, HEIGHT, mockBall, mockBrick, mockPaddle, mockGamePanel);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new GameUI(mockFrame, WIDTH, HEIGHT, mockBall, mockBrick, mockPaddle, mockGamePanel));
  }

  @Test void testInitUI_createsFrame() {
    sut.initUI();

    verify(mockFrame).setBounds(30, 30, 800, 800);
    verify(mockFrame).setTitle("Breakout");
    verify(mockFrame).setResizable(false);
    verify(mockFrame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}
