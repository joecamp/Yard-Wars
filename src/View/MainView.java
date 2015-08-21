package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.MouseListener;
import Controller.EscapeKeyListener;
import Model.EcoBar;
import Model.Field;
import Model.Player;
import Model.SpecialAbilities;

import java.util.ArrayList;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class MainView extends JPanel {

	final public static JFrame frame = new JFrame();
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public final static int frameWidth = (int) screenSize.getWidth();
	public final static int frameHeight = (int) screenSize.getHeight();

	public static int cardWidth = (int) (.12847 * frameWidth);
	public static int cardHeight = (int) (.26041 * frameHeight);
	public static int ecoBarWidth = (int) (.0347 * frameWidth);
	public static int ecoBarHeight = (int) (.39 * frameHeight);
	public static int ecoBarFilledWidth = (int) (ecoBarWidth * .83);
	public static int deckWidth;
	public static int deckHeight;

	public static int time = 1;
	public static int gameTimer = 20;
	public static int helpMessageTimeStart;
	public static int helpMessageTimeEnd;
	public static int helpMessageLength = 300;

	public static boolean specialAnimation = false;
	public static int specialAnimationTimeStart;
	public static int specialAnimationTimeEnd;
	public static int specialAnimationLength = 125;
	public static boolean animationDone = true;

	public static boolean quizResult = false;
	public static boolean resultCorrect;
	public static int resultTimeStart;
	public static int resultTimeEnd;
	public static int resultLength = 200;

	public static int quizID;

	public static int mouseX;
	public static int mouseY;

	public static ArrayList<BufferedImage> cardImages = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> deckImages = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> timerImages = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> pointsImages = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> quizImages = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> resultImages = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> helpMessages = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> gameOverImages = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> playerTurnImages = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> hintImages = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> deckDescs = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> deckChooseImages = new ArrayList<BufferedImage>();
	public static ArrayList<ArrayList<BufferedImage>> animations = new ArrayList<ArrayList<BufferedImage>>();
	public static ArrayList<BufferedImage> tempAni0 = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> tempAni1 = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> tempAni2 = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> tempAni3 = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> tempAni4 = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> tempAni5 = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> tempAni6 = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> tempAni7 = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> tempAni8 = new ArrayList<BufferedImage>();

	public static BufferedImage tempBufferedImage;

	public static BufferedImage emptyEcoBarImage;
	public static BufferedImage fenceImage;
	public static BufferedImage quizImage;
	public static BufferedImage startScreenImage;
	public static BufferedImage timeImage;
	public static BufferedImage turnCounterImage;
	public static BufferedImage grassImage;
	public static BufferedImage cursorImage;
	public static BufferedImage endTurnImage;
	public static BufferedImage tutorialImage1;
	public static BufferedImage tutorialImage2;
	public static BufferedImage tutorialImage3;
	public static BufferedImage tutorialImage4;
	public static BufferedImage hintImage;
	public static BufferedImage seedMarket;
	
	public static BufferedImage draggedCardImage = null;

	public static int deckSlot1x;
	public static int deckSlot2x;
	public static int deckSlot3x;
	public static int deckSloty = (frameHeight*37/100);

	public static int fieldSlot1x = (frameWidth*1/6);
	public static int fieldSlot2x = (frameWidth*2/6);
	public static int fieldSlot3x = (frameWidth*3/6);
	public static int fieldSlot4x = (frameWidth*4/6);
	public static int fieldSlot5x = (frameWidth*5/6);
	public static int fieldSlot24y = (frameHeight*60/100);
	public static int fieldSlot135y = (frameHeight*2/3);

	public static int fieldSlot6x = (frameWidth*1/6);
	public static int fieldSlot7x = (frameWidth*2/6);
	public static int fieldSlot8x = (frameWidth*3/6);
	public static int fieldSlot9x = (frameWidth*4/6);
	public static int fieldSlot10x = (frameWidth*5/6);
	public static int fieldSlot6810y = (frameHeight*1/25);
	public static int fieldSlot79y = (frameHeight*10/100);

	public static int handSlot1y = (frameHeight*5/100);
	public static int handSlot2y = (frameHeight*20/100);
	public static int handSlot3y = (frameHeight*35/100);
	public static int handSlot4y = (frameHeight*50/100);
	public static int handSlot5y = (frameHeight*65/100);

	public static int handSlotx = (frameWidth*1/150);

	public int ecoBar1x = (frameWidth*96/100);
	public int ecoBar1y = (frameHeight*5/100);
	public int ecoBar2x = (frameWidth*96/100);
	public int ecoBar2y = (frameHeight*53/100);
	public int ecoBarPixels1 = 0;
	public int ecoBarPixels2 = 0;

	public static int endTurnx = frameWidth*95/100;
	public static int endTurny = frameHeight*44/100;

	public int specAbilityIndicX = (int) (.011 * frameWidth);
	public int specAbilityIndicY = (frameHeight*1/200);
	public int specAbilityIndicW = (int) (1.000001 * cardWidth);
	public int specAbilityIndicH = (cardHeight*104/100);

	public int helpMessageX = (frameWidth*40/100);
	public int helpMessageY = (frameHeight*48/100);

	public int fenceX = (frameWidth*-30/100);
	public int fenceY = (frameHeight*-15/100);

	public int timeWordY = (frameHeight*93/100); 
	public int turnWordX = (frameWidth*85/100);
	public int turnWordY = (frameHeight*93/100);
	public int hintWordX = (frameWidth*60/100);
	public int hintWordY = (frameHeight*93/100);

	public int gameplayTimeX = (frameWidth*10/100);
	public int gameplayTimeY = (frameHeight*185/200);

	public int gameplayCounterX = (frameWidth*94/100);
	public int gameplayCounterY = (frameHeight*185/200);

	public static int questionWidth = (frameWidth*70/100);
	public static int questionHeight = (frameHeight*1/9);
	public static int questionSlotx = (frameWidth *15/100);
	public static int questionSlot1y = (frameHeight*34/100);
	public static int questionSlot2y = (frameHeight*46/100);
	public static int questionSlot3y = (frameHeight*58/100);
	public static int questionSlot4y = (frameHeight*70/100);
	
	public static Rectangle hintBox;

	int onFieldID1; int onFieldID2; int onFieldID3; int onFieldID4; int onFieldID5;
	int onFieldID6; int onFieldID7; int onFieldID8; int onFieldID9; int onFieldID10;

	int inHandID1; int inHandID2; int inHandID3; int inHandID4; int inHandID5;

	Stroke targetingLine = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,
			new float[]{9}, 0);

	// called by repaint; updates view depending on gamePhase
	public void paint(Graphics g) {

		mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
		mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();

		if(Model.Field.gamePhase == 0) { 
			g.drawImage(startScreenImage, 0, 0, this);
		}

		else if(Model.Field.gamePhase == 2 || Model.Field.gamePhase == 9) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, frameWidth, frameHeight);
			g.drawImage(seedMarket, 0, 0, this);
			if(MouseListener.deckSlot1.contains(mouseX, mouseY)) {
				g.fillRect(frameWidth*3/100, frameHeight*72/100, frameWidth*94/100, frameHeight*26/100); 
				g.drawImage(deckDescs.get(0), 0, 0, this);
			}
			else if(MouseListener.deckSlot2.contains(mouseX, mouseY)) {
				g.fillRect(frameWidth*3/100, frameHeight*72/100, frameWidth*94/100, frameHeight*26/100); 
				g.drawImage(deckDescs.get(1), 0, 0, this);
			}
			else if(MouseListener.deckSlot3.contains(mouseX, mouseY)) {
				g.fillRect(frameWidth*3/100, frameHeight*70/100, frameWidth*94/100, frameHeight*29/100); 
				g.drawImage(deckDescs.get(2), 0, 0, this);
			}
			g.drawImage(deckImages.get(0), deckSlot1x, deckSloty, this);
			g.drawImage(deckImages.get(1), deckSlot2x, deckSloty, this);
			g.drawImage(deckImages.get(2), deckSlot3x, deckSloty, this);
			if(Model.Field.gamePhase == 2) {
				g.drawImage(deckChooseImages.get(0), frameWidth*15/100, 0, this);
			}
			else {
				g.drawImage(deckChooseImages.get(1), frameWidth*15/100, 0, this);
			}
		}

		else if(Model.Field.gamePhase == 4) {
			if(Model.EcoBar.calcMyEcoPoints() >= Model.EcoBar.calcEnemyEcoPoints()) {
				g.drawImage(gameOverImages.get(0), 0, 0, this);
			}
			else {
				g.drawImage(gameOverImages.get(1), 0, 0, this);
			}
		}

		else if(Model.Field.gamePhase == 5) {
			g.drawImage(tutorialImage1, 0, 0, this);
		}

		else if(Model.Field.gamePhase == 6) {
			g.drawImage(tutorialImage2, 0, 0, this);
		}

		else if(Model.Field.gamePhase == 7) {
			g.drawImage(tutorialImage3, 0, 0, this);
		}

		else if(Model.Field.gamePhase == 8) {
			g.drawImage(tutorialImage4, 0, 0, this);
		}

		else if(Model.Field.gamePhase == 3) {

			g.drawImage(grassImage, 0, 0, this);

			g.drawImage(fenceImage, fenceX, fenceY, this);

			g.drawImage(timeImage, 0, timeWordY, this);
			g.drawImage(turnCounterImage, turnWordX, turnWordY, this);

			g.drawImage(timerImages.get(gameTimer), gameplayTimeX, gameplayTimeY, this);
			g.drawImage(timerImages.get(Model.Field.turnCounter), gameplayCounterX, gameplayCounterY, this);

			g.drawImage(cardImages.get(inHandID1), handSlotx, handSlot1y, this);
			g.drawImage(cardImages.get(inHandID2), handSlotx, handSlot2y, this);
			g.drawImage(cardImages.get(inHandID3), handSlotx, handSlot3y, this);
			g.drawImage(cardImages.get(inHandID4), handSlotx, handSlot4y, this);
			g.drawImage(cardImages.get(inHandID5), handSlotx, handSlot5y, this);

			ecoBarPixels1 = (Model.EcoBar.calcEnemyEcoPoints() * ecoBarHeight) * 1/20;
			ecoBarPixels2 = (Model.EcoBar.calcMyEcoPoints() * ecoBarHeight) * 1/20;

			g.drawImage(emptyEcoBarImage, ecoBar1x, ecoBar1y, this);
			g.drawImage(emptyEcoBarImage, ecoBar2x, ecoBar2y, this);

			g.setColor(Color.YELLOW);
			g.fillRect(ecoBar1x, (ecoBar1y + ecoBarHeight - ecoBarPixels1), ecoBarFilledWidth, ecoBarPixels1);
			g.fillRect(ecoBar2x, (ecoBar2y + ecoBarHeight - ecoBarPixels2), ecoBarFilledWidth, ecoBarPixels2);

			g.drawImage(quizImages.get(quizID), frameWidth*1/8, frameHeight*1/8, this);
			g.setColor(Color.WHITE);

			if(quizResult == false) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(10));
				g2.setColor(Color.YELLOW);
				if(MouseListener.questionSlot1.contains(mouseX, mouseY)) {
					g.drawRect(MainView.questionSlotx, MainView.questionSlot1y, MainView.questionWidth, MainView.questionHeight);
				}
				else if(MouseListener.questionSlot2.contains(mouseX, mouseY)) {
					g.drawRect(MainView.questionSlotx, MainView.questionSlot2y, MainView.questionWidth, MainView.questionHeight);
				}
				else if(MouseListener.questionSlot3.contains(mouseX, mouseY)) {
					g.drawRect(MainView.questionSlotx, MainView.questionSlot3y, MainView.questionWidth, MainView.questionHeight);
				}
				else if(MouseListener.questionSlot4.contains(mouseX, mouseY)) {
					g.drawRect(MainView.questionSlotx, MainView.questionSlot4y, MainView.questionWidth, MainView.questionHeight);
				}
			}

			if(quizResult) {
				if(resultCorrect && resultTimeStart <= resultTimeEnd) {
					g.drawImage(resultImages.get(0), frameWidth*1/2 - resultImages.get(0).getWidth()*1/2, frameHeight*1/2 - resultImages.get(0).getHeight()*1/2, this);
					resultTimeStart++;
				}
				else if(resultCorrect == false && resultTimeStart <= resultTimeEnd) {
					g.drawImage(resultImages.get(1), frameWidth*1/2 - resultImages.get(1).getWidth()*1/2, frameHeight*1/2 - resultImages.get(1).getHeight()*1/2, this);
					resultTimeStart++;
				}
				else {
					quizResult = false;
					Model.Field.gamePhase = 1;
				}
			}
		}

		else if(Model.Field.gamePhase == 1) {

			g.drawImage(grassImage, 0, 0, this);

			g.drawImage(fenceImage, fenceX, fenceY, this);

			g.drawImage(endTurnImage, endTurnx, endTurny, this);
			
			g.setColor(Color.CYAN);
			g.fillRect(0, frameHeight*187/200, frameWidth, frameHeight*8/100);

			g.drawImage(timeImage, 0, timeWordY, this);
			g.drawImage(turnCounterImage, turnWordX, turnWordY, this);

			g.drawImage(timerImages.get(gameTimer), gameplayTimeX, gameplayTimeY, this);
			g.drawImage(timerImages.get(Model.Field.turnCounter), gameplayCounterX, gameplayCounterY, this);

			g.drawImage(hintImage, hintWordX, hintWordY, this);

			if(Model.Field.playerTurn == 1) {
				g.drawImage(playerTurnImages.get(0), frameWidth*30/100, turnWordY, this);
			}
			else {
				g.drawImage(playerTurnImages.get(1), frameWidth*30/100, turnWordY, this);
			}

			ecoBarPixels1 = (Model.EcoBar.calcEnemyEcoPoints() * ecoBarHeight) * 1/20;
			ecoBarPixels2 = (Model.EcoBar.calcMyEcoPoints() * ecoBarHeight) * 1/20;

			onFieldID1 = (Model.Card.getCardNameID(Player.getCardFromPlayerField(0)));
			onFieldID2 = (Model.Card.getCardNameID(Player.getCardFromPlayerField(1)));
			onFieldID3 = (Model.Card.getCardNameID(Player.getCardFromPlayerField(2)));
			onFieldID4 = (Model.Card.getCardNameID(Player.getCardFromPlayerField(3)));
			onFieldID5 = (Model.Card.getCardNameID(Player.getCardFromPlayerField(4)));

			g.setColor(Color.MAGENTA);

			if(Model.Player.getCardFromPlayerField(0).specialAvailable == true && Model.Player.getCardFromPlayerField(0).cardNameID != 0) {
				g.fillRect(fieldSlot1x - specAbilityIndicX, fieldSlot135y - specAbilityIndicY, specAbilityIndicW, specAbilityIndicH); 
			}
			if(Model.Player.getCardFromPlayerField(1).specialAvailable == true && Model.Player.getCardFromPlayerField(1).cardNameID != 0) { 
				g.fillRect(fieldSlot2x - specAbilityIndicX, fieldSlot24y - specAbilityIndicY, specAbilityIndicW, specAbilityIndicH); 
			}
			if(Model.Player.getCardFromPlayerField(2).specialAvailable == true && Model.Player.getCardFromPlayerField(2).cardNameID != 0) { 
				g.fillRect(fieldSlot3x - specAbilityIndicX, fieldSlot135y - specAbilityIndicY, specAbilityIndicW, specAbilityIndicH); 
			}
			if(Model.Player.getCardFromPlayerField(3).specialAvailable == true && Model.Player.getCardFromPlayerField(3).cardNameID != 0) { 
				g.fillRect(fieldSlot4x - specAbilityIndicX, fieldSlot24y - specAbilityIndicY, specAbilityIndicW, specAbilityIndicH); 
			}
			if(Model.Player.getCardFromPlayerField(4).specialAvailable == true && Model.Player.getCardFromPlayerField(4).cardNameID != 0) { 
				g.fillRect(fieldSlot5x - specAbilityIndicX, fieldSlot135y - specAbilityIndicY, specAbilityIndicW, specAbilityIndicH); 
			}
			if(Model.Player.getCardFromEnemyField(0).specialAvailable == true && Model.Player.getCardFromEnemyField(0).cardNameID != 0) { 
				g.fillRect(fieldSlot6x - specAbilityIndicX, fieldSlot6810y - specAbilityIndicY, specAbilityIndicW, specAbilityIndicH); 
			}
			if(Model.Player.getCardFromEnemyField(1).specialAvailable == true && Model.Player.getCardFromEnemyField(1).cardNameID != 0) { 
				g.fillRect(fieldSlot7x - specAbilityIndicX, fieldSlot79y - specAbilityIndicY, specAbilityIndicW, specAbilityIndicH); 
			}
			if(Model.Player.getCardFromEnemyField(2).specialAvailable == true && Model.Player.getCardFromEnemyField(2).cardNameID != 0) { 
				g.fillRect(fieldSlot8x - specAbilityIndicX, fieldSlot6810y - specAbilityIndicY, specAbilityIndicW, specAbilityIndicH); 
			}
			if(Model.Player.getCardFromEnemyField(3).specialAvailable == true && Model.Player.getCardFromEnemyField(3).cardNameID != 0) { 
				g.fillRect(fieldSlot9x - specAbilityIndicX, fieldSlot79y - specAbilityIndicY, specAbilityIndicW, specAbilityIndicH); 
			}
			if(Model.Player.getCardFromEnemyField(4).specialAvailable == true && Model.Player.getCardFromEnemyField(4).cardNameID != 0) { 
				g.fillRect(fieldSlot10x - specAbilityIndicX, fieldSlot6810y - specAbilityIndicY, specAbilityIndicW, specAbilityIndicH); 
			}

			g.drawImage(cardImages.get(onFieldID1), fieldSlot1x, fieldSlot135y, this);
			g.drawImage(cardImages.get(onFieldID2), fieldSlot2x, fieldSlot24y, this);
			g.drawImage(cardImages.get(onFieldID3), fieldSlot3x, fieldSlot135y, this);
			g.drawImage(cardImages.get(onFieldID4), fieldSlot4x, fieldSlot24y, this);
			g.drawImage(cardImages.get(onFieldID5), fieldSlot5x, fieldSlot135y, this);

			onFieldID6 = (Model.Card.getCardNameID(Player.getCardFromEnemyField(0)));
			onFieldID7 = (Model.Card.getCardNameID(Player.getCardFromEnemyField(1)));
			onFieldID8 = (Model.Card.getCardNameID(Player.getCardFromEnemyField(2)));
			onFieldID9 = (Model.Card.getCardNameID(Player.getCardFromEnemyField(3)));
			onFieldID10 = (Model.Card.getCardNameID(Player.getCardFromEnemyField(4)));

			g.drawImage(cardImages.get(onFieldID6), fieldSlot6x, fieldSlot6810y, this);
			g.drawImage(cardImages.get(onFieldID7), fieldSlot7x, fieldSlot79y, this);
			g.drawImage(cardImages.get(onFieldID8), fieldSlot8x, fieldSlot6810y, this);
			g.drawImage(cardImages.get(onFieldID9), fieldSlot9x, fieldSlot79y, this);
			g.drawImage(cardImages.get(onFieldID10), fieldSlot10x, fieldSlot6810y, this);
			
			inHandID1 = Model.Player.myHand.get(0).cardNameID;
			inHandID2 = (Model.Card.getCardNameID(Model.Player.getCardFromPlayerHand(1)));
			inHandID3 = (Model.Card.getCardNameID(Model.Player.getCardFromPlayerHand(2)));
			inHandID4 = (Model.Card.getCardNameID(Model.Player.getCardFromPlayerHand(3)));
			inHandID5 = (Model.Card.getCardNameID(Model.Player.getCardFromPlayerHand(4)));

			g.drawImage(cardImages.get(inHandID1), handSlotx, handSlot1y, this);
			g.drawImage(cardImages.get(inHandID2), handSlotx, handSlot2y, this);
			g.drawImage(cardImages.get(inHandID3), handSlotx, handSlot3y, this);
			g.drawImage(cardImages.get(inHandID4), handSlotx, handSlot4y, this);
			g.drawImage(cardImages.get(inHandID5), handSlotx, handSlot5y, this);

			g.drawImage(emptyEcoBarImage, ecoBar1x, ecoBar1y, this);
			g.drawImage(emptyEcoBarImage, ecoBar2x, ecoBar2y, this);

			g.setColor(Color.YELLOW);
			g.fillRect(ecoBar1x, (ecoBar1y + ecoBarHeight - ecoBarPixels1), ecoBarFilledWidth, ecoBarPixels1);
			g.fillRect(ecoBar2x, (ecoBar2y + ecoBarHeight - ecoBarPixels2), ecoBarFilledWidth, ecoBarPixels2);
			
			g.drawImage(pointsImages.get(Model.EcoBar.enemyEcoPoints), ecoBar1x - (pointsImages.get(0).getWidth()*1/5), ecoBar1y + ecoBarHeight*1/2 - (pointsImages.get(0).getWidth()*1/2), this);
			g.drawImage(pointsImages.get(Model.EcoBar.myEcoPoints), ecoBar2x - (pointsImages.get(0).getWidth()*1/5), ecoBar2y + ecoBarHeight*1/2 - (pointsImages.get(0).getWidth()*1/2), this);

			if(MouseListener.helpMessage != 5 && helpMessageTimeStart <= helpMessageTimeEnd) {
				switch(MouseListener.helpMessage) {
				case 0: g.drawImage(helpMessages.get(0), helpMessageX, helpMessageY, this); break;
				case 1: g.drawImage(helpMessages.get(1), helpMessageX, helpMessageY, this); break;
				case 2: g.drawImage(helpMessages.get(2), helpMessageX, helpMessageY, this); break;
				}
				helpMessageTimeStart++;
			}
			else {
				MouseListener.helpMessage = 5;
			}

			if(specialAnimation && specialAnimationTimeStart <= specialAnimationTimeEnd) {
				Animations.drawAnimations(g);
			}
			else {
				animationDone = true;
				specialAnimation = false;
				SpecialAbilities.currentAnimations.clear();
			}

			if(MouseListener.currentlySpecAbility) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(targetingLine);
				g2.setColor(Color.RED);
				switch(MouseListener.cardActivatedPosition) {
				case 1: g2.drawLine(fieldSlot1x + cardWidth*3/7, fieldSlot135y + cardHeight*1/2, mouseX, mouseY); break;
				case 2: g2.drawLine(fieldSlot2x + cardWidth*3/7, fieldSlot24y + cardHeight*1/2, mouseX, mouseY); break;
				case 3: g2.drawLine(fieldSlot3x + cardWidth*3/7, fieldSlot135y + cardHeight*1/2, mouseX, mouseY); break;
				case 4: g2.drawLine(fieldSlot4x + cardWidth*3/7, fieldSlot24y + cardHeight*1/2, mouseX, mouseY); break;
				case 5: g2.drawLine(fieldSlot5x + cardWidth*3/7, fieldSlot135y + cardHeight*1/2, mouseX, mouseY); break;
				case 6: g2.drawLine(fieldSlot6x + cardWidth*3/7, fieldSlot6810y + cardHeight*1/2, mouseX, mouseY); break;
				case 7: g2.drawLine(fieldSlot7x + cardWidth*3/7, fieldSlot79y + cardHeight*1/2, mouseX, mouseY); break;
				case 8: g2.drawLine(fieldSlot8x + cardWidth*3/7, fieldSlot6810y + cardHeight*1/2, mouseX, mouseY); break;
				case 9: g2.drawLine(fieldSlot9x + cardWidth*3/7, fieldSlot79y + cardHeight*1/2, mouseX, mouseY); break;
				case 10: g2.drawLine(fieldSlot10x + cardWidth*3/7, fieldSlot6810y + cardHeight*1/2, mouseX, mouseY); break;
				}
				g2.setStroke(new BasicStroke(5));
				g2.drawOval(mouseX-25, mouseY-25, 50, 50);
			}
			
			if(hintBox.contains(mouseX, mouseY)) {
				g.drawImage(hintImages.get(Field.currentHintID), frameWidth*1/2-(hintImages.get(0).getWidth()*1/2), frameHeight*1/2-(hintImages.get(0).getHeight()*1/2), this);
			}
			
			g.drawImage(draggedCardImage, mouseX-(cardWidth*1/2), mouseY-(cardHeight*1/2), this);
		}
	}

	// constructor for the View
	public MainView() {
		emptyEcoBarImage = createEcoBarImage();
		startScreenImage = createStartScreenImage();
		fenceImage = createFenceImage();
		timeImage = createTimeImage();
		turnCounterImage = createTurnImage();
		grassImage = createGrassImage();
		cursorImage = createCursor();
		endTurnImage = createEndTurnImage();
		tutorialImage1 = createTutorialImage1();
		tutorialImage2 = createTutorialImage2();
		tutorialImage3 = createTutorialImage3();
		tutorialImage4 = createTutorialImage4();
		hintImage = createHintImage();
		seedMarket = createSeedMarketImage();

		populateCardImages();
		populateTimerImages();
		populateQuizImages();
		populateHelpMessages();
		populateDeckImages();
		populateGameOverImages();
		populatePlayerTurnImages();
		populateResultImages();
		populateHintImages();
		populateDeckDescs();
		populateDeckChooseImages();
		populatePointsImages();
		Animations.populateAnimations();

		deckWidth = deckImages.get(0).getWidth();
		deckHeight = deckImages.get(0).getHeight();
		deckSlot1x = ((frameWidth * 20/120)-(deckWidth*1/2));
		deckSlot2x = ((frameWidth * 60/120)-(deckWidth*1/2));
		deckSlot3x = ((frameWidth * 100/120)-(deckWidth*1/2));
		hintBox = new Rectangle(hintWordX, hintWordY, hintImage.getWidth(), hintImage.getHeight());
	}

	// set-up for the JFrame
	private static JFrame buildFrame() {
		frame.setTitle("Yard Wars");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new MainView());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);

		frame.addKeyListener(new EscapeKeyListener());
		frame.addMouseListener(new MouseListener());

		Cursor mycursor;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Point hotspot = new Point(0, 0);
		mycursor = toolkit.createCustomCursor(cursorImage, hotspot, "cursor");
		frame.setCursor(mycursor);

		return frame;
	}

	public static void wait(int n) {
		long t0, t1;
		t0 = System.currentTimeMillis();
		do {
			t1 = System.currentTimeMillis();
		} while ((t1 - t0) < n);
	}

	// runs the program
	public static void main(String[] args) {

		final JFrame frame = buildFrame();

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(Model.Field.gamePhase == 1) {
					if(time % 100 == 0) {
						gameTimer--;
						if(gameTimer == -1 && animationDone) {
							Model.Field.endTurn();
						}
					}
					if(Field.playerTurn == 1) {
						if((Controller.MouseListener.p1.cardAvailThisTurn == false) && (Controller.MouseListener.p1.specialAvailableThisTurn == false) && animationDone) {
							Model.Field.endTurn();
						}
						Model.Field.currPlayer = Controller.MouseListener.p1;
					}
					else {
						if((Controller.MouseListener.p2.cardAvailThisTurn == false) && (Controller.MouseListener.p2.specialAvailableThisTurn == false) && animationDone) {
							Model.Field.endTurn();
						}
						Model.Field.currPlayer = Controller.MouseListener.p2;
					}
					EcoBar.myEcoPoints = EcoBar.calcMyEcoPoints();
					EcoBar.enemyEcoPoints = EcoBar.calcEnemyEcoPoints();
				}
				frame.repaint();
				time++;
			}
		};

		Timer timer = new Timer(10, taskPerformer);
		timer.setRepeats(true);
		timer.start();

	}

	// fills cardImages[]
	public static void populateCardImages(){
		for(int i = 0; i < 26; i++) {
			try {
				tempBufferedImage = ImageIO.read(new File("Images/Card_Images/" + i + ".png"));
				cardImages.add(getScaledImage(tempBufferedImage, cardWidth, cardHeight));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// fills deckImages[]
	public static void populateDeckImages() {
		for(int i = 1; i < 4; i++) {
			try {
				tempBufferedImage = ImageIO.read(new File("Images/Deck_Images/" + "deck_" + i + ".png"));
				deckImages.add(getScaledImage(tempBufferedImage, frameWidth*32/100, frameHeight*32/100));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// fills timerImages[]
	public static void populateTimerImages() {
		for(int i = 0; i < 21; i++) {
			try{
				tempBufferedImage = ImageIO.read(new File("Images/Time_Images/" + "timer_" + i + ".png"));
				timerImages.add(getScaledImage(tempBufferedImage, frameWidth * 1/14, frameHeight * 1/14));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//fills quizImages[]
	public static void populateQuizImages() {
		for(int i = 0; i < 16; i++) {
			try{
				tempBufferedImage = ImageIO.read(new File("Images/Quiz_Images/" + "quiz_" + i + ".png"));
				quizImages.add(getScaledImage(tempBufferedImage, frameWidth * 3/4, frameHeight * 3/4));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void populateResultImages() {
		try{
			tempBufferedImage = ImageIO.read(new File("Images/Misc_Images/" + "correct.png"));
			resultImages.add(getScaledImage(tempBufferedImage, frameWidth * 1/4, frameHeight * 1/4));
			tempBufferedImage = ImageIO.read(new File("Images/Misc_Images/" + "wrong.png"));
			resultImages.add(getScaledImage(tempBufferedImage, frameWidth * 1/4, frameHeight * 1/4));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void populateHelpMessages() {
		try{
			tempBufferedImage = ImageIO.read(new File("Images/Help_Messages/help_invasive.png"));
			helpMessages.add(tempBufferedImage);
			tempBufferedImage = ImageIO.read(new File("Images/Help_Messages/help_native.png"));
			helpMessages.add(tempBufferedImage);
			tempBufferedImage = ImageIO.read(new File("Images/Help_Messages/help_invalid.png"));
			helpMessages.add(tempBufferedImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage populateGameOverImages() {
		try{
			tempBufferedImage = ImageIO.read(new File("Images/Static_Screens/victoryscreen_player1.png"));
			gameOverImages.add(getScaledImage(tempBufferedImage, frameWidth, frameHeight));
			tempBufferedImage = ImageIO.read(new File("Images/Static_Screens/victoryscreen_player2.png"));
			gameOverImages.add(getScaledImage(tempBufferedImage, frameWidth, frameHeight));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedImage populatePlayerTurnImages() {
		try{
			tempBufferedImage = ImageIO.read(new File("Images/Misc_Images/player_1.png"));
			playerTurnImages.add(getScaledImage(tempBufferedImage, frameWidth * 16/100, frameHeight * 16/100));
			tempBufferedImage = ImageIO.read(new File("Images/Misc_Images/player_2.png"));
			playerTurnImages.add(getScaledImage(tempBufferedImage, frameWidth * 16/100, frameHeight * 16/100));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage populateHintImages() {
		try{
			for(int i = 0; i < 7; i++) {
				tempBufferedImage = ImageIO.read(new File("Images/Hint_Images/" + i + ".png"));
				hintImages.add(getScaledImage(tempBufferedImage, frameWidth * 24/100, frameHeight * 15/100));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage populateDeckDescs() {
		try{
			for(int i = 1; i < 4; i++) {
				tempBufferedImage = ImageIO.read(new File("Images/Deck_Images/deckdescr_" + i + ".png"));
				deckDescs.add(getScaledImage(tempBufferedImage, frameWidth, frameHeight));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage populateDeckChooseImages() {
		try{
			for(int i = 1; i < 3; i++) {
				tempBufferedImage = ImageIO.read(new File("Images/Deck_Images/choosePlayer_" + i + ".png"));
				deckChooseImages.add(getScaledImage(tempBufferedImage, frameWidth*100/100, frameHeight*1/2));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage populatePointsImages() {
		try{
			for(int i = 0; i < 21; i++) {
				tempBufferedImage = ImageIO.read(new File("Images/Time_Images/" + "timer_" + i + ".png"));
				pointsImages.add(getScaledImage(tempBufferedImage, frameWidth * 1/12, frameHeight * 1/12));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		return null;
	}

	public static BufferedImage createTimeImage() {
		try{
			tempBufferedImage = ImageIO.read(new File("Images/Time_Images/timer_timer.png"));
			return getScaledImage(tempBufferedImage, frameWidth * 1/12, frameHeight * 1/12);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedImage createCursor() {
		try{
			tempBufferedImage = ImageIO.read(new File("Images/Misc_Images/delta_arrow_cursor.png"));
			return getScaledImage(tempBufferedImage, frameWidth*5/100, frameHeight*5/100);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedImage createTurnImage() {
		try{
			tempBufferedImage = ImageIO.read(new File("Images/Time_Images/timer_turn.png"));
			return getScaledImage(tempBufferedImage, frameWidth * 1/12, frameHeight * 1/12);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BufferedImage createEcoBarImage() {
		try {
			tempBufferedImage = ImageIO.read(new File("Images/Misc_Images/empty_ecobar.png"));
			return getScaledImage(tempBufferedImage, ecoBarWidth, ecoBarHeight);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BufferedImage createStartScreenImage() {
		try {
			tempBufferedImage = ImageIO.read(new File("Images/Static_Screens/yardwars_startscreen.png"));
			return getScaledImage(tempBufferedImage, frameWidth, frameHeight);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BufferedImage createFenceImage() {
		try {
			tempBufferedImage = ImageIO.read(new File("Images/Static_Screens/fence.png"));
			return getScaledImage(tempBufferedImage, frameWidth*13/10, frameHeight *12/10);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BufferedImage createEndTurnImage() {
		try {
			tempBufferedImage = ImageIO.read(new File("Images/Misc_Images/end_turn.png"));
			return getScaledImage(tempBufferedImage, frameWidth*9/100, frameHeight*9/100);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BufferedImage createTutorialImage1() {
		try {
			tempBufferedImage = ImageIO.read(new File("Images/Static_Screens/tutorial_1.png"));
			return getScaledImage(tempBufferedImage, frameWidth, frameHeight);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BufferedImage createTutorialImage2() {
		try {
			tempBufferedImage = ImageIO.read(new File("Images/Static_Screens/tutorial_2.png"));
			return getScaledImage(tempBufferedImage, frameWidth, frameHeight);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BufferedImage createTutorialImage3() {
		try {
			tempBufferedImage = ImageIO.read(new File("Images/Static_Screens/tutorial_3.png"));
			return getScaledImage(tempBufferedImage, frameWidth, frameHeight);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BufferedImage createTutorialImage4() {
		try {
			tempBufferedImage = ImageIO.read(new File("Images/Static_Screens/tutorial_4.png"));
			return getScaledImage(tempBufferedImage, frameWidth, frameHeight);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BufferedImage createGrassImage() {
		try {
			tempBufferedImage = ImageIO.read(new File("Images/Static_Screens/grass_background.png"));
			return getScaledImage(tempBufferedImage, frameWidth, frameHeight);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BufferedImage createHintImage() {
		try {
			tempBufferedImage = ImageIO.read(new File("Images/Misc_Images/hint.png"));
			return getScaledImage(tempBufferedImage, frameWidth*1/12, frameHeight*1/12);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private BufferedImage createSeedMarketImage() {
		try {
			tempBufferedImage = ImageIO.read(new File("Images/Static_Screens/BobsSeeds.png"));
			return getScaledImage(tempBufferedImage, frameWidth, frameHeight);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Resizes a BufferedImage
	public static BufferedImage getScaledImage(BufferedImage src, int w, int h){
		int finalw = w;
		int finalh = h;
		double factor = 1.0d;
		if(src.getWidth() > src.getHeight()){
			factor = ((double)src.getHeight()/(double)src.getWidth());
			finalh = (int)(finalw * factor);                
		} 
		else {
			factor = ((double)src.getWidth()/(double)src.getHeight());
			finalw = (int)(finalh * factor);
		}   

		BufferedImage resizedImg = new BufferedImage(finalw, finalh, BufferedImage.TRANSLUCENT);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(src, 0, 0, finalw, finalh, null);
		g2.dispose();
		return resizedImg;
	}
}
