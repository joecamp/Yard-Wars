package Model;

public abstract class Card {
	
	// unique identifier for a card (ex. Butterfly Bush 1's ID =/=
	// Butterfly Bush 2's ID)
	public int cardID;
	// (1 -> ?) identifies card and identifies special ability
	public int cardNameID;
	// 1 for Native, 2 for Invasive, 3 for Action
	public int cardType;
	// ecoPoints awarded or deducted for having this plant on your lawn / playing this card
	public int ecoPointValue;
	// true if tree, false if not
	public boolean tree; 
	// tracks whether or not the cards special ability has been used
	public boolean specialAvailable;
	// tracks whether or not the card is protected
	public boolean shielded;
	public int quizID;
	public boolean floodShielded;
	
	public Card(int newCardID, int newCardName, int cardType, int ecoPointValue, boolean tree, int quizID){
		this.cardID = newCardID;
		this.cardNameID = newCardName;
		this.cardType = cardType;
		this.ecoPointValue = ecoPointValue;
		this.tree = tree;
		this.specialAvailable = true;
		this.shielded = false;
		this.quizID = quizID;
		this.floodShielded = false;
	}
	
	public static int getCardNameID(Card c) {
		return c.cardNameID;
	}
}