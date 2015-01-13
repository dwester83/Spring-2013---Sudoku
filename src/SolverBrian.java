/**
 * Sudoku Solver
 * 
 * @author Brian Hanson
 */
public class SolverBrian implements SolverADT {

	private static int[][] grid;

	/**
	 * Default constructor
	 */
	public SolverBrian(){

		grid = new int[9][9];

	}

	/**
	 * Constructor
	 * @param args Takes in a String and its content by position are parsed into integers. 
	 */
	public SolverBrian(String [] puzzle) {

		int z = 0;

		while(z < puzzle.length) {

			int x = Integer.parseInt((String) puzzle[z].subSequence(0,1)), y = Integer.parseInt((String) puzzle[z].subSequence(1,2)), num = Integer.parseInt((String) puzzle[z].subSequence(2,3));

			grid[x][y] = num;
		}
	}
	
	public void Solve(int[][] grid) {

		if((solveGame(0,0,grid)) == true) {

			SolverBrian.grid = grid;

		}
	}

	public int[][] Solution() throws NoSolutionStored {

		return print(grid);

	}

	/**
	 * Method that verifies if the game can be solved.
	 * 
	 * @require That the correct values are taken in.
	 * @ensure A boolean response is returned when called upon.
	 * @param x Integer value horizontal.
	 * @param y Integer value vertical
	 * @param grid Integer 2D grid
	 * @return boolean response true or false.  
	 */
	private static boolean solveGame(int x, int y, int[][] grid) {

		if (x == 9) { 

			x = 0;

			while (++y == 9) 

				return true;

		}

		if (grid[x][y] != 0) {

			return solveGame(x+1,y,grid);

		}

		for (int num = 1; num <= 9; ++num) {

			if (validate(x,y,num,grid)) {

				grid[x][y] = num;

				while (solveGame(x+1,y,grid)) 

					return true;

			}
		}

		grid[x][y] = 0; 
		return false;
	}

	/**
	 * Validates each position to see if it's equal to num and returns a boolean value of true or false.
	 * 
	 * @require That the correct values are taken in.
	 * @ensures A boolean response is returned when called upon.
	 * @param x Integer value of horizontal.
	 * @param y Integer value of vertical.
	 * @param num Integer value of String.
	 * @param grid Integer 2D grid.
	 * @return boolean response true or false.
	 */
	private static boolean validate(int x, int y, int num, int[][] grid) {

		for (int z = 0; z < 9; ++z) {

			if (num == grid[z][y] || num == grid[x][z]){

				return false; // not valid.
			}
		}

		for (int a = 0; a < 3; ++a) {
			for (int b = 0; b < 3; ++b) {

				if (grid[(x / 3) * 3 + a][(y / 3) * 3 + b] == num) {

					return false; // not valid.

				}
			}
		}

		return true; // valid.
	}

	/**
	 * Prints the values in the 2D array.
	 * 
	 * @require A correct 2D is taken in.  
	 * @ensure The grid is returned correctly.
	 * @param grid Takes in a 2D integer grid.
	 * @return A 2D integer grid.
	 */
	private static int[][] print(int[][] grid) {

		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {

				if(grid[i][j] == 0) {

					Integer.toString(grid[i][j] = 0);

				}else{

					Integer.toString(grid[i][j]);

				}
			}
		}

		return grid;
	}
}


