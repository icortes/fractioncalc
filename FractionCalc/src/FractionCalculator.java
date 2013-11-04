import java.util.Scanner;

public class FractionCalculator {
	public static int[] firstHalf = new int[2];
	public static int[] secondHalf = new int[2];
	public static int[] answer = new int[2];

	public static void main(String[] args) {
		String in = inputFromUser();
		while (!in.equalsIgnoreCase("quit")) {
			separate(in);

			in = inputFromUser();
		}
	}

	public static String inputFromUser() {
		return new Scanner(System.in).nextLine();

	}

	public static int findUnderscore(String in) {
		if (in.contains("_")) {
			return in.indexOf("_");
		}
		return in.indexOf("_");

	}

	public static int[] setVars(String frac) {
		int numerator;
		int denominator;
		int wholeNum;
		int indexOfUnderscore = findUnderscore(frac);
		int[] arr = new int[2];
		if (indexOfUnderscore != -1) {
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
			arr[0] = numerator + (wholeNum * denominator);
			arr[1] = denominator;
		} else {
			wholeNum = 0;
			int indexOfSlash = frac.indexOf("/");
			String numeratorString = frac.substring(0, indexOfSlash).trim();
			String denominatorString = frac.substring(indexOfSlash + 1).trim();
			numerator = Integer.parseInt(numeratorString);
			denominator = Integer.parseInt(denominatorString);
			arr[0] = numerator + (wholeNum * denominator);
			arr[1] = denominator;
		}
		return arr;
	}

	public static void separate(String equ) {
		String operator = findOperator(equ);
		setFirstHalf(equ.substring(0, equ.indexOf(operator)));
		setSecondHalf(equ.substring(equ.indexOf(operator) + 1));
		if (operator == "+") {
			
		}
	}

	public static String findOperator(String in) {
		String operator = null;
		if (in.contains("+"))
			operator = "+";
		else if (in.contains("-"))
			operator = "-";
		else if (in.contains("*"))
			operator = "*";
		else if (in.contains("%"))
			operator = "%";
		return operator;
	}

	public static void setFirstHalf(String frac) {
		firstHalf = setVars(frac);
		for (int element : firstHalf)
			System.out.print(element + " ");
		System.out.println();
	}

	public static void setSecondHalf(String frac) {
		secondHalf = setVars(frac);
		for (int element : secondHalf)
			System.out.print(element + " ");
	}

	public static int getLCM(int a, int b) {
		for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
			if (i % a == 0 && i % b == 0) {
				return i;
			}
		}
		return a * b;
	}

	public static int getGCD(int num, int denom) {
		int gcd = 1;
		for (int i = 1; i <= denom; i++) {
			if (num % i == 0 && denom % i == 0 && i > gcd) {
				gcd = i;
			}
		}
		return gcd;
	}

}
