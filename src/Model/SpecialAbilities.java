package Model;

import java.util.ArrayList;
import java.util.Random;




import Cards.EmptyCard;
import Model.Card;

public class SpecialAbilities {

	public static ArrayList<SpecAbilityNode> currentAnimations = new ArrayList<SpecAbilityNode>();
	public static Card tempCard;
	public static Random generator = new Random();
	
	public static boolean checkSpecialAbility(Card activatedCard, Card targetedCard, int targetedCardPos) {
		boolean result = false;
		switch(Model.Card.getCardNameID(activatedCard)){
			case 1: result = checkInferno(targetedCard, targetedCardPos); break;
			case 2: result = checkGrowth(targetedCard, targetedCardPos); break;
			case 3: result = checkSweetScent(targetedCard, targetedCardPos); break;
			case 4: result = checkDive(targetedCard, targetedCardPos); break;
			case 5: result = checkNoxious(targetedCard, targetedCardPos); break;
			case 6: result = checkSafeHaven(targetedCard, targetedCardPos); break;
			case 7: result = checkSelfDestruct(targetedCard, targetedCardPos); break;
			case 8: result = checkFastGrowing(targetedCard, targetedCardPos); break;
			case 9: result = checkButterflyFood(targetedCard, targetedCardPos); break;
			case 10: result = checkMultiply(targetedCard, targetedCardPos); break;
			case 11: result = checkDroughtResilient(targetedCard, targetedCardPos); break;
			case 12: result = checkAbsorbantRoots(targetedCard, targetedCardPos); break;
			case 13: result = checkNaturalRemedy(targetedCard, targetedCardPos); break; 
			case 14: result = checkRainGarden(targetedCard, targetedCardPos); break;
			case 15: result = checkWeeding(targetedCard, targetedCardPos); break;
			case 16: result = checkTimber(targetedCard, targetedCardPos); break;
			case 17: result = checkGnaughtyGnome(targetedCard, targetedCardPos); break;
			case 18: result = checkCopycatGnome(targetedCard, targetedCardPos); break;
			case 19: result = checkGnosyGnome(targetedCard, targetedCardPos); break;
			case 20: result = checkPesticides(targetedCard, targetedCardPos); break;
			case 21: result = checkCompost(targetedCard, targetedCardPos); break;
			case 22: result = checkOrnamental(targetedCard, targetedCardPos); break;
			case 23: result = checkInvadingRoots(targetedCard, targetedCardPos); break;
			case 24: result = checkOvergrowth(targetedCard, targetedCardPos); break;
			case 25: result = checkFlood(targetedCard, targetedCardPos); break;
			case 26: result = false; break;
		}
		return result;
	}
	
	
	public static void activateSpecialAbility(Card activatedCard, int activatedCardPos, int targetedCardPos) {
		switch(Model.Card.getCardNameID(activatedCard)){
			case 1: inferno(activatedCardPos, targetedCardPos); break;
			case 2: growth(activatedCardPos, targetedCardPos); break;
			case 3: sweetScent(activatedCardPos, targetedCardPos); break;
			case 4: dive(activatedCardPos, targetedCardPos); break;
			case 5: noxious(activatedCardPos, targetedCardPos); break;
			case 6: safeHaven(activatedCardPos, targetedCardPos); break;
			case 7: selfDestruct(activatedCardPos, targetedCardPos); break;
			case 8: fastGrowing(activatedCardPos, targetedCardPos); break;
			case 9: butterflyFood(activatedCardPos, targetedCardPos); break;
			case 10: multiply(activatedCardPos, targetedCardPos); break;
			case 11: droughtResilient(activatedCardPos, targetedCardPos); break;
			case 12: absorbantRoots(activatedCardPos, targetedCardPos); break;
			case 13: naturalRemedy(activatedCardPos, targetedCardPos); break; 
			case 14: rainGarden(); break;
			case 15: weeding(targetedCardPos); break;
			case 16: timber(targetedCardPos); break;
			case 17: gnaughtyGnome(targetedCardPos); break;
			case 18: copycatGnome(); break;
			case 19: gnosyGnome(); break;
			case 20: pesticides(); break;
			case 21: compost(targetedCardPos); break;
			case 22: ornamental(activatedCardPos, targetedCardPos); break;
			case 23: invadingRoots(activatedCardPos, targetedCardPos); break;
			case 24: overgrowth(activatedCardPos, targetedCardPos); break;
			case 25: flood(); break;
			case 26: break;
			case 27: break;
		}
	}

	
	public static boolean checkInferno(Card targetedCard, int targetedCardPos) {
		if(targetedCard.cardType == 1 && targetedCardPos >= 6) {
			return true;
		}
		else return false;
	}
	
