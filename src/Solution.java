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
				moveNorth(x, y, n, 0, terrain);
				break;
			case 's':
				moveSouth(x, y, n, 0, terrain);
				break;
			case 'e':
				moveEast(x, y, n, 0, terrain);
				break;
			case 'w':
				moveWest(x, y, n, 0, terrain);
				break;
			default:
				moveNorth(0,0, n, 0, terrain);
				break;
		}
	}

	private static void moveWest(int x, int y, int n, int time, int[][] terrain) {
		for(int j=y; j>=0; j--) {
			time++;
			terrain[x][j] = time;
		}

		if(time < n * n) {
			// The Snake is at (x,y) and moves East
			if(x == 0) {
				moveEast(x + 1, y, n, time, terrain);
			} else {
				moveEast(x - 1, y, n, time, terrain);
			}
		} else {
			show(terrain, n);
		}
	}

	private static void moveEast(int x, int y, int n, int time, int[][] terrain) {
		for(int j=y; j<n; j++) {
			time++;
			terrain[x][j] = time;
		}

		if(time < n * n) {
			// The snake is at (x,y) and moves West
			if(x == n-1) {
				moveWest(x - 1, y, n, time, terrain);
			} else {
				moveWest(x + 1, y, n, time, terrain);
			}
		} else {
			show(terrain, n);
		}
	}

	private static void moveNorth(int x, int y, int n, int time, int[][] terrain) {
		for(int i=x; i>=0; i--) {
			time++;
			terrain[i][y] = time;
		}

		if(time < n * n) {
			//Start from (x,y) and go south
			if(y == 0) {
				moveSouth(x, y + 1, n, time, terrain);
			} else {
				moveSouth(x, y - 1, n, time, terrain);
			}
		} else {
			show(terrain, n);
		}
	}

	private static void moveSouth(int x, int y, int n, int time, int[][] terrain) {
		for(int i=0; i<n; i++) {
			time++;
			terrain[i][y] = time;
		}

		if(time < n * n) {
			//Start from (x,y) and go north
			if(y == 0) {
				moveNorth(n - 1, y + 1, n, time, terrain);
			} else {
				moveNorth(n - 1, y - 1, n, time, terrain);
			}
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