package banksys.account;

import static org.junit.Assert.*;

import org.junit.Test;

import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;

public class TaxAccountTest {

	@Test
	public void testOrdinaryAccount() {
		TaxAccount test = new TaxAccount("123B");
		try {
			test.credit(50.0);
			test.debit(30.0);
			assertEquals(20.0, test.getBalance(), 0.0);
		}
		catch(NegativeAmountException e) {
			System.out.println(e.getMessage());
		}
		catch(InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
		catch(AssertionError e) {
			System.out.println("Ordinary Account Error: Balance = " + test.getBalance());
			fail("Assertion error.");
		}
	}

	@Test
	public void testDebit() {
		fail("Not yet implemented");
	}

	@Test
	public void testCredit() {
		fail("Not yet implemented");
	}

}
