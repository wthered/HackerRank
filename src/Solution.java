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
			show(terrain, n);
			System.out.println("[West] Moving from (" + x + ",0) at time " + time);
			// The Snake is at (x,y) and moves East
			if(x == 0) {
				moveEast(1, 0, n, time, terrain);
			} else {
				moveEast(n - 2, 0, n, time, terrain);
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
			show(terrain, n);
			System.out.println("[East] Moving from (" + x + "," + y + ") at time " + time);
			// The snake is at (x,y) and moves West
			if(x == 0) {
				moveWest(1, n-1, n, time, terrain);
			} else {
				moveWest(n-2, n-1, n, time, terrain);
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
			show(terrain, n);
			System.out.println("[North] Moving from (" + x + "," + y + ") at time " + time);
			//Start from (x,y) and go south
			if(y == 0) {
				moveSouth(0,1, n, time, terrain);
			} else {
				if(terrain[0][y+1] == 0) {
					moveSouth(0, y + 1, n, time, terrain);
				} else {
					moveSouth(0, y - 1, n, time, terrain);
				}
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
			show(terrain, n);
			System.out.println("[South] Moving from (" + x + "," + y + ") at time " + time);
			//Start from (x,y) and go north
			if(y == 0) {
				moveNorth(n - 1, 1, n, time, terrain);
			} else {
				if(terrain[n-1][y-1] == 0) {
					moveNorth(n - 1, y - 1, n, time, terrain);
				} else {
					moveNorth(n - 1, y + 1, n, time, terrain);
				}
			}
		} else {
			show(terrain, n);
		}
	}

	private static void show(int[][] terrain, int size) {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print("(" + i + "," + j + ",");
				if(terrain[i][j] < 10) {
					System.out.print("0");
				}
				System.out.print(terrain[i][j] + ")\t");
			}
			System.out.println();
		}
	}
}