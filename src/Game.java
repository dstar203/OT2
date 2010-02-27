

import java.util.ArrayList; // Import libraries
import java.util.Random;
import java.util.Stack;
import java.util.Scanner;

/**
 * Everything behind the interface, separate thread for game.
 */
public class Game extends Thread {
	
	private int stacks;
	private int gamemode;
	private int aimode;
	private int turn;
	private Scanner scanner;
	private String inputBuffer;
	private ConsoleUI ui;
	ArrayList<Stack<String>> stackarray;
	
	Random rand;
	
	/**
	 * Game object constructor, sets up random amount of stacks and random AI player (dumb/intelligent)
	 * 
	 * @param mode Game mode, Normal or Misére
	 */
	
	public Game(int mode) {
	
		scanner = new Scanner(System.in); // User input reader
		stackarray = new ArrayList<Stack<String>>(10); // Array for storing n number of stacks
		rand = new Random(); // Random generator
		stacks = rand.nextInt(5) + 2; // Random number of stacks, min 2, max 7
		aimode = rand.nextInt(1) + 1; // Random AI player profile (options 1,2)
		aimode = 1; //REMOVE WHEN INTELLIGENT AI IS DONE
		turn = 1;
		this.gamemode = mode;
		ui = new ConsoleUI();
	}
	/**
	 * User input reader
	 * 
	 * @return Read string from input is returned
	 */
	public String readInput() { 

		inputBuffer = scanner.next();
		
		//inputBuffer.trim();
		
		return inputBuffer;
	}
	
	/**
	 *  Shuffle the stacks to have random rumber of objects 
	 */
	public void randomizeStacks() { 
		
		for(int i = 0; i<stacks; i++) { 
			
			Stack<String> p = new Stack<String>();
			
			for(int h = 0; h<rand.nextInt(6)+2; h++) { /* Min 2, Max 8 objects in Stacks */
				p.push("O");
			}
			
			stackarray.add(p);
		}
		
	}
	 /**
	  *  Prints all NIM stacks to the screen
	  */
	public void printStacks() {
		
		int i;
		int h;
		String stackBuffer = "";
		char[] letters = {'a' ,'b','c','d','e','f','g','h','i','j','k'};
		
	//		for(int j = stackarray.size()-1; j>=0; j--) {
	//			ui.println(stackarray.get(j));
	//		}//for

		
		for(i=10; i>=0; i--) {
			stackBuffer = ""; // Empty buffer 
			
			for(h=0; h<= stackarray.size()-1; h++) {
				if(stackarray.get(h).size() > i) {
					stackBuffer += "O ";
				}
				else {
					stackBuffer += "  ";
				}
			}
			if(stackBuffer.contains("O ")) {
				ui.println(stackBuffer);
			} 
		}
		for(h=0; h<=stackarray.size()-1; h++) {
			ui.print(letters[h]+ " ");
		}
		ui.println("");


	}
	/**
	 * Removes an object from stack if there is any
	 * 
	 * @param n Number of stack to be popped
	 */
	public void popStack(int n) { 
		
		if(stackarray.get(n).size() > 0) {
			stackarray.get(n).pop();
		}
	}
	/**
	 * Lets user remove objects from stacks, disallows removing objects from multiple stacks at once.
	 * Checks if user has lost after his/her turn
	 */
	public void userTurn() {
		
		boolean flag = false;
		boolean selected = false;
		int selectedstack = -1;
		String buffer;

		
		while(flag != true) {
			
			ui.println("Turn " + turn);
			ui.println("-------");
			printStacks();
			buffer = readInput();
			
			if(buffer.equals("a") && (selected == false || selectedstack == 0)) {
				popStack(0);
				selected = true;
				selectedstack = 0;
			}
			else if(buffer.equals("b") && (selected == false || selectedstack == 1 )) {
				popStack(1);
				selected = true;
				selectedstack = 1;
			}
			else if(buffer.equals("c") && (selected == false || selectedstack == 2)) {
				popStack(2);
				selected = true;
				selectedstack = 2;
			}
			else if(buffer.equals("d") && (selected == false || selectedstack == 3)) {
				popStack(3);
				selected = true;
				selectedstack = 3;
			}
			else if(buffer.equals("e") && (selected == false || selectedstack == 4)) {
				popStack(4);
				selected = true;
				selectedstack = 4;	
			}
			else if(buffer.equals("f") && (selected == false || selectedstack == 5)) {
				popStack(5);
				selected = true;
				selectedstack = 5;	
			}
			else if(buffer.equals("g") && (selected == false || selectedstack == 6)) {
				popStack(6);
				selected = true;
				selectedstack = 6;	
			}
			else if(buffer.equals("exit")) {
				System.exit(0);
			}
			else if(buffer.equals("turn") && (selected == true || turn == 1)) {
				flag = true;
				if(turn == 1) { // Turn correction if computer begins
					turn = 0;
				}
			}
			
			if(checkWin() == 1) { // If user has lost the game during his turn
				flag = true;
			}
		}
		
	}
	/**
	 *  Game AI, both random and intelligent AI implemented.
	 *  
	 *  Random AI (aimode = 1) removes random amount of objects from stack each turn, and keeps no track of game progress.
	 *  
	 *  Intelligent AI (aimode = 2) ... to be written here
	 */
	public void aiTurn() { 
		
		if(aimode == 1) { // Random ai
		
		
			boolean empty = true;
			int randomstack = 0;
			int randomamount = 1;
		
			while(empty == true) { // search for random stack as long as nonempty stack is found
				randomstack = rand.nextInt(stackarray.size()); // random stack
			
				if(stackarray.get(randomstack).size() > 0) {
					empty = false;
				}
			}
		
			randomamount = rand.nextInt(stackarray.get(randomstack).size()) +1; // random amount, 1 - stacksize
		
			for(int i=0; i<randomamount; i++) {
				popStack(randomstack);
			}
		}
		else if(aimode == 2) { // Intelligent AI
			ui.println("Not implemented");
		}
		
		
	}
	
