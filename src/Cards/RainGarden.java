package Cards;

import Model.Card;

public class RainGarden extends Card{

	public RainGarden() {
		super(Model.Field.IDcounter, 14, 3, 0, false, -1);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "Rain Garden";
	}

}
