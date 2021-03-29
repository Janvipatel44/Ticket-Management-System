package SLA;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Tickets.ITicketOperationsDB;
import Tickets.TicketOperationsDB;
import validations.IInputDateValidation;
import validations.IInputRangeValidation;
import validations.IInputStringValidation;
import validations.InputDateValidation;
import validations.InputRangeValidation;
import validations.InputStringValidation;

public class CloseTicket implements ICloseTicket{

	
	private String ticketId = null;
	
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
