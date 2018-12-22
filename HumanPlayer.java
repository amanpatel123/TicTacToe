package Assignmet3;
import java.util.*;
/**
 * - HumanPlayer.java extends player, a type of
 *  player that requests its input from the user and 
 *  submit the move (or play) to the gameboard.
 *  @author Aman Patel
 */
public class HumanPlayer extends player{
	
	// parameterized constructor
	public HumanPlayer(String name, int Symbol)
	{
		super(name, Symbol);
	}
	Scanner sn = new Scanner(System.in);
	
	// Implementation of play() method from parent class
	@Override
	public void play() {
		
		while(true)
		{
			System.out.println(tostring());
			System.out.println(getName()+": Enter your Move-> ");	// Gets the move from the user
			int a = sn.nextInt();
			if(!gameBoard.makeMove(a, getSymbol())) 	// if the move not successful then print invalid and ask again
			{
				System.out.println("Invalid move");
				continue;
			}
			else 
				{
					checkWin = gameBoard.updateInternalState();
					break;
				}
		}
	}
	
	// Implementation of CheckWin() method from parent class
	@Override
	public int CheckWin()
	{
		if(checkWin == DRAW)
			return DRAW;
		else if(checkWin == X)
			return X;
		else if(checkWin == O)
			return O;
		else 
			return EMPTY;	
	}
}
