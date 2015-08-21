package Cards;

import Model.Card;

public class Flood extends Card{
	
	public Flood() {
		super(Model.Field.IDcounter, 25, 3, 0, false, -1);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Flood";
	}

}
