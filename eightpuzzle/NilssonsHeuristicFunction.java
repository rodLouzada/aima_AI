//package aima.core.environment.eightpuzzle;

import aima.core.search.framework.evalfunc.HeuristicFunction;
import aima.core.util.datastructure.XYLocation;

/**
 * @author Rodrigo
 * 
 */
public class NilssonsHeuristicFunction implements HeuristicFunction {

	public double h(Object state) {
		EightPuzzleBoard board = (EightPuzzleBoard) state;
		int retVal = 0;
		for (int i = 1; i < 9; i++) {
			XYLocation loc = board.getLocationOf(i);
			retVal += evaluateNilssomDistanceOf(i, loc, board);
		}
		return retVal;

	}

	public int evaluateNilssomDistanceOf(int i, XYLocation loc, EightPuzzleBoard board) {
		int retVal = -1;
		int xpos = loc.getXCoOrdinate();
		int ypos = loc.getYCoOrdinate();
		int xsuccessor = -1;
		int ysuccessor = -1;
		XYLocation successorloc = loc;
		switch (i) {

		case 1:
	    retVal = (Math.abs(xpos-0)+Math.abs(ypos - 0));
	    successorloc = board.getLocationOf(2);
	    xsuccessor = successorloc.getXCoOrdinate();
		ysuccessor = successorloc.getYCoOrdinate();
	    if ((xsuccessor -xpos != 1)&&(ysuccessor -ypos != 0))
	    		retVal = retVal + 2;
	    break;
	case 2:
		retVal = (Math.abs(xpos-0) + Math.abs(ypos-1));
		successorloc = board.getLocationOf(3);
	    xsuccessor = successorloc.getXCoOrdinate();
		ysuccessor = successorloc.getYCoOrdinate();
	    if ((xsuccessor -xpos != 1)&&(ysuccessor -ypos != 0))
	    		retVal = retVal + 2;
	    break;
	case 3:
	    retVal = (Math.abs(xpos-0)+Math.abs(ypos*2));
	    successorloc = board.getLocationOf(4);
	    xsuccessor = successorloc.getXCoOrdinate();
		ysuccessor = successorloc.getYCoOrdinate();
	    if ((xsuccessor -xpos != 0)&&(ysuccessor -ypos != 1))
	    		retVal = retVal + 2;
	    break;
	case 4:
	    retVal = (Math.abs(xpos-1)+Math.abs(ypos-2));
	    successorloc = board.getLocationOf(5);
	    xsuccessor = successorloc.getXCoOrdinate();
		ysuccessor = successorloc.getYCoOrdinate();
	    if ((xsuccessor -xpos != 0)&&(ysuccessor -ypos != 1))
	    		retVal = retVal + 2;
	    break;
	case 5:
	    retVal = (Math.abs(xpos-2)+Math.abs(ypos-2));
	    successorloc = board.getLocationOf(6);
	    xsuccessor = successorloc.getXCoOrdinate();
		ysuccessor = successorloc.getYCoOrdinate();
	    if ((xsuccessor -xpos != -1)&&(ysuccessor -ypos != 0))
	    		retVal = retVal + 2;
	    break;
	case 6:
	    retVal = (Math.abs(xpos-2)+Math.abs(ypos-1));
	    successorloc = board.getLocationOf(7);
	    xsuccessor = successorloc.getXCoOrdinate();
		ysuccessor = successorloc.getYCoOrdinate();
	    if ((xsuccessor -xpos != -1)&&(ysuccessor -ypos != 0))
	    		retVal = retVal + 2;
	    break;
	case 7:
	    retVal = (Math.abs(xpos-2)+Math.abs(ypos-0));
	    successorloc = board.getLocationOf(8);
	    xsuccessor = successorloc.getXCoOrdinate();
		ysuccessor = successorloc.getYCoOrdinate();
	    if ((xsuccessor -xpos != 0)&&(ysuccessor -ypos != -1))
	    		retVal = retVal + 2;
	    break;
	case 8:
	    retVal = (Math.abs(xpos-1)+Math.abs(ypos-0));
	    successorloc = board.getLocationOf(1);
	    xsuccessor = successorloc.getXCoOrdinate();
		ysuccessor = successorloc.getYCoOrdinate();
	    if ((xsuccessor -xpos != 0)&&(ysuccessor -ypos != -1))
	    		retVal = retVal + 2;
	    break;


		}
		return retVal;
	}
}