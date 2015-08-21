package Model;

import java.util.ArrayList;
import java.util.Collections;

import Cards.*;

public class Deck {
	
	// all 3 different decks to choose from
	public static ArrayList<Card> Deck1 = new ArrayList<Card>();
	public static ArrayList<Card> Deck2 = new ArrayList<Card>();
	public static ArrayList<Card> Deck3 = new ArrayList<Card>();
	
	// checks the player's deck, then gets a random card (shuffled) from the
	// correct deck, adds the card to the player's hand and removes it from
	// the deck
	
	public static void drawNewCardFromDeck(int playerNum, int playerDeck){
		if(playerNum == 1) {
			if(playerDeck == 1) {
				if(Model.Player.getCardFromPlayerHand(0).cardNameID == 0) { Model.Player.addToHand(Deck1.get(0).cardNameID, 0); Deck1.remove(0); }
				else if(Model.Player.getCardFromPlayerHand(1).cardNameID == 0) { Model.Player.addToHand(Deck1.get(0).cardNameID, 1); Deck1.remove(0); }
				else if(Model.Player.getCardFromPlayerHand(2).cardNameID == 0) { Model.Player.addToHand(Deck1.get(0).cardNameID, 2); Deck1.remove(0); }
				else if(Model.Player.getCardFromPlayerHand(3).cardNameID == 0) { Model.Player.addToHand(Deck1.get(0).cardNameID, 3); Deck1.remove(0); }
				else if(Model.Player.getCardFromPlayerHand(4).cardNameID == 0) { Model.Player.addToHand(Deck1.get(0).cardNameID, 4); Deck1.remove(0); }
				}
			else if(playerDeck == 2) {
				if(Model.Player.getCardFromPlayerHand(0).cardNameID == 0) { Model.Player.addToHand(Deck2.get(0).cardNameID, 0); }
				else if(Model.Player.getCardFromPlayerHand(1).cardNameID == 0) { Model.Player.addToHand(Deck2.get(0).cardNameID, 1); }
				else if(Model.Player.getCardFromPlayerHand(2).cardNameID == 0) { Model.Player.addToHand(Deck2.get(0).cardNameID, 2); }
				else if(Model.Player.getCardFromPlayerHand(3).cardNameID == 0) { Model.Player.addToHand(Deck2.get(0).cardNameID, 3); }
				else if(Model.Player.getCardFromPlayerHand(4).cardNameID == 0) { Model.Player.addToHand(Deck2.get(0).cardNameID, 4); }
				Deck2.remove(0);
				}
			else {
				if(Model.Player.getCardFromPlayerHand(0).cardNameID == 0) { Model.Player.addToHand(Deck3.get(0).cardNameID, 0); }
				else if(Model.Player.getCardFromPlayerHand(1).cardNameID == 0) { Model.Player.addToHand(Deck3.get(0).cardNameID, 1); }
				else if(Model.Player.getCardFromPlayerHand(2).cardNameID == 0) { Model.Player.addToHand(Deck3.get(0).cardNameID, 2); }
				else if(Model.Player.getCardFromPlayerHand(3).cardNameID == 0) { Model.Player.addToHand(Deck3.get(0).cardNameID, 3); }
				else if(Model.Player.getCardFromPlayerHand(4).cardNameID == 0) { Model.Player.addToHand(Deck3.get(0).cardNameID, 4); }
				Deck3.remove(0);
				}
			}
		else {
			if(playerDeck == 1) {
				if(Model.Player.getCardFromEnemyHand(0).cardNameID == 0) { Model.Player.addToEnemyHand(Deck1.get(0).cardNameID, 0); Deck1.remove(0); }
				else if(Model.Player.getCardFromEnemyHand(1).cardNameID == 0) { Model.Player.addToEnemyHand(Deck1.get(0).cardNameID, 1); Deck1.remove(0); }
				else if(Model.Player.getCardFromEnemyHand(2).cardNameID == 0) { Model.Player.addToEnemyHand(Deck1.get(0).cardNameID, 2); Deck1.remove(0); }
				else if(Model.Player.getCardFromEnemyHand(3).cardNameID == 0) { Model.Player.addToEnemyHand(Deck1.get(0).cardNameID, 3); Deck1.remove(0); }
				else if(Model.Player.getCardFromEnemyHand(4).cardNameID == 0) { Model.Player.addToEnemyHand(Deck1.get(0).cardNameID, 4); Deck1.remove(0); }
				}
			else if(playerDeck == 2){
				if(Model.Player.getCardFromEnemyHand(0).cardNameID == 0) { Model.Player.addToEnemyHand(Deck2.get(0).cardNameID, 0); }
				else if(Model.Player.getCardFromEnemyHand(1).cardNameID == 0) { Model.Player.addToEnemyHand(Deck2.get(0).cardNameID, 1); }
				else if(Model.Player.getCardFromEnemyHand(2).cardNameID == 0) { Model.Player.addToEnemyHand(Deck2.get(0).cardNameID, 2); }
				else if(Model.Player.getCardFromEnemyHand(3).cardNameID == 0) { Model.Player.addToEnemyHand(Deck2.get(0).cardNameID, 3); }
				else if(Model.Player.getCardFromEnemyHand(4).cardNameID == 0) { Model.Player.addToEnemyHand(Deck2.get(0).cardNameID, 4); }
				Deck2.remove(0);
				}
			else {
				if(Model.Player.getCardFromEnemyHand(0).cardNameID == 0) { Model.Player.addToEnemyHand(Deck3.get(0).cardNameID, 0); }
				else if(Model.Player.getCardFromEnemyHand(1).cardNameID == 0) { Model.Player.addToEnemyHand(Deck3.get(0).cardNameID, 1); }
				else if(Model.Player.getCardFromEnemyHand(2).cardNameID == 0) { Model.Player.addToEnemyHand(Deck3.get(0).cardNameID, 2); }
				else if(Model.Player.getCardFromEnemyHand(3).cardNameID == 0) { Model.Player.addToEnemyHand(Deck3.get(0).cardNameID, 3); }
				else if(Model.Player.getCardFromEnemyHand(4).cardNameID == 0) { Model.Player.addToEnemyHand(Deck3.get(0).cardNameID, 4); }
				Deck3.remove(0);
				}
		}
		}

	// instantiates the cards for a deck and adds them to the deck
	// then shuffles the deck
	public static void populateDeck(int deckType) {
		if(deckType == 1) {
		Deck1.add(new AmericanSweetFlag());
		Deck1.add(new AmericanWaterPlantain());
		//Deck1.add(new BradfordPearTree());
		Deck1.add(new BurningBush());
		Deck1.add(new ButterflyBush());
		Deck1.add(new CommonMilkweed());
		Deck1.add(new AmericanSweetFlag());
		Deck1.add(new AmericanWaterPlantain());
		//Deck1.add(new BradfordPearTree());
		Deck1.add(new BurningBush());
		Deck1.add(new ButterflyBush());
		Deck1.add(new CommonMilkweed());
		//Deck1.add(new Compost());
		//Deck1.add(new CopycatGnome());
		Deck1.add(new Dandelion());
		Deck1.add(new EnglishIvy());
		Deck1.add(new Flood());
		//Deck1.add(new GnaughtyGnome());
		//Deck1.add(new GnosyGnome());
		Deck1.add(new JapaneseMaple());
		Deck1.add(new JoePyeWeed());
		Deck1.add(new Kudzu());
		//Deck1.add(new MaidenGrass());
		Deck1.add(new Meadow());
		Deck1.add(new MultifloraRose());
		Deck1.add(new JapaneseMaple());
		Deck1.add(new Kudzu());
		//Deck1.add(new MaidenGrass());
		Deck1.add(new Meadow());
		Deck1.add(new MultifloraRose());
		Deck1.add(new Pesticides());
		Deck1.add(new RainGarden());
		Deck1.add(new Sassafras());
		Deck1.add(new ScarletOak());
		Deck1.add(new Timber());
		Deck1.add(new Weeding());
		Deck1.add(new AmericanSweetFlag());
		Deck1.add(new AmericanWaterPlantain());
		//Deck1.add(new BradfordPearTree());
		Deck1.add(new BurningBush());
		Deck1.add(new ButterflyBush());
		Deck1.add(new CommonMilkweed());
		Deck1.add(new AmericanSweetFlag());
		Deck1.add(new AmericanWaterPlantain());
		//Deck1.add(new BradfordPearTree());
		Deck1.add(new BurningBush());
		Deck1.add(new ButterflyBush());
		Deck1.add(new CommonMilkweed());
		//Deck1.add(new Compost());
		//Deck1.add(new CopycatGnome());
		Deck1.add(new Dandelion());
		Deck1.add(new EnglishIvy());
		Deck1.add(new Flood());
		//Deck1.add(new GnaughtyGnome());
		//Deck1.add(new GnosyGnome());
		Deck1.add(new JapaneseMaple());
		Deck1.add(new JoePyeWeed());	
		Deck1.add(new Kudzu());
		//Deck1.add(new MaidenGrass());
		Deck1.add(new Meadow());
		Deck1.add(new MultifloraRose());
		Deck1.add(new JapaneseMaple());
		Deck1.add(new Kudzu());
		//Deck1.add(new MaidenGrass());
		Deck1.add(new Meadow());
		Deck1.add(new MultifloraRose());
		Deck1.add(new Pesticides());
		Deck1.add(new RainGarden());
		Deck1.add(new Sassafras());
		Deck1.add(new ScarletOak());
		Deck1.add(new Timber());
		Deck1.add(new Weeding());
		Collections.shuffle(Deck1);
		}
		else if(deckType == 2) {
			Deck2.add(new AmericanSweetFlag());
			Deck2.add(new AmericanWaterPlantain());
			//Deck2.add(new BradfordPearTree());
			Deck2.add(new BurningBush());
			Deck2.add(new ButterflyBush());
			Deck2.add(new CommonMilkweed());
			Deck2.add(new AmericanSweetFlag());
			Deck2.add(new AmericanWaterPlantain());
			//Deck2.add(new BradfordPearTree());
			Deck2.add(new BurningBush());
			Deck2.add(new ButterflyBush());
			Deck2.add(new CommonMilkweed());
			//Deck2.add(new Compost());
			//Deck2.add(new CopycatGnome());
			Deck2.add(new Dandelion());
			Deck2.add(new EnglishIvy());
			Deck2.add(new Flood());
			//Deck2.add(new GnaughtyGnome());
			//Deck2.add(new GnosyGnome());
			Deck2.add(new JapaneseMaple());
			Deck2.add(new JoePyeWeed());	
			Deck2.add(new Kudzu());
			//Deck2.add(new MaidenGrass());
			Deck2.add(new Meadow());
			Deck2.add(new MultifloraRose());
			Deck2.add(new JapaneseMaple());
			Deck2.add(new Kudzu());
			//Deck2.add(new MaidenGrass());
			Deck2.add(new Meadow());
			Deck2.add(new MultifloraRose());
			Deck2.add(new Pesticides());
			Deck2.add(new RainGarden());
			Deck2.add(new Sassafras());
			Deck2.add(new ScarletOak());
			Deck2.add(new Timber());
			Deck2.add(new Weeding());
			Deck2.add(new AmericanSweetFlag());
			Deck2.add(new AmericanWaterPlantain());
			//Deck2.add(new BradfordPearTree());
			Deck2.add(new BurningBush());
			Deck2.add(new ButterflyBush());
			Deck2.add(new CommonMilkweed());
			Deck2.add(new AmericanSweetFlag());
			Deck2.add(new AmericanWaterPlantain());
			//Deck2.add(new BradfordPearTree());
			Deck2.add(new BurningBush());
			Deck2.add(new ButterflyBush());
			Deck2.add(new CommonMilkweed());
			//Deck2.add(new Compost());
			//Deck2.add(new CopycatGnome());
			Deck2.add(new Dandelion());
			Deck2.add(new EnglishIvy());
			Deck2.add(new Flood());
			//Deck2.add(new GnaughtyGnome());
			//Deck2.add(new GnosyGnome());
			Deck2.add(new JapaneseMaple());
			Deck2.add(new JoePyeWeed());	
			Deck2.add(new Kudzu());
			//Deck2.add(new MaidenGrass());
			Deck2.add(new Meadow());
			Deck2.add(new MultifloraRose());
			Deck2.add(new JapaneseMaple());
			Deck2.add(new Kudzu());
			//Deck2.add(new MaidenGrass());
			Deck2.add(new Meadow());
			Deck2.add(new MultifloraRose());
			Deck2.add(new Pesticides());
			Deck2.add(new RainGarden());
			Deck2.add(new Sassafras());
			Deck2.add(new ScarletOak());
			Deck2.add(new Timber());
			Deck2.add(new Weeding());
			Collections.shuffle(Deck2);
		}
		else {
			Deck3.add(new AmericanSweetFlag());
			Deck3.add(new AmericanWaterPlantain());
			//Deck3.add(new BradfordPearTree());
			Deck3.add(new BurningBush());
			Deck3.add(new ButterflyBush());
			Deck3.add(new CommonMilkweed());
			Deck3.add(new AmericanSweetFlag());
			Deck3.add(new AmericanWaterPlantain());
			//Deck3.add(new BradfordPearTree());
			Deck3.add(new BurningBush());
			Deck3.add(new ButterflyBush());
			Deck3.add(new CommonMilkweed());
			//Deck3.add(new Compost());
			//Deck3.add(new CopycatGnome());
			Deck3.add(new Dandelion());
			Deck3.add(new EnglishIvy());
			Deck3.add(new Flood());
			//Deck3.add(new GnaughtyGnome());
			//Deck3.add(new GnosyGnome());
			Deck3.add(new JapaneseMaple());
			Deck3.add(new JoePyeWeed());	
			Deck3.add(new Kudzu());
			//Deck3.add(new MaidenGrass());
			Deck3.add(new Meadow());
			Deck3.add(new MultifloraRose());
			Deck3.add(new JapaneseMaple());
			Deck3.add(new Kudzu());
			//Deck3.add(new MaidenGrass());
			Deck3.add(new Meadow());
			Deck3.add(new MultifloraRose());
			Deck3.add(new Pesticides());
			Deck3.add(new RainGarden());
			Deck3.add(new Sassafras());
			Deck3.add(new ScarletOak());
			Deck3.add(new Timber());
			Deck3.add(new Weeding());
			Deck3.add(new AmericanSweetFlag());
			Deck3.add(new AmericanWaterPlantain());
			//Deck3.add(new BradfordPearTree());
			Deck3.add(new BurningBush());
			Deck3.add(new ButterflyBush());
			Deck3.add(new CommonMilkweed());
			Deck3.add(new AmericanSweetFlag());
			Deck3.add(new AmericanWaterPlantain());
			//Deck3.add(new BradfordPearTree());
			Deck3.add(new BurningBush());
			Deck3.add(new ButterflyBush());
			Deck3.add(new CommonMilkweed());
			//Deck3.add(new Compost());
			//Deck3.add(new CopycatGnome());
			Deck3.add(new Dandelion());
			Deck3.add(new EnglishIvy());
			Deck3.add(new Flood());
			//Deck3.add(new GnaughtyGnome());
			//Deck3.add(new GnosyGnome());
			Deck3.add(new JapaneseMaple());
			Deck3.add(new JoePyeWeed());	
			Deck3.add(new Kudzu());
			//Deck3.add(new MaidenGrass());
			Deck3.add(new Meadow());
			Deck3.add(new MultifloraRose());
			Deck3.add(new JapaneseMaple());
			Deck3.add(new Kudzu());
			//Deck3.add(new MaidenGrass());
			Deck3.add(new Meadow());
			Deck3.add(new MultifloraRose());
			Deck3.add(new Pesticides());
			Deck3.add(new RainGarden());
			Deck3.add(new Sassafras());
			Deck3.add(new ScarletOak());
			Deck3.add(new Timber());
			Deck3.add(new Weeding());
			Collections.shuffle(Deck3);
		}
	}
	
}