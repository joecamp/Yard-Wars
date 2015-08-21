package Cards;

import Model.Card;

public class BurningBush extends Card{

	public BurningBush() {
		super(Model.Field.IDcounter, 1, 2, -3, false, 0);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Burning Bush";
	}

}
