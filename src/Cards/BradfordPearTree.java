package Cards;

import Model.Card;

public class BradfordPearTree extends Card{

	public BradfordPearTree() {
		super(Model.Field.IDcounter, 7, 2, -1, true, 6);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Bradford Pear Tree";
	}

}
