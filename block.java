package Assignmet3;
/**
 *  Block is the abstraction of basic building element of the board. It implements Global interface 
 * @author Aman Patel
 *
 */
public class block implements Global{
	
	/**
	 * We have 3 States of the block:
	 * X: 1
	 * Y:0
	 * Empty: neither X or Y(-1)
	 */
	public int State;
	
	// default constructor 
	public block()
	{
		State = EMPTY;
	}
	
	/**
	 *  Parameterized Constructor
	 *  Notice we are not calling the this() here because 
	 *  I wont allow any player to enter any invalid State at the First place so no need of this()*/
	public block(int a)
	{
		setState(a);
	}
	
	/**
	 * 
	 * @param State: Sets the State of the block depending on who makes a move
	 */
	public void setState(int State)	
	{
		if(isValidState(State))
			this.State = State;
	}
	
	/**
	 * 
	 * @param State
	 * @return true if the state is valid
	 */
	public boolean isValidState(int State)	
	{
		return (State == O || State == X || State == EMPTY);
	}
	
	/**
	 * 
	 * @return : Current state of the bock
	 */
	public int getState()
	{
		return State;
	}
	
	/**
	 * Displays the State of the block in string form
	 */
	public String toString()
	{
		if(State == X)
			return "X";
		else if(State == O)
			return "O";
		else 
			return "?";	// put blank after words;
		
	}

}
