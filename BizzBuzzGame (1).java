package edu.cuny.csi.csc330.lab1;

/**
 * Simulates BizzBuzzGame Pattern - with no mistakes, that is.
 * Sample Game Rules
 * https://glacier.adams12.org/sites/glacier.d7sb.adams12.org/files/users/mue001026/attachments/Buzz.pdf
 * @author lji
 *
 */
public class BizzBuzzGame {

	// Max number of turns
	static private final int MAX_TURNS = 50;
	static private final int BIZZ = 3;
	static private final int BUZZ = 6;

	// Player Names
	static private final String[] PLAYERS = { 
			"Richard", 
			"John", 
			"Cynthia", 
			"Paul", 
			"Jane", 
			"George", 
			"Patti", 
			"Olivia",
			"Brian", 
			"Maureen"
	};


	/**
	 * BIZ = 6 
	 * BUZZ = 3
	 * if current count is factor of both BIZ and BUZZ, return "BIZ-BUZZ"
	 * if current count is factor of BUZZ, return "BUZZ" 
	 * if current count is factor of BIZ, return "BIZ" 
	 * otherwise, return the count value
	 * @param count
	 */
	// Implement this stubbed out method 
	static private void generateSpokenValue(int count) {
		 if(count % 3 == 0 && count % 6 == 0)
         {
            System.out.printf("BIZZ-BUZZ");
            System.out.printf("\n");
         }
         else if(count % 3 == 0) {
             System.out.printf("BIZZ");
             System.out.printf("\n");
         }
         else if (count % 6 == 0) {
             System.out.printf("BUZZ");
         }
         else
            System.out.printf("%d %n", count);




      
	}

	/**
	 * method that starts game ... from 1 to MAX_TURNS 
	 */
	// Implement this stubbed out method 
	static public void goPlay() 
{
		// cycle 1 thru MAX_TURNS and PLAYERS[0] thru PLAYERS[ PLAYERS.length ]
		 for(int i=1; i<=MAX_TURNS; i++)
         {
			 System.out.print(PLAYERS[(i-1)%10] + "                        \t");

           
            
             
             
             generateSpokenValue(i);
             

     }
 }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// start the game! 
		BizzBuzzGame.goPlay();

	}
	
}