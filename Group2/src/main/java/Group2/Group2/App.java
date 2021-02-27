package Group2.Group2;

import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    
    {
    	String text    =
    	        "This is the text to be searched " +
    	        "for occurrences of thehttp://pattern.";

    	String regex = ".*http:///.*";

    	boolean matches = Pattern.matches(regex, text);

    	System.out.println("matches = " + matches);
    }
}
