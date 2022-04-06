package app.bingo.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.bingo.util.UtilLibrary;

/***
 * Class to manage the bingo cards
 * @author wjsem
 *
 */
public class CardManager {
	
	/**
	 * Method to generate a bingo card. It will create 5 numbers per column (Columns: B, I, N, G, O).
	 * @return Map
	 */
	public static Map<String, Integer> cardGenerator() {
		Map<String, Integer> bingoCard = new HashMap<String, Integer>();
		generateColumnLetterNumbers(bingoCard, "B", 1, 15);
		generateColumnLetterNumbers(bingoCard, "I", 16, 30);
		generateColumnLetterNumbers(bingoCard, "N", 31, 45);
		generateColumnLetterNumbers(bingoCard, "G", 46, 60);
		generateColumnLetterNumbers(bingoCard, "O", 61, 75);
		return bingoCard;
	}

	/**
	 * Private method used to generate the numbers per column from the bingo card. 
	 * @param bingoCard
	 * @param column
	 * @param min
	 * @param max
	 */
	private static void generateColumnLetterNumbers(Map<String, Integer> bingoCard, String column, Integer min, Integer max) {
		List<Integer> numbersForColumn = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			boolean isNumberInList;
			do {
				Integer numberGenerated = UtilLibrary.generateBingoNumber(min, max);
				System.out.println("Number generated: " + numberGenerated);
				isNumberInList = UtilLibrary.validateNumberInList(numbersForColumn, numberGenerated);
				if(!isNumberInList) {
					numbersForColumn.add(numberGenerated);
					bingoCard.put(column, numberGenerated);
				}
			} while (isNumberInList);
		}
	}
	
	/**
	 * Method used to validate if a player has won the bingo game. It needs the list of numbers and the bingo card to validate it.
	 * @param bingoNumbersPlayed
	 * @param bingoCard
	 * @return true or false
	 */
	public static boolean checkIfPlayerCardWon(List<Integer> bingoNumbersPlayed, Map<String, Integer> bingoCard) {
		List<Integer> cardNumbers = new ArrayList<>((bingoCard).values());
		if(bingoNumbersPlayed.containsAll(cardNumbers)) {
			System.out.println("Congratulations, you won the Bingo");
			return true;
		} else {
			System.out.println("Sorry but you are missing some numbers still");
			return false;
		}
		
	}
	
}
