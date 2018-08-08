import java.util.ArrayList;

public class SolutionFinder {

	Automaton automaton;
	ArrayList<ArrayList<State>> solutionVisitedStates;
	ArrayList<ArrayList<String>> solutionInputs;
	ArrayList<ArrayList<State>> lowestSolutionVisitedStates;
	ArrayList<ArrayList<String>> lowestSolutionInputs;
	
	public SolutionFinder(Automaton automaton) {
		this.automaton = automaton;
		solutionVisitedStates = new ArrayList<>();
		solutionInputs = new ArrayList<>();
		lowestSolutionVisitedStates = new ArrayList<>();
		lowestSolutionInputs = new ArrayList<>();
		State initState = automaton.getStates().get(0);
		ArrayList<State> visited = new ArrayList<>();
		visited.add(initState);
		ArrayList<String> solution = new ArrayList<>();
		findSolution(initState,visited,solution);
		int lowestMove = solutionInputs.get(0).size();
		for(int i = 1 ; i < solutionInputs.size() ; i++) {
			if(lowestMove > solutionInputs.get(i).size()) {
				lowestMove = solutionInputs.get(i).size();
			}
		}
		for(int i = 0 ; i < solutionInputs.size() ; i++) {
			if(lowestMove == solutionInputs.get(i).size()) {
				lowestSolutionVisitedStates.add(solutionVisitedStates.get(i));
				lowestSolutionInputs.add(solutionInputs.get(i));
			}
		}
	}
	
	public void findSolution(State currentState, ArrayList<State> visited, ArrayList<String> solution) {
		if(!currentState.isFinal) {
			for(int i = 0 ; i < currentState.getTransitions().size() ; i++) {
				String nextState = currentState.getTransitions().get(i).getDestination().replace("q", "");
				int stateNumber = Integer.parseInt(nextState);
				State newState = automaton.getStates().get(stateNumber);
				if(!visited.contains(newState)) {
					visited.add(newState);
					solution.add(currentState.getTransitions().get(i).getInput());
					findSolution(newState, visited, solution);
					visited.remove(visited.size()-1);
					solution.remove(solution.size()-1);
				}
			}
		}else {
			ArrayList<State> newVisited = new ArrayList<>();
			ArrayList<String> newSolution = new ArrayList<>();
			newVisited.addAll(visited);
			newSolution.addAll(solution);
			addVisitedState(newVisited);
			addInput(newSolution);
		}
	}
	
	public void addVisitedState(ArrayList<State> visited) {
		this.solutionVisitedStates.add(visited);
	}
	
	public void addInput(ArrayList<String> solution) {
		this.solutionInputs.add(solution);
	}	
	
}
