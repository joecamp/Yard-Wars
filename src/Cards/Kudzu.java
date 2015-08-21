package Cards;

import Model.Card;

public class Kudzu extends Card{

	public Kudzu() {
		super(Model.Field.IDcounter, 8, 2, -2, false, 7);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Kudzu";
	}

}
