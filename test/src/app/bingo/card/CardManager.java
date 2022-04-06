package src.app.bingo.card;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import app.bingo.number.NumberManager;

public class CardManager {
	
	@Test
	public void testBingoWon() {
		NumberManager.startNewGame();
		for (int i = 0; i < 74; i++) {
			NumberManager.callBingoNumber();
		}
		List<Integer> bingoNumbers = NumberManager.getNumbers();
		Map<String, Integer> bingoCard = app.bingo.card.CardManager.cardGenerator();
		assertTrue(app.bingo.card.CardManager.checkIfPlayerCardWon(bingoNumbers, bingoCard));
	}
	
	@Test
	public void testBingoIfPlayerDidntWin() {
		NumberManager.startNewGame();
		for (int i = 0; i < 15; i++) {
			NumberManager.callBingoNumber();
		}
		List<Integer> bingoNumbers = NumberManager.getNumbers();
		Map<String, Integer> bingoCard = app.bingo.card.CardManager.cardGenerator();
		assertFalse(app.bingo.card.CardManager.checkIfPlayerCardWon(bingoNumbers, bingoCard));
	}

}
