import aima.core.search.framework.problem.GoalTest;

public class DatingGameGoalTest implements GoalTest {
    DatingGameBoard goal = new DatingGameBoard(new int[] {1,2,1,2,1,2,0});

    public boolean isGoalState(Object state){
    	DatingGameBoard board = (DatingGameBoard) state;
    	//System.out.println("is it goal? "+board.equals(goal)+" Board is:"+board.toString());
	return board.equals(goal);
    }
}