	public static void inferno(int activatedCardPos, int targetedCardPos) {
		if(Model.Player.getCardFromEnemyField(targetedCardPos - 6).shielded == false) {
			Model.Player.lastCardToDie = Model.Player.getCardFromEnemyField(targetedCardPos - 6);
			Model.Player.addToEnemyField(0, targetedCardPos - 6);
			Model.Player.getCardFromEnemyField(activatedCardPos - 6).specialAvailable = false;
			
			currentAnimations.add(new SpecAbilityNode(0, targetedCardPos));
			
			View.MainView.specialAnimation = true;
			View.MainView.specialAnimationTimeStart = View.MainView.time;
			View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
			View.MainView.animationDone = false;
		}
		else {
			Model.Player.getCardFromEnemyField(targetedCardPos - 6).shielded = false;
			Model.Player.getCardFromEnemyField(activatedCardPos - 6).specialAvailable = false;
			
			currentAnimations.add(new SpecAbilityNode(7, targetedCardPos));
			
			View.MainView.specialAnimation = true;
			View.MainView.specialAnimationTimeStart = View.MainView.time;
			View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
			View.MainView.animationDone = false;
		}
	}
	
	public static boolean checkGrowth(Card targetedCard, int targetedCardPos) {
		if(targetedCard.cardType == 1 && targetedCardPos >= 6) {
			return true;
		}
		else return false;
	}
	
	public static void growth(int activatedCardPos, int targetedCardPos) {	
		if(Model.Player.getCardFromEnemyField(targetedCardPos - 6).shielded == false) {
			Model.Player.getCardFromEnemyField(targetedCardPos - 6).ecoPointValue = 0;
			Model.Player.getCardFromEnemyField(activatedCardPos - 6).specialAvailable = false;
			
			currentAnimations.add(new SpecAbilityNode(6, targetedCardPos));
			
			View.MainView.specialAnimation = true;
			View.MainView.specialAnimationTimeStart = View.MainView.time;
			View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
			View.MainView.animationDone = false;
		}
		else {
			Model.Player.getCardFromEnemyField(targetedCardPos - 6).shielded = false;
			Model.Player.getCardFromEnemyField(activatedCardPos - 6).specialAvailable = false;
			
			currentAnimations.add(new SpecAbilityNode(7, targetedCardPos));
			
			View.MainView.specialAnimation = true;
			View.MainView.specialAnimationTimeStart = View.MainView.time;
			View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
			View.MainView.animationDone = false;
		}
	}
	
	public static boolean checkSweetScent(Card targetedCard, int targetedPos) {
		if(targetedCard.cardType == 1 && targetedPos <= 5) {
			return true;
		}
		else return false;
	}
	
 	public static void sweetScent(int activatedCardPos, int targetedCardPos) {
 		Model.Player.getCardFromPlayerField(targetedCardPos - 1).specialAvailable = true;
 		Model.Player.getCardFromPlayerField(activatedCardPos - 1).specialAvailable = false;
 		
 		currentAnimations.add(new SpecAbilityNode(5, targetedCardPos));
 		
 		View.MainView.specialAnimation = true;
		View.MainView.specialAnimationTimeStart = View.MainView.time;
		View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
	}
	
