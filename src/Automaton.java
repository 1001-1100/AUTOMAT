import java.util.ArrayList;

public class Automaton {

	private ArrayList<State> states;
	
	public Automaton() {
		states = new ArrayList<>();
		addStates();
	}
	
	private void addStates() {
		
		State q0 = new State(0,"HHLCG",false);
		states.add(q0);

		State q1 = new State(1,"LC",false);
		states.add(q1);
		
		State q2 = new State(2,"HHLG",false);
		states.add(q2);	
		
		State q3 = new State(3,"HHCG",false);
		states.add(q3);		

		State q4 = new State(4,"HLC",false);
		states.add(q4);				

		State q5 = new State(5,"LCG",false);
		states.add(q5);			
		
		State q6 = new State(6,"HHC",false);
		states.add(q6);	
		
		State q7 = new State(7,"HLCG",false);
		states.add(q7);			

		State q8 = new State(8,"LCG",false);
		states.add(q8);	
		
		State q9 = new State(9,"HHC",false);
		states.add(q9);	
		
		State q10 = new State(10,"HHLC",false);
		states.add(q10);	
		
		State q11 = new State(11,"HHCG",false);
		states.add(q11);		
		
		State q12 = new State(12,"LC",false);
		states.add(q12);	
		
		State q13 = new State(13,"HHLCG",true);
		states.add(q13);		

		State q14 = new State(14,"HHLG",false);
		states.add(q14);	

		State q15 = new State(15,"HLCG",false);
		states.add(q15);			
		
		State q16 = new State(16,"HHLC",false);
		states.add(q16);					

		State q17 = new State(17,"HLC",false);
		states.add(q17);			
		
		q0.addTransition(new Transition("LC",q1));
		q1.addTransition(new Transition("LC",q0));
		q1.addTransition(new Transition("C",q3));
		q1.addTransition(new Transition("L",q2));
		q2.addTransition(new Transition("L",q1));
		q2.addTransition(new Transition("HL",q4));
		q2.addTransition(new Transition("HH",q6));
		q2.addTransition(new Transition("LG",q5));
		q3.addTransition(new Transition("HC",q4));
		q3.addTransition(new Transition("CG",q5));
		q3.addTransition(new Transition("C",q1));
		q4.addTransition(new Transition("HC",q3));
		q4.addTransition(new Transition("HL",q2));
		q4.addTransition(new Transition("LC",q7));
		q5.addTransition(new Transition("CG",q3));
		q5.addTransition(new Transition("LC",q10));
		q5.addTransition(new Transition("LG",q2));
		q5.addTransition(new Transition("C",q9));
		q6.addTransition(new Transition("HH",q2));
		q6.addTransition(new Transition("HC",q7));
		q6.addTransition(new Transition("C",q8));
		q7.addTransition(new Transition("LC",q4));
		q7.addTransition(new Transition("HC",q6));
		q8.addTransition(new Transition("LG",q14));
		q8.addTransition(new Transition("LC",q16));
		q8.addTransition(new Transition("CG",q11));
		q8.addTransition(new Transition("C",q6));
		q9.addTransition(new Transition("HC",q15));
		q9.addTransition(new Transition("HH",q14));
		q9.addTransition(new Transition("C",q5));
		q10.addTransition(new Transition("LC",q5));
		q11.addTransition(new Transition("HC",q17));
		q11.addTransition(new Transition("CG",q8));
		q11.addTransition(new Transition("C",q12));
		q12.addTransition(new Transition("L",q14));
		q12.addTransition(new Transition("LC",q13));
		q12.addTransition(new Transition("C",q11));
		q13.addTransition(new Transition("LC",q12));
		q14.addTransition(new Transition("HH",q9));
		q14.addTransition(new Transition("HL",q17));
		q14.addTransition(new Transition("LG",q8));
		q14.addTransition(new Transition("L",q12));
		q15.addTransition(new Transition("HC",q9));
		q15.addTransition(new Transition("LC",q17));
		q16.addTransition(new Transition("LC",q8));
		q17.addTransition(new Transition("HL",q14));
		q17.addTransition(new Transition("HC",q11));
		q17.addTransition(new Transition("LC",q15));
	
	}

	public ArrayList<State> getStates() {
		return states;
	}
	
		
}
