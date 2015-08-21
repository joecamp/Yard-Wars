package Controller;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

import javax.swing.event.MouseInputAdapter;

import Cards.EmptyCard;
import Model.Card;
import Model.Field;
import Model.Player;
import View.MainView;

public class MouseListener extends MouseInputAdapter{

	public static Player p1;
	public static Player p2;
	
	boolean mousePressed = false;
	
	Card cardBeingDragged;
	Card cardBeingActivated;
	Card cardBeingTargeted;

	public static int cardIDDragged;
	public static int cardActivatedPosition; // 1 - 10
	public static int cardTargetedPosition; // 1 - 10
	public static boolean cardActivatedOnMyField;
	public static int handPositionChosen; // 0 - 4

	public static int helpMessage = 5;

	public static boolean currentlyDragging = false;
	public static boolean currentlySpecAbility = false;

	Rectangle playerField = new Rectangle(0, (MainView.frameHeight * 1/2), MainView.frameWidth, MainView.frameHeight); 
	Rectangle enemyField = new Rectangle(0, 0, MainView.frameWidth, (MainView.frameHeight * 1/2));

	Rectangle handSlot1 = new Rectangle(MainView.handSlotx, MainView.handSlot1y, MainView.cardWidth, (MainView.handSlot2y - MainView.handSlot1y));
	Rectangle handSlot2 = new Rectangle(MainView.handSlotx, MainView.handSlot2y, MainView.cardWidth, (MainView.handSlot3y - MainView.handSlot2y));
	Rectangle handSlot3 = new Rectangle(MainView.handSlotx, MainView.handSlot3y, MainView.cardWidth, (MainView.handSlot4y - MainView.handSlot3y));
	Rectangle handSlot4 = new Rectangle(MainView.handSlotx, MainView.handSlot4y, MainView.cardWidth, (MainView.handSlot5y - MainView.handSlot4y));
	Rectangle handSlot5 = new Rectangle(MainView.handSlotx, MainView.handSlot5y, MainView.cardWidth, MainView.cardHeight);

	Rectangle fieldSlot1 = new Rectangle(MainView.fieldSlot1x, MainView.fieldSlot135y, MainView.cardWidth, MainView.cardHeight);
	Rectangle fieldSlot2 = new Rectangle(MainView.fieldSlot2x, MainView.fieldSlot24y, MainView.cardWidth, MainView.cardHeight);
	Rectangle fieldSlot3 = new Rectangle(MainView.fieldSlot3x, MainView.fieldSlot135y, MainView.cardWidth, MainView.cardHeight);
	Rectangle fieldSlot4 = new Rectangle(MainView.fieldSlot4x, MainView.fieldSlot24y, MainView.cardWidth, MainView.cardHeight);
	Rectangle fieldSlot5 = new Rectangle(MainView.fieldSlot5x, MainView.fieldSlot135y, MainView.cardWidth, MainView.cardHeight);

	Rectangle fieldSlot6 = new Rectangle(MainView.fieldSlot6x, MainView.fieldSlot6810y, MainView.cardWidth, MainView.cardHeight);
	Rectangle fieldSlot7 = new Rectangle(MainView.fieldSlot7x, MainView.fieldSlot79y, MainView.cardWidth, MainView.cardHeight);
	Rectangle fieldSlot8 = new Rectangle(MainView.fieldSlot8x, MainView.fieldSlot6810y, MainView.cardWidth, MainView.cardHeight);
	Rectangle fieldSlot9 = new Rectangle(MainView.fieldSlot9x, MainView.fieldSlot79y, MainView.cardWidth, MainView.cardHeight);
	Rectangle fieldSlot10 = new Rectangle(MainView.fieldSlot10x, MainView.fieldSlot6810y, MainView.cardWidth, MainView.cardHeight);

	public static Rectangle deckSlot1 = new Rectangle(MainView.deckSlot1x, MainView.deckSloty, MainView.deckWidth, MainView.deckHeight);
	public static Rectangle deckSlot2 = new Rectangle(MainView.deckSlot2x, MainView.deckSloty, MainView.deckWidth, MainView.deckHeight);
	public static Rectangle deckSlot3 = new Rectangle(MainView.deckSlot3x, MainView.deckSloty, MainView.deckWidth, MainView.deckHeight); 

	Rectangle endTurnSlot = new Rectangle(MainView.endTurnx, MainView.endTurny, MainView.endTurnImage.getWidth(), MainView.endTurnImage.getHeight());

	public static Rectangle questionSlot1 = new Rectangle(MainView.questionSlotx, MainView.questionSlot1y, MainView.questionWidth, MainView.questionHeight);
	public static Rectangle questionSlot2 = new Rectangle(MainView.questionSlotx, MainView.questionSlot2y, MainView.questionWidth, MainView.questionHeight);
	public static Rectangle questionSlot3 = new Rectangle(MainView.questionSlotx, MainView.questionSlot3y, MainView.questionWidth, MainView.questionHeight);
	public static Rectangle questionSlot4 = new Rectangle(MainView.questionSlotx, MainView.questionSlot4y, MainView.questionWidth, MainView.questionHeight);

