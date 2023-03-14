package edu.cuny.csi.csc330.lab7;


import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HangMan 
{


private static List<String> answers = new ArrayList<String>(); //creates list for Words.txt
private static int lengthTest; //gets length of list
private static int count = 0; // for <6 loop
private static String random_word; //gets random word from list
private static String hidden_word; //makes the word not visible

  public static String[] guessed = new String[6];
  public static String guessed_incorrect; 



public static void main(String[] args) throws HangManException 
{
  
      String fileName = "C:/Users/17183/Desktop/Words.txt"; //Words file location 
      String line = null;
      try 
      {
        
    	  FileReader fileAnalyzer = 
              new FileReader(fileName);

          // warp fileAnalyzer in bufferedReader
          BufferedReader buffered_read = new BufferedReader(fileAnalyzer);

          while((line = buffered_read.readLine()) != null) 
          {
        	  answers.add(line);
          }   

   
          buffered_read.close();         
      }
      catch(FileNotFoundException ex) 
      {
          System.out.println(
              "Can't Find File '" + 
              fileName + "'");                
      }
      catch(IOException ex) 
      {
          System.out.println(
              "Can't Read File '" 
              + fileName + "'");                  
      }
      
      
      
      
     lengthTest = answers.size(); //list length
     random_word = answers.get((int) (Math.random() * lengthTest)); //random word from text file
     hidden_word = new String(new char[random_word.length()]).replace("\0", "_"); //letters of the word get replaced with "_"

     
     
      
  Scanner sc = new Scanner(System.in);

  while (count < 6 && hidden_word.contains("_")) 
  {
    try 
    {
      
      System.out.println("Input any letter of the alphabet");
      char[] letters = hidden_word.toCharArray(); 
        for(int i = 0; i < letters.length; i++)
        {
          System.out.format("%2c", letters[i]);
        }
        System.out.printf(System.lineSeparator());
      String guesses = sc.next(); //reads user input
      guessed_incorrect = guesses;
      hang(guesses);        
    }
    catch (HangManException tester) { //exception caught from count of 6
      
      System.err.println(tester); //exception printed
    }

  }
  sc.close();
}

public static void hang(String guess) throws HangManException 
{
  String newasterisk = "";
  for (int i = 0; i < random_word.length(); i++) 
  {
    if (random_word.charAt(i) == guess.charAt(0)) 
    {
      newasterisk += guess.charAt(0);
    } 
    else if (hidden_word.charAt(i) != '_') 
    {
      newasterisk += random_word.charAt(i);
    } 
    else 
    {
      newasterisk += "_";
    }
  }

  if (hidden_word.equals(newasterisk)) 
  {
	  guessed[count] = guessed_incorrect;
    count++;
    hangmanImage();
  } else {
	  hidden_word = newasterisk;
  }
  if (hidden_word.equals(random_word)) 
  {
    System.out.println("Correct! You win! The word was " + random_word);
  }
}
public static void hangmanImage() throws HangManException 
{
  if (count == 1) 
  {
    System.out.println("Wrong letter, try again");
    System.out.println("__________");
    System.out.println("|   |");
    System.out.println("|   |");
    System.out.println("|   O");
    System.out.println("|  ");
    System.out.println("|  ");
    System.out.println("|_____________");
  }
  if (count == 2) 
  {
    System.out.println("Wrong letter, try again");
    System.out.println("__________");
    System.out.println("|   |");
    System.out.println("|   |");
    System.out.println("|   O");
    System.out.println("|  /");
    System.out.println("|  ");
    System.out.println("|_____________");
  }
  if (count == 3) 
  {
    System.out.println("Wrong letter, try again");
    System.out.println("__________");
    System.out.println("|   |");
    System.out.println("|   |");
    System.out.println("|   O");
    System.out.println("|  /|");
    System.out.println("|");
    System.out.println("|_____________");
  }
  if (count == 4) 
  {
    System.out.println("Wrong letter, try again");
    System.out.println("__________");
    System.out.println("|   |");
    System.out.println("|   |");
    System.out.println("|   O");
    System.out.println("|  /|\\ ");
    System.out.println("|");
    System.out.println("|_____________");
  }
  if (count == 5) 
  {
    System.out.println("Wrong letter, try again");
    System.out.println("__________");
    System.out.println("|   |");
    System.out.println("|   |");
    System.out.println("|   O");
    System.out.println("|  /|\\ ");
    System.out.println("|  /");
    System.out.println("|_____________");
  }
  if (count == 6) 
  {
    
    System.out.println("Wrong Guesses: ");
    
    for (int i = 0; i < 6; i++)
    {
      System.out.printf("%2s", guessed[i]);
    }
    
    System.out.println("\n The answer was " + random_word);
    
    throw new HangManException(null); //exception thrown to main
    

  }
}




}