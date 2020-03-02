import java.util.ArrayList;
import java.util.List;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.util.datastructure.XYLocation;

/**
 * @author Rodrigo L Campos
 */

public class WaterJugsBoard {

    public static Action FILL_4 = new DynamicAction("Fill_4");

    public static Action FILL_3 = new DynamicAction("Fill_3");

    public static Action EMPTY_4 = new DynamicAction("Empty_4");

    public static Action EMPTY_3 = new DynamicAction("Empty_3");

    public static Action POUR_4_TO_3 = new DynamicAction("Pour_4_to_3");

    public static Action POUR_3_TO_4 = new DynamicAction("Pour_3_to_4");

    private int[] state;

    /*
     * Public methods
     */

    public WaterJugsBoard() {
	state = new int [] {0,0};
    }

    public WaterJugsBoard(int[] state) {
	this.state = new int[state.length];
	System.arraycopy(state,0,this.state, 0, state.length);
    }

    public WaterJugsBoard (WaterJugsBoard copyBoard){
	this(copyBoard.getState());
    }

    public int [] getState(){
	return state;
    }

    public void Fill4 () {
	state[0] = 4;
    }

    public void Fill3 (){
	state[1] = 3;
    }

    public void Empty4 (){
	state[0] = 0;
    }

    public void Empty3 (){
	state[1] = 0;
    }

    public void Pour4to3 (){
	int emptySpace =  3 - state[1];
	if(state[0] - emptySpace >= 0)
	    {
		state[0] = state[0] - emptySpace;
		state[1] = 3;
	    }
	else
	    {
		state[1] = state[1] + state[0];
		state[0] = 0;
	    }
    }

    public void Pour3to4 (){
	int emptySpace = 4 - state[0];
	if (state[1] - emptySpace >= 0)
	    {
		state[1] = state[1] - emptySpace;
		state[0] =  4;
	    }
	else
	    {
		state[0] = state[0] + state[1];
		state[1] = 0;
	    }
    }

    public boolean canMoveWater (Action where)
    {
	if (where.equals (FILL_4)){
	    if(state[0] < 4 ){ return true; }
	    else { return false; }
	}
	else if (where.equals (FILL_3)){
	    if(state[1] < 3 ){ return true;}
	    else { return false;}
	}
	else if (where.equals (EMPTY_4)){
	    if (state[0] >= 1){return true;}
	    else {return false;}
	}
	else if (where.equals (EMPTY_3)){
	    if (state[1] >= 1){return true;}
	    else {return true;}
	}
	else if (where.equals (POUR_4_TO_3)){
	    if(state[0] >= 1 && state[1]<3){return true;}
	    else { return false;}
	}
	else if (where.equals(POUR_3_TO_4)){
	    if(state[1] >= 1 && state[0]<4){return true;}
	    else { return false;}
	}
	else
	    return false;
    }

    @Override
    public String toString(){
	String ret = state[0] + " " + state[1];
	return ret;
    }
    
    @Override                                                                        public boolean equals(Object o) {

	if (this == o) {
	    return true;
	}

	if ((o == null) || (this.getClass() != o.getClass())) {
	    return false;
	}
	WaterJugsBoard aBoard = (WaterJugsBoard) o;
	for (int i = 0; i < 2; i++) {                                                            if (this.state[i] != aBoard.state[i]) {                                  return false;                                                            }                                                                        }                                                                                return true;                                                             } 

    /*@Override                                                                        public int hashCode() {                                                                  int result = 17;                                                                 for (int i = 0; i < 2; i++) {                                                            int position = this.getPositionOf(i);                                            result = 37 * result + position;                                         }                                                                               return result;                                                           } */
	    
        private int getPositionOf(int val) {                                                     for (int i = 0; i < 2; i++) {                                                            if (state[i] == val) {                                                                   return i;                                                                }                                                                        }                                                                                return -1;                                                               }          
     }
