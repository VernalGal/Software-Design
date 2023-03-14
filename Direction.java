/**
 * Partially completed Direction ENUM 
 */

package edu.cuny.csi.csc330.lab5;

import edu.cuny.csi.csc330.util.Randomizer;


public enum Direction {
	 NORTH, EAST, SOUTH, WEST, SOUTHEAST, SOUTHWEST, NORTHWEST, NORTHEAST ;
	 // !!! Add 4 more Direction Values - NORTHEAST, NORTHWEST, SOUTHWEST, SOUTHEAST
	 
	 // methods 
	 public Direction getFavorite() {
		 return SOUTH;  // It's getting cold! ... 
	 }
	 
	 public static Direction getNextRandom() {
		 	
		 	/******************************
		 	 * !!!!!
		 	 * WHAT CHANGES NEED TO BE MADE HERE SO THAT THE 4 NEW RANDOM DIRECTIONS ARE CONSIDERED 
		 	 */
			int direction = Randomizer.generateInt(1, 8); 
		
			// 1 = south,  2 = west, 3 = north, 4 = east, 5 = southeast, 6 = southwest, 7 = northwest, 8 = northeast
			if(direction == 1) { // south 
				 return SOUTH;
			}
			else if(direction == 2) {   // west 
				 return WEST; 
			}
			else if(direction == 3) {   // north 
				 return NORTH; 
			}
			else if(direction == 4){    // east 
				return EAST; 
			}
			else if(direction == 5) {   // southeast 
				 return SOUTHEAST; 
			}
			else if(direction == 6) {   // southwest 
				 return SOUTHWEST; 
			}
			else if(direction == 7) {   // northwest 
				 return NORTHWEST; 
			}
			else {  					// northeast 
				 return NORTHEAST; 
			}
	 }
	 
	 public static void main(String [] args)  {
		 
		 int c = 0; 
		 while(c++ < 100) {  
			 System.out.println(Direction.getNextRandom() );
		 }
		 
	 }
	 
	 
}
