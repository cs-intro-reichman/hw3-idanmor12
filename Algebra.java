// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
		System.out.println(div(-2,1));
	    // System.out.println(plus(2,3));   // 2 + 3
	    // System.out.println(minus(7,2));  // 7 - 2
   		// System.out.println(minus(2,7));  // 2 - 7
 		// System.out.println(times(3,4));  // 3 * 4
   		// System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		// System.out.println(pow(5,3));      // 5^3
   		// System.out.println(pow(3,5));      // 3^5
   		// System.out.println(div(12,3));   // 12 / 3    
   		// System.out.println(div(5,5));    // 5 / 5  
   		// System.out.println(div(1,3));   // 25 / 7
   		// System.out.println(mod(25,7));   // 25 % 7
   		// System.out.println(mod(120,6));  // 120 % 6    
   		// System.out.println(sqrt(36));
		// System.out.println(sqrt(263169));
   		// System.out.println(sqrt(76123));
	}  

	public static int absoluteValue(int x){
		int absVal = 0;
		while (x + absVal < 0  ){
			absVal++;
		}
		return absVal;
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 < 0) {
			x2 = absoluteValue(x2);
			for (int i = 0; i < x2; i++) {
				x1--;
			}
		} else {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 < 0) {
			x2 = absoluteValue(x2);
			for (int i = 0; i < x2; i++) {
				x1--;
			}
		} else {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		boolean isNegativeResult = (x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0);
		if (x1 < 0) {
			x1 = absoluteValue(x1);
		}
		if (x2 < 0) {
			x2 = absoluteValue(x2);
		}

		int newValue = x1;
		for (int i = 0; i < x2-1; i++) {
			newValue = plus(newValue, x1);
		}

		return isNegativeResult ? -newValue : newValue;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int newValue = x;
		for (int i = 0; i < n-1; i++) {
			newValue = times(newValue, x);
		}
		return newValue;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		boolean isNegativeResult = (x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0);
		boolean wasNumberFound = false;
		int counter = 1;
		int newNumber = 0;
		if (x1 < 0) {
			x1 = absoluteValue(x1);
		}
		if (x2 < 0) {
			x2 = absoluteValue(x2);
		}
		while (!wasNumberFound) {
			newNumber = times(x2, counter);
			if (newNumber == x1) {
				wasNumberFound = !wasNumberFound;
			} else if (newNumber > x1){
				counter--;
				wasNumberFound = !wasNumberFound;
			} else {
				counter++;
			}
		}
		return isNegativeResult ? -counter : counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int result = x1;
		while (result >= x2) {
			result -= x2;
		}
		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int newNumber = 0;
		int counter = 0;
		while (newNumber < x){
			newNumber = times(counter, counter);
			counter++;
		}
		if (newNumber == x){
			counter--;
			return counter;
		} else {
			return minus(counter, 2);
		}
	}	  	  
}