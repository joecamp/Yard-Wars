package Cards;

import Model.Card;

public class CopycatGnome extends Card{

	public CopycatGnome() {
		super(Model.Field.IDcounter, 18, 3, 0, false, -1);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Copycat Gnome";
	}

}
