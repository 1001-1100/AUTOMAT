import java.util.ArrayList;

public class Automaton {

	private ArrayList<State> states;
	
	public Automaton() {
		states = new ArrayList<>();
		addStates();
	}
	
	private void addStates() {
		State state;
		ArrayList<Transition> transitions;
		
		transitions = new ArrayList<>();
		transitions.add(new Transition("LC","q1"));
		state = new State("q0","q0",transitions,false);
		states.add(state);
		
		transitions = new ArrayList<>();
		transitions.add(new Transition("LC","q0"));
		transitions.add(new Transition("C","q3"));
		transitions.add(new Transition("L","q2"));
		state = new State("q1","q1",transitions,false);
		states.add(state);
		
		transitions = new ArrayList<>();
		transitions.add(new Transition("L","q1"));
		transitions.add(new Transition("HL","q4"));
		transitions.add(new Transition("HH","q6"));
		transitions.add(new Transition("LG","q5"));
		state = new State("q2","q2",transitions,false);
		states.add(state);	
		
		transitions = new ArrayList<>();
		transitions.add(new Transition("HC","q4"));
		transitions.add(new Transition("CG","q5"));
		transitions.add(new Transition("C","q1"));
		state = new State("q3","q3",transitions,false);
		states.add(state);		

		transitions = new ArrayList<>();
		transitions.add(new Transition("HC","q3"));
		transitions.add(new Transition("HL","q2"));
		transitions.add(new Transition("LC","q7"));
		state = new State("q4","q4",transitions,false);
		states.add(state);				

		transitions = new ArrayList<>();
		transitions.add(new Transition("CG","q3"));
		transitions.add(new Transition("LC","q10"));
		transitions.add(new Transition("LG","q2"));
		transitions.add(new Transition("C","q9"));
		state = new State("q5","q5",transitions,false);
		states.add(state);			
		
		transitions = new ArrayList<>();
		transitions.add(new Transition("HH","q2"));
		transitions.add(new Transition("HC","q7"));
		transitions.add(new Transition("C","q8"));
		state = new State("q6","q6",transitions,false);
		states.add(state);	
		
		transitions = new ArrayList<>();
		transitions.add(new Transition("LC","q4"));
		transitions.add(new Transition("HC","q6"));
		state = new State("q7","q7",transitions,false);
		states.add(state);			

		transitions = new ArrayList<>();
		transitions.add(new Transition("LG","q14"));
		transitions.add(new Transition("LC","q16"));
		transitions.add(new Transition("CG","q11"));
		transitions.add(new Transition("C","q6"));
		state = new State("q8","q8",transitions,false);
		states.add(state);	
		
		transitions = new ArrayList<>();
		transitions.add(new Transition("HC","q15"));
		transitions.add(new Transition("HH","q14"));
		transitions.add(new Transition("C","q5"));
		state = new State("q9","q9",transitions,false);
		states.add(state);	
		
		transitions = new ArrayList<>();
		transitions.add(new Transition("LC","q5"));
		state = new State("q10","q10",transitions,false);
		states.add(state);	
		
		transitions = new ArrayList<>();
		transitions.add(new Transition("HC","q17"));
		transitions.add(new Transition("CG","q8"));
		transitions.add(new Transition("C","q12"));
		state = new State("q11","q11",transitions,false);
		states.add(state);		
		
		transitions = new ArrayList<>();
		transitions.add(new Transition("L","q14"));
		transitions.add(new Transition("LC","q13"));
		transitions.add(new Transition("C","q11"));
		state = new State("q12","q12",transitions,false);
		states.add(state);	
		
		transitions = new ArrayList<>();
		transitions.add(new Transition("LC","q12"));
		state = new State("q13","q13",transitions,true);
		states.add(state);		

		transitions = new ArrayList<>();
		transitions.add(new Transition("HH","q9"));
		transitions.add(new Transition("HL","q17"));
		transitions.add(new Transition("LG","q8"));
		transitions.add(new Transition("L","q12"));
		state = new State("q14","q14",transitions,false);
		states.add(state);	

		transitions = new ArrayList<>();
		transitions.add(new Transition("HC","q9"));
		transitions.add(new Transition("LC","q17"));
		state = new State("q15","q15",transitions,false);
		states.add(state);			
		
		transitions = new ArrayList<>();
		transitions.add(new Transition("LC","q8"));
		state = new State("q16","q16",transitions,false);
		states.add(state);					

		transitions = new ArrayList<>();
		transitions.add(new Transition("HL","q14"));
		transitions.add(new Transition("HC","q11"));
		transitions.add(new Transition("LC","q15"));
		state = new State("q17","q17",transitions,false);
		states.add(state);			
		
	}

	public ArrayList<State> getStates() {
		return states;
	}
	
		
}
