
//package aima.core.environment.eightpuzzle;

import aima.core.search.framework.evalfunc.HeuristicFunction;
import aima.core.util.datastructure.XYLocation;

/**
 * @author Rodrigo
 * 
 */
public class NeighborsHeuristicFunction implements HeuristicFunction {

	public double h(Object state) {
		DatingGameBoard board = (DatingGameBoard) state;
		int retVal = 0;
		for (int i = 1; i < 7; i++) {

			retVal += evaluateNeighbors(i, board);
		}
		return retVal;

	} //Let's check if our neighbors are the opposite sex

	public int evaluateNeighbors(int i, DatingGameBoard board) { 
		int retVal = 0;
		if (i > 0 && i < 6) { //We have two neighbors, get +1 penalty if your neighbor is the same sex as you
			int valueOnLeft = board.getValueAt(i - 1);
			int valueOnRight = board.getValueAt(i + 1);
			int value = board.getValueAt(i);

			if (valueOnLeft == value) {
				retVal = retVal + 1;
			}
			if (valueOnRight == value) {
				retVal = retVal + 1;
			}
			
		}
		else if(i == 0) { // dont have a neighbor on its left
			int valueOnRight = board.getValueAt(i + 1);
			int value = board.getValueAt(i);
			if (valueOnRight == value) {
				retVal = retVal + 2;
			}
		}
		else if(i == 6) { // dont have a neighbor on its right
			int valueOnLeft = board.getValueAt(i - 1);
			int value = board.getValueAt(i);
			if (valueOnLeft == value) {
				retVal = retVal + 2;
			}
		}

		return retVal;
	}
}