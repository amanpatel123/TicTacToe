package Assignmet3;
import java.util.*;
/**
 * - Board is class which is abstract version of the (X-O) game board.
 * @author Aman Patel
 * This class implements Global.
 */
public class board implements Global {
	
	block[][] OneBlock = new block[3][3]; // Creating array of Block Size 3X3
	public int internalState;	// Variable which Stores the State of the BOARD.
	List<Integer> FilledPlaces = new ArrayList<>();	// Creating the Array List which tracks the places which are occupied.

	/* Parameterized constructor*/
	public board()
	{
		for(int r=0;r<3;r++)
			for(int c=0;c<3;c++)
				OneBlock[r][c] = new block();
		
		internalState = EMPTY;

	}
	
	/** there should not be any parameterized constructor. Imagine someone playing a game with already X and O present on board*/
	// Should be considered if we want to continue game but I am not doing that complex//
	/**
	 * 
	 * @param a: move enterd by the player
	 * @param PlayerState: The state of the player making the move
	 * @return: true if the move is successful
	 */
	public boolean makeMove(int a, int PlayerState)
	{
		
		if(isValidMove(a))
		{
			FilledPlaces.add(a);// If place valid the add to List
			updateState(a, PlayerState);	// update state of the block.	
			return true;
		}
		else return false;
		
	}
	
	/**
	 * This method updates the state of the block by checking its current state.
	 */
	private void updateState(int a, int PlayerState)// Update the state of block
	{
	
		switch(a)
		{
		case 1:
			OneBlock[0][0].setState(PlayerState);
				break;
		case 2:
			OneBlock[0][1].setState(PlayerState);
				break;
		case 3:
			OneBlock[0][2].setState(PlayerState);
			break;
		case 4:
			OneBlock[1][0].setState(PlayerState);
			break;
		case 5:
			OneBlock[1][1].setState(PlayerState);
			break;
		case 6:
			OneBlock[1][2].setState(PlayerState);
			break;
		case 7:
			OneBlock[2][0].setState(PlayerState);
			break;
		case 8:
			OneBlock[2][1].setState(PlayerState);
			break;
		case 9:
			OneBlock[2][2].setState(PlayerState);
			break;
		}
		
	}
	
	/**
	 * 
	 * @return: returns the updated state of the BOARD
	 */
	public int updateInternalState() // Update the state of board
	{
		if(OneBlock[0][0].getState() == OneBlock[0][1].getState() && OneBlock[0][1].getState() == OneBlock[0][2].getState())
		{
			internalState = OneBlock[0][0].getState();
			return internalState;
		}
		else if(OneBlock[1][0].getState() == OneBlock[1][1].getState() && OneBlock[1][1].getState() == OneBlock[1][2].getState())
		{
			internalState = OneBlock[1][0].getState();
			return internalState;
		}
		else if(OneBlock[2][0].getState() == OneBlock[2][1].getState() && OneBlock[2][1].getState() == OneBlock[2][2].getState())
		{
			internalState = OneBlock[2][0].getState();
			return internalState;
		}
		else if(OneBlock[0][0].getState() == OneBlock[1][0].getState() && OneBlock[1][0].getState() == OneBlock[2][0].getState())
		{
			internalState = OneBlock[0][0].getState();
			return internalState;
		}
		else if(OneBlock[0][1].getState() == OneBlock[1][1].getState() && OneBlock[1][1].getState() == OneBlock[2][1].getState())
		{
			internalState = OneBlock[0][1].getState();
			return internalState;
		}
		else if(OneBlock[0][2].getState() == OneBlock[1][2].getState() && OneBlock[1][2].getState() == OneBlock[2][2].getState())
		{
			internalState = OneBlock[0][2].getState();
			return internalState;
		}
		else if(OneBlock[0][0].getState() == OneBlock[1][1].getState() && OneBlock[1][1].getState() == OneBlock[2][2].getState())
		{
			internalState = OneBlock[0][0].getState();
			return internalState;
		}
		else if(OneBlock[0][2].getState() == OneBlock[1][1].getState() && OneBlock[1][1].getState() == OneBlock[2][0].getState())
		{
			internalState = OneBlock[0][2].getState();
			return internalState;
		}
		else if(FilledPlaces.size() == 9)
		{
			internalState = DRAW;
			return internalState;
		}
		else return EMPTY;
	}
	
	/**
	 * 
	 * @return: the state of the board;
	 */
	public int getInternalState()
	{
		return internalState;
	}
	
	/**
	 * 
	 * @param a : user move
	 * @return: true if its valid. Check if that move is not present in the array list.
	 */
	private boolean isValidMove(int a)
	{	
		if(a<1 || a>9)
			return false;
		else
			return (!FilledPlaces.contains(a));
	}

	/**
	 * 
	 * @return: String which displays whole board
	 */
	public String dispayBoard()
	{
		String ABC="";
		for(int r=0;r<3;r++)
			for(int c=0;c<3;c++) {
				if(OneBlock[r][c].getState()==X || OneBlock[r][c].getState() == O)
				ABC +=(OneBlock[r][c].toString()+"|");
				else 									// case when its "?" meaning its empty.
					ABC += 3*r+1+c+"|";
				if(c == 2)
					ABC +="\n";
			}
				
		return ABC;
	}

}
