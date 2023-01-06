package view;

import org.junit.jupiter.api.Test;

import model.Ball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import java.awt.Graphics;
import static org.mockito.Mockito.*;

public class BallPanelTest {
  private BallPanel sut;
  private Ball mockBall;
  private Graphics graphics;

  @BeforeEach void setUp() {
    BallPanel sut = new BallPanel();
    Ball mockBall = mock(Ball.class);
    Graphics graphics = mock(Graphics.class);
  }

  @Test void constructor () {
    assertDoesNotThrow(() -> new BallPanel());
  }

  @Test void ballShouldBePaintedWhenMethodIsCalled() {
    when(mockBall.getWidth()).thenReturn(10);
    when(mockBall.getHeight()).thenReturn(10);
    when(mockBall.getXPos()).thenReturn(50);
    when(mockBall.getYPos()).thenReturn(50);

    sut.paintComponent(graphics);

    verify(graphics).fillOval(50, 50, 10, 10);
  }
}
