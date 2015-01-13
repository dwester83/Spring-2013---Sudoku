/**
 * @author Stuart
 */
public class SolverStuart implements SolverADT {

	private int[][] puzzle = new int [9][9];

	public int[][] Solution() throws NoSolutionStored {
		if (puzzle == null) {
			throw new NoSolutionStored();
		}
		return puzzle;
	}

	public void Solve(int[][] input){
		Solve(0, 0, input);

		for (int i = 0; i < 9; i++) {
			System.arraycopy(input[i], 0, puzzle[i], 0, 9);
		}
	}
	
	/**
	 * Solves the given puzzle through a brute force method 
	 * @require all passed in parameters are valid
	 * @ensure puzzle will be successfully solved
	 * @param r the current row
	 * @param c the current column
	 * @param input the passed in puzzle array
	 * @return true returned if number is successfully added to position [r][c], false returned if not possible
	 */  
	private boolean Solve(int r, int c, int[][] input) {
		if (r == 9) {
			r = 0;
			if (++c == 9) {
				return true;
			}
		}

		if (input[r][c] != 0) {
			return Solve(r+1,c,input);
		}

		for (int val = 1; val <= 9; val++) {
			if (validMove(r,c,val,input)) {
				input[r][c] = val;
				if (Solve(r + 1, c, input)) {
					return true;
				}
			}
		}
		input[r][c] = 0; 
		return false;
	}

	/**
	 * Checks if the move proposed is valid
	 * @require all passed in values are valid
	 * @ensure value placed in puzzle only if valid
	 * @param r the current row
	 * @param c the current column
	 * @param val the current value being checked for validity
	 * @param input the passed in puzzle array
	 * @return true returned if the move is valid within the rules of the game, false returned if move violates these rules
	 */
	private boolean validMove(int r, int c, int val, int[][] input) {
		for (int i = 0; i < 9; i++) {   
			if (val == input[i][c]) {
				return false;
			}
		}

		for (int j = 0; j < 9; j++) {   
			if (val == input[r][j]) {
				return false;
			}
		}

		int rowArea = (r / 3)*3;
		int colArea = (c / 3)*3;
		for (int ra = 0; ra < 3; ra++) { 
			for (int ca = 0; ca < 3; ca++) {
				if (val == input[rowArea+ra][colArea+ca]) {
					return false;
				}
			}
		}

		return true; 
	}

}
