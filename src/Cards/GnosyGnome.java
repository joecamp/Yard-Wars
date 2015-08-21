package Cards;

import Model.Card;

public class GnosyGnome extends Card{

	public GnosyGnome() {
		super(Model.Field.IDcounter, 19, 3, 0, false, -1);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Gnosy Gnome";
	}

}