 	public static boolean checkDive(Card targetedCard, int targetedCardPos) {
 		if(targetedCard.cardType == 1 && targetedCardPos <= 5) {
			return true;
		}
 		else {
 			return false;
 		}
	}
 	
	public static void dive(int activatedCardPos, int targetedCardPos) {	
		Model.Player.getCardFromPlayerField(targetedCardPos - 1).shielded = true;
		Model.Player.getCardFromPlayerField(activatedCardPos - 1).specialAvailable = false;
		
		currentAnimations.add(new SpecAbilityNode(4, targetedCardPos));
		
		View.MainView.specialAnimation = true;
		View.MainView.specialAnimationTimeStart = View.MainView.time;
		View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
		View.MainView.animationDone = false;
	}
	
	public static boolean checkNoxious(Card targetedCard, int targetedCardPos) {
		if(targetedCard.cardType == 1 && targetedCardPos >= 6) {
			return true;
		}
		else return false;
	}
	
	public static void noxious(int activatedCardPos, int targetedCardPos) {	
		if(Model.Player.getCardFromEnemyField(targetedCardPos - 6).shielded == false) {
			Model.Player.lastCardToDie = Model.Player.getCardFromEnemyField(targetedCardPos - 6);
			Model.Player.addToEnemyField(0, targetedCardPos - 6);
			Model.Player.getCardFromEnemyField(activatedCardPos - 6).specialAvailable = false;
			
			currentAnimations.add(new SpecAbilityNode(1, targetedCardPos));
			
			View.MainView.specialAnimation = true;
			View.MainView.specialAnimationTimeStart = View.MainView.time;
			View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
			View.MainView.animationDone = false;
		}
		else {
			Model.Player.getCardFromEnemyField(targetedCardPos - 6).shielded = false;
			Model.Player.getCardFromEnemyField(activatedCardPos - 6).specialAvailable = false;
			
			currentAnimations.add(new SpecAbilityNode(7, targetedCardPos));
			
			View.MainView.specialAnimation = true;
			View.MainView.specialAnimationTimeStart = View.MainView.time;
			View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
			View.MainView.animationDone = false;
		}
	}
	
	public static boolean checkSafeHaven(Card targetedCard, int targetedCardPos) {
		if(targetedCard.cardType == 1 && targetedCardPos <= 5) {
			return true;
		}
		else return false;
	}
	
	public static void safeHaven(int activatedCardPos, int targetedCardPos) {	
		for(int i = 0; i < 5; i++) {
			if(Model.Player.getCardFromPlayerField(i).cardType == 1) {
				Model.Player.getCardFromPlayerField(i).ecoPointValue = 
						(Model.Player.getCardFromPlayerField(i).ecoPointValue + 1);
			}
			Model.Player.getCardFromPlayerField(activatedCardPos - 1).specialAvailable = false;
			
			currentAnimations.add(new SpecAbilityNode(5, 1));
			currentAnimations.add(new SpecAbilityNode(5, 2));
			currentAnimations.add(new SpecAbilityNode(5, 3));
			currentAnimations.add(new SpecAbilityNode(5, 4));
			currentAnimations.add(new SpecAbilityNode(5, 5));
			
			View.MainView.specialAnimation = true;
			View.MainView.specialAnimationTimeStart = View.MainView.time;
			View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
			View.MainView.animationDone = false;
		}
	}
	
	public static boolean checkSelfDestruct(Card targetedCard, int targetedCardPos) {
		if(targetedCard.cardNameID == 7 && targetedCardPos >= 6) {
			return true;
		}
		else return false;
	}
	
	public static void selfDestruct(int activatedCardPos, int targetedCardPos) {	
		Model.Player.addToEnemyField(27, targetedCardPos - 6);
	}
	
