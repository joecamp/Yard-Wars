package Cards;

import Model.Card;

public class EmptyCard extends Card{

	public EmptyCard() {
		super(Model.Field.IDcounter, 0, 0, 0, false, -1);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Empty Card";
	}

}
