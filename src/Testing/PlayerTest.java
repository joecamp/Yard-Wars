package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Cards.EmptyCard;
import Model.Player;

public class PlayerTest {

	@Test
	public void playerTest1() {
		Player testPlayer1 = new Player(1, 1);
		assertEquals(testPlayer1.playerNumber, 1);
		assertEquals(testPlayer1.playerDeck, 1);
		for(int i = 0; i < 5; i++) {
			Player.myHand.add(new EmptyCard());
		}
		Player.startingCards(testPlayer1);
		assertEquals(Player.myHand.size(), 5);
		Player.addToHand(1, 0);
		assertEquals(Player.getCardFromPlayerHand(0).cardNameID, 1);
		Player.addToPlayerField(1, 0);
		assertEquals(Player.getCardFromPlayerField(0).cardNameID, 1);
		
		Player testPlayer2 = new Player(2, 2);
		assertEquals(testPlayer2.playerNumber, 2);
		assertEquals(testPlayer2.playerDeck, 2);
		for(int i = 0; i < 5; i++) {
			Player.enemyHand.add(new EmptyCard());
		}
		Player.startingCards(testPlayer2);
		assertEquals(Player.enemyHand.size(), 5);
		Player.addToEnemyHand(1, 0);
		assertEquals(Player.getCardFromEnemyHand(0).cardNameID, 1);
		Player.addToEnemyField(1, 0);
		assertEquals(Player.getCardFromEnemyField(0).cardNameID, 1);
	}

}
