package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Cards.Sassafras;
import Model.Card;

public class CardTest {
	
	Card testCard = new Sassafras();

	@Test
	public void cardTest1() {
		assertEquals(testCard.cardNameID, 12);
		assertEquals(testCard.cardType, 1);
		assertEquals(testCard.shielded, false);
		assertEquals(testCard.toString(), "Sassafras");
		assertEquals(Card.getCardNameID(testCard), 12);
	}

}
