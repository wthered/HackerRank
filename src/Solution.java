import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	private static void tripleRecursion(int n, int m, int k) {
		int[][] a = new int[n][n];
		a[0][0] = m;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i < j) { a[i][j] = a[i][j-1] - 1; }
				if(i == j && i>1 && j>1){ a[i][j] = a[i-1][j-1] + k; }
				if(i > j && i>1) { a[i][j] = a[i-1][j] - 1; }
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		tripleRecursion(n, m, k);
		in.close();
	}
}