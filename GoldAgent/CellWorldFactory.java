/**
 * 
 * @author Ciaran O'Reilly
 * 
 */
public class CellWorldFactory {

	/**
	 * Create the cell world as defined in Figure 17.1 in AIMA3e. (a) A simple 4
	 * x 3 environment that presents the agent with a sequential decision
	 * problem.
	 * 
	 * @return a cell world representation of Fig 17.1 in AIMA3e.
	 */
	public static CellWorld<Double> createCellWorldForFig17_1() {
		CellWorld<Double> cw = new CellWorld<Double>(3, 3, -0.04);

		cw.getCellAt(3, 2).setContent(1.0);

		return cw;
	}
}
