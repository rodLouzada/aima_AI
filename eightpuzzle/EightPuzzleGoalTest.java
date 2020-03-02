//package aima.core.environment.eightpuzzle;

import aima.core.search.framework.problem.GoalTest;

/**
 * @author Ravi Mohan
 * 
 */
public class EightPuzzleGoalTest implements GoalTest {
    EightPuzzleBoard goal = new EightPuzzleBoard(new int[] {  1, 2, 3, 8, 0, 4, 7, 6, 5 });

	public boolean isGoalState(Object state) {
		EightPuzzleBoard board = (EightPuzzleBoard) state;
		return board.equals(goal);
	}
}