	public void mousePressed(MouseEvent e) {

		// Tutorial Screens
		
		if(Model.Field.gamePhase == 5) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				mousePressed = true;
			}
		}
		
		if(Model.Field.gamePhase == 6) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				mousePressed = true;
			}
		}
		
		if(Model.Field.gamePhase == 7) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				mousePressed = true;
			}
		}
		
		if(Model.Field.gamePhase == 8) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				mousePressed = true;
			}
		}
		
		// Deck Selection

		if(Model.Field.gamePhase == 2) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(deckSlot1.contains(MainView.mouseX, MainView.mouseY)) {
					mousePressed = true;
				}
				else if(deckSlot2.contains(MainView.mouseX, MainView.mouseY)) {
					mousePressed = true;
				}
				else if(deckSlot3.contains(MainView.mouseX, MainView.mouseY)) {
					mousePressed = true;
				}
			}
		}
		
		if(Model.Field.gamePhase == 9) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(deckSlot1.contains(MainView.mouseX, MainView.mouseY)) {
					mousePressed = true;
				}
				else if(deckSlot2.contains(MainView.mouseX, MainView.mouseY)) {
					mousePressed = true;
				}
				else if(deckSlot3.contains(MainView.mouseX, MainView.mouseY)) {
					mousePressed = true;
				}
			}
		}

		// Quizzes

		else if(Model.Field.gamePhase == 3) {
			if(MainView.quizResult == false) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					if(questionSlot1.contains(MainView.mouseX, MainView.mouseY)) {
						if(Model.Quiz.isRight(cardBeingActivated.quizID, 0)) {
							Model.SpecialAbilities.activateSpecialAbility(cardBeingActivated, cardActivatedPosition, cardTargetedPosition);
							currentlySpecAbility = false;
							if(Field.playerTurn == 1) {
								p1.specialAvailableThisTurn = false;
							}
							else {
								p2.specialAvailableThisTurn = false;
							}
							MainView.quizResult = true;
							MainView.resultCorrect = true;
							MainView.resultTimeStart = View.MainView.time;
							MainView.resultTimeEnd = View.MainView.time + View.MainView.resultLength;
						}
						else {
							currentlySpecAbility = false;
							if(Field.playerTurn == 1) {
								p1.specialAvailableThisTurn = false;
							}
							else {
								p2.specialAvailableThisTurn = false;
							}
							MainView.quizResult = true;
							MainView.resultCorrect = false;
							MainView.resultTimeStart = View.MainView.time;
							MainView.resultTimeEnd = View.MainView.time + View.MainView.resultLength;
						}
					}
					else if(questionSlot2.contains(MainView.mouseX, MainView.mouseY)) {
						if(Model.Quiz.isRight(cardBeingActivated.quizID, 1)) {
							Model.SpecialAbilities.activateSpecialAbility(cardBeingActivated, cardActivatedPosition, cardTargetedPosition);
							currentlySpecAbility = false;
							if(Field.playerTurn == 1) {
								p1.specialAvailableThisTurn = false;
							}
							else {
								p2.specialAvailableThisTurn = false;
							}
							MainView.quizResult = true;
							MainView.resultCorrect = true;
							MainView.resultTimeStart = View.MainView.time;
							MainView.resultTimeEnd = View.MainView.time + View.MainView.resultLength;
						}
						else {
							currentlySpecAbility = false;
							if(Field.playerTurn == 1) {
								p1.specialAvailableThisTurn = false;
							}
							else {
								p2.specialAvailableThisTurn = false;
							}
							MainView.quizResult = true;
							MainView.resultCorrect = false;
							MainView.resultTimeStart = View.MainView.time;
							MainView.resultTimeEnd = View.MainView.time + View.MainView.resultLength;
						}
					}
					else if(questionSlot3.contains(MainView.mouseX, MainView.mouseY)) {
						if(Model.Quiz.isRight(cardBeingActivated.quizID, 2)) {
							Model.SpecialAbilities.activateSpecialAbility(cardBeingActivated, cardActivatedPosition, cardTargetedPosition);
							currentlySpecAbility = false;
							if(Field.playerTurn == 1) {
								p1.specialAvailableThisTurn = false;
							}
							else {
								p2.specialAvailableThisTurn = false;
							}
							MainView.quizResult = true;
							MainView.resultCorrect = true;
							MainView.resultTimeStart = View.MainView.time;
							MainView.resultTimeEnd = View.MainView.time + View.MainView.resultLength;
						}
						else {
							currentlySpecAbility = false;
							if(Field.playerTurn == 1) {
								p1.specialAvailableThisTurn = false;
							}
							else {
								p2.specialAvailableThisTurn = false;
							}
							MainView.quizResult = true;
							MainView.resultCorrect = false;
							MainView.resultTimeStart = View.MainView.time;
							MainView.resultTimeEnd = View.MainView.time + View.MainView.resultLength;
						}
					}
					else if(questionSlot4.contains(MainView.mouseX, MainView.mouseY)) {
						if(Model.Quiz.isRight(cardBeingActivated.quizID, 3)) {
							Model.SpecialAbilities.activateSpecialAbility(cardBeingActivated, cardActivatedPosition, cardTargetedPosition);
							currentlySpecAbility = false;
							if(Field.playerTurn == 1) {
								p1.specialAvailableThisTurn = false;
							}
							else {
								p2.specialAvailableThisTurn = false;
							}
							MainView.quizResult = true;
							MainView.resultCorrect = true;
							MainView.resultTimeStart = View.MainView.time;
							MainView.resultTimeEnd = View.MainView.time + View.MainView.resultLength;
						}
						else {
							currentlySpecAbility = false;
							if(Field.playerTurn == 1) {
								p1.specialAvailableThisTurn = false;
							}
							else {
								p2.specialAvailableThisTurn = false;
							}
							MainView.quizResult = true;
							MainView.resultCorrect = false;
							MainView.resultTimeStart = View.MainView.time;
							MainView.resultTimeEnd = View.MainView.time + View.MainView.resultLength;
						}
					}
				}
			}
		}

		// Game Over
		
		else if(Model.Field.gamePhase == 4) {
			MainView.frame.setVisible(false);
			MainView.frame.dispose();
			System.out.println("Game over!");
			
			Field.resetField();
			String[] args = {};
			MainView.main(args);
		}

		// MouseDown for Gameplay

		else if(Model.Field.gamePhase == 1) {
			
			// Pressing the end turn button
			
			if(endTurnSlot.contains(MainView.mouseX, MainView.mouseY)) {
				Model.Field.endTurn();
			}

			// Picking up a card from your hand

			else if(Model.Field.currPlayer.cardAvailThisTurn) {

				if(e.getButton() == MouseEvent.BUTTON1) {
					if(handSlot1.contains(MainView.mouseX, MainView.mouseY)) {
						cardBeingDragged = Model.Player.getCardFromPlayerHand(0);
						if(cardBeingDragged.cardNameID != 0) {
							MainView.draggedCardImage = MainView.cardImages.get(cardBeingDragged.cardNameID);
							Model.Player.addToHand(0, 0);
							MainView.frame.repaint();
							handPositionChosen = 0;
							currentlyDragging = true;
						}
						else {
							cardBeingDragged = null;
						}
					}

					else if(handSlot2.contains(MainView.mouseX, MainView.mouseY)) {
						cardBeingDragged = Model.Player.getCardFromPlayerHand(1);
						if(cardBeingDragged.cardNameID != 0) {
							MainView.draggedCardImage = MainView.cardImages.get(cardBeingDragged.cardNameID);
							Model.Player.addToHand(0, 1);
							MainView.frame.repaint();
							handPositionChosen = 1;
							currentlyDragging = true;
						}
						else {
							cardBeingDragged = null;
						}
					}

					else if(handSlot3.contains(MainView.mouseX, MainView.mouseY)) {
						cardBeingDragged = Model.Player.getCardFromPlayerHand(2);
						if(cardBeingDragged.cardNameID != 0) {
							MainView.draggedCardImage = MainView.cardImages.get(cardBeingDragged.cardNameID);
							Model.Player.addToHand(0, 2);
							MainView.frame.repaint();
							handPositionChosen = 2;
							currentlyDragging = true;
						}
						else {
							cardBeingDragged = null;
						}
					}

					else if(handSlot4.contains(MainView.mouseX, MainView.mouseY)) {
						cardBeingDragged = Model.Player.getCardFromPlayerHand(3);
						if(cardBeingDragged.cardNameID != 0) {
							MainView.draggedCardImage = MainView.cardImages.get(cardBeingDragged.cardNameID);
							Model.Player.addToHand(0, 3);
							MainView.frame.repaint();
							handPositionChosen = 3;
							currentlyDragging = true;
						}
						else {
							cardBeingDragged = null;
						}
					}

					else if(handSlot5.contains(MainView.mouseX, MainView.mouseY)) {
						cardBeingDragged = Model.Player.getCardFromPlayerHand(4);
						if(cardBeingDragged.cardNameID != 0) {
							MainView.draggedCardImage = MainView.cardImages.get(cardBeingDragged.cardNameID);
							Model.Player.addToHand(0, 4);
							MainView.frame.repaint();
							handPositionChosen = 4;
							currentlyDragging = true;
						}
						else {
							cardBeingDragged = null;
						}
					}
				}
			}

			// Activate Special Abilities in Player Slots 1-5

			if(Model.Field.currPlayer.specialAvailableThisTurn == true && currentlySpecAbility == false) {

				if(fieldSlot1.contains(MainView.mouseX, MainView.mouseY)) {
					if(Model.Player.getCardFromPlayerField(0).cardNameID != 0 && Model.Player.getCardFromPlayerField(0).specialAvailable 
							&& Model.Field.currPlayer.specialAvailableThisTurn && Model.Player.getCardFromPlayerField(0).cardType != 2) {
						cardBeingActivated = Model.Player.getCardFromPlayerField(0);
						cardActivatedPosition = 1;
						cardActivatedOnMyField = true;
						currentlySpecAbility = true;
					}
					else if(Model.Field.currPlayer.specialAvailableThisTurn == false){
						System.out.println("Player special used this turn already");
					}
				}

				else if(fieldSlot2.contains(MainView.mouseX, MainView.mouseY)) {
					if(Model.Player.getCardFromPlayerField(1).cardNameID != 0 && Model.Player.getCardFromPlayerField(1).specialAvailable
							&& Model.Field.currPlayer.specialAvailableThisTurn && Model.Player.getCardFromPlayerField(1).cardType != 2) {
						cardBeingActivated = Model.Player.getCardFromPlayerField(1);
						cardActivatedPosition = 2;
						cardActivatedOnMyField = true;
						currentlySpecAbility = true;
					}
					else if(Model.Field.currPlayer.specialAvailableThisTurn == false){
						System.out.println("Player special used this turn already");
					}
				}

				else if(fieldSlot3.contains(MainView.mouseX, MainView.mouseY)) {
					if(Model.Player.getCardFromPlayerField(2).cardNameID != 0 && Model.Player.getCardFromPlayerField(2).specialAvailable 
							&& Model.Field.currPlayer.specialAvailableThisTurn && Model.Player.getCardFromPlayerField(2).cardType != 2) {
						cardBeingActivated = Model.Player.getCardFromPlayerField(2);
						cardActivatedPosition = 3;
						cardActivatedOnMyField = true;
						currentlySpecAbility = true;
					}
					else if(Model.Field.currPlayer.specialAvailableThisTurn == false){
						System.out.println("Player special used this turn already");
					}
				}

				else if(fieldSlot4.contains(MainView.mouseX, MainView.mouseY)) {
					if(Model.Player.getCardFromPlayerField(3).cardNameID != 0 && Model.Player.getCardFromPlayerField(3).specialAvailable
							&& Model.Field.currPlayer.specialAvailableThisTurn && Model.Player.getCardFromPlayerField(3).cardType != 2) {
						cardBeingActivated = Model.Player.getCardFromPlayerField(3);
						cardActivatedPosition = 4;
						cardActivatedOnMyField = true;
						currentlySpecAbility = true;
					}
					else if(Model.Field.currPlayer.specialAvailableThisTurn == false){
						System.out.println("Player special used this turn already");
					}
				}

				else if(fieldSlot5.contains(MainView.mouseX, MainView.mouseY)) {
					if(Model.Player.getCardFromPlayerField(4).cardNameID != 0 && Model.Player.getCardFromPlayerField(4).specialAvailable 
							&& Model.Field.currPlayer.specialAvailableThisTurn && Model.Player.getCardFromPlayerField(4).cardType != 2) {
						cardBeingActivated = Model.Player.getCardFromPlayerField(4);
						cardActivatedPosition = 5;
						cardActivatedOnMyField = true;
						currentlySpecAbility = true;
					}
					else if(Model.Field.currPlayer.specialAvailableThisTurn == false){
						System.out.println("Player special used this turn already");
					}
				}

				// Activate Special Abilities in Enemy Slots 6-10

				else if(fieldSlot6.contains(MainView.mouseX, MainView.mouseY)) {
					if(Model.Player.getCardFromEnemyField(0).cardNameID != 0 && Model.Player.getCardFromEnemyField(0).specialAvailable
							&& Model.Field.currPlayer.specialAvailableThisTurn && Model.Player.getCardFromEnemyField(0).cardType != 1) {
						cardBeingActivated = Model.Player.getCardFromEnemyField(0);
						cardActivatedPosition = 6;
						cardActivatedOnMyField = false;
						currentlySpecAbility = true;
					}
					else if(Model.Field.currPlayer.specialAvailableThisTurn == false){
						System.out.println("Player special used this turn already");
					}
				}

				else if(fieldSlot7.contains(MainView.mouseX, MainView.mouseY)) {
					if(Model.Player.getCardFromEnemyField(1).cardNameID != 0 && Model.Player.getCardFromEnemyField(1).specialAvailable
							&& Model.Field.currPlayer.specialAvailableThisTurn && Model.Player.getCardFromEnemyField(1).cardType != 1) {
						cardBeingActivated = Model.Player.getCardFromEnemyField(1);
						cardActivatedPosition = 7;
						cardActivatedOnMyField = false;
						currentlySpecAbility = true;
					}
					else if(Model.Field.currPlayer.specialAvailableThisTurn == false){
						System.out.println("Player special used this turn already");
					}
				}

				else if(fieldSlot8.contains(MainView.mouseX, MainView.mouseY)) {
					if(Model.Player.getCardFromEnemyField(2).cardNameID != 0 && Model.Player.getCardFromEnemyField(2).specialAvailable 
							&& Model.Field.currPlayer.specialAvailableThisTurn && Model.Player.getCardFromEnemyField(2).cardType != 1) {
						cardBeingActivated = Model.Player.getCardFromEnemyField(2);
						cardActivatedPosition = 8;
						cardActivatedOnMyField = false;
						currentlySpecAbility = true;
					}
					else if(Model.Field.currPlayer.specialAvailableThisTurn == false){
						System.out.println("Player special used this turn already");
					}
				}

				else if(fieldSlot9.contains(MainView.mouseX, MainView.mouseY)) {
					if(Model.Player.getCardFromEnemyField(3).cardNameID != 0 && Model.Player.getCardFromEnemyField(3).specialAvailable
							&& Model.Field.currPlayer.specialAvailableThisTurn && Model.Player.getCardFromEnemyField(3).cardType != 1) {
						cardBeingActivated = Model.Player.getCardFromEnemyField(3);
						cardActivatedPosition = 9;
						cardActivatedOnMyField = false;
						currentlySpecAbility = true;
					}
					else if(Model.Field.currPlayer.specialAvailableThisTurn == false){
						System.out.println("Player special used this turn already");
					}
				}

				else if(fieldSlot10.contains(MainView.mouseX, MainView.mouseY)) {
					if(Model.Player.getCardFromEnemyField(4).cardNameID != 0 && Model.Player.getCardFromEnemyField(4).specialAvailable 
							&& Model.Field.currPlayer.specialAvailableThisTurn && Model.Player.getCardFromEnemyField(4).cardType != 1) {
						cardBeingActivated = Model.Player.getCardFromEnemyField(4);
						cardActivatedPosition = 10;
						cardActivatedOnMyField = false;
						currentlySpecAbility = true;
					}
					else if(Model.Field.currPlayer.specialAvailableThisTurn == false){
						System.out.println("Player special used this turn already");
					}
				}
			}

			// Target a card in Player Slots 1-5
			
			else if(currentlySpecAbility == true) {
				if(fieldSlot1.contains(MainView.mouseX, MainView.mouseY)) {
					cardBeingTargeted = Model.Player.getCardFromPlayerField(0);
					cardTargetedPosition = 1;
					System.out.println(cardBeingActivated.toString() + " targeting " + cardBeingTargeted.toString());
					if(Model.SpecialAbilities.checkSpecialAbility(cardBeingActivated, cardBeingTargeted, cardTargetedPosition)) {
						MainView.quizID = cardBeingActivated.quizID;
						Model.Field.gamePhase = 3;
					}
					else {
						helpMessage = 2;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
				}
				else if(fieldSlot2.contains(MainView.mouseX, MainView.mouseY)) {
					cardBeingTargeted = Model.Player.getCardFromPlayerField(1);
					cardTargetedPosition = 2;
					System.out.println(cardBeingActivated.toString() + " targeting " + cardBeingTargeted.toString());
					if(Model.SpecialAbilities.checkSpecialAbility(cardBeingActivated, cardBeingTargeted, cardTargetedPosition)) {
						MainView.quizID = cardBeingActivated.quizID;
						Model.Field.gamePhase = 3;
					}
					else {
						helpMessage = 2;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
				}
				else if(fieldSlot3.contains(MainView.mouseX, MainView.mouseY)) {
					cardBeingTargeted = Model.Player.getCardFromPlayerField(2);
					cardTargetedPosition = 3;
					System.out.println(cardBeingActivated.toString() + " targeting " + cardBeingTargeted.toString());
					if(Model.SpecialAbilities.checkSpecialAbility(cardBeingActivated, cardBeingTargeted, cardTargetedPosition)) {
						MainView.quizID = cardBeingActivated.quizID;
						Model.Field.gamePhase = 3;
					}
					else {
						helpMessage = 2;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
				}
				else if(fieldSlot4.contains(MainView.mouseX, MainView.mouseY)) {
					cardBeingTargeted = Model.Player.getCardFromPlayerField(3);
					cardTargetedPosition = 4;
					System.out.println(cardBeingActivated.toString() + " targeting " + cardBeingTargeted.toString());
					if(Model.SpecialAbilities.checkSpecialAbility(cardBeingActivated, cardBeingTargeted, cardTargetedPosition)) {
						MainView.quizID = cardBeingActivated.quizID;
						Model.Field.gamePhase = 3;
					}
					else {
						helpMessage = 2;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
				}
				else if(fieldSlot5.contains(MainView.mouseX, MainView.mouseY)) {
					cardBeingTargeted = Model.Player.getCardFromPlayerField(4);
					cardTargetedPosition = 5;
					System.out.println(cardBeingActivated.toString() + " targeting " + cardBeingTargeted.toString());
					if(Model.SpecialAbilities.checkSpecialAbility(cardBeingActivated, cardBeingTargeted, cardTargetedPosition)) {
						MainView.quizID = cardBeingActivated.quizID;
						Model.Field.gamePhase = 3;
					}
					else {
						helpMessage = 2;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
				}
				
				// Target a card in Enemy Slots 6-10
				
				else if(fieldSlot6.contains(MainView.mouseX, MainView.mouseY)) {
					cardBeingTargeted = Model.Player.getCardFromEnemyField(0);
					cardTargetedPosition = 6;
					System.out.println(cardBeingActivated.toString() + " targeting " + cardBeingTargeted.toString());
					if(Model.SpecialAbilities.checkSpecialAbility(cardBeingActivated, cardBeingTargeted, cardTargetedPosition)) {
						MainView.quizID = cardBeingActivated.quizID;
						Model.Field.gamePhase = 3;
					}
					else {
						helpMessage = 2;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
				}
				else if(fieldSlot7.contains(MainView.mouseX, MainView.mouseY)) {
					cardBeingTargeted = Model.Player.getCardFromEnemyField(1);
					cardTargetedPosition = 7;
					System.out.println(cardBeingActivated.toString() + " targeting " + cardBeingTargeted.toString());
					if(Model.SpecialAbilities.checkSpecialAbility(cardBeingActivated, cardBeingTargeted, cardTargetedPosition)) {
						MainView.quizID = cardBeingActivated.quizID;
						Model.Field.gamePhase = 3;
					}
					else {
						helpMessage = 2;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
				}
				else if(fieldSlot8.contains(MainView.mouseX, MainView.mouseY)) {
					cardBeingTargeted = Model.Player.getCardFromEnemyField(2);
					cardTargetedPosition = 8;
					System.out.println(cardBeingActivated.toString() + " targeting " + cardBeingTargeted.toString());
					if(Model.SpecialAbilities.checkSpecialAbility(cardBeingActivated, cardBeingTargeted, cardTargetedPosition)) {
						MainView.quizID = cardBeingActivated.quizID;
						Model.Field.gamePhase = 3;
					}
					else {
						helpMessage = 2;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
				}
				else if(fieldSlot9.contains(MainView.mouseX, MainView.mouseY)) {
					cardBeingTargeted = Model.Player.getCardFromEnemyField(3);
					cardTargetedPosition = 9;
					System.out.println(cardBeingActivated.toString() + " targeting " + cardBeingTargeted.toString());
					if(Model.SpecialAbilities.checkSpecialAbility(cardBeingActivated, cardBeingTargeted, cardTargetedPosition)) {
						MainView.quizID = cardBeingActivated.quizID;
						Model.Field.gamePhase = 3;
					}
					else {
						helpMessage = 2;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
				}
				else if(fieldSlot10.contains(MainView.mouseX, MainView.mouseY)) {
					cardBeingTargeted = Model.Player.getCardFromEnemyField(4);
					cardTargetedPosition = 10;
					System.out.println(cardBeingActivated.toString() + " targeting " + cardBeingTargeted.toString());
					if(Model.SpecialAbilities.checkSpecialAbility(cardBeingActivated, cardBeingTargeted, cardTargetedPosition)) {
						MainView.quizID = cardBeingActivated.quizID;
						Model.Field.gamePhase = 3;
					}
					else {
						helpMessage = 2;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
				}
				else {
					currentlySpecAbility = false;
				}
			}
		}
	}
	




	public void mouseReleased(MouseEvent e) {

		// Click to go past start screen
		
		if(Model.Field.gamePhase == 0) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				Model.Field.gamePhase = 5;
			}
		}
		
		// Tutorial Screens
		
		if(Model.Field.gamePhase == 5) {
			if(e.getButton() == MouseEvent.BUTTON1 && mousePressed == true) {
				Model.Field.gamePhase = 6;
				mousePressed = false;
			}
		}
		
		if(Model.Field.gamePhase == 6) {
			if(e.getButton() == MouseEvent.BUTTON1 && mousePressed == true) {
				Model.Field.gamePhase = 7;
				mousePressed = false;
			}
		}
		
		if(Model.Field.gamePhase == 7) {
			if(e.getButton() == MouseEvent.BUTTON1 && mousePressed == true) {
				Model.Field.gamePhase = 8;
				mousePressed = false;
			}
		}
		
		if(Model.Field.gamePhase == 8) {
			if(e.getButton() == MouseEvent.BUTTON1 && mousePressed == true) {
				Model.Field.gamePhase = 2;
				mousePressed = false;
			}
		}
		
		// Deck Selection
		
		if(Model.Field.gamePhase == 2) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(deckSlot1.contains(MainView.mouseX, MainView.mouseY) && mousePressed) {
					mousePressed = false;
					p1 = new Player(1, 1);
					for(int i = 0; i < 5; i++) {
						Model.Player.myHand.add(new EmptyCard());
					}
					Model.Player.startingCards(p1);
					Model.Field.gamePhase = 9;
				}
				else if(deckSlot2.contains(MainView.mouseX, MainView.mouseY) && mousePressed) {
					mousePressed = false;
					p1 = new Player(1, 2);
					for(int i = 0; i < 5; i++) {
						Model.Player.myHand.add(new EmptyCard());
					}
					Model.Player.startingCards(p1);
					Model.Field.gamePhase = 9;
				}
				else if(deckSlot3.contains(MainView.mouseX, MainView.mouseY) && mousePressed) {
					mousePressed = false;
					p1 = new Player(1, 3);
					for(int i = 0; i < 5; i++) {
						Model.Player.myHand.add(new EmptyCard());
					}
					Model.Player.startingCards(p1);
					Model.Field.gamePhase = 9;
				}
			}
		}
		
		if(Model.Field.gamePhase == 9) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(deckSlot1.contains(MainView.mouseX, MainView.mouseY) && mousePressed) {
					mousePressed = false;
					p2 = new Player(2, 1);
					for(int i = 0; i < 5; i++) {
						Model.Player.enemyHand.add(new EmptyCard());
					}
					Model.Player.startingCards(p2);
					Model.Field.currPlayer = p1;
					Model.Field.gamePhase = 1;
				}
				else if(deckSlot2.contains(MainView.mouseX, MainView.mouseY) && mousePressed) {
					mousePressed = false;
					p2 = new Player(2, 2);
					for(int i = 0; i < 5; i++) {
						Model.Player.enemyHand.add(new EmptyCard());
					}
					Model.Player.startingCards(p2);
					Model.Field.currPlayer = p1;
					Model.Field.gamePhase = 1;
				}
				else if(deckSlot3.contains(MainView.mouseX, MainView.mouseY) && mousePressed) {
					mousePressed = false;
					p2 = new Player(2, 3);
					for(int i = 0; i < 5; i++) {
						Model.Player.enemyHand.add(new EmptyCard());
					}
					Model.Player.startingCards(p2);
					Model.Field.currPlayer = p1;
					Model.Field.gamePhase = 1;
				}
			}
		}
		
		// MouseUp for Gameplay

		if(Model.Field.gamePhase == 1) {

			// While dragging a card, drop onto a field slot
			if(currentlyDragging) {

				if(fieldSlot1.contains(MainView.mouseX, MainView.mouseY)) {
					if(cardBeingDragged.cardType == 1) {
						if(Model.Player.getCardFromPlayerField(0).cardNameID == 0) {
							Model.Player.addToPlayerField(cardBeingDragged.cardNameID, 0);
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							MainView.frame.repaint();
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
					}
					else if(cardBeingDragged.cardType == 2) {
						Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
						MainView.frame.repaint();
						currentlyDragging = false;
						cardBeingDragged = null;
						helpMessage = 0;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
					else if(cardBeingDragged.cardType == 3) {
						if(Model.SpecialAbilities.checkSpecialAbility(cardBeingDragged, Model.Player.getCardFromPlayerField(0), 1)) {
							System.out.println(cardBeingDragged.toString() + " being used on " + Model.Player.getCardFromPlayerField(0).toString());
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							Model.SpecialAbilities.activateSpecialAbility(cardBeingDragged, 1, 1);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
					}
				}
				}

				else if(fieldSlot2.contains(MainView.mouseX, MainView.mouseY)) {
					if(cardBeingDragged.cardType == 1) {
						if(Model.Player.getCardFromPlayerField(1).cardNameID == 0) {
							Model.Player.addToPlayerField(cardBeingDragged.cardNameID, 1);
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							MainView.frame.repaint();
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
					}
					else if(cardBeingDragged.cardType == 2) {
						Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
						MainView.frame.repaint();
						currentlyDragging = false;
						cardBeingDragged = null;
						helpMessage = 0;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
					else if(cardBeingDragged.cardType == 3) {
						if(Model.SpecialAbilities.checkSpecialAbility(cardBeingDragged, Model.Player.getCardFromPlayerField(1), 2)) {
							System.out.println(cardBeingDragged.toString() + " being used on " + Model.Player.getCardFromPlayerField(1).toString());
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							Model.SpecialAbilities.activateSpecialAbility(cardBeingDragged, 2, 2);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
					}
					}
				}

				else if(fieldSlot3.contains(MainView.mouseX, MainView.mouseY)) {
					if(cardBeingDragged.cardType == 1) {
						if(Model.Player.getCardFromPlayerField(2).cardNameID == 0) {
							Model.Player.addToPlayerField(cardBeingDragged.cardNameID, 2);
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							MainView.frame.repaint();
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
					}
					else if(cardBeingDragged.cardType == 2) {
						Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
						MainView.frame.repaint();
						currentlyDragging = false;
						cardBeingDragged = null;
						helpMessage = 0;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
					else if(cardBeingDragged.cardType == 3) {
						if(Model.SpecialAbilities.checkSpecialAbility(cardBeingDragged, Model.Player.getCardFromPlayerField(2), 3)) {
							System.out.println(cardBeingDragged.toString() + " being used on " + Model.Player.getCardFromPlayerField(0).toString());
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							Model.SpecialAbilities.activateSpecialAbility(cardBeingDragged, 3, 3);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
					}
					}
				}

				else if(fieldSlot4.contains(MainView.mouseX, MainView.mouseY)) {
					if(cardBeingDragged.cardType == 1) {
						if(Model.Player.getCardFromPlayerField(3).cardNameID == 0) {
							Model.Player.addToPlayerField(cardBeingDragged.cardNameID, 3);
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							MainView.frame.repaint();
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
					}
					else if(cardBeingDragged.cardType == 2) {
						Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
						MainView.frame.repaint();
						currentlyDragging = false;
						cardBeingDragged = null;
						helpMessage = 0;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
					else if(cardBeingDragged.cardType == 3) {
						if(Model.SpecialAbilities.checkSpecialAbility(cardBeingDragged, Model.Player.getCardFromPlayerField(3), 4)) {
							System.out.println(cardBeingDragged.toString() + " being used on " + Model.Player.getCardFromPlayerField(0).toString());
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							Model.SpecialAbilities.activateSpecialAbility(cardBeingDragged, 4, 4);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
					}
					}
				}

				else if(fieldSlot5.contains(MainView.mouseX, MainView.mouseY)) {
					if(cardBeingDragged.cardType == 1) {
						if(Model.Player.getCardFromPlayerField(4).cardNameID == 0) {
							Model.Player.addToPlayerField(cardBeingDragged.cardNameID, 4);
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							MainView.frame.repaint();
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
					}
					else if(cardBeingDragged.cardType == 2) {
						Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
						MainView.frame.repaint();
						currentlyDragging = false;
						cardBeingDragged = null;
						helpMessage = 0;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
					else if(cardBeingDragged.cardType == 3) {
						if(Model.SpecialAbilities.checkSpecialAbility(cardBeingDragged, Model.Player.getCardFromPlayerField(4), 5)) {
							System.out.println(cardBeingDragged.toString() + " being used on " + Model.Player.getCardFromPlayerField(0).toString());
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							Model.SpecialAbilities.activateSpecialAbility(cardBeingDragged, 5, 5);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
					}
					}
				}

				else if(fieldSlot6.contains(MainView.mouseX, MainView.mouseY)) {
					if(cardBeingDragged.cardType == 2) {
						if(Model.Player.getCardFromEnemyField(0).cardNameID == 0) {
							Model.Player.addToEnemyField(cardBeingDragged.cardNameID, 0);
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							MainView.frame.repaint();
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
					}
					else if(cardBeingDragged.cardType == 1) {
						Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
						MainView.frame.repaint();
						currentlyDragging = false;
						cardBeingDragged = null;
						helpMessage = 1;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
					else if(cardBeingDragged.cardType == 3) {
						if(Model.SpecialAbilities.checkSpecialAbility(cardBeingDragged, Model.Player.getCardFromEnemyField(0), 6)) {
							System.out.println(cardBeingDragged.toString() + " being used on " + Model.Player.getCardFromEnemyField(0).toString());
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							Model.SpecialAbilities.activateSpecialAbility(cardBeingDragged, 6, 6);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
					}
					}
				}

				else if(fieldSlot7.contains(MainView.mouseX, MainView.mouseY)) {
					if(cardBeingDragged.cardType == 2) {
						if(Model.Player.getCardFromEnemyField(1).cardNameID == 0) {
							Model.Player.addToEnemyField(cardBeingDragged.cardNameID, 1);
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							MainView.frame.repaint();
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
					}
					else if(cardBeingDragged.cardType == 1) {
						Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
						MainView.frame.repaint();
						currentlyDragging = false;
						cardBeingDragged = null;
						helpMessage = 1;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
					else if(cardBeingDragged.cardType == 3) {
						if(Model.SpecialAbilities.checkSpecialAbility(cardBeingDragged, Model.Player.getCardFromEnemyField(1), 7)) {
							System.out.println(cardBeingDragged.toString() + " being used on " + Model.Player.getCardFromEnemyField(1).toString());
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							Model.SpecialAbilities.activateSpecialAbility(cardBeingDragged, 7, 7);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
					}
					}
				}

				else if(fieldSlot8.contains(MainView.mouseX, MainView.mouseY)) {
					if(cardBeingDragged.cardType == 2) {
						if(Model.Player.getCardFromEnemyField(2).cardNameID == 0) {
							Model.Player.addToEnemyField(cardBeingDragged.cardNameID, 2);
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							MainView.frame.repaint();
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
					}
					else if(cardBeingDragged.cardType == 1) {
						Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
						MainView.frame.repaint();
						currentlyDragging = false;
						cardBeingDragged = null;
						helpMessage = 1;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
					else if(cardBeingDragged.cardType == 3) {
						if(Model.SpecialAbilities.checkSpecialAbility(cardBeingDragged, Model.Player.getCardFromEnemyField(2), 8)) {
							System.out.println(cardBeingDragged.toString() + " being used on " + Model.Player.getCardFromEnemyField(2).toString());
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							Model.SpecialAbilities.activateSpecialAbility(cardBeingDragged, 8, 8);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
					}
					}
				}

				else if(fieldSlot9.contains(MainView.mouseX, MainView.mouseY)) {
					if(cardBeingDragged.cardType == 2) {
						if(Model.Player.getCardFromEnemyField(3).cardNameID == 0) {
							Model.Player.addToEnemyField(cardBeingDragged.cardNameID, 3);
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							MainView.frame.repaint();
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
					}
					else if(cardBeingDragged.cardType == 1) {
						Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
						MainView.frame.repaint();
						currentlyDragging = false;
						cardBeingDragged = null;
						helpMessage = 1;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
					else if(cardBeingDragged.cardType == 3) {
						if(Model.SpecialAbilities.checkSpecialAbility(cardBeingDragged, Model.Player.getCardFromEnemyField(3), 9)) {
							System.out.println(cardBeingDragged.toString() + " being used on " + Model.Player.getCardFromEnemyField(3).toString());
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							Model.SpecialAbilities.activateSpecialAbility(cardBeingDragged, 9, 9);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
					}
					}
				}

				else if(fieldSlot10.contains(MainView.mouseX, MainView.mouseY)) {
					if(cardBeingDragged.cardType == 2) {
						if(Model.Player.getCardFromEnemyField(4).cardNameID == 0) {
							Model.Player.addToEnemyField(cardBeingDragged.cardNameID, 4);
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							MainView.frame.repaint();
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
					}
					else if(cardBeingDragged.cardType == 1) {
						Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
						MainView.frame.repaint();
						currentlyDragging = false;
						cardBeingDragged = null;
						helpMessage = 1;
						View.MainView.helpMessageTimeStart = View.MainView.time;
						View.MainView.helpMessageTimeEnd = View.MainView.time + View.MainView.helpMessageLength;
					}
					else if(cardBeingDragged.cardType == 3) {
						if(Model.SpecialAbilities.checkSpecialAbility(cardBeingDragged, Model.Player.getCardFromEnemyField(4), 10)) {
							System.out.println(cardBeingDragged.toString() + " being used on " + Model.Player.getCardFromEnemyField(4).toString());
							if(Model.Field.playerTurn == 1) {
								p1.cardAvailThisTurn = false;
							}
							else {
								p2.cardAvailThisTurn = false;
							}
							Model.SpecialAbilities.activateSpecialAbility(cardBeingDragged, 10, 10);
							currentlyDragging = false;
							cardBeingDragged = null;
						}
						else {
							Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
							currentlyDragging = false;
							cardBeingDragged = null;
					}
					}
				}

				// While dragging a card, drop onto somewhere other than a field slot
				else {
					//if(cardBeingDragged.cardType != 3) {
					Model.Player.addToHand(cardBeingDragged.cardNameID, handPositionChosen);
					MainView.frame.repaint();
					currentlyDragging = false;
					cardBeingDragged = null;
					//}
					/*else if(cardBeingDragged.cardType == 3) {
						if(playerField.contains(MainView.mouseX, MainView.mouseY)) {
							System.out.println(cardBeingDragged.toString() + " being used on player field");
							Model.Player.cardAvailThisTurn = false;
						}
						else if(enemyField.contains(MainView.mouseX, MainView.mouseY)) {
							System.out.println(cardBeingDragged.toString() + " being used on enemy field");
							Model.Player.cardAvailThisTurn = false;
						}
					}*/
				}

				MainView.draggedCardImage = null;
			}
		}
	}
	
	}