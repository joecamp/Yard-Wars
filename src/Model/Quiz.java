package Model;

public class Quiz {

	public static boolean isRight(int quizID, int answer) {
		if(0 <= quizID && quizID < 16) {
			switch(quizID) {
			case 0: 
				if(answer == 0) return true;
				else return false;
			case 1: 
				if(answer == 2) return true;
				else return false;
			case 2:
				if(answer == 3) return true;
				else return false;
			case 3: 
				if(answer == 1) return true;
				else return false;
			case 4: 
				if(answer == 0) return true;
				else return false;
			case 5: 
				if(answer == 3) return true;
				else return false;
			case 6: 
				if(answer == 1) return true;
				else return false;
			case 7: 
				if(answer == 3) return true;
				else return false;
			case 8: 
				if(answer == 2) return true;
				else return false;
			case 9: 
				if(answer == 1) return true;
				else return false;
			case 10: 
				if(answer == 3) return true;
				else return false;
			case 11: 
				if(answer == 2) return true;
				else return false;
			case 12: 
				if(answer == 0) return true;
				else return false;
			case 13: 
				if(answer == 1) return true;
				else return false;
			case 14: 
				if(answer == 3) return true;
				else return false;
			case 15:
				if(answer == 2) return true;
				else return false;
			}
		}
		return false;
	}

}
