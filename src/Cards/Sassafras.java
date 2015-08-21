package Cards;

import Model.Card;

public class Sassafras extends Card{

	public Sassafras() {
		super(Model.Field.IDcounter, 12, 1, 3, true, 11);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Sassafras";
	}

}
