/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// // Tests the isAnagram function.
		// System.out.println(isAnagram("silent","listen"));  // true
		// System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		// System.out.println(isAnagram("Madam Curie","Radium came")); // true
		// System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		//System.out.println(preProcess("What? No way!!!"));
		
		// // Tests the randomAnagram function.
		//System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		//Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String word1 = preProcess(str1);
		String word2 = preProcess(str2);
		Character currChar;
		String letters = "abcdefghijklmnopqrstuvwxyz1234567890";

		for (int i = 0; i < letters.length(); i++) {
			currChar = letters.charAt(i);
			int counter1 = 0;
			int counter2 = 0;

			for (int j = 0; j < word1.length(); j++) {
				if (word1.charAt(j) == currChar) {
					counter1++;
				}
			} 
			for (int j = 0; j < word2.length(); j++) {
				if (word2.charAt(j) == currChar) {
					counter2++;
				}
			}
			if (counter1 != counter2) {
				return false;
			}
		}
		
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String lowerCased = str.toLowerCase();
		String letters = "abcdefghijklmnopqrstuvwxyz1234567890 ";
		String preProcessedWord = "";
		for (int i = 0; i < lowerCased.length(); i++) { 
			if (letters.indexOf(lowerCased.charAt(i)) != -1) {
				preProcessedWord = preProcessedWord + lowerCased.charAt(i);
			} 
		}

		return preProcessedWord;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String anagram = "";
		int randomCharIndex;
		str = preProcess(str);
		int length = str.length();
		for (int i = 0; i < length; i++) {
			randomCharIndex = (int) (Math.random() * str.length());
			anagram += str.charAt(randomCharIndex);
			str = str.substring(0, randomCharIndex) + str.substring(randomCharIndex + 1);
		}

		return anagram;
	}
}
