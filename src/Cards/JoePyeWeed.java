package Cards;

import Model.Card;

public class JoePyeWeed extends Card{

	public JoePyeWeed() {
		super(Model.Field.IDcounter, 13, 1, 2, false, 12);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Joe Pye Weed";
	}

}
