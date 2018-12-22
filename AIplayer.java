package Assignmet3;

import java.util.*;
/**
 * This class is a extention of player class. It contains the logic for computer to play on its own. 
 */

public class AIplayer extends player implements Global {
	
	// parameterized constructor
	public AIplayer(String Name, int Symbol) {
		super(Name, Symbol);
	}	
	
	Scanner sn = new Scanner(System.in);
	
	// Implementation of play() method from parent class
	@Override
	public void play() {
		
		while(true)
		{
			System.out.println(tostring());
			if(!gameBoard.makeMove(makeRandomMove(), getSymbol())) 
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
	
	/**
	 * 
	 * @return: the random integer from 1-9 except those number which are already filled.
	 */
	private int makeRandomMove()
	{
		Random rn = new Random();
		int a = rn.nextInt(9)+1;
		while(true)
		{
			if(gameBoard.FilledPlaces.contains(a))
			{
				a++;
				continue;
			}
			break;
		}
		System.out.println("Computer Choose: "+a);
		return a;
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
