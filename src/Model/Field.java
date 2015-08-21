package Model;

import java.util.ArrayList;

public class Field {
	
	// current turn
	public static int turnCounter;
	
	// maximum amount of turns per game
	public static int turnCounterMax = 10;
	
	// keeps track of how many cards have been instantiated
	public static int IDcounter = 0;
	
	// 0 = start screen, 2 = deck choice, 1 = gameplay, 3 = quiz, 4 = game over
	public static int gamePhase = 0; 
	
	public static int currentHintID = (int) (Math.random() * 7);
	
	public static int playerTurn = 1;

	static ArrayList<Card> temp1;
	static ArrayList<Card> temp2;
	
	public static Player currPlayer;
	
	// constructor
	public Field(int tC) {
		Field.turnCounter = tC;
	}
	
	public static void endTurn() {
		if(turnCounter == turnCounterMax) {
			temp1 = Player.myHand;
			temp2 = Player.enemyHand;
			Player.myHand = temp2;
			Player.enemyHand = temp1;
			temp1 = Player.myOnField;
			temp2 = Player.enemyOnField;
			Player.myOnField = temp2;
			Player.enemyOnField = temp2;
			
			gamePhase = 4;
		}
		
		else if(playerTurn == 1) {
			View.MainView.gameTimer = 20;
			Controller.MouseListener.p1.cardAvailThisTurn = true;
			Controller.MouseListener.p1.specialAvailableThisTurn = true;
			Model.Deck.drawNewCardFromDeck(Controller.MouseListener.p1.playerNumber, Controller.MouseListener.p1.playerDeck);
			Model.Deck.drawNewCardFromDeck(Controller.MouseListener.p2.playerNumber, Controller.MouseListener.p2.playerDeck);
			currentHintID = (int) (Math.random() * 7);
			
			temp1 = Player.myHand;
			Player.myHand = Player.enemyHand;
			Player.enemyHand = temp1;
			temp1 = Player.myOnField;
			Player.myOnField = Player.enemyOnField;
			Player.enemyOnField = temp1;
			
			playerTurn = 2;
			currPlayer = Controller.MouseListener.p2;
		}
		
		else {
			View.MainView.gameTimer = 20;
			Model.Field.turnCounter++;
			Controller.MouseListener.p2.cardAvailThisTurn = true;
			Controller.MouseListener.p2.specialAvailableThisTurn = true;
			Model.Deck.drawNewCardFromDeck(Controller.MouseListener.p1.playerNumber, Controller.MouseListener.p1.playerDeck);
			Model.Deck.drawNewCardFromDeck(Controller.MouseListener.p2.playerNumber, Controller.MouseListener.p2.playerDeck);
			currentHintID = (int) (Math.random() * 7);
			
			temp1 = Player.myHand;
			Player.myHand = Player.enemyHand;
			Player.enemyHand = temp1;
			temp1 = Player.myOnField;
			Player.myOnField = Player.enemyOnField;
			Player.enemyOnField = temp1;
			
			playerTurn = 1;
			currPlayer = Controller.MouseListener.p1;
		}
	}
	
	public static void resetField() {
		gamePhase = 0;
		turnCounter = 0;
		Player.myOnField.clear();
		Player.enemyOnField.clear();
		Player.myHand.clear();
	}
}