	/**
	 * Determines if user or computer has lost/won the game
	 * 
	 * @return Returns 1 if game has been lost, 2 for win and 0 for game continues.
	 */
	public int checkWin() {
		
		if(gamemode == 1) { // Normal game
			
			int empty = 0; //Number of empty stacks
			int hasOne = 0; //Number of stacks with one object
		
			for(int i=0; i<stacks; i++) { // Analyze stacks
				if(stackarray.get(i).size() == 0) {
					empty++;
				}
				else if(stackarray.get(i).size() == 1) {
						hasOne++;
				}
			}
		
			if(empty == stacks-1 && hasOne == 1) { // If all but one stack is empty and the stack has one, the next player has lost
				return 2;
			}
			else if(empty == stacks) { // If all stacks are empty, current player has lost
				return 1;
			}
			else {
				return 0; // Else, the game continues
			}
		}
		else { // Misere game
			int empty = 0;
			
			for(int i=0; i<stacks; i++) {
				if(stackarray.get(i).size() == 0) {
					empty++;
				}	
			}
		
			if(empty == stacks) { // If all stacks all empty, return 1
				return 1;
			}
			else {
				return 0; // Else, the game continues
			}
			
		}
	}
	/**
	 * Print highscores to screen and update them to a file
	 * TBD:
	 * 
	 */
	public void updateScores(int result) {
		//TBD
		ui.endGame();
	}
	
	/**
	 * Game thread, gives turns to user and AI
	 */
	public void run() { //thread
	
		while(!this.isInterrupted()) {
			
			userTurn();
			
			if(checkWin() == 1) {
				ui.println("You have lost.");
				updateScores(1);
			}
			else if(checkWin() == 2) {
				ui.println("You have won!");
				updateScores(2);
				
			}
			
			turn++;
			
			aiTurn();
			
			if(checkWin() == 1) {
				ui.println("You have won.");
				updateScores(1);
			}
			else if(checkWin() == 2) {
				ui.println("You have lost.");
				updateScores(2);
			}
			
			turn++;
			
			//printStacks();
			//aiTurn();

		}
	}

}