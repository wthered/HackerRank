import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int[] list = new int[n];
		for(int i = 0; i < n; i++){
			list[(i+n-d) % n] = in.nextInt();
		}
		in.close();

		for (int item : list) {
			System.out.print(item + "\t");
		}
	}
}