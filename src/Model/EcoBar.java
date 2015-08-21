package Model;

public class EcoBar {

	static int minEcoPoints = 0;
	static int maxEcoPoints = 20;
	static int maxSoFar = 0;

	public static int myEcoPoints;
	public static int enemyEcoPoints;

	public static int calcMyEcoPoints() {
		int total = 0;
		for(int i = 0; i < 5; i++) {
			total = total + (Model.Player.getCardFromPlayerField(i).ecoPointValue);
		}
		if(maxSoFar < total) {
			maxSoFar = total;
		}
		if(total >= maxEcoPoints) {
			maxSoFar = maxEcoPoints;
			return maxEcoPoints;
		}
		else if(total <= minEcoPoints) {
			return minEcoPoints;
		}
		else return total;
	}

	public static int calcEnemyEcoPoints() {
		int total = 0;
		for(int i = 0; i < 5; i++) {
			total = total + (Model.Player.getCardFromEnemyField(i).ecoPointValue);
		}
		if(total >= maxEcoPoints) {
			return maxEcoPoints;
		}
		else if(total <= minEcoPoints) {
			return minEcoPoints;
		}
		else return total;
	}
}
