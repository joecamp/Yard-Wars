package Cards;

import Model.Card;

public class Weeding extends Card{

	public Weeding() {
		super(Model.Field.IDcounter, 15, 3, 0, false, -1);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Weeding";
	}

}
