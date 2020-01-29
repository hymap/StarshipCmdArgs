package excercise;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This program accepts command line arguments and pass to a function
 * which validates and throws some exception if any and prints the final output
 * in required manner
 */
public class App 
{
    public static void main( String[] args )
    {
    	for(int i=0;i< args.length;i++)
	    {
    		System.out.println("Given input: " +args[i]);
	    }
    	if (args.length > 0) {
	    	try {
	    		//initialize with default values 
	    		Starship st = new Starship(1.0, false, 0, new ArrayList<>());
	    		System.out.println(st.getWarp() +" " + st.isCloak()+" "+st.getShields() + " " + st.getCrew());
	    		Starship s = Starship.fromArgs(args);
	    		//Starship s = Starship.fromArgs(new String[] { "--shields", "7", "--warp", "5.2", "--crew", "kirk,uhura,mccoy" });
	    		String cloak = null;
	    		if (s.isCloak()){
	    			cloak = "Engaged";
	    		}
	    		else {
	    			cloak = "DisEngaged";
	    		}
	    		System.out.println("Shields: [" +s.getShields() + "]");
	    		System.out.println("Warp:    [" +s.getWarp() + "]");
	    		
				System.out.println("Cloak:   [" +cloak + "]");
	    		System.out.println("Bridge Crew: " 
	    				+s.getCrew());
	    	}
	    	catch(IllegalArgumentException i1)
	    	{
	    		System.out.println(i1);
	    	}
    	}
    }
} 

