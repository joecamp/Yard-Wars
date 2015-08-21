package Testing;

import static org.junit.Assert.*;
import Cards.EmptyCard;
import Model.Deck;
import Model.Player;

import org.junit.Test;

public class DeckTest {
	
	@Test
	public void deckTest1() {
		@SuppressWarnings("unused")
		Player testPlayer = new Player(1, 1);
		for(int i = 0; i < 5; i++) {
			Player.myHand.add(new EmptyCard());
		}
		Deck.populateDeck(1);
		assertEquals(Deck.Deck1.size(), 56);
		Deck.drawNewCardFromDeck(1, 1);
		assertEquals(Deck.Deck1.size(), 55);
	}
}
