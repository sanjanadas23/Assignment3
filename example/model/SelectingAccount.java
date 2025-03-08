package behavioural.state.example.model;

public class SelectingAccount implements State {

	@Override
	public void handleRequest(ATMStateHandle atmRequest) {
		System.out.println("Choose your account type.. Savings/Salary...");
		
		atmRequest.SetState(new WithdrawMoney());
		
	}

}
