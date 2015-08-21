package Cards;

import Model.Card;

public class Pesticides extends Card{

	public Pesticides() {
		super(Model.Field.IDcounter, 20, 3, 0, false, -1);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Pesticides";
	}

}

