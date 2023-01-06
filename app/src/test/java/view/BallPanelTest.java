package view;

import org.junit.jupiter.api.Test;

import model.Ball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import java.awt.Graphics;
import static org.mockito.Mockito.*;

public class BallPanelTest {
  private Ball mockBall;
  private Graphics graphics;
  private BallPanel sut;

  @BeforeEach void setUp() {
    mockBall = mock(Ball.class);
    graphics = mock(Graphics.class);
    sut = new BallPanel(mockBall);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> sut);
  }
  
  @Test void verifyThatBallIsPainted() {
      when(mockBall.getWidth()).thenReturn(10);
      when(mockBall.getHeight()).thenReturn(10);
      when(mockBall.getXPos()).thenReturn(50);
      when(mockBall.getYPos()).thenReturn(50);

      sut.paintComponent(graphics);

      verify(graphics).fillOval(50, 50, 10, 10);
  }
}
