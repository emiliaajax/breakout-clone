package view;

import org.junit.jupiter.api.Test;

import model.Ball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import java.awt.Graphics;
import static org.mockito.Mockito.*;

public class BallPanelTest {
  @BeforeEach void setUp() {
    BallPanel sut = new BallPanel();
    Ball mockBall = mock(Ball.class);
    Graphics graphics = mock(Graphics.class);
  }

  @Test void constructor () {
    assertDoesNotThrow(() -> new BallPanel());
  }
}
