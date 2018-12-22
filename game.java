package Assignmet3;

import java.util.*;

/**
 * contains a game board and two players, playerX and playerO. It manages the iteration with the players.
 *  First by getting the player names, does a coin toss to decide the turn and allows each player to take a turn 
 *  and make a move. It finally announces the winner/draw when the game ends.
 * @author admin Aman Patel
 *
 */

public class game implements Global{

	board gameBoard = new board();		// creating a instance of board
	player playerX;						// This player places X in the block
	player playerO;						// This player places O in the block
	int turns;				

	
	Scanner sc = new Scanner(System.in);
	
	public void start() {
		
		System.out.println("--------------------------------------------------");
		System.out.println("                  TIC TAC TOE ");
		System.out.println("--------------------------------------------------");
		
		while(true) 
		{
		boolean flag =true;
				
		System.out.println("[1] Player vs Palyer [2] Player vs AI");
		
		int n = sc.nextInt();// taking the players answer
		
		
		switch(n)
		{
		case 1:
			System.out.println("Enter player 1 name: ");
			String Name1= sc.next();
			System.out.println("Enter player 2 name: ");
			String Name2= sc.next();
			

			playerX = new HumanPlayer(Name1 , X);	// creating object of type player with name stored in Name1 and symbol X
			playerO = new HumanPlayer(Name2 , O);	// creating object of type player with name stored in Name2 and symbol O

			break;
		case 2:
			System.out.println("Enter your name: ");
			String Name3= sc.next();
		
			playerX = new HumanPlayer(Name3 , X);	// creating object of type player with name stored in Name3 and symbol X
			playerO = new AIplayer("COMPUTER" , O);		//This is the computer.(AI)
			
			break;
			default:
				System.out.println("Invalid Input.");
				flag = false;
			
		}
	
		if(flag == false) continue;		// checking if user inputs other than 1 or 2 
		else 
			break;
		}
	
	//coin toss:
	
	Random rn = new Random();
	int TossWinner = rn.nextInt(2);
	if(TossWinner == X) {
		System.out.println(playerX.getName()+" !!Won the toss and will make move first");
		
		/* iterative moves depending on who wins the toss*/
		for(int i =1; i<=9; i++)
		{
			if(i%2 != 0)	
				playerXturn();
			else 
				playerOturn();			
		}
		
	}
	else if(TossWinner == O) {
		System.out.println(playerO.getName()+" Won the toss and will make move first");
		
		/* iterative moves depending on who wins the toss*/
		for(int i =1; i<=9; i++)
		{
			if(i%2 != 0)
				playerOturn();
			else 
				playerXturn();			
		}
		
	}
		
	}
	/**
	 * This method makes the move for playerX and checks if anyone wins after the move
	 */
	 private void playerXturn ()
	   {
	
			playerX.play();
			if(playerX.CheckWin() == O || playerX.CheckWin() == X || playerX.CheckWin() == DRAW)
			//if(((HumanPlayer)playerX).CheckWin() == O || ((HumanPlayer)playerX).CheckWin() == X || ((HumanPlayer)playerX).CheckWin() == DRAW)
			{
				if(((HumanPlayer)playerX).CheckWin() == O)
				{
					System.out.println(playerX.tostring());
					System.out.println(playerO.getName()+" Winns the game!!");
					System.out.println("GAME OVER");
					System.exit(0);
				}
				else if(((HumanPlayer)playerX).CheckWin() == X)
				{
					System.out.println(playerX.tostring());
					System.out.println(playerX.getName()+" Winns the game!!");
					System.out.println("GAME OVER");
					System.exit(0);
				}
				else if(((HumanPlayer)playerX).CheckWin() == DRAW)
				{
					System.out.println(playerX.tostring());
					System.out.println("ITS A DRAW");
					System.out.println("GAME OVER");
					System.exit(0);
				}
				
			}
	   }

	 /**
	 * This method makes the move for playerX and checks if anyone wins after the move
	 */
	 private void playerOturn ()
	   {
		
			playerO.play();
			
		
			if(playerO.CheckWin() == O || playerO.CheckWin() == X || playerX.CheckWin() == DRAW)
			{
				if (playerX.CheckWin() == O)
				{
					System.out.println(playerO.tostring());
					System.out.println(playerO.getName()+" Winns the game!!");
					System.out.println("GAME OVER");
					System.exit(0);
				}
				else if(playerO.CheckWin() == X)
				{
					System.out.println(playerO.tostring());
					System.out.println(playerX.getName()+" Winns the game!!");
					System.out.println("GAME OVER");
					System.exit(0);
				}
				else if(playerO.CheckWin() == DRAW)
				{
					System.out.println(playerO.tostring());
					System.out.println("ITS A DRAW");
					System.out.println("GAME OVER");
					System.exit(0);
				}
				
			}
	   }
	
}
