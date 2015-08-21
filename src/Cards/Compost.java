package Cards;

import Model.Card;

public class Compost extends Card{

	public Compost() {
		super(Model.Field.IDcounter, 21, 3, 2, false, -1);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Compost";
	}

}
