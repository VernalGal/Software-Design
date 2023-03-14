/**
 * LAB 3 -  Lotto QuickPicker Game 
 */
package edu.cuny.csi.csc330.lab3;

import edu.cuny.csi.csc330.util.Randomizer;
import java.util.Arrays;
import java.math.BigInteger;
import java.util.Date;


public class LottoQuickPicker 
{
	
	// constants  specific to current game - BUT NOT ALL GAMES 
	public final static int DEFAULT_GAME_COUNT = 1; 
	private final static int SELECTION_POOL_SIZE = 59; 
	private final static int SELECTION_COUNT = 6; 
	private int [][]lotto_ticket;


	
	
	public LottoQuickPicker() 
	{
		init(DEFAULT_GAME_COUNT); 
	}
	
	
	
	
	public LottoQuickPicker(int games) 
	{
		init(games); 
	}
  

	
	
	
	
	private void init(int games) 
	{
		lotto_ticket = new int[games][SELECTION_COUNT];
		int winningNumbers;
		for(int i = 0; i < games; i++) 
		{
			for(int j = 0; j < SELECTION_COUNT; j++) 
			{
				winningNumbers = Randomizer.generateInt(1, SELECTION_POOL_SIZE);
				for (int k=0; k<j; k++)
				{
					if (lotto_ticket[i][k] == winningNumbers)
					winningNumbers = Randomizer.generateInt(1, SELECTION_POOL_SIZE);
				}
				lotto_ticket[i][j]=winningNumbers;
			}
			Arrays.sort(lotto_ticket[i]);
		}
	}
	


	
	
	
	public void displayTicket() 
	{
		
		
		displayHeading();
		for(int i = 0; i<lotto_ticket.length; i++) 
		{
			System.out.printf("(%2d)", i+1);
			for(int j = 0; j < SELECTION_COUNT; j++) 
			{
				System.out.printf(" %02d",lotto_ticket[i][j]);
			}
			System.out.println();
		}
		
		
		displayFooter(); 
		calculateOdds();		
		return;
	}
	
	
	


	protected void displayHeading() 
	{
	 
		System.out.println("---------------------------------\n" + "-------------- LOTTO ------------");

	    Date current = new Date();
	    System.out.println(" " + current + "\n");
		
	}
	
	
	

	
	
	
	protected void displayFooter() 
	{
		 
		BigInteger odds = calculateOdds();
        System.out.printf("\n Odds of winning: 1 in %, d\n", odds);
        System.out.println("\n----- (c) S.I. Corner Deli ------\n" + "---------------------------------");
		
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	
	
	
	
	
	
	//private BigInteger odds;
	
	private BigInteger calculateOdds() 
	{
		
		BigInteger x = factorial(SELECTION_POOL_SIZE);
		BigInteger y = factorial(SELECTION_COUNT);
		BigInteger nSubR = factorial(SELECTION_POOL_SIZE - SELECTION_COUNT);
		BigInteger total;
		
		total = x.divide(y.multiply(nSubR));
		
		return total;
	}
  

	public static BigInteger factorial(int num) 
	
	{
		BigInteger total = BigInteger.ONE;

	       for (int i = 1; i <= num; i++)

	          total = total.multiply(new BigInteger(i + ""));

	       return total;
	}

	/**
	 * @param args 
	 */
	
	
	public static void main(String[] args)
	{
		// takes an optional command line parameter specifying number of QP games to be generated
		//  By default, generate 1  
		int numberOfGames  = DEFAULT_GAME_COUNT; 
		
		if(args.length > 0) {  // if user provided an arg, assume it to be a game count
			numberOfGames = Integer.parseInt(args[0]);  // [0] is the 1st element!
		}
		
		LottoQuickPicker lotto = new LottoQuickPicker(numberOfGames);
		 
		lotto.displayTicket(); 
		

	}

}
