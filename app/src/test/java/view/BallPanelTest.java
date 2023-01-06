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
    Ball mockBall = mock(Ball.class);
    Graphics graphics = mock(Graphics.class);
    BallPanel sut = new BallPanel(mockBall);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> sut);
  }
}
