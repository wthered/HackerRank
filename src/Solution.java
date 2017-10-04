import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int many = input.nextInt();
		boolean[] results = new boolean[many];
		for(int i=0; i<many; i++) {
			int n = input.nextInt();
			int[] numbers = new int[n];
			for(int j=0; j<n; j++) {
				numbers[j] = input.nextInt();
			}
			int gcd = getGCD(numbers);
			results[i] = gcd >= 2 && exists(numbers, gcd);
		}
		input.close();

		for(boolean result : results) {
			System.out.println(result ? "NO" : "YES");
		}
	}

	private static boolean exists(int[] numbers, int gcd) {
		boolean present = false;
		for(int i=0; i < numbers.length; i++) {
			if(numbers[i] == gcd) {
				present = true;
				i = numbers.length;
			}
		}
		return present;
	}

	private static int getGCD(int[] numbers) {
		int q = numbers[0];
		int p = numbers[numbers.length - 1];
		while (q != 0) {
			int temp = q;
			q = p % q;
			p = temp;
		}
		return p;
	}
}