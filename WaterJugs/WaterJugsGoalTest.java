import aima.core.search.framework.problem.GoalTest;

public class WaterJugsGoalTest implements GoalTest {
    WaterJugsBoard goal = new WaterJugsBoard(new int[] {2,0});

    public boolean isGoalState(Object state){
	WaterJugsBoard board = (WaterJugsBoard) state;
	//	System.out.println("Goal is: "+ goal.toString() + "Board is: " + board.toString() + "is euqals?????" + board.equals(goal));
	return board.equals(goal);
    }
}
