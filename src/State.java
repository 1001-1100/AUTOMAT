import java.util.ArrayList;

public class State {
	
	private int stateNumber;
	private String stateLabel;
	private ArrayList<Transition> transitions;
	boolean isFinal;
	
	public State(int stateNumber, String stateLabel, boolean isFinal) {
		this.stateLabel = stateLabel;
		this.stateNumber = stateNumber;
		this.isFinal = isFinal;
		transitions = new ArrayList<>();
	}

	public String getStateLabel() {
		return stateLabel;
	}

	public ArrayList<Transition> getTransitions() {
		return transitions;
	}
	
	public void addTransition(Transition newTransition) {
		transitions.add(newTransition);
	}

	public boolean isFinal() {
		return isFinal;
	}

	public int getStateNumber() {
		return stateNumber;
	}

	
	
}
