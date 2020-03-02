import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.uninformed.DepthLimitedSearch;

/**
 * @author Rodrigo
 * 
 */

public class Gold {
	
static GoldBoard assig = new GoldBoard(new int[] { 1, 0, 0, 0, 0, 0, 0, 2, 0 });
private static final int boardSize = 8;

	public static void main(String[] args) {
		
		System.out.println("\n Gold Depth-limited Search -->");
		try {
			Problem problem = new Problem(assig , GoldFunctionFactory.getActionsFunction(),
					GoldFunctionFactory.getResultFunction(), new GoldGoalTest());
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