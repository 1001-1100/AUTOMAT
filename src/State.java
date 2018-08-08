import java.util.ArrayList;

public class State {
	
	private String stateName;
	private String stateNumber;
	private ArrayList<Transition> transitions;
	boolean isFinal;
	
	public State(String stateName, String stateNumber, ArrayList<Transition> transitions, boolean isFinal) {
		this.stateName = stateName;
		this.stateNumber = stateNumber;
		this.transitions = transitions;
		this.isFinal = isFinal;
	}

	public String getStateName() {
		return stateName;
	}

	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public String getStateNumber() {
		return stateNumber;
	}

	
	
}
