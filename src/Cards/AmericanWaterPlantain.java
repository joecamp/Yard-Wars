package Cards;

import Model.Card;

public class AmericanWaterPlantain extends Card{

	public AmericanWaterPlantain() {
		super(Model.Field.IDcounter, 4, 1, 3, false, 3);
		Model.Field.IDcounter++;
	}
	
	public String toString() {
		return "American Water Plantain";
	}

}
