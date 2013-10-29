import java.util.Scanner;

public class FractionCalculator {
	public static int indexOfUnderscore = -1;
	public static int[] firstHalf = new int[3];
	public static int[] secondHalf = new int[3];
	public static void main(String[] args) {
		String in = inputFromUser();
		while (!in.equalsIgnoreCase("quit")) {
			separate(in);
//			for(int i : firstHalf)
//				System.out.println(i);
//			System.out.println(in);
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

	public static int[] setVars(String frac) {
		int numerator;
		int denominator;
		int wholeNum;
		int[] arr = new int[3];
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
			arr[0] = wholeNum;
			arr[1] = numerator;
			arr[2] = denominator;
		} else {
			wholeNum = 0;
			int indexOfSlash = frac.indexOf("/");
			String numeratorString = frac.substring(0, indexOfSlash).trim();
			String denominatorString = frac.substring(indexOfSlash + 1).trim();
			numerator = Integer.parseInt(numeratorString);
			denominator = Integer.parseInt(denominatorString);
			arr[0] = wholeNum;
			arr[1] = numerator;
			arr[2] = denominator;
		}
		return arr;
	}

	public static void separate(String equ) {
		String operator = null;
		if (equ.contains("+"))
			operator = "+";
		else if (equ.contains("-"))
			operator = "-";
		else if (equ.contains("*"))
			operator = "*";
		else if (equ.contains("%"))
			operator = "%";
		setFirstHalf(equ.substring(0, equ.indexOf(operator)));
		setSecondHalf(equ.substring(equ.indexOf(operator) + 1));
	}

	public static void setFirstHalf(String frac) {
		firstHalf = setVars(frac);
	}

	public static void setSecondHalf(String frac) {
		secondHalf = setVars(frac);
	}
	public static int addition(){
		int[] temp = new int[3];
		if(firstHalf[2] == secondHalf[2]){
			temp[2] = firstHalf[2] = secondHalf[2];
		}
		return 0;
		
	}
	public static void reduce(int[] arr){
		
	}
}
