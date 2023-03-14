package edu.cuny.csi.csc330.lab6;

import edu.cuny.csi.csc330.util.Randomizer;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

public class QuickPicker 
{
  public final static int DEFAULT_GAME_COUNT = 1;
  private static String GAME_NAME = "Lotto";
  private static String VENDOR;
  private static String FILE_NAME_PROPERTIES;
  
  
  private static int gameCount = DEFAULT_GAME_COUNT;
  private static int Pool_Size_One_Selection = 0;
  private static int selection1_count = 0;
  private static int Pool_Size_Two_Selection = 0;
  private static int selection2_count = 0;

  public QuickPicker(int gameCount) throws QuickPickerException 
  {
    init(gameCount);
  }

  private void init(int games) throws QuickPickerException 
  {
    gameCount = games;
    initFromPropBundle();
  }

  private static void initFromPropBundle() throws QuickPickerException 
  {
    
    try 
    {
      ResourceBundle bundle = ResourceBundle.getBundle(FILE_NAME_PROPERTIES);
      
      if (bundle.containsKey("GameName")) 
      {
        GAME_NAME = bundle.getString("GameName");
      } else {
        throw new QuickPickerException("Can't find: " + FILE_NAME_PROPERTIES, QuickPickerException.GAMENAME_ERROR);
      }
      if (bundle.containsKey("Pool1")) 
      {
    	  selection1_count = Integer.parseInt(bundle.getString("Pool1").split("/")[0]);
    	  Pool_Size_One_Selection = Integer.parseInt(bundle.getString("Pool1").split("/")[1]);
      } else {
        throw new QuickPickerException("Can't find: " + FILE_NAME_PROPERTIES, QuickPickerException.POOL1_ERROR);
      }
      if (bundle.containsKey("Pool2")) 
      {
    	  selection2_count = Integer.parseInt(bundle.getString("Pool2").split("/")[0]);
        Pool_Size_Two_Selection = Integer.parseInt(bundle.getString("Pool2").split("/")[1]);
      } else {
        throw new QuickPickerException("Can't find: " + FILE_NAME_PROPERTIES, QuickPickerException.POOL2_ERROR);
      }
      if (bundle.containsKey("Vendor")) 
      {
        VENDOR = bundle.getString("Vendor");
      } else {
        throw new QuickPickerException("Can't find: " + FILE_NAME_PROPERTIES, QuickPickerException.VENDOR_ERROR);
      }
    } catch (QuickPickerException e) 
    {
      System.err.println(e);
      System.exit(1);
    }
  }

  //Generate random numbers
  private int[] generateLottoNumbers() 
  {
    int count = selection1_count + selection2_count;
    int selection[] = new int[count];

    for (int i = 0; i < selection1_count; i++) 
    {
      selection[i] = Randomizer.generateInt(1, Pool_Size_One_Selection);
      if (i > 0) 
      {
        if (checkForSimilarity(selection, selection[i], i) == true) {
        	
          continue;
        }
      }
    }

    for (int j = selection1_count; j < count; j++) 
    {
      selection[j] = Randomizer.generateInt(1, Pool_Size_Two_Selection);
      if (j > 0) 
      {
        if (checkForSimilarity(selection, selection[j], j) == true) 
        {
          continue;
        }
      }
    }

    Arrays.sort(selection, 0, selection1_count);
    Arrays.sort(selection, selection1_count, count);

    return selection;
  }

  // checking same numbers
  private boolean checkForSimilarity(int[] selection, int value,  int ending_Index) 
  {
    for (int i = 0; i < ending_Index; i++) 
    {
      if (value == selection[i])
        return true;
    }
    return false;
  }

  
  
  //Display overall ticket
  public void showTicket() 
  {
    generateHeading();
    for (int i = 0; i < gameCount; i++) 
    {
      int selection[] = generateLottoNumbers();
      generateGame(i + 1, selection);
    }
    generateFooter();
  }
  
  
  

  // show heading
  private void generateHeading() 
  {
    System.out.println("-------------------------------------\n--------  <<" + GAME_NAME + ">> ---------");
    Date today = new Date();
    System.out.println("  " + today + "\n");
  }
  
  
  
//showcase Lotto Numbers
  private void generateGame(int index, int[] selection) 
  {
    if (index != 0)
      System.out.printf(" (%2d) ", index);
    for (int i = 0; i < selection.length; i++) 
    {
      if (i >= selection1_count) 
      {
        System.out.printf(" (( %02d  ))", selection[i]);
      } else {
        System.out.printf(" %02d ", selection[i]);
      }
    }
    System.out.println();
  }

  
  private void generateFooter() 
  {
    long calcOdd = calculateOdds();
    System.out.printf("\nOdds of winning: 1 in <<%,d>>\n", calcOdd);

    System.out.println("----- (c) " + VENDOR + " -------\n-------------------------------------");
  }

  //Odds of winning
  private long calculateOdds() 
  {
    long sequencesProduct = 1;
    long sequencesProductTwo = 1;
    long poolsProduct = 1;
    long poolsProductTwo = 1;

    for (int i = 1; i <= selection1_count; i++) 
    {
      sequencesProduct *= i;
    }
    for (int j = Pool_Size_One_Selection; j > (Pool_Size_One_Selection - selection1_count); j--) 
    {
      poolsProduct *= j;
    }

    if (selection2_count > 0) {
      for (int k = 1; k <= selection2_count; k++) 
      {
        sequencesProductTwo *= k;
      }
      for (int l = Pool_Size_Two_Selection; l > (Pool_Size_Two_Selection - selection2_count); l--) 
      {
        poolsProductTwo *= l;
      }
    }

    return (poolsProduct * poolsProductTwo) / (sequencesProduct * sequencesProductTwo);
  }

  public static void main(String[] args) throws QuickPickerException 
  {

    int num_games = DEFAULT_GAME_COUNT;
    

    if (args.length > 0) 
    {
    	FILE_NAME_PROPERTIES = args[0];
    }
    if (args.length > 1) 
    {
    	num_games = Integer.parseInt(args[1]);
    }
    
    try {
      QuickPicker lotto = new QuickPicker(num_games);
      lotto.showTicket();
    } catch (Exception e) 
    {
      throw new QuickPickerException("Can't find: " + FILE_NAME_PROPERTIES, QuickPickerException.FILENAME_ERROR);
    }

  }

}