	public static boolean checkFastGrowing(Card targetedCard, int targetedCardPos) {
		if(targetedCard.cardType == 1 && targetedCardPos >= 6) {
			return true;
		}
		else return false;
	}
	
	public static void fastGrowing(int activatedCardPos, int targetedCardPos) {
		if(Model.Player.getCardFromEnemyField(targetedCardPos - 6).shielded == false) {
			Model.Player.addToEnemyField(8, targetedCardPos - 6);
			Model.Player.getCardFromEnemyField(activatedCardPos - 6).specialAvailable = false;
		}
		else {
			Model.Player.getCardFromEnemyField(targetedCardPos - 6).shielded = false;
			Model.Player.getCardFromEnemyField(activatedCardPos - 6).specialAvailable = false;
			
			currentAnimations.add(new SpecAbilityNode(7, targetedCardPos));
			
			View.MainView.specialAnimation = true;
			View.MainView.specialAnimationTimeStart = View.MainView.time;
			View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
			View.MainView.animationDone = false;
		}
	}
	
	public static boolean checkButterflyFood(Card targetedCard, int targetedCardPos) {
		if(targetedCard.cardType == 2 && targetedCardPos <= 5) {
			return true;
		}
		else return false;
	}
	
	public static void butterflyFood(int activatedCardPos, int targetedCardPos) {	
		Model.Player.addToPlayerField(0, targetedCardPos - 1);
		Model.Player.getCardFromPlayerField(activatedCardPos - 1).specialAvailable = false;
		
		currentAnimations.add(new SpecAbilityNode(3, targetedCardPos));
		
		View.MainView.specialAnimation = true;
		View.MainView.specialAnimationTimeStart = View.MainView.time;
		View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
		View.MainView.animationDone = false;
	}
	
	public static boolean checkMultiply(Card targetedCard, int targetedCardPos) {
		if(targetedCard.cardNameID == 0) {
			return true;
		}
		else return false;
	}
	
	public static void multiply(int activatedCardPos, int targetedCardPos) {
		if(targetedCardPos <= 5) {
			Model.Player.addToPlayerField(10, targetedCardPos - 1);
		}
		else {
			Model.Player.addToEnemyField(10, targetedCardPos - 6);
		}
		Model.Player.getCardFromPlayerField(activatedCardPos - 1).specialAvailable = false;
	}
	
	public static boolean checkDroughtResilient(Card targetedCard, int targetedCardPos) {
		if(targetedCard.cardNameID == 11 && targetedCardPos <= 5) {
			return true;
		}
		else return false;
	}
	
	public static void droughtResilient(int activatedCardPos, int targetedCardPos) {
		switch(activatedCardPos) {
		case 1: 
			if(Model.Player.getCardFromPlayerField(1).cardType == 1) {
				Model.Player.getCardFromPlayerField(1).floodShielded = true;
				currentAnimations.add(new SpecAbilityNode(4, 2));
			}
			break; 
		case 2: 
			if(Model.Player.getCardFromPlayerField(0).cardType == 1) {
				Model.Player.getCardFromPlayerField(0).floodShielded = true;
				currentAnimations.add(new SpecAbilityNode(4, 1));
			}
			if(Model.Player.getCardFromPlayerField(2).cardType == 1) {
				Model.Player.getCardFromPlayerField(2).floodShielded = true;
				currentAnimations.add(new SpecAbilityNode(4, 3));
			}
			break; 
		case 3:
			if(Model.Player.getCardFromPlayerField(1).cardType == 1) {
				Model.Player.getCardFromPlayerField(1).floodShielded = true;
				currentAnimations.add(new SpecAbilityNode(4, 2));
			}
			if(Model.Player.getCardFromPlayerField(3).cardType == 1) {
				Model.Player.getCardFromPlayerField(3).floodShielded = true;
				currentAnimations.add(new SpecAbilityNode(4, 4));
			}
			break; 
		case 4:
			if(Model.Player.getCardFromPlayerField(2).cardType == 1) {
				Model.Player.getCardFromPlayerField(2).floodShielded = true;
				currentAnimations.add(new SpecAbilityNode(4, 3));
			}
			if(Model.Player.getCardFromPlayerField(4).cardType == 1) {
				Model.Player.getCardFromPlayerField(4).floodShielded = true;
				currentAnimations.add(new SpecAbilityNode(4, 5));
			}
			break; 
		case 5:
			if(Model.Player.getCardFromPlayerField(3).cardType == 1) {
				Model.Player.getCardFromPlayerField(3).floodShielded = true;
				currentAnimations.add(new SpecAbilityNode(4, 4));
			}
			break; 
		}
		Model.Player.getCardFromPlayerField(activatedCardPos - 1).floodShielded = true;
		Model.Player.getCardFromPlayerField(activatedCardPos - 1).specialAvailable = false;
		currentAnimations.add(new SpecAbilityNode(4, activatedCardPos));
		
		View.MainView.specialAnimation = true;
		View.MainView.specialAnimationTimeStart = View.MainView.time;
		View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
		View.MainView.animationDone = false;
	}
	
