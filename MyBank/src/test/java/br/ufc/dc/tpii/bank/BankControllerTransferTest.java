package br.ufc.dc.tpii.bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.dc.tpii.bank.account.OrdinaryAccount;
import br.ufc.dc.tpii.bank.account.SavingsAccount;
import br.ufc.dc.tpii.bank.persistence.AccountVector;
import br.ufc.dc.tpii.bank.control.BankController;
import br.ufc.dc.tpii.bank.control.exception.BankTransactionException;
import br.ufc.dc.tpii.bank.account.exception.InsufficientFundsException;
import br.ufc.dc.tpii.bank.account.exception.NegativeAmountException;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BankControllerTransferTest {
	
	private OrdinaryAccount accountA;
	private SavingsAccount accountC;
	private BankController UFCRepository;
	private AccountVector ACVector;
	
	@Before
	public void setUp() throws Exception {
		accountA = new OrdinaryAccount("123A");
		accountC = new SavingsAccount("123C");
		ACVector = new AccountVector();
		UFCRepository = new BankController(ACVector);
	}
	
	@Test
	public void testCredit50AndDebit30WithBankController() throws BankTransactionException{
		try {
			accountA.credit(50);
			Assert.assertEquals("Erro no credito",50, accountA.getBalance(), 0.0);	
			accountA.debit(30);
			Assert.assertEquals("Erro no debito",20, accountA.getBalance(), 0.0);
			
			accountC.credit(50);
			Assert.assertEquals("Erro no credito",50, accountC.getBalance(), 0.0);	
			accountC.debit(30);
			Assert.assertEquals("Erro no debito",20, accountC.getBalance(), 0.0);
			
			UFCRepository.addAccount(accountA);
			UFCRepository.addAccount(accountC);
			UFCRepository.doTransfer("123A", "123C", 10.0);
			
			Assert.assertEquals("Erro no debito",10, accountA.getBalance(), 0.0);
			Assert.assertEquals("Erro no credito",30, accountC.getBalance(), 0.0);
			
		}catch(NegativeAmountException e) {
			fail(e.getMessage());
		}
		catch(InsufficientFundsException e) {
			fail(e.getMessage());
		}
		
	}

}
