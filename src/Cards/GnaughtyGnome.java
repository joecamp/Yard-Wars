package Cards;

import Model.Card;

public class GnaughtyGnome extends Card{

	public GnaughtyGnome() {
		super(Model.Field.IDcounter, 17, 3, 0, false, -1);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Gnaughty Gnome";
	}

}
