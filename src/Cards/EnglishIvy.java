package Cards;

import Model.Card;

public class EnglishIvy extends Card{

	public EnglishIvy() {
		super(Model.Field.IDcounter, 24, 2, -3, false, 15);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "English Ivy";
	}
	
}
