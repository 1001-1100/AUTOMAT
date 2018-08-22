
public class Transition {

	private String input;
	private State destination;
	
	public Transition(String input, State destination) {
		this.input = input;
		this.destination = destination;
	}

	public String getInput() {
		return input;
	}

	public State getDestination() {
		return destination;
	}

}
