package Cards;

import Model.Card;

public class CommonMilkweed extends Card{

	public CommonMilkweed() {
		super(Model.Field.IDcounter, 9, 1, 2, false, 8);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Common Milkweed";
	}

}
