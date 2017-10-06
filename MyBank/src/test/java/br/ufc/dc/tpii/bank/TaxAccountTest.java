package br.ufc.dc.tpii.bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.dc.tpii.bank.account.TaxAccount;
import br.ufc.dc.tpii.bank.account.exception.InsufficientFundsException;
import br.ufc.dc.tpii.bank.account.exception.NegativeAmountException;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TaxAccountTest {
	
	private TaxAccount account;
	@Before
	public void setUp() throws Exception {
		account = new TaxAccount("123B");
	}
	
	@Test
	public void testCredit50AndDebit30WithTaxAccount(){
		try {
			account.credit(50);
			Assert.assertEquals("Erro no credito",50, account.getBalance(), 0.0);
			
			account.debit(30);
			Assert.assertEquals("Erro no debito",19.97, account.getBalance(), 0.0);
		}catch(NegativeAmountException e) {
			fail(e.getMessage());
		}
		catch(InsufficientFundsException e) {
			fail(e.getMessage());
		}
		
	}

}