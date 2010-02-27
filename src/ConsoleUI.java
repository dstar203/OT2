

import java.util.Scanner;

/** 
 * Console UI, printing and game mode question for user.
 * Has been implemented as a separate object to accommodite possible future GUI
 */

public class ConsoleUI {

	int mode;
	Scanner scanner;
	String buffer;
	Start newGame;
	
	/**
	 * ConsoleUI object constructor
	 */
	public ConsoleUI() {
		
		mode = 1; // Default mode is normal game
		scanner = new Scanner(System.in);	
	}
	
	/**
	 * Print to console
	 * 
	 * @param printbuffer String to be printed, no linechange
	 */
	public void print(String printbuffer) {
		System.out.print(printbuffer);
	}
	
	/**
	 * Print line to console
	 * 
	 * @param printbuffer String to be printed, linechange.
	 */
	public void println(String printbuffer) {
		System.out.println(printbuffer);
	}
	/**
	 *  End current game, currently exits the game
	 */
	public void endGame() {
		System.out.println("New game (Y/N)?");
		String buffer = scanner.next();
		
		while(true) {
			
			if(buffer.equals("Y") || buffer.equals("y")) {
				System.out.println(""); // Empty line
				newGame = new Start();
				newGame.begin();
				break;
				}
			
			else if(buffer.equals("N") || buffer.equals("n")) {
				System.exit(0);
			}
		}
	}
	
	/**
	 * Selection between two game modes, normal or misére.
	 * 
	 * @return Game mode is returned.
	 */
	public int gameChoice() { /* Select between two game modes */
		
		String buffer = scanner.next();
		
		if(buffer.equals("1")) {
			System.out.println("Normal game");
			System.out.println("-----------");
			mode = 1;
			}
		
		else if(buffer.equals("2")) {
			System.out.println("Misére game");
			System.out.println("-----------");
			mode = 2;
		}
		return mode;
	}
}
