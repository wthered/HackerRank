import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String args[] ) throws Exception {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        ArrayList<Integer> chocolates = new ArrayList<>();
        for(int i=0; i<t; i++) {
        	int n = input.nextInt();
        	int min = 1024;
        	int max = 0;
        	int minIndex = n;
        	int maxIndex = 0;
        	int[] chocos = new int[n];
        	for(int c=0; c<n; c++) {
        		chocos[c] = input.nextInt();
        		if(chocos[c] < min) { min = chocos[c]; minIndex = c; }
        		if(chocos[c] > max) { max = chocos[c]; maxIndex = c; }
	        }
	        chocolates.add(share(chocos, minIndex, maxIndex));
        }
        input.close();

		for (Integer chocolate : chocolates) {
			System.out.println("She gave at " + chocolate + " rounds");
		}
	}

	private static int share(int[] choco, int minIndex, int maxIndex) {
		int iterations = 0;
		int give;
		int tmpMin;
		int tmpMax;
		while(choco[minIndex] != choco[maxIndex] && iterations < 1024) {
			tmpMin = choco[minIndex];
			tmpMax = choco[maxIndex];
			give = christy(tmpMin, tmpMax);
			for (int i = 0; i < choco.length; i++) {
				if (i != maxIndex) {
					choco[i] += give;
				}
				if(choco[i] > tmpMax) { maxIndex = i; tmpMax = choco[maxIndex]; }
			}
			System.out.println("Min = " + choco[minIndex] + "\tMax = " + choco[maxIndex] + "\tGive = " + give);
			show(choco);
			iterations++;
		}
		return iterations;
	}

	private static int christy(int min, int max) {
		if(max - min >= 5) { return 5; }
		if(max - min >= 2) { return 2; }
		return 1;
	}

	private static void show(int[] block) {
		for (int chocolate : block) {
			System.out.print(chocolate + "\t");
		}
	}
}