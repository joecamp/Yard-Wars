package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Cards.*;

public class SpecialAbilitiesTests {
	
	Model.Card testActivatedCard = new EmptyCard();
	Model.Card testTargetCard = new Sassafras();
	int ownCard = 1;
	int enemyCard = 6;
	Boolean testResult;

	@Test
	public void testCheckInferno(){
		testResult = Model.SpecialAbilities.checkInferno(testTargetCard, enemyCard);
		assertTrue(testResult);
		}
	
	@Test
	public void testCheckGrowth(){
		testResult = Model.SpecialAbilities.checkGrowth(testTargetCard, enemyCard);
		assertTrue(testResult);
		}
	
	@Test
	public void testCheckSweetScent(){
		testResult = Model.SpecialAbilities.checkSweetScent(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckDive(){
		testResult = Model.SpecialAbilities.checkInferno(testTargetCard, enemyCard);
		assertTrue(testResult);
		}
	
	@Test
	public void testCheckNoxious(){
		testResult = Model.SpecialAbilities.checkNoxious(testTargetCard, enemyCard);
		assertTrue(testResult);
		}
	
	@Test
	public void testCheckSafeHaven(){
		testResult = Model.SpecialAbilities.checkSafeHaven(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckSelfDestruct(){
		testResult = Model.SpecialAbilities.checkSelfDestruct(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckFastGrowing(){
		testResult = Model.SpecialAbilities.checkFastGrowing(testTargetCard, enemyCard);
		assertTrue(testResult);
		}
	
	@Test
	public void testCheckButterflyFood(){
		testResult = Model.SpecialAbilities.checkButterflyFood(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckMultiply(){
		testResult = Model.SpecialAbilities.checkMultiply(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckDroughtResilient(){
		testResult = Model.SpecialAbilities.checkDroughtResilient(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckAbsorbantRoots(){
		testResult = Model.SpecialAbilities.checkAbsorbantRoots(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckNaturalRemedy(){
		testResult = Model.SpecialAbilities.checkNaturalRemedy(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckRainGarden(){
		testResult = Model.SpecialAbilities.checkRainGarden(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckWeeding(){
		testResult = Model.SpecialAbilities.checkWeeding(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckTimber(){
		testResult = Model.SpecialAbilities.checkTimber(testTargetCard, enemyCard);
		assertTrue(testResult);
		}
	
	@Test
	public void testCheckGnaughtyGnome(){
		testResult = Model.SpecialAbilities.checkGnaughtyGnome(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckCopyCatGnome(){
		testResult = Model.SpecialAbilities.checkCopycatGnome(testTargetCard, enemyCard);
		assertTrue(testResult);
		}
	
	@Test
	public void testCheckGnosyGnome(){
		testResult = Model.SpecialAbilities.checkGnosyGnome(testTargetCard, enemyCard);
		assertTrue(testResult);
		}
	
	@Test
	public void testCheckPesticides(){
		testResult = Model.SpecialAbilities.checkPesticides(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckCompost(){
		testResult = Model.SpecialAbilities.checkCompost(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckOrnamental(){
		testResult = Model.SpecialAbilities.checkOrnamental(testTargetCard, enemyCard);
		assertTrue(testResult);
		}
	
	@Test
	public void testCheckInvadingRoots(){
		testResult = Model.SpecialAbilities.checkInvadingRoots(testTargetCard, enemyCard);
		assertFalse(testResult);
		}
	
	@Test
	public void testCheckOvergrowth(){
		testResult = Model.SpecialAbilities.checkOvergrowth(testTargetCard, enemyCard);
		assertTrue(testResult);
		}
	
	@Test
	public void testCheckFlood(){
		testResult = Model.SpecialAbilities.checkFlood(testTargetCard, enemyCard);
		assertTrue(testResult);
		}

}
