package employeeEfficiency;

public class chart 
{
	  	public static void main(String[] args) 
	  	{
		    int arr[]= {4,3,4,5,7};
		    int len=arr.length;
		    int max=0;
		    
		    for(int i=0;i<len;i++)   //find max of array
		    {
		      if (arr[i]>max)
		      {
		        max=arr[i];
		      }
		    }
		    char [][]dis1=new char[len][max];
		    for(int j=0;j<len;j++)   //store the array in horizontal order
		    { 
		      for(int i=0;i<max-arr[j];i++)   
		       dis1[j][i]=' ';
		    
		      for(int k=max-arr[j];k<max;k++)
		      {  dis1[j][k]='*';
		      
		      }
		        
		    }
		    
		    for(int i=0;i<max;i++)  //print the array in transpose order 
		    {
		      for(int j=0;j<len;j++)
		      System.out.print(dis1[j][i]+" ");  
		      System.out.println();
		    }
	  }
} // end class BarChart

