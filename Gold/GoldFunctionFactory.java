import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.problem.ActionsFunction;
import aima.core.search.framework.problem.ResultFunction;


public class GoldFunctionFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new EPActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new EPResultFunction();
		}
		return _resultFunction;
	}

	private static class EPActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			GoldBoard board = (GoldBoard) state;

			Set<Action> actions = new LinkedHashSet<Action>();

			if (board.canMoveGold(GoldBoard.UP)) {
				actions.add(GoldBoard.UP);
			}
			if (board.canMoveGold(GoldBoard.DOWN)) {
				actions.add(GoldBoard.DOWN);
			}
			if (board.canMoveGold(GoldBoard.LEFT)) {
				actions.add(GoldBoard.LEFT);
			}
			if (board.canMoveGold(GoldBoard.RIGHT)) {
				actions.add(GoldBoard.RIGHT);
			}

			return actions;
		}
	}

	private static class EPResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			GoldBoard board = (GoldBoard) s;

			if (GoldBoard.UP.equals(a)
					&& board.canMoveGold(GoldBoard.UP)) {
				GoldBoard newBoard = new GoldBoard(board);
				newBoard.moveGoldUp();
				return newBoard;
			} else if (GoldBoard.DOWN.equals(a)
					&& board.canMoveGold(GoldBoard.DOWN)) {
				GoldBoard newBoard = new GoldBoard(board);
				newBoard.moveGoldDown();
				return newBoard;
			} else if (GoldBoard.LEFT.equals(a)
					&& board.canMoveGold(GoldBoard.LEFT)) {
				GoldBoard newBoard = new GoldBoard(board);
				newBoard.moveGoldLeft();
				return newBoard;
			} else if (GoldBoard.RIGHT.equals(a)
					&& board.canMoveGold(GoldBoard.RIGHT)) {
				GoldBoard newBoard = new GoldBoard(board);
				newBoard.moveGoldRight();
				return newBoard;
			}

			// The Action is not understood or is a NoOp
			// the result will be the current state.
			return s;
		}
	}
}
