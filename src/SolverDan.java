/**
 * Implementation of the SolverADT
 * @author Daniel Wester
 */

public class SolverDan implements SolverADT {

	private int[][] sol;

	/**
	 * Default constructor for the solver.
	 */
	SolverDan(){
		
	}

	public void Solve(int[][] input) {

		sol = new int[9][9];
		
		solve(0, input);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++){
				sol[i][j] = input[i][j];
			}
		}
	}

	public int[][] Solution() throws NoSolutionStored {
		if (sol == null) //If no puzzle was ever passed to it, there will be nothing stored.
			throw new NoSolutionStored();
		return sol;
	}

	/**
	 * Solves the puzzle. This method uses a recursive method by brute force.
	 * Will call to the nextPosition and then insert a number in the position given, validate it, and repeat.
	 * 
	 * @require A valid puzzle must be given initially.
	 * @ensure Will solve the puzzle in a brute force method
	 * @param position the current position that needs a number given in bit 
	 * @param input The array that represents the puzzle.
	 * @return boolean true if a number was entered without problems, false if it couldn't add number
	 */
	private boolean solve(int position, int[][] input) {

		if (position == -1) return true;  //no position/spots left
		if (position == -2) return false; //no solution, backtrack

		int i = position >> 4;
		int j = position & 15;

		if (input[i][j] != 0)
			return solve(nextPosition(position),input);

		for (int valid = 1; valid < 10; valid++) {
			if (rules(i,j,valid,input)) {
				input[i][j] = valid;
				if (solve(nextPosition(position),input))
					return true;
			}
		}
		input[i][j] = 0;
		return false;
	}

	/**
	 * Next valid position, checked by bit position available.
	 * 
	 * @require valid int that doesn't exceed a valid positions
	 * @ensure Will make sure spots a still available.
	 * @param p int that states what position should be looked at.
	 * @return int next position
	 */
	private int nextPosition(int position) {
		int j = position & 15;
		if (j < 8)
			return position+1;
		int i = position >> 4; // shift 4 bits right
		if (i == 8)
			return -1;
		return (i+1)<< 4;
	}
	
	/**
	 * Validates the number given to make sure it follows the rules of Sudoku.
	 * 
	 * @require valid numbers that do not exceed valid rules.
	 * @ensure The puzzle is still a valid Sudoku puzzle
	 * @param i Column of the spot being checked.
	 * @param j Row of the spot being checked.
	 * @param valid the number being checked to see if it's a valid number
	 * @param input The array that represents the puzzle.
	 * @return boolean true means it is a correct puzzle, false an invalid puzzle
	 */
	private boolean rules(int i, int j, int valid, int[][] input) {
		for (int k = 0; k < 9; k++)
			if (valid == input[k][j])
				return false;

		for (int k = 0; k < 9; k++)
			if (valid == input[i][k])
				return false;

		int row = (i / 3)*3;
		int col = (j / 3)*3;
		for (int k = 0; k < 3; k++)
			for (int m = 0; m < 3; m++)
				if (valid == input[row+k][col+m])
					return false;

		return true;
	}

}
