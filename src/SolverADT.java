/**
 * Sudoku Solver ADT Interface
 * @author Daniel Wester, Brian Hanson, Stuart Gabe
 */
public interface SolverADT {

	/**
	 * Solves the Sudoku problem passed to it.
	 * 
	 * @param input 2d array of the Sudoku problem to be solved.
	 * @require A solvable solution must be passed, must follow sudoku rules.
	 */
	public void Solve(int[][] input);

	/**
	 * Solution of the last Sudoku problem solved.
	 * 
	 * @return int[][] 2d array of the Sudoku problem that has been solved.
	 * @throws NoSolutionStored Exception thrown if there is no solution stored.
	 * @ensure A correct solution will be returned if it follows the requirements of the solve() method.
	 */
	public int[][] Solution() throws NoSolutionStored;

}
