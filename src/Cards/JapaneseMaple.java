package Cards;

import Model.Card;

public class JapaneseMaple extends Card{

	public JapaneseMaple() {
		super(Model.Field.IDcounter, 23, 2, -3, true, 14);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Japanese Maple";
	}
	
}
