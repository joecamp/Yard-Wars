package Model;

import java.util.ArrayList;

import Cards.*;

public class Player {

	// 1 or 2
	public int playerNumber;
	// 1, 2 or 3
	public int playerDeck;
	// Player 1 cards available to play
	public static ArrayList<Card> myHand;
	// Player 2 cards available to play
	public static ArrayList<Card> enemyHand = new ArrayList<Card>();
	// Player 1 cards on field
	public static ArrayList<Card> myOnField;
	// Player 2 cards on field
	public static ArrayList<Card> enemyOnField = new ArrayList<Card>();
	public boolean cardAvailThisTurn;
	public boolean specialAvailableThisTurn;
	public static Card lastCardToDie = new EmptyCard();
	
		// adds a new player to the game
		public Player(int playerNumber, int deck) {
			this.playerNumber = playerNumber;
			playerDeck = deck;
			if(playerNumber == 1) {
				myHand = new ArrayList<Card>();
				myOnField = new ArrayList<Card>();
			}
			else {
				enemyHand = new ArrayList<Card>();
				enemyOnField = new ArrayList<Card>();
			}
			for(int i = 0; i < 5; i++) {
				myOnField.add(new EmptyCard());
			}
			for(int i = 0; i < 5; i++) {
				enemyOnField.add(new EmptyCard());
			}
			this.cardAvailThisTurn = true;
			this.specialAvailableThisTurn = true;
		}
		
		public static void startingCards(Player player) {
			Model.Deck.populateDeck(player.playerDeck);
			for(int i = 0; i < 5; i++) {
				Model.Deck.drawNewCardFromDeck(player.playerNumber, player.playerDeck);
			}
		}
		
		// adds a card to the player's available cards
		public static boolean addToHand(int cardNameID, int position) {
					switch(cardNameID) {
					case 0: myHand.set(position, new EmptyCard()); break;
					case 1: myHand.set(position, new BurningBush()); break;
					case 2: myHand.set(position, new ButterflyBush()); break;
					case 3: myHand.set(position, new AmericanSweetFlag()); break;
					case 4: myHand.set(position, new AmericanWaterPlantain()); break;
					case 5: myHand.set(position, new MultifloraRose()); break;
					case 6: myHand.set(position, new Meadow()); break;
					case 7: myHand.set(position, new BradfordPearTree()); break;
					case 8: myHand.set(position, new Kudzu()); break;
					case 9: myHand.set(position, new CommonMilkweed()); break;
					case 10: myHand.set(position, new Dandelion()); break;
					case 11: myHand.set(position, new ScarletOak()); break;
					case 12: myHand.set(position, new Sassafras()); break;
					case 13: myHand.set(position, new JoePyeWeed()); break;
					case 14: myHand.set(position, new RainGarden()); break;
					case 15: myHand.set(position, new Weeding()); break;
					case 16: myHand.set(position, new Timber()); break;
					case 17: myHand.set(position, new GnaughtyGnome()); break;
					case 18: myHand.set(position, new CopycatGnome()); break;
					case 19: myHand.set(position, new GnosyGnome()); break;
					case 20: myHand.set(position, new Pesticides()); break;
					case 21: myHand.set(position, new Compost()); break;
					case 22: myHand.set(position, new MaidenGrass()); break;
					case 23: myHand.set(position, new JapaneseMaple()); break;
					case 24: myHand.set(position, new EnglishIvy()); break;
					case 25: myHand.set(position, new Flood()); break;
					}
					return true;
				}
		
		public static Card getCardFromPlayerHand(int position) {
			return myHand.get(position);
		}
		
		// adds a card to the enemy's available cards
				public static boolean addToEnemyHand(int cardNameID, int position) {
							switch(cardNameID) {
							case 0: enemyHand.set(position, new EmptyCard()); break;
							case 1: enemyHand.set(position, new BurningBush()); break;
							case 2: enemyHand.set(position, new ButterflyBush()); break;
							case 3: enemyHand.set(position, new AmericanSweetFlag()); break;
							case 4: enemyHand.set(position, new AmericanWaterPlantain()); break;
							case 5: enemyHand.set(position, new MultifloraRose()); break;
							case 6: enemyHand.set(position, new Meadow()); break;
							case 7: enemyHand.set(position, new BradfordPearTree()); break;
							case 8: enemyHand.set(position, new Kudzu()); break;
							case 9: enemyHand.set(position, new CommonMilkweed()); break;
							case 10: enemyHand.set(position, new Dandelion()); break;
							case 11: enemyHand.set(position, new ScarletOak()); break;
							case 12: enemyHand.set(position, new Sassafras()); break;
							case 13: enemyHand.set(position, new JoePyeWeed()); break;
							case 14: enemyHand.set(position, new RainGarden()); break;
							case 15: enemyHand.set(position, new Weeding()); break;
							case 16: enemyHand.set(position, new Timber()); break;
							case 17: enemyHand.set(position, new GnaughtyGnome()); break;
							case 18: enemyHand.set(position, new CopycatGnome()); break;
							case 19: enemyHand.set(position, new GnosyGnome()); break;
							case 20: enemyHand.set(position, new Pesticides()); break;
							case 21: enemyHand.set(position, new Compost()); break;
							case 22: enemyHand.set(position, new MaidenGrass()); break;
							case 23: enemyHand.set(position, new JapaneseMaple()); break;
							case 24: enemyHand.set(position, new EnglishIvy()); break;
							case 25: enemyHand.set(position, new Flood()); break;
							}
							return true;
						}
				
