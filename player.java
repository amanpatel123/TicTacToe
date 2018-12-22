package Assignmet3;

/**
 *  player.java is an abstract class that maintains a design that every player has a symbol (X or O), a name, 
 *  and an abstract play(board gameboard) method. 
 *  It also maintains a reference to the game board for players to examine and make their move.
 * @author Aman Patel
 *
 */
public abstract class player implements Global {

	public static board gameBoard = new board();	// Instantiating the game board common to all the objects of type player
	static int checkWin = EMPTY;	// Shared by all the object of type player
	private int symbol;
	private String name;
	
	/**
	 * 
	 * @param Name: name of the player
	 * @param Symbol: the symbol of the player
	 */
	public player(String Name ,int Symbol)
	{
		setName(Name);
		setSymbol(Symbol);
	}
	
	/**
	 * sets the name of the 
	 * @param Name
	 */
	public void setName(String Name)
	{
		if(isValidName(Name))
			name = Name;
	}
	
	/** 
	 * @param Name: Name entered by the user
	 * @return: true if it is empty
	 */
	public boolean isValidName(String Name)
	{
		return(Name.length() > 0);
	}
	
	/**
	 * @return: name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @param S: symbol of the player;
	 */
	public void setSymbol(int S)
	{
		if(isValidSymbol(S))
			symbol = S;
	}
	
	/**
	 * @return: symbol of player(X or Y)
	 */
	public int getSymbol()
	{
		return symbol;
	}
	
	/**
	 * 
	 * @param S: symbol whose validity is to be checked
	 * @return true if is it is X or O.
	 */
	private boolean isValidSymbol(int S)
	{
		return(S == X || S == O);
	}
	
	/** 
	 * @return: display the gameboard
	 */
	public String tostring()
	{
		return gameBoard.dispayBoard();
	}
	
	// abstract methods which is to be is to be implemented in children class
		public abstract void play(); 
		public abstract int CheckWin();
	
	
}
