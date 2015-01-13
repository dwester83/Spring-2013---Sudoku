/**
 * 
 * @author dwester12
 */
@SuppressWarnings("serial")
public class NoSolutionStored extends Exception {

	/**
	 * The exception is used if there is no completed solution in the return.
	 */
	public NoSolutionStored() {
		super ("The Sudoku puzzle does not contain a stored solution.");
	}
}
