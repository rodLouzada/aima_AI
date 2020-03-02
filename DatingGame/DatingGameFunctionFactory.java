import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.problem.ActionsFunction;
import aima.core.search.framework.problem.ResultFunction;

public class DatingGameFunctionFactory {
    private static ActionsFunction _actionsFunction = null;
    private static ResultFunction _resultFunction = null;

    public static ActionsFunction getActionsFunction() {
	if (null == _actionsFunction){
	    _actionsFunction = new DGActionsFunction();
	}
	return _actionsFunction;
    }

    public static ResultFunction getResultFunction() {
	if (null == _resultFunction){
	    _resultFunction = new DGResultFunction();
	}
	return _resultFunction;
    }

    private static class DGActionsFunction implements ActionsFunction {
	public Set<Action> actions(Object state){
	    DatingGameBoard board = (DatingGameBoard) state;

	    Set<Action> actions = new LinkedHashSet<Action>();

	    if (board.canMoveChair(DatingGameBoard.MOVE_LEFT)){
		actions.add(DatingGameBoard.MOVE_LEFT);
	    }
	    if (board.canMoveChair(DatingGameBoard.MOVE_RIGHT)){
		actions.add(DatingGameBoard.MOVE_RIGHT);
	    }
	    if (board.canMoveChair(DatingGameBoard.JUMP_1_LEFT)){
		actions.add(DatingGameBoard.JUMP_1_LEFT);
	    }
	    if (board.canMoveChair(DatingGameBoard.JUMP_1_RIGHT)){
		actions.add(DatingGameBoard.JUMP_1_RIGHT);
	    }
	    if (board.canMoveChair(DatingGameBoard.JUMP_2_LEFT)){
		actions.add(DatingGameBoard.JUMP_2_LEFT);
	    }
	    if (board.canMoveChair(DatingGameBoard.JUMP_2_RIGHT)){
		actions.add(DatingGameBoard.JUMP_2_RIGHT);
	    }

	    return actions;
	}
    }

	private static class DGResultFunction implements ResultFunction {
	    public Object result(Object s,  Action a) {
		DatingGameBoard board = (DatingGameBoard) s;

		if (DatingGameBoard.MOVE_LEFT.equals(a) && board.canMoveChair(DatingGameBoard.MOVE_LEFT)){
		    
		    DatingGameBoard newBoard = new DatingGameBoard(board);
		    //System.out.println("Added water to four");		    
		    newBoard.MOVE_LEFT();
		    
		    return newBoard;
		    
		} else if (DatingGameBoard.MOVE_RIGHT.equals(a) && board.canMoveChair(DatingGameBoard.MOVE_RIGHT)){
		    
		    DatingGameBoard newBoard = new DatingGameBoard(board);
		    //System.out.println("Added water to three");
		    newBoard.MOVE_RIGHT();
		    
		    return newBoard;
		    
		} else if (DatingGameBoard.JUMP_1_LEFT.equals(a) && board.canMoveChair(DatingGameBoard.JUMP_1_LEFT)){
		    
		    DatingGameBoard newBoard = new DatingGameBoard(board);
		    
		    newBoard.JUMP_1_LEFT();
		    //System.out.println("Empty 4");
		    return newBoard;
		    
		} else if (DatingGameBoard.JUMP_1_RIGHT.equals(a) && board.canMoveChair(DatingGameBoard.JUMP_1_RIGHT)){
		    
		    DatingGameBoard newBoard = new DatingGameBoard(board);
		    
		    newBoard.JUMP_1_RIGHT();
		    //System.out.println("Empty 3");
		    
		    return newBoard;
		    
		} else if (DatingGameBoard.JUMP_2_LEFT.equals(a) && board.canMoveChair(DatingGameBoard.JUMP_2_LEFT)){
		    
		    DatingGameBoard newBoard = new DatingGameBoard(board);
		    //System.out.println("Pour 4 to 3");
		    newBoard.JUMP_2_LEFT();
		    
		    return newBoard;
		    
		} else if (DatingGameBoard.JUMP_2_RIGHT.equals(a) && board.canMoveChair(DatingGameBoard.JUMP_2_RIGHT)){
		    
		    DatingGameBoard newBoard = new DatingGameBoard(board);
		    
		    newBoard.JUMP_2_RIGHT();
		    //System.out.println("Pour 3 to 4");
		    return newBoard;
		    
		}
		

		
		return s;
	    }
	}
}
