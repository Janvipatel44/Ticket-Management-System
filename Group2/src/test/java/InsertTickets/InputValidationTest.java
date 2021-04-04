package InsertTickets;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import insertTicket.CreateTicket;
import insertTicket.Interfaces.ICreateTicket;

public class InputValidationTest {

/*	@Test
	public void isDescriptionNull() throws ParseException 
	{
		
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
		//description null
	    createTicket.setTicketId("123456");
	    createTicket.setDescription("");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("");
	    createTicket.setEmployeeId("EMP123");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Bug");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
	    assertFalse(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isTicketIdNull() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId(" ");
	    createTicket.setDescription("Search functionality");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMP123");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Bug");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isStartDateNull() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("1235");
	    createTicket.setDescription("Search functionality");
	    createTicket.setStartDate(" ");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMP123");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Bug");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}

	@Test
	public void isTicketTypeNull() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("1235");
	    createTicket.setDescription("Search functionality");
	    createTicket.setStartDate(" ");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMP123");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void insertTicketNullStringValidation() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("1235");
	    createTicket.setDescription("Search functionality");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMP123");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Bug");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertTrue(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isTicketIdContainsSpecialCharacter() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("12#35");
	    createTicket.setDescription("Login functionality");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMP123");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Bug");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isEmployeeIdContainsSpecialCharacter() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("12435");
	    createTicket.setDescription("Login functionality");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMP@123");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Bug");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}

	@Test
	public void isReporterIdContainsSpecialCharacter() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("124#35");
	    createTicket.setDescription("Login functionality");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMP@123");
	    createTicket.setReporterId("EMP_456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Bug");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}

	@Test
	public void isAssigneeNameContainsSpecialCharacter() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("124#35");
	    createTicket.setDescription("Login functionality");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMP@123");
	    createTicket.setReporterId("EMP_456");
	    createTicket.setAssigneeName("J@nvi Patel");
	    createTicket.setTicketType("Bug");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isEmployeeIdHasPrefix() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("12345");
	    createTicket.setDescription("Login functionality");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMPloyee123");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Bug");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isEmployeeIdAndReporterIdValid() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("12345");
	    createTicket.setDescription("Login functionality");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("Emp123");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Bug");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertTrue(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isTicketIdLengthValid() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("1234567891234567891234567891234567");
	    createTicket.setDescription("issue found in login details");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("Emp123");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Issuesignup");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isDateLengthValid() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("891");
	    createTicket.setDescription("issue found in login details");
	    createTicket.setStartDate("2020-001-01");
	    createTicket.setEndDate("2020-02-022");
	    createTicket.setEmployeeId("Emp123");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Issuesignup");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isEmployeeIdLengthValid() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("891");
	    createTicket.setDescription("issue found in login details");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMPJANVIGHANSHYAMBHAIPATEL2432431256577783");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Issuesignup");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isTicketTypeLengthValid() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("891");
	    createTicket.setDescription("issue found in login details");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMPJANVIGHANSHYAMBHAIPATEL2432431256577783");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Issue signup while generating it with yahoo account the account is not working");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isStringLengthValid() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("891");
	    createTicket.setDescription("issue found in login details");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMP83");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Issue");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertTrue(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isRangeValid() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("891");
	    createTicket.setDescription("issue found in login details");
	    createTicket.setStartDate("2020/01/01");
	    createTicket.setEndDate("2020-13-02");
	    createTicket.setEmployeeId("EMP83");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Issue");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(7);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}
	 
	@Test
	public void isDateFormatValid() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
	    createTicket.setTicketId("891");
	    createTicket.setDescription("issue found in login details");
	    createTicket.setStartDate("2020/01/01");
	    createTicket.setEndDate("2020-13-02");
	    createTicket.setEmployeeId("EMP83");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Issue");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
		
	    createTicket.setTicketId("891");
	    createTicket.setDescription("issue found in login details");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMP83");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Issue");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertTrue(insertTickets.validateInsertion(createTicket));
	}
	
	@Test
	public void isDurationValid() throws ParseException 
	{
		InsertTicketsMock insertTickets = new InsertTicketsMock();
		ICreateTicket createTicket = new CreateTicket();
		
	    createTicket.setTicketId("891");
	    createTicket.setDescription("issue found in login details");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2020-02-02");
	    createTicket.setEmployeeId("EMP83");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Issue");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertTrue(insertTickets.validateInsertion(createTicket));
		
		//end date is less than start date
		createTicket.setTicketId("891");
	    createTicket.setDescription("issue found in login details");
	    createTicket.setStartDate("2020-01-01");
	    createTicket.setEndDate("2018-02-03");
	    createTicket.setEmployeeId("EMP83");
	    createTicket.setReporterId("EMP456");
	    createTicket.setAssigneeName("Janvi Patel");
	    createTicket.setTicketType("Issue");
	    createTicket.setPriority(1);
	    createTicket.setUrgency(2);
	    createTicket.setImpact(4);
		assertFalse(insertTickets.validateInsertion(createTicket));
	}*/
}
