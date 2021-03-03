package searchFuncTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import searchingFunctionality.IsearchTicket;

public class searchTicketGTest {
	private searchTicketGMock searchticketGMock;
	private IsearchTicket isearchTicket;
	
	
	@Before
	public void init() {
		isearchTicket=new searchTicketGMock();
	}
	@Test
	public void searchbyTicketIDTest() {
		assertTrue(isearchTicket.searchbyTicket(1,"2567"));
		assertFalse(isearchTicket.searchbyTicket(1,"2005"));
	}
	
	@Test
	public void searchbyTicketAssigneeTest() {
		assertTrue(isearchTicket.searchbyTicket(2,"Kolol"));
		assertFalse(isearchTicket.searchbyTicket(2,"Koll"));
	}
	
	@Test
	public void searchbyTicketTypeTest() {
		assertTrue(isearchTicket.searchbyTicket(3,"Service Request"));
		assertFalse(isearchTicket.searchbyTicket(3,"Bug"));
	}
	
	@Test
	public void searchbyAllTicketTest() {
		assertTrue(isearchTicket.searchbyTicket(4,null));
	}

	@Test
	public void searchbyTicketCreatorTest() {
		assertTrue(isearchTicket.searchbyTicket(5,"Reporter123"));
		assertFalse(isearchTicket.searchbyTicket(5,"Reporter523"));
	}
	
	@Test
	public void searchbyTicketKeywordTest() {
		assertTrue(isearchTicket.searchbyTicket(6,"DB Connection"));
		assertFalse(isearchTicket.searchbyTicket(6,"Technical Glitch"));
	}
}
