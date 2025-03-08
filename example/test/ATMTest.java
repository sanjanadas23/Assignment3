package behavioural.state.example.test;

import behavioural.state.example.model.ATMStateHandle;

public class ATMTest {
	public static void main(String[] args) {
		
		ATMStateHandle atmState= new ATMStateHandle();
		
		atmState.ChangeState();
		atmState.ChangeState();
		atmState.ChangeState();
		atmState.ChangeState();
		atmState.ChangeState();
		System.out.println("----------------------------------------");
		atmState.ChangeState();
		atmState.ChangeState();
		atmState.ChangeState();
		atmState.ChangeState();
		atmState.ChangeState();
	}

}
