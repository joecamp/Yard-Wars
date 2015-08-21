package Cards;

import Model.Card;

public class CompostPile extends Card{

	public CompostPile() {
		super(Model.Field.IDcounter, 26, 1, 2, false, -1);
		Model.Field.IDcounter++;
		this.specialAvailable = false;
	}
	
	public String toString() {
		return "Compost Pile";
	}

}
