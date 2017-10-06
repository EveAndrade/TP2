package br.ufc.dc.tpii.bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.dc.tpii.bank.account.SavingsAccount;
import br.ufc.dc.tpii.bank.account.exception.InsufficientFundsException;
import br.ufc.dc.tpii.bank.account.exception.NegativeAmountException;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class SavingsAccountTest {
	
	private SavingsAccount account;
	@Before
	public void setUp() throws Exception {
		account = new SavingsAccount("123C");
	}
	
	@Test
	public void testCredit50AndDebit30(){
		try {
			account.credit(50);
			Assert.assertEquals("Erro no credito",50, account.getBalance(), 0.0);
			
			account.debit(30);
			Assert.assertEquals("Erro no debito",20, account.getBalance(), 0.0);
		}catch(NegativeAmountException e) {
			fail(e.getMessage());
		}
		catch(InsufficientFundsException e) {
			fail(e.getMessage());
		}
		
	}

}