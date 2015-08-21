package Cards;

import Model.Card;

public class DeadStinkyTree extends Card{

	public DeadStinkyTree() {
		super(Model.Field.IDcounter, 27, 2, -5, true, -1);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Dead Stinky Tree";
	}

}