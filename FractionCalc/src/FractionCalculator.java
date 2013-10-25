import java.util.Scanner;

public class FractionCalculator {
	public static int[] fracOne = new int[3];
	public static int[] fracTwo = new int[3];
	public static String operator = null;
	public static int indexOfUnderscore = -1;
	public static int wholeNum = 0;
	public static int numerator = 0;
	public static int denominator = 1;

	public static void main(String[] args) {
		String in = inputFromUser();
		while (!in.equalsIgnoreCase("quit")) {

			System.out.println(in);
			in = inputFromUser();
		}
	}

	public static String inputFromUser() {
		return new Scanner(System.in).nextLine();

	}

	public static boolean findUnderscore(String in) {
		if (in.contains("_")) {
			indexOfUnderscore = in.indexOf("_");
			return true;
		}
		return false;

	}

	public static void setVars(String frac) {
		if (findUnderscore(frac)) {
			String wholeNumString = frac.substring(0, indexOfUnderscore).trim();
			wholeNum = Integer.parseInt(wholeNumString);
			String fractionString = frac.substring(indexOfUnderscore + 1)
					.trim();
			int indexOfSlash = fractionString.indexOf("/");
			String numeratorString = fractionString.substring(0, indexOfSlash)
					.trim();
			String denominatorString = fractionString.substring(
					indexOfSlash + 1).trim();
			numerator = Integer.parseInt(numeratorString);
			denominator = Integer.parseInt(denominatorString);
		} else {
			int indexOfSlash = frac.indexOf("/");
			String numeratorString = frac.substring(0, indexOfSlash).trim();
			String denominatorString = frac.substring(indexOfSlash + 1).trim();
			numerator = Integer.parseInt(numeratorString);
			denominator = Integer.parseInt(denominatorString);
		}

	}

	public static void separate(String equ) {
		if (equ.contains("+")) {
			operator = "+";
		} else if (equ.contains("-")) {
			operator = "-";
		} else if (equ.contains("*")) {
			operator = "*";
		} else if (equ.contains("%")) {
			operator = "%";
		}
		
	}
}
