package Cards;

import Model.Card;

public class AmericanSweetFlag extends Card{

	public AmericanSweetFlag() {
		super(Model.Field.IDcounter, 3, 1, 3, false, 2);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "American Sweet Flag";
	}

}
