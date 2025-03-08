package behavioural.state.example.model;

public class NoCardInserted implements State{

	@Override
	public void handleRequest(ATMStateHandle atmRequest) {
		System.out.println("The card is not yet inserted... NO card inserted");
		
		atmRequest.SetState(new CardInserted());
		
	}

}
