package backend;

public class Grid implements iController {

	private int[][] grid;

	public Grid() {
		this.grid = new int[7][6];
	}

	public int turn(int x, int p) {
		if (x < 7 && x >= 0) {
			for (int i = this.grid[x].length - 1; i >= 0; i--) {
				if (this.grid[x][i] == 0) {
					this.grid[x][i] = p;
					return i;
				}
			}
			return -1;
		} else {
			return -1;
		}
	}

	public int hasWon() {
		int xCounter = 0;
		int yCounter = 0;
		for (int i = 0; i < this.grid.length; i++) {
			for (int o = 0; o < this.grid[i].length; o++) {
				if (this.grid[i][o] == 1) {
					xCounter++;
					yCounter = 0;
					if (xCounter == 4) {
						return 1;
					}
				} else if (this.grid[i][o] == 2) {
					yCounter++;
					xCounter = 0;
					if (yCounter == 4) {
						return 2;
					}
				} else {
					xCounter = 0;
					yCounter = 0;
				}
			}
			xCounter = 0;
			yCounter = 0;
		}

		for (int i = 0; i < this.grid[0].length; i++) {
			for (int o = 0; o < this.grid.length; o++) {
				if (this.grid[o][i] == 1) {
					xCounter++;
					yCounter = 0;
					if (xCounter == 4) {
						return 1;
					}
				} else if (this.grid[o][i] == 2) {
					yCounter++;
					xCounter = 0;
					if (yCounter == 4) {
						return 2;
					}
				} else {
					xCounter = 0;
					yCounter = 0;
				}
			}
			xCounter = 0;
			yCounter = 0;
		}

		for (int i = 0; i < 4; i++) {
			for (int o = 0; o < 3; o++) {
				if (this.grid[i][o] == 1 && this.grid[i + 1][o + 1] == 1 && this.grid[i + 2][o + 2] == 1
						&& this.grid[i + 3][o + 3] == 1) {
					return 1;
				} else if (this.grid[i][o] == 2 && this.grid[i + 1][o + 1] == 2 && this.grid[i + 2][o + 2] == 2
						&& this.grid[i + 3][o + 3] == 2) {
					return 2;
				}
			}
		}

		for (int i = grid.length - 1; i >= 3; i--) {
			for (int o = 0; o < 3; o++) {
				if (this.grid[i][o] == 1 && this.grid[i - 1][o + 1] == 1 && this.grid[i - 2][o + 2] == 1
						&& this.grid[i - 3][o + 3] == 1) {
					return 1;
				} else if (this.grid[i][o] == 2 && this.grid[i - 1][o + 1] == 2 && this.grid[i - 2][o + 2] == 2
						&& this.grid[i - 3][o + 3] == 2) {
					return 2;
				}
			}
		}
		return -1;
	}

	public void clear() {
		for (int i = 0; i < this.grid.length; i++) {
			for (int o = 0; o < this.grid[i].length; o++) {
				this.grid[i][o] = 0;
			}
		}
	}

}