	public static boolean checkAbsorbantRoots(Card targetedCard, int targetedCardPos) {
		if(targetedCard.cardNameID == 12 && targetedCardPos <= 5) {
			return true;
		}
		else return false;
	}
	
	public static void absorbantRoots(int activatedCardPos, int targetedCardPos) {	
		Model.Player.getCardFromPlayerField(activatedCardPos - 1).ecoPointValue = 
				Model.Player.getCardFromPlayerField(activatedCardPos - 1).ecoPointValue * 2;
		Model.Player.getCardFromPlayerField(activatedCardPos - 1).specialAvailable = false;
		
		currentAnimations.add(new SpecAbilityNode(5, targetedCardPos));
		
		View.MainView.specialAnimation = true;
		View.MainView.specialAnimationTimeStart = View.MainView.time;
		View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
		View.MainView.animationDone = false;
	}
	
	public static boolean checkNaturalRemedy(Card targetedCard, int targetedCardPos) {
		if((targetedCardPos < 6) && (targetedCard.cardNameID == 0)){
		return true;
		}
		else {
		return false;
		}
	}
	
	public static void naturalRemedy(int activatedCardPos, int targetedCardPos) {	
		Model.Player.addToPlayerField(Model.Player.lastCardToDie.cardNameID, targetedCardPos - 1);
		Model.Player.getCardFromPlayerField(targetedCardPos - 1).ecoPointValue = Model.Player.lastCardToDie.ecoPointValue;
		Model.Player.getCardFromPlayerField(activatedCardPos - 1).specialAvailable = false;
		Model.Player.lastCardToDie = new EmptyCard();
	}
	
