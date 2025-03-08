package behavioural.state.example.model;

public class WithdrawMoney implements State {

	@Override
	public void handleRequest(ATMStateHandle atmRequest) {
		System.out.println("Select the amount to withdraw... Amount is withdrawed");
		
		atmRequest.SetState(new NoCardInserted());
		
	}

}
