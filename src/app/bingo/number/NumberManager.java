package app.bingo.number;

import java.util.ArrayList;
import java.util.List;
import app.bingo.util.UtilLibrary;

/**
 * Class to manage the numbers from the bingo game
 * @author wjsem
 *
 */
public class NumberManager {
	
	final static Integer MAX = 75;
	final static Integer MIN = 1;
	static List<Integer> NUMBERS;

	/**
	 * Method used to retrieve the numbers list
	 * @return
	 */
	public static List<Integer> getNumbers() {
		return NUMBERS;
	}
	
	/**
	 * Method used to empty the numbers and start a new game
	 */
	public static void startNewGame() {
		NUMBERS = null;
	}
	
	/**
	 * Method used to callout the unique bingo number generated
	 */
	public static void callBingoNumber() {
		
		if(NUMBERS == null) {
			NUMBERS = new ArrayList<Integer>();
		}
		boolean isNumberInList;
		do {
			Integer numberGenerated = UtilLibrary.generateBingoNumber(MIN, MAX);
			System.out.println("Number generated: " + numberGenerated);
			isNumberInList = UtilLibrary.validateNumberInList(NUMBERS, numberGenerated);
			if(!isNumberInList) {
				System.out.println("Number generated: " + numberGenerated);
				NUMBERS.add(numberGenerated);
			}
		} while (isNumberInList);
		
		System.out.println("size: " + NUMBERS.size());
		
	}
	

}
