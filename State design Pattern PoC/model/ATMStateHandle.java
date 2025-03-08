package behavioural.state.example.model;

public class ATMStateHandle {
	private State currentState;
	
	public ATMStateHandle() {
		currentState= new NoCardInserted();
	}
	
	public void SetState(State state) {
		this.currentState=state;
	}
	
	public void ChangeState() {
		currentState.handleRequest(this);
	}
	

}
