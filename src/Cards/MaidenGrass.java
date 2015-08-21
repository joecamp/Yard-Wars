package Cards;

import Model.Card;

public class MaidenGrass extends Card{
	
	public MaidenGrass() {
		super(Model.Field.IDcounter, 22, 2, -1, false, 13);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Maiden Grass";
	}

}
