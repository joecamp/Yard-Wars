package Cards;

import Model.Card;

public class ButterflyBush extends Card{

	public ButterflyBush() {
		super(Model.Field.IDcounter, 2, 2, -3, false, 1);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Butterfly Bush";
	}

}
