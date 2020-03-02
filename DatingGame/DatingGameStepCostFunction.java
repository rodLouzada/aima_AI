
import aima.core.agent.Action;

import aima.core.search.framework.problem.StepCostFunction;


/**
 * @author Rodrigo Campos
 */
public class DatingGameStepCostFunction implements StepCostFunction {

   // private DatingGameBoard board = null;
    
    
    //public DatingGameStepCostFunction (DatingGameBoard board) {
    //	this.board = board;
   // }
    
public double c(Object fromCurrentState, Action action, Object toNextState) {
    	
    	String act = action.toString();
    	
    	if (act.compareTo("Action[name==Jump_2_right]")==0 || act.compareTo("Action[name==Jump_2_left]") == 0) {
    		//System.out.println("-- Distance is 2 : "+act);
    		return 2.0;
    		
    	}
    	//System.out.println("-- Distance is 1 "+ act);
    	return 1.0;
    	
    }
}
