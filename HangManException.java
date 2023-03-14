package edu.cuny.csi.csc330.lab7;

public class HangManException extends Exception 
{
	  
	 private static HangMan hangMan;
	
	 public HangManException(HangMan hangMan) 
	 {
		 this.hangMan = hangMan;
	  
	  } 
	  

	  @Override
	  public String toString() 
	  {
	
		  
	    return "\n \n GAME OVER! \n"
	        + "__________ \n"
	        + "|   | \n"
	        + "|   | \n"
	        + "|   | \n"
	        + "|   O \n"
	        + "|  /|\\ \n"
	        + "|  / \\ \n"
	        + "|_____________ \n";
	    
	  
	   
	    
	    }



	  public static void main(String[] args) {
	    
	      HangManException repeat = new HangManException(hangMan);
	  }

	}