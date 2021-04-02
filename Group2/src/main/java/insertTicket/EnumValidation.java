package insertTicket;

public enum EnumValidation {
	
	
		validateTicketID,	//null & special character, length
	    validateDescription,	//null & special character
	    validateStartDate,		//automatically generated
	    validateExpectedEndDate,	//	range
	    validateEndDate,			//range	    
	    validateReporterID,			//employeeReporterPrefix , range, special character
	    validateEmployeeID,			//employeeReporterPrefix , range, special character
	    validateAssigneeName,		//range, special character
	    validateTicketType,			//not null, special character, range, 
	    validateTicketStatus,		// special character
	    validatePriority,			//range
	    validateImpact,				//range
	    validateUrgency,			//range
	    validateCustomerID,			//special character
	    validateCustomerName,		//special character
	    validateTicketLevel,		//not null
	    validateCreatorID,			//not null, special character, range
	    validateCreatorName,		//not null, special character, range
	    validateRating,				//range
	    validateAttachmentID,		
	    validateWorkingHours,		//non negative
	    validateTicketOnHoldHours,	//non negative 
	    validateTicketProgressHours	//non negative
}
