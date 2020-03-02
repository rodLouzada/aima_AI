import java.util.ArrayList;
import java.util.List;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.util.datastructure.XYLocation;

/**
 * @author Rodrigo L Campos
 */

public class DatingGameBoard {

	public static Action MOVE_LEFT = new DynamicAction("Move_Left");
	public static Action MOVE_RIGHT = new DynamicAction("Move_Right");
	public static Action JUMP_1_LEFT = new DynamicAction("Jump_1_left");
	public static Action JUMP_1_RIGHT = new DynamicAction("Jump_1_right");
	public static Action JUMP_2_LEFT = new DynamicAction("Jump_2_left");
	public static Action JUMP_2_RIGHT = new DynamicAction("Jump_2_right");

	private int[] state;

	/*
	 * Public methods
	 */

	public DatingGameBoard() {
		state = new int[] { 1, 1, 1, 0, 2, 2, 2 };
	}

	public DatingGameBoard(int[] state) {
		this.state = new int[state.length];
		System.arraycopy(state, 0, this.state, 0, state.length);
	}

	public DatingGameBoard(DatingGameBoard copyBoard) {
		this(copyBoard.getState());
	}

	public int[] getState() {
		return state;
	}

	public int getValueAt(int x) {
		// refactor this use either case or a div/mod soln
		return state[x];
	}

	public int getLocationOf(int val) {
		int absPos = getPositionOf(val);
		return absPos;
	}

	public void MOVE_RIGHT() {
		int gapPos = getGapPosition();
		int pos = gapPos;
		if (!(pos == 6)) {
			int valueOnRight = getValueAt(pos + 1);
			setValue(pos, valueOnRight);
			setValue(pos + 1, 0);
		}

	}

	public void MOVE_LEFT() {
		int gapPos = getGapPosition();
		int pos = gapPos;
		if (!(pos == 0)) {
			int valueOnLeft = getValueAt(pos - 1);
			setValue(pos, valueOnLeft);
			setValue(pos - 1, 0);
		}

	}

	public void JUMP_1_RIGHT() {
		int gapPos = getGapPosition();
		int pos = gapPos;
		if (!(pos == 5)) {
			int valueOnRight = getValueAt(pos + 2);
			setValue(pos, valueOnRight);
			setValue(pos + 2, 0);
		}

	}

	public void JUMP_1_LEFT() {
		int gapPos = getGapPosition();
		int pos = gapPos;
		if (!(pos == 1)) {
			int valueOnLeft = getValueAt(pos - 2);
			setValue(pos, valueOnLeft);
			setValue(pos - 2, 0);
		}

	}

	public void JUMP_2_RIGHT() {
		int gapPos = getGapPosition();
		int pos = gapPos;
		if (!(pos == 4)) {
			int valueOnRight = getValueAt(pos + 3);
			setValue(pos, valueOnRight);
			setValue(pos + 3, 0);
		}

	}

	public void JUMP_2_LEFT() {
		int gapPos = getGapPosition();
		int pos = gapPos;
		if (!(pos == 2)) {
			int valueOnLeft = getValueAt(pos - 3);
			setValue(pos, valueOnLeft);
			setValue(pos - 3, 0);
		}

	}

	public List <Integer> getPositions() {
		ArrayList<Integer> retVal = new ArrayList<Integer>();
		for (int i = 0; i < 7; i++) {
			int absPos = getPositionOf(i);
			retVal.add(absPos);

		}
		return retVal;
	}

	public void setBoard(List<Integer> locs) {
		int count = 0;
		for (int i = 0; i < locs.size(); i++) {
			int loc = locs.get(i);
			this.setValue(loc, count);
			count = count + 1;
		}
	}

	public boolean canMoveChair(Action where) {
		boolean retVal = true;
		int absPos = getPositionOf(0);
		if (where.equals(MOVE_LEFT))
			retVal = (absPos != 0);
		else if (where.equals(MOVE_RIGHT))
			retVal = (absPos != 6);
		else if (where.equals(JUMP_1_LEFT))
			retVal = (absPos > 1);
		else if (where.equals(JUMP_1_RIGHT))
			retVal = (absPos < 5);
		else if (where.equals(JUMP_2_LEFT))
			retVal = (absPos > 2);
		else if (where.equals(JUMP_2_RIGHT))
			retVal = (absPos < 4);
		return retVal;
	}

	@Override
	public String toString() {
		String ret = state[0] + " " + state[1]+ " " + state[2]+ " " + state[3]+ " " + state[4]+ " " + state[5]+ " " + state[6];
		return ret;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}

		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		DatingGameBoard aBoard = (DatingGameBoard) o;
		for (int i = 0; i < 7; i++) {
			if (this.state[i] != aBoard.state[i]) {
				return false;
			}
		}
		return true;
	}

	/*
	 * @Override public int hashCode() { int result = 17; for (int i = 0; i < 2;
	 * i++) { int position = this.getPositionOf(i); result = 37 * result + position;
	 * } return result; }
	 */
	public int getGapPosition() {
		return getPositionOf(0);
	}

	public int getPositionOf(int val) {
		for (int i = 0; i < 7; i++) {
			if (state[i] == val) {
				return i;
			}
		}
		return -1;
	}
	public void setValue(int x, int val) {
		state[x] = val;

	}
	private int getCoord(int absPos) {
		return absPos;
	}

}
