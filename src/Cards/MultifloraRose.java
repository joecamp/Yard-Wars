package Cards;

import Model.Card;

public class MultifloraRose extends Card{

	public MultifloraRose() {
		super(Model.Field.IDcounter, 5, 2, -3, false, 4);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Multiflora Rose";
	}

}
