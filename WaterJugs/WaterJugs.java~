import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.List;

import aima.core.agent.Action;

import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.GoalTest;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;

import aima.core.search.uninformed.IterativeDeepeningSearch;

/**
 * @author Rodrigo Campos
 */
public class WaterJugs {

    static WaterJugsBoard initial = new WaterJugsBoard(new int[] {0,0});
    public static void main(String[] args){

	try{
	    System.out.println("\nWater Jugs Iterative DLS -->");
	    Problem problem = new Problem( initial,WaterJugsFunctionFactory.getActionsFunction(),WaterJugsFunctionFactory.getResultFunction(),new WaterJugsGoalTest());
	    SearchForActions search  = new IterativeDeepeningSearch();
	    SearchAgent agent = new SearchAgent(problem, search);
	    printActions(agent.getActions());
	    printInstrumentation(agent.getInstrumentation());
	} catch (Exception e){
	    e.printStackTrace();
	}
    }

    private static void printInstrumentation(Properties properties) {
	Iterator<Object> keys = properties.keySet().iterator();

	while (keys.hasNext()) {
	    String key = (String) keys.next();
	    String property = properties.getProperty(key);
	    System.out.println(key + " : " + property);
	}
    }

    private static void printActions(List<Action> actions) {
	for (int i = 0; i < actions.size(); i++) {
	    String action = actions.get(i).toString();
	    System.out.println(action);
	}
    }
}
