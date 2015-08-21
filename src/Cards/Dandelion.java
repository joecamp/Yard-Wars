package Cards;

import Model.Card;

public class Dandelion extends Card{

	public Dandelion() {
		super(Model.Field.IDcounter, 10, 1, 1, false, 9);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Dandelion";
	}

}
