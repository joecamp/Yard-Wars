package Cards;

import Model.Card;

public class ScarletOak extends Card{

	public ScarletOak() {
		super(Model.Field.IDcounter, 11, 1, 4, true, 10);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Scarlet Oak";
	}

}
