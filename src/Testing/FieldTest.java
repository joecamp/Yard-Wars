package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Cards.BurningBush;
import Cards.Sassafras;
import Controller.MouseListener;
import Model.Deck;
import Model.Field;
import Model.Player;

public class FieldTest {

	@Test
	public void fieldTest1() {
		MouseListener.p1 = new Player(1, 1);
		MouseListener.p2 = new Player(2, 2);
		Deck.populateDeck(1);
		Deck.populateDeck(2);
		for(int i = 0; i < 5; i++) {
			Player.myHand.add(i, new BurningBush());
		}
		for(int i = 0; i < 5; i++) {
			Player.enemyHand.add(i, new Sassafras());
		}
		for(int i = 0; i < 5; i++) {
			Player.myOnField.add(i, new BurningBush());
		}
		for(int i = 0; i < 5; i++) {
			Player.enemyOnField.add(i, new Sassafras());
		}
		Field.endTurn();
		assertEquals(Player.getCardFromPlayerHand(0).cardNameID, 12);
		assertEquals(Player.getCardFromEnemyHand(0).cardNameID, 1);
		assertEquals(Player.getCardFromPlayerField(0).cardNameID, 12);
		assertEquals(Player.getCardFromEnemyField(0).cardNameID, 1);
		assertEquals(Field.currPlayer, MouseListener.p2);
	}
}
