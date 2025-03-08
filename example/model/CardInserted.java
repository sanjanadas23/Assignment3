package behavioural.state.example.model;

public class CardInserted implements State{

	@Override
	public void handleRequest(ATMStateHandle atmRequest) {
		System.out.println("The card is Inserted...");
		
		atmRequest.SetState(new EnterPIN());
		
	}

}
