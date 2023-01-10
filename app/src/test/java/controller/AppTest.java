package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
	@Test void constructor() {
		assertNotNull(new App());
	}

	@Test void shouldStartGame() {
		assertDoesNotThrow(() -> App.main(null));
	}
}
