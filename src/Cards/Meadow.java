package Cards;

import Model.Card;

public class Meadow extends Card{

	public Meadow() {
		super(Model.Field.IDcounter, 6, 1, 2, false, 5);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Meadow";
	}

}
