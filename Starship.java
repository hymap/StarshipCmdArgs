package excercise;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//-----------------------------------------------------------
//File:   Starship.java
//Desc:   This program accepts command line arguments as input and
//        validate given input and prints output in required manner.
//----------------------------------------------------------- 
// 
public class Starship {
	private double warp=1.0;
	private boolean cloak;
	private int shields=0;
	//private ArrayList<String> crew = new ArrayList<>()
	ArrayList<String> crew = 
            new ArrayList<String>(Arrays.asList("kirk", "spock"));
	
	
	Starship(double warp, boolean cloak, int shields, ArrayList<String> crew){
		this.warp = warp;
		this.cloak = cloak;
		this.shields = shields;
		this.crew = crew;
	}

	public double getWarp() {
		return warp;
	}

	public void setWarp(double warp) {
		this.warp = warp;
	}

	public boolean isCloak() {
		return cloak;
	}

	public void setCloak(boolean cloak) {
		this.cloak = cloak;
	}

	public int getShields() {
		return shields;
	}

	public void setShields(int shields) {
		this.shields = shields;
	}

	public ArrayList<String> getCrew() {
		return crew;
	}

	public void setCrew(ArrayList<String> crew) {
		this.crew = crew;
	}
	
	//Takes command line arguments and validates the data given
	//returns the object
	//public static Starship fromArgs(String[] args) throws IllegalArgumentException {
	public static Starship fromArgs(String[] args) throws IllegalArgumentException {	
		double _warp = 1.0;
		int _shields = 0;
		boolean _cloak = false;
		ArrayList<String> _crew = null;
		
		for(int i=0;i< args.length;i++)
	    {
			System.out.println( "Given input to fromArgs : " + args[i]);
			
			switch(args[i]) {
			case "--shields" :
				System.out.println("Shields arg passed: "+args[i+1]);
				_shields = Integer.parseInt(args[i+1]);	
				i++;
				break;
			case "--warp":
				System.out.println(args[i+1]);
				_warp = Double.parseDouble(args[i+1]) ;
				i++;
				break;
			case "--cloak":
				System.out.println(args[i+1]);
				_cloak = Boolean.parseBoolean(args[i+1]);
				i++;
				break;
			case "--crew":
				System.out.println(args[i+1]);
				String configFileList = args[i+1];
				_crew = new ArrayList<>(Arrays.asList(configFileList.split(","))); 
				i++;
				break;
			default :
				throw new IllegalArgumentException("Given input is invalid. ex;--warp 5.2 --cloak --shields 7 --crew kirk,uhura,mccoy ");
			}
	    }
		//Parsing commandline arguments into local variables
		//System.out.println("After parsing from fromArgs() "+_warp+" "+_cloak+" "+ _shields +" " +_crew);
		
		//Valitions of given input 
		if((_warp > 0 && _warp < 15) && (_warp != 0)) {
			//Valid input
		}
		else{
			throw new IllegalArgumentException("Warp factor not a floating point number in the range 0-15");
		}
		
		if((_shields > 0 && _shields < 9) && (_shields != 0)) {
			//Valid input
		}
		else{
			throw new IllegalArgumentException("Shields not an integer in the range 0-9");
		}
		
		if(_crew.isEmpty()) {
			throw new IllegalArgumentException("Last argument is a valid option, but has no configuration value");
		}
		//Sorting given crew list
		Collections.sort(_crew);
		
		return new Starship(_warp,  _cloak,  _shields,  _crew);
	} 
	
}
