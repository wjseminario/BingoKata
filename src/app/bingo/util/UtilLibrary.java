package app.bingo.util;

import java.util.List;
import java.util.Random;

/**
 * Utilitary class.
 * @author wjsem
 *
 */
public class UtilLibrary {
	
	/**
	 * Utilitary method used to validate if a number is in a list
	 * @param inputList
	 * @param number
	 * @return boolean true if number is in list, false if the number is not in list
	 */
	@SuppressWarnings("rawtypes")
	public static boolean validateNumberInList(List inputList, Integer number) {
		if (!inputList.contains(number)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Utilitary method used to generate a number between a min and a max range
	 * @param min
	 * @param max
	 * @return Integer value
	 */
	public static Integer generateBingoNumber(Integer min, Integer max) {
		Random rn = new Random();
		return rn.nextInt(max - min + 1) + min;
	}
}
