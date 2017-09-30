import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char d = in.next().charAt(0);
		int x = in.nextInt();
		int y = in.nextInt();
		in.close();
		int[][] terrain = new int[n][n];

		switch (d) {
			case 'n':
				moveNorth(x, y, n, 0, terrain, d);
				break;
			case 's':
				moveSouth(x, y, n, 0, terrain, d);
				break;
			case 'e':
				moveEast(x, y, n, 0, terrain, d);
				break;
			case 'w':
				moveWest(x, y, n, 0, terrain, d);
				break;
			default:
				moveNorth(0,0, n, 0, terrain, 'd');
				break;
		}
	}

	private static void moveWest(int x, int y, int n, int time, int[][] terrain, char wind) {
		for(int j=n-1; j>=0; j--) {
			time++;
			terrain[x][j] = time;
		}

		if(time < n * n) {
			// The Snake is at (x,y) and moves East
			moveEast(x+1, y, n, time, terrain, wind);
		} else {
			show(terrain, n);
		}
	}

	private static void moveEast(int x, int y, int n, int time, int[][] terrain, char wind) {
		for(int j=y; j<n; j++) {
			time++;
			terrain[x][j] = time;
		}

		if(time < n * n) {
			// The snake is at (x,y) and moves West
			moveWest(x+1, y, n, time, terrain, wind);
		} else {
			show(terrain, n);
		}
	}

	private static void moveNorth(int x, int y, int n, int time, int[][] terrain, char wind) {
		for(int i=n-1; i>=0; i--) {
			time++;
			terrain[i][y] = time;
		}

		if(time < n * n) {
			//Start from (x,y) and go south
			moveSouth(x,y+1, n, time, terrain, wind);
		} else {
			show(terrain, n);
		}
	}

	private static void moveSouth(int x, int y, int n, int time, int[][] terrain, char wind) {
		for(int i=0; i<n; i++) {
			time++;
			terrain[i][y] = time;
		}

		if(time < n * n) {
			//Start from (x,y) and go north
			moveNorth(x,y+1, n, time, terrain, wind);
		} else {
			show(terrain, n);
		}
	}

	private static void show(int[][] terrain, int size) {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(terrain[i][j] + "\t");
			}
			System.out.println();
		}
	}
}