	public static boolean checkRainGarden(Card targetedCard, int targetedCardPos) {
		if(targetedCardPos < 6) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void rainGarden() {
		if(Model.Player.getCardFromPlayerField(0).cardType == 1) {
			Model.Player.getCardFromPlayerField(0).floodShielded = true;
			currentAnimations.add(new SpecAbilityNode(4, 1));
		}
		if(Model.Player.getCardFromPlayerField(1).cardType == 1) {
			Model.Player.getCardFromPlayerField(1).floodShielded = true;
			currentAnimations.add(new SpecAbilityNode(4, 2));
		}
		if(Model.Player.getCardFromPlayerField(2).cardType == 1) {
			Model.Player.getCardFromPlayerField(2).floodShielded = true;
			currentAnimations.add(new SpecAbilityNode(4, 3));
		}
		if(Model.Player.getCardFromPlayerField(3).cardType == 1) {
			Model.Player.getCardFromPlayerField(3).floodShielded = true;
			currentAnimations.add(new SpecAbilityNode(4, 4));
		}
		if(Model.Player.getCardFromPlayerField(4).cardType == 1) {
			Model.Player.getCardFromPlayerField(4).floodShielded = true;
			currentAnimations.add(new SpecAbilityNode(4, 5));
		}
		
		View.MainView.specialAnimation = true;
		View.MainView.specialAnimationTimeStart = View.MainView.time;
		View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
		View.MainView.animationDone = false;
	}
	
	public static boolean checkWeeding(Card targetedCard, int targetedCardPos) {
		if((targetedCardPos < 6) && (!(targetedCard.tree)) && (targetedCard.cardType == 2)) {
			return true;
			}
		else {
			return false;
		}
	}
	
	
	public static void weeding(int targetedCardPos) {	
		System.out.println("Weeding card from position:" + targetedCardPos);
		Model.Player.addToPlayerField(0, targetedCardPos - 1);
	}
	
	public static boolean checkTimber(Card targetedCard, int targetedCardPos) {
		if(targetedCard.tree) {
			return true;
		}
	else {
		return false;
		}
	}
	
	public static void timber(int targetedCardPos) {	
		System.out.println("Cutting down tree from position:" + targetedCardPos);
		
		if(targetedCardPos < 6) {
			Model.Player.addToPlayerField(0, targetedCardPos - 1);
		}
		else {
			Model.Player.addToEnemyField(0, targetedCardPos - 6);
		}
	}
	
	public static boolean checkGnaughtyGnome(Card targetedCard, int targetedCardPos) {
		return false;
	}
	
	public static void gnaughtyGnome(int targetedCardPos) {
	 tempCard = Model.Player.getCardFromEnemyField(targetedCardPos-6);
//	 boolean findEmptySlot;
	 for(int i = 0; i < 5; i++){
		 if (Model.Player.getCardFromPlayerField(i).cardNameID == 0){
			 System.out.println("The old ecopoint value is:" + Model.Player.getCardFromPlayerField(i).ecoPointValue);
			 Model.Player.addToEnemyField(0, targetedCardPos -6);
			 Model.Player.addToPlayerField(tempCard.cardNameID, i);
			 Model.Player.getCardFromPlayerField(i).ecoPointValue = tempCard.ecoPointValue;
			 Model.Player.getCardFromPlayerField(i).floodShielded = tempCard.floodShielded;
			 Model.Player.getCardFromPlayerField(i).shielded = tempCard.shielded;
			 System.out.println("The new ecopoint value is:" + Model.Player.getCardFromPlayerField(i).ecoPointValue);
			 break;
		 }
	 }
	}
	
	public static boolean checkCopycatGnome(Card targetedCard, int targetedCardPos) {
		return true;
	}
	
	public static void copycatGnome() {	
	}
	
	public static boolean checkGnosyGnome(Card targetedCard, int targetedCardPos) {
		return true;
	}
	
	public static void gnosyGnome() {	
	}
	
	public static boolean checkPesticides(Card targetedCard, int targetedCardPos) {
		if(targetedCardPos < 6) {
			return true;
			}
		else {
			return false;
		}
	}
	
	public static void pesticides() {	
		for(int i = 0; i < 5; i++) {
			if(Model.Player.getCardFromPlayerField(i).cardType == 2) {
				currentAnimations.add(new SpecAbilityNode(1, i + 1));
				Model.Player.addToPlayerField(0, i);
				Model.EcoBar.myEcoPoints += (-1);
			}
		}
		
		View.MainView.specialAnimation = true;
		View.MainView.specialAnimationTimeStart = View.MainView.time;
		View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
		View.MainView.animationDone = false;
	}
	
	public static boolean checkCompost(Card targetedCard, int targetedCardPos) {
		if((targetedCardPos < 6) && (targetedCard.cardType == 2)) {
			return true;
			}
		else {
			return false;
		}
	}
	
	public static void compost(int targetedCardPos) {
		Model.Player.addToPlayerField(0, targetedCardPos - 1);
	}
	
	public static boolean checkOrnamental(Card targetedCard, int targetedCardPos) {
		return true;
	}
	
	public static void ornamental(int activatedCardPos, int targetedCardPos) {
	}
	
	public static boolean checkInvadingRoots(Card targetedCard, int targetedCardPos) {
		if(targetedCard.cardNameID == 23 && targetedCardPos >= 6) {
			return true;
		}
		else return false;
	}
	
	public static void invadingRoots(int activatedCardPos, int targetedCardPos) {
		switch(activatedCardPos) {
		case 6: 
			if(Model.Player.getCardFromEnemyField(1).cardType == 1 && Model.Player.getCardFromEnemyField(1).shielded == false) {
				Model.Player.lastCardToDie = Model.Player.getCardFromEnemyField(1);
				Model.Player.addToEnemyField(0, 1);
				currentAnimations.add(new SpecAbilityNode(6, 7));
			}
			break; 
		case 7: 
			if(Model.Player.getCardFromEnemyField(0).cardType == 1 && Model.Player.getCardFromEnemyField(0).shielded == false) {
				Model.Player.lastCardToDie = Model.Player.getCardFromEnemyField(0);
				Model.Player.addToEnemyField(0, 0);
				currentAnimations.add(new SpecAbilityNode(6, 6));
			}
			if(Model.Player.getCardFromEnemyField(2).cardType == 1 && Model.Player.getCardFromEnemyField(2).shielded == false) {
				Model.Player.lastCardToDie = Model.Player.getCardFromEnemyField(2);
				Model.Player.addToEnemyField(0, 2);
				currentAnimations.add(new SpecAbilityNode(6, 8));
			}
			break; 
		case 8:
			if(Model.Player.getCardFromEnemyField(1).cardType == 1 && Model.Player.getCardFromEnemyField(1).shielded == false) {
				Model.Player.lastCardToDie = Model.Player.getCardFromEnemyField(1);
				Model.Player.addToEnemyField(0, 1);
				currentAnimations.add(new SpecAbilityNode(6, 7));
			}
			if(Model.Player.getCardFromEnemyField(3).cardType == 1 && Model.Player.getCardFromEnemyField(3).shielded == false) {
				Model.Player.lastCardToDie = Model.Player.getCardFromEnemyField(3);
				Model.Player.addToEnemyField(0, 3);
				currentAnimations.add(new SpecAbilityNode(6, 9));
			}
			break; 
		case 9:
			if(Model.Player.getCardFromEnemyField(2).cardType == 1 && Model.Player.getCardFromEnemyField(2).shielded == false) {
				Model.Player.lastCardToDie = Model.Player.getCardFromEnemyField(2);
				Model.Player.addToEnemyField(0, 2);
				currentAnimations.add(new SpecAbilityNode(6, 8));
			}
			if(Model.Player.getCardFromEnemyField(4).cardType == 1 && Model.Player.getCardFromEnemyField(4).shielded == false) {
				Model.Player.lastCardToDie = Model.Player.getCardFromEnemyField(4);
				Model.Player.addToEnemyField(0, 4);
				currentAnimations.add(new SpecAbilityNode(6, 10));
			}
			break; 
		case 10:
			if(Model.Player.getCardFromEnemyField(3).cardType == 1 && Model.Player.getCardFromEnemyField(3).shielded == false) {
				Model.Player.lastCardToDie = Model.Player.getCardFromEnemyField(3);
				Model.Player.addToEnemyField(0, 3);
				currentAnimations.add(new SpecAbilityNode(6, 9));
			}
			break; 
		}
		Model.Player.getCardFromEnemyField(activatedCardPos - 6).specialAvailable = false;
		
		View.MainView.specialAnimation = true;
		View.MainView.specialAnimationTimeStart = View.MainView.time;
		View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
		View.MainView.animationDone = false;
	}
	
	public static boolean checkOvergrowth(Card targetedCard, int targetedCardPos) {
		if(targetedCard.cardType == 1 && targetedCardPos >= 6) {
			return true;
		}
		else return false;
	}
	
	public static void overgrowth(int activatedCardPos, int targetedCardPos) {	
		if(Model.Player.getCardFromEnemyField(targetedCardPos - 6).shielded == false) {
			Model.Player.addToEnemyField(24, targetedCardPos - 6);
			Model.Player.getCardFromEnemyField(activatedCardPos - 6).specialAvailable = false;
		}
		else {
			Model.Player.getCardFromEnemyField(targetedCardPos - 6).shielded = false;
			Model.Player.getCardFromEnemyField(activatedCardPos - 6).specialAvailable = false;
			
			currentAnimations.add(new SpecAbilityNode(7, targetedCardPos));
			
			View.MainView.specialAnimation = true;
			View.MainView.specialAnimationTimeStart = View.MainView.time;
			View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
			View.MainView.animationDone = false;
		}
	}
	
	public static boolean checkFlood(Card targetedCard, int targetedCardPos) {
		if(targetedCardPos < 11) {
		return true;
		}
		else {
		return false;
		}
	}
	
	public static void flood() {
		int RANDOMNUMBER = generator.nextInt(5);
		int tempNumber = RANDOMNUMBER;
		if(Model.Player.getCardFromPlayerField(RANDOMNUMBER).floodShielded) {
			currentAnimations.add(new SpecAbilityNode(7, RANDOMNUMBER + 1));
		} else if(Model.Player.getCardFromPlayerField(RANDOMNUMBER).cardNameID != 0) {
		Model.Player.addToPlayerField(0,RANDOMNUMBER);
		currentAnimations.add(new SpecAbilityNode(8, RANDOMNUMBER + 1));
		}
		while(tempNumber == RANDOMNUMBER){
			RANDOMNUMBER = generator.nextInt(5);
		};
		if(Model.Player.getCardFromPlayerField(RANDOMNUMBER).floodShielded) {
			currentAnimations.add(new SpecAbilityNode(7, RANDOMNUMBER + 1));

		} else if(Model.Player.getCardFromPlayerField(RANDOMNUMBER).cardNameID != 0) {
		Model.Player.addToPlayerField(0,RANDOMNUMBER);
		currentAnimations.add(new SpecAbilityNode(8, RANDOMNUMBER + 1));
		}
		RANDOMNUMBER = generator.nextInt(5);
		tempNumber = RANDOMNUMBER;
		if(Model.Player.getCardFromEnemyField(RANDOMNUMBER).floodShielded) {
			currentAnimations.add(new SpecAbilityNode(7, RANDOMNUMBER + 6));

		} else if(Model.Player.getCardFromEnemyField(RANDOMNUMBER).cardNameID != 0) {
		Model.Player.addToEnemyField(0,RANDOMNUMBER);
		currentAnimations.add(new SpecAbilityNode(8, RANDOMNUMBER + 6));
		}
		while(tempNumber == RANDOMNUMBER){
			RANDOMNUMBER = generator.nextInt(5);
		};
		if(Model.Player.getCardFromEnemyField(RANDOMNUMBER).floodShielded) {
			currentAnimations.add(new SpecAbilityNode(7, RANDOMNUMBER + 6));

		} else if(Model.Player.getCardFromEnemyField(RANDOMNUMBER).cardNameID != 0) {
		Model.Player.addToEnemyField(0,RANDOMNUMBER);
		currentAnimations.add(new SpecAbilityNode(8, RANDOMNUMBER + 6));
		}
		
		View.MainView.specialAnimation = true;
		View.MainView.specialAnimationTimeStart = View.MainView.time;
		View.MainView.specialAnimationTimeEnd = View.MainView.time + View.MainView.specialAnimationLength;
		View.MainView.animationDone = false;
	}

}