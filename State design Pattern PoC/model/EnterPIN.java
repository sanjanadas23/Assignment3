package behavioural.state.example.model;

public class EnterPIN implements State{

	@Override
	public void handleRequest(ATMStateHandle atmRequest) {
		System.out.println("Enter the PIN...");
		
		atmRequest.SetState(new SelectingAccount());
		
	}

}
