package Cards;

import Model.Card;

public class Timber extends Card{

	public Timber() {
		super(Model.Field.IDcounter, 16, 3, 0, false, -1);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Timberrr";
	}

}
