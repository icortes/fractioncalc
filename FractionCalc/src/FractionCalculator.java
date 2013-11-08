import java.util.Scanner;

public class FractionCalculator {

	public static void main(String[] args) {
		int[] firstHalf = new int[2];
		int[] secondHalf = new int[2];
		int[] answer = new int[2];
		String in = inputFromUser();
		while (!in.equalsIgnoreCase("quit")) {
			String operator = findOperator(in.trim());
			firstHalf = setFraction(in.substring(0, in.indexOf(operator))
					.trim(), firstHalf);
			secondHalf = setFraction(in.substring(in.indexOf(operator) + 1)
					.trim(), secondHalf);
			answer = handleOperation(operator, firstHalf, secondHalf);
			int wholeNum = 0;
			if (answer[1] == -1)
				System.out.print(answer[0]);
			else if (answer[0] > answer[1]) {
				wholeNum = answer[0] / answer[1];
				answer[0] = answer[0] % answer[1];
				if (answer[0] == 0)
					System.out.println(wholeNum);
				else
					System.out.println(wholeNum + "_" + answer[0] + "/"
							+ answer[1]);
			} else if (answer[0] == 0)
				System.out.println("0");
			else if (answer[0] > 0) {
				String fracString = answer[0] + "/" + answer[1];
				answer = setToArray(fracString.substring(1), answer);
				
			}

			else
				System.out.print(answer[0] + "/" + answer[1]);
			in = inputFromUser();
		}
	}

	public static String inputFromUser() {
		return new Scanner(System.in).nextLine();

	}

	public static int[] setFraction(String equ, int[] frac) {
		return setToArray(equ, frac);
	}

	public static int[] setToArray(String frac, int[] arr) {
		arr = setVars(frac);
		return arr;
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

	public static int findUnderscore(String in) {
		if (in.contains("_")) {
			return in.indexOf("_");
		}
		return in.indexOf("_");

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

	public static int[] handleOperation(String operator, int[] leftFraction,
			int[] rightFraction) {
		int[] answer = new int[2];
		if (operator.equals("+")) {
			if (leftFraction[1] == rightFraction[1]) {
				answer[0] = leftFraction[0] + rightFraction[0];
				answer[1] = leftFraction[1];
				answer = reduceFraction(answer);
				if (answer[0] == answer[1])
					answer[1] = -1;
			} else {
				leftFraction[0] *= getLCM(leftFraction[1], rightFraction[1]);
				leftFraction[1] *= getLCM(leftFraction[1], rightFraction[1]);
				rightFraction[0] *= getLCM(leftFraction[1], rightFraction[1]);
				rightFraction[1] *= getLCM(leftFraction[1], rightFraction[1]);
				answer[0] = leftFraction[0] + rightFraction[0];
				answer[1] = leftFraction[1];
				answer = reduceFraction(answer);
				if (answer[0] == answer[1])
					answer[1] = -1;
			}
		}
		if (operator.equals("-")) {
			if (leftFraction[1] == rightFraction[1]) {
				answer[0] = leftFraction[0] - rightFraction[0];
				answer[1] = leftFraction[1];
				answer = reduceFraction(answer);
				if (answer[0] == answer[1])
					answer[1] = -1;
			} else {
				leftFraction[0] *= getLCM(leftFraction[1], rightFraction[1]);
				leftFraction[1] *= getLCM(leftFraction[1], rightFraction[1]);
				rightFraction[0] *= getLCM(leftFraction[1], rightFraction[1]);
				rightFraction[1] *= getLCM(leftFraction[1], rightFraction[1]);
				answer[0] = leftFraction[0] - rightFraction[0];
				answer[1] = leftFraction[1];
				answer = reduceFraction(answer);
				if (answer[0] == answer[1])
					answer[1] = -1;
			}

		}
		return answer;

	}

	public static int[] reduceFraction(int[] fraction) {
		int gcd = getGCD(fraction[0], fraction[1]);
		fraction[0] /= gcd;
		fraction[1] /= gcd;
		return fraction;
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
