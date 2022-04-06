package app.bingo.number;

import java.util.Random;

public class NumberManager {
	
	public static void callBingoNumber() {
		final int max = 75;
		final int min = 1;
		Random rn = new Random();
		int answer = rn.nextInt(max - min + 1) + min;
		
		System.out.println("answer: " + answer);
	}

}
