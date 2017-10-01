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
				if(x == 0) {
					if(y == 0) {
//						System.out.println("Moving East from (" + x + "," + y + ")");
						moveEast(x, y, n, 0, terrain);
					} else {
//						System.out.println("Moving West from (" + x + "," + y + ")");
						moveWest(x, y, n, 0, terrain);
					}
				} else {
//					System.out.println("Moving North from (" + x + "," + y + ")");
					moveNorth(x, y, n, 0, terrain);
				}
				break;
			case 's':
				if(x == n - 1) {
					if(y == n - 1) {
//						System.out.println("Moving West from (" + x + "," + y + ")");
						moveWest(x, y, n, 0, terrain);
					} else {
//						System.out.println("Moving East from (" + x + "," + y + ")");
						moveEast(x, y, n, 0, terrain);
					}
				} else {
//					System.out.println("Moving South from (" + x + "," + y + ")");
					moveSouth(x, y, n, 0, terrain);
				}
				break;
			case 'e':
				if(y == n - 1) {
					if(x == n -1) {
						moveNorth(x, y, n, 0, terrain);
					} else {
						moveSouth(x, y, n, 0, terrain);
					}
				} else {
					if(y == 0) {
						moveEast(x, y, n, 0, terrain);
					} else {
						moveNorth(x, y, n, 0, terrain);
					}
				}
				break;
			case 'w':
				if(y == 0) {
					if(x == 0) {
						moveSouth(x, y, n, 0, terrain);
					} else {
						moveNorth(x, y, n, 0, terrain);
					}
				} else {
					if(x == 0) {
						moveWest(x, y, n, 0, terrain);
					} else {
						//System.out.println("Moving West from (" + x + "," + y + ")");
						moveWest(x, y, n, 0, terrain);
					}
				}
				break;
			default:
				moveEast(0,0, n, 0, terrain);
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
			if(x > 0 && terrain[x-1][0] == 0) {
				// North East
				moveEast(x - 1, 0, n, time, terrain);
			} else {
				// South East
				moveEast(x + 1, 0, n, time, terrain);
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
			if(x > 0 && terrain[x-1][n-1] == 0) {
				// North West
				moveWest(x - 1, n - 1, n, time, terrain);
			} else {
				// South West
				moveWest(x + 1, n - 1, n, time, terrain);
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
			// Start from (x,y) and go south
			if(y > 0 && terrain[0][y-1] == 0) {
				// South East ->
				moveSouth(0, y - 1, n, time, terrain);
			} else {
				// South West ->
				moveSouth(0, y + 1, n, time, terrain);
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
			if(y > 0 && terrain[n-1][y-1] == 0) {
				// North East
				moveNorth(n - 1, y - 1, n, time, terrain);
			} else {
				// North West <-
				moveNorth(n - 1, y + 1, n, time, terrain);
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