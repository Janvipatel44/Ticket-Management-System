package employeeEfficiency;

public enum WorkWeights {
	    
		HIGH  (9),  //calls constructor with value 3
	    MEDIUM(8),  //calls constructor with value 2
	    LOW   (7)   //calls constructor with value 1
	    ; // semicolon needed when fields / methods follow


	    public int workWeights = 0;

	    WorkWeights(int workWeights) {
			// TODO Auto-generated constructor stub
	    	this.workWeights = workWeights;
		}

	    public int getWorkWeights() {
	        return this.workWeights;
	    }
	    
}