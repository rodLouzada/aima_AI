import aima.core.search.framework.problem.GoalTest;

/**
 * @author Ravi Mohan
 * 
 */
public class GoldGoalTest implements GoalTest {
	GoldBoard goal = new GoldBoard(new int[] {  0, 0, 0, 0, 0, 0, 0, 3, 0 });

	public boolean isGoalState(Object state) {
		GoldBoard board = (GoldBoard) state;
		System.out.println("Goal: " +goal.toString()+ " \n State: "+ state.toString());
		return board.equals(goal);
	}
}
