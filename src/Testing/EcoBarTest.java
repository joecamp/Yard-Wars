package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.EcoBar;
import Model.Player;

public class EcoBarTest {

	@Test
	public void ecoBarTest1() {
		@SuppressWarnings("unused")
		Player testPlayer1 = new Player(1, 1);
		for(int i = 0; i < 5; i++) {
			Player.addToPlayerField(0, i);
		}
		assertEquals(EcoBar.calcMyEcoPoints(), 0);
		for(int i = 0; i < 5; i++) {
			Player.addToPlayerField(4, i);
		}
		assertEquals(EcoBar.calcMyEcoPoints(), 15);
		
		@SuppressWarnings("unused")
		Player testPlayer2 = new Player(2, 2);
		for(int i = 0; i < 5; i++) {
			Player.addToEnemyField(0, i);
		}
		assertEquals(EcoBar.calcEnemyEcoPoints(), 0);
		for(int i = 0; i < 5; i++) {
			Player.addToEnemyField(4, i);
		}
		assertEquals(EcoBar.calcEnemyEcoPoints(), 15);
	}

}
