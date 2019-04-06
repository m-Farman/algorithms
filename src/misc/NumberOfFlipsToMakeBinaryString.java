package misc;

//https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/
public class NumberOfFlipsToMakeBinaryString {

	public static void main(String[] args) {
		String str = "0001010111";

		int output = Math.min(find(str, '0'), find(str, '1'));

		System.out.println("Min number of flip required is/are : " + output);
	}

	private static int find(String str, char expected) {

		int min = 0;
		char zero = '0', one = '1';
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) != expected) {
				min++;
			}

			expected = expected == zero ? one : zero;

		}

		return min;
	}
}


/*output
 * 
 Min number of flip required is/are : 2
 * */
 