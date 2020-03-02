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
import aima.core.search.informed.AStarSearch;
import aima.core.search.uninformed.DepthLimitedSearch;

/**
 * @author Rodrigo Campos
 */
public class DatingGame {

	static DatingGameBoard assig = new DatingGameBoard(new int[] { 1,1,1,0,2,2,2});
	private static final int boardSize = 6;

    public static void main(String[] args){

    	
    		System.out.println("\nDating Game AStar Search (NeighbosHeursitic)-->");
    		try {
    			Problem problem = new Problem(assig , DatingGameFunctionFactory.getActionsFunction(),
    					DatingGameFunctionFactory.getResultFunction(), new DatingGameGoalTest(), new DatingGameStepCostFunction()); 
    			SearchForActions search = new AStarSearch(new GraphSearch(), new NeighborsHeuristicFunction());
    			SearchAgent agent = new SearchAgent(problem, search);
    			printActions(agent.getActions());
    			//System.out.println("Final State=\n" + search.getLastSearchState());
    			printInstrumentation(agent.getInstrumentation());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		System.out.println("\nDating Game Depth-limited Search -->");
    		try {
    			Problem problem = new Problem(assig , DatingGameFunctionFactory.getActionsFunction(),
    					DatingGameFunctionFactory.getResultFunction(), new DatingGameGoalTest(), new DatingGameStepCostFunction());
				// DatingGameFunctionFactory.getResultFunction(), new DatingGameGoalTest()); //,new DatingGameStepCostFunction()
    			SearchForActions search = new DepthLimitedSearch(boardSize);
    			SearchAgent agent = new SearchAgent(problem, search);
    			printActions(agent.getActions());
    			//System.out.println("Final State=\n" + search.getLastSearchState());
    			printInstrumentation(agent.getInstrumentation());
    		} catch (Exception e) {
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
