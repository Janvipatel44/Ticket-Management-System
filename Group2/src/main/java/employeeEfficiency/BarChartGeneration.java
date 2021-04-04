package employeeEfficiency;

import java.util.HashMap;

import employeeEfficiency.Interfaces.IBarChartGeneration;

public class BarChartGeneration implements IBarChartGeneration
{
	public String Displaybarchart(HashMap <Integer, Integer> PatternGeneration ) 
	{
	    String string = null;
        String[] monthString = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String pattern = null;
		
	    int length = 0;
	    for(int i=0;i<monthString.length;i++)   
	    {
	      if(PatternGeneration.containsKey(i))	
	      {
	    	  if(PatternGeneration.get(i)>100) 
	    	  {
	    		  length = 10;
	    	  }	
	    	  else
	    	  {
	    		  length = PatternGeneration.get(i)/10;
	    	  } 
	          
		      for(int j=0;j<length;j++) 
		      {
		    	  if(string==null) {
		    		  string = "*";
		    	  }
		    	  else 
		    	  {
		          string += "*";  
		    	  }
		      }
		      if(pattern==null)
		    	  pattern = monthString[i];
		      else {
		    	  pattern += monthString[i];
		      }
		      pattern += ":";
		      pattern += string;
		      pattern += "\n";

		      System.out.printf("%2s: %s", monthString[i], string );
		      string = null;
		      System.out.print("\n");
	      }
	    }
	    
	    return pattern;
	}
}
