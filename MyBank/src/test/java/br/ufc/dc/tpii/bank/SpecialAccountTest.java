package br.ufc.dc.tpii.bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.dc.tpii.bank.account.SpecialAccount;
import br.ufc.dc.tpii.bank.account.exception.InsufficientFundsException;
import br.ufc.dc.tpii.bank.account.exception.NegativeAmountException;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class SpecialAccountTest {
	
	private SpecialAccount account;
	@Before
	public void setUp() throws Exception {
		account = new SpecialAccount("123B"); // toda vida que iniciar um novo teste isso vai criar uma instancia nova da classe
	}
	
	@Test
	public void testCredit50AndDebit30WithSpecialAccount(){
		try {
			account.credit(50);
			Assert.assertEquals("Erro no credito",50.5, account.getBalance(), 0.0);
			
			account.debit(30);
			Assert.assertEquals("Erro no debito",20.5, account.getBalance(), 0.0);
		}catch(NegativeAmountException e) {
			fail(e.getMessage());
		}
		catch(InsufficientFundsException e) {
			fail(e.getMessage());
		}
		
	}

}
