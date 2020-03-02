import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.informed.AStarSearch;

/**
 * @author Rodrigo
 * 
 */

public class EightPuzzleDemo {
	
static EightPuzzleBoard assig = new EightPuzzleBoard(new int[] { 3, 5, 1, 8, 2, 6, 0, 7, 4 });

	public static void main(String[] args) {
		
		eightPuzzleAStarManhattanDemo();
		eightPuzzleAStarMisplacedDemo();
		eightPuzzleAStarMaxDemo();
		eightPuzzleAStarNilssonDemo();

	}

	
	private static void eightPuzzleAStarManhattanDemo() {
		System.out.println("\nEightPuzzleDemo AStar Search (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(assig , EightPuzzleFunctionFactory.getActionsFunction(),
					EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest());
			SearchForActions search = new AStarSearch(new GraphSearch(), new ManhattanHeuristicFunction());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

private static void eightPuzzleAStarMisplacedDemo() {
		System.out.println("\nEightPuzzleDemo AStar Search (Misplaced Tiles Heursitic)-->");
		try {
			Problem problem = new Problem(assig , EightPuzzleFunctionFactory.getActionsFunction(),
					EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest());
			SearchForActions search = new AStarSearch(new GraphSearch(), new MisplacedTilleHeuristicFunction());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

private static void eightPuzzleAStarMaxDemo() {
		System.out.println("\nEightPuzzleDemo AStar Search (N-Max-SwapHeursitic)-->");
		try {
			Problem problem = new Problem(assig , EightPuzzleFunctionFactory.getActionsFunction(),
					EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest());
			SearchForActions search = new AStarSearch(new GraphSearch(), new MaxSwapHeuristicFunction());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	} 

private static void eightPuzzleAStarNilssonDemo() {
	System.out.println("\nEightPuzzleDemo AStar Search (NilssonsHeursitic)-->");
	try {
		Problem problem = new Problem(assig , EightPuzzleFunctionFactory.getActionsFunction(),
				EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest());
		SearchForActions search = new AStarSearch(new GraphSearch(), new NilssonsHeuristicFunction());
		SearchAgent agent = new SearchAgent(problem, search);
		printActions(agent.getActions());
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