				public static Card getCardFromEnemyHand(int position) {
					return enemyHand.get(position);
				}
		
		public static boolean addToPlayerField(int cardID, int position) {
				switch(cardID) {
				case 0: myOnField.set(position, new EmptyCard()); break;
				case 1: myOnField.set(position, new BurningBush()); break;
				case 2: myOnField.set(position, new ButterflyBush()); break;
				case 3: myOnField.set(position, new AmericanSweetFlag()); break;
				case 4: myOnField.set(position, new AmericanWaterPlantain()); break;
				case 5: myOnField.set(position, new MultifloraRose()); break;
				case 6: myOnField.set(position, new Meadow()); break;
				case 7: myOnField.set(position, new BradfordPearTree()); break;
				case 8: myOnField.set(position, new Kudzu()); break;
				case 9: myOnField.set(position, new CommonMilkweed()); break;
				case 10: myOnField.set(position, new Dandelion()); break;
				case 11: myOnField.set(position, new ScarletOak()); break;
				case 12: myOnField.set(position, new Sassafras()); break;
				case 13: myOnField.set(position, new JoePyeWeed()); break;
				case 14: myOnField.set(position, new RainGarden()); break;
				case 15: myOnField.set(position, new Weeding()); break;
				case 16: myOnField.set(position, new Timber()); break;
				case 17: myOnField.set(position, new GnaughtyGnome()); break;
				case 18: myOnField.set(position, new CopycatGnome()); break;
				case 19: myOnField.set(position, new GnosyGnome()); break;
				case 20: myOnField.set(position, new Pesticides()); break;
				case 21: myOnField.set(position, new Compost()); break;
				case 22: myOnField.set(position, new MaidenGrass()); break;
				case 23: myOnField.set(position, new JapaneseMaple()); break;
				case 24: myOnField.set(position, new EnglishIvy()); break;
				case 25: myOnField.set(position, new Flood()); break;
				}
				return true;
		}
		
		public static Card getCardFromPlayerField(int position) {
			return myOnField.get(position);
		}
		
		public static boolean addToEnemyField(int cardID, int position) {
				switch(cardID) {
				case 0: enemyOnField.set(position, new EmptyCard()); break;
				case 1: enemyOnField.set(position, new BurningBush()); break;
				case 2: enemyOnField.set(position, new ButterflyBush()); break;
				case 3: enemyOnField.set(position, new AmericanSweetFlag()); break;
				case 4: enemyOnField.set(position, new AmericanWaterPlantain()); break;
				case 5: enemyOnField.set(position, new MultifloraRose()); break;
				case 6: enemyOnField.set(position, new Meadow()); break;
				case 7: enemyOnField.set(position, new BradfordPearTree()); break;
				case 8: enemyOnField.set(position, new Kudzu()); break;
				case 9: enemyOnField.set(position, new CommonMilkweed()); break;
				case 10: enemyOnField.set(position, new Dandelion()); break;
				case 11: enemyOnField.set(position, new ScarletOak()); break;
				case 12: enemyOnField.set(position, new Sassafras()); break;
				case 13: enemyOnField.set(position, new JoePyeWeed()); break;
				case 14: enemyOnField.set(position, new RainGarden()); break;
				case 15: enemyOnField.set(position, new Weeding()); break;
				case 16: enemyOnField.set(position, new Timber()); break;
				case 17: enemyOnField.set(position, new GnaughtyGnome()); break;
				case 18: enemyOnField.set(position, new CopycatGnome()); break;
				case 19: enemyOnField.set(position, new GnosyGnome()); break;
				case 20: enemyOnField.set(position, new Pesticides()); break;
				case 21: enemyOnField.set(position, new Compost()); break;
				case 22: enemyOnField.set(position, new MaidenGrass()); break;
				case 23: enemyOnField.set(position, new JapaneseMaple()); break;
				case 24: enemyOnField.set(position, new EnglishIvy()); break;
				case 25: enemyOnField.set(position, new Flood()); break;
				}
				return true;
		}
		
		public static Card getCardFromEnemyField(int position) {
			return enemyOnField.get(position);
		}
}
		
