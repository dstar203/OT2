/* Import libraries */
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.Scanner;

public class Game extends Thread {
	
	private int stacks;
	private int gamemode;
	private int aitype;
	private int turn;
	private Scanner scanner;
	private String inputBuffer;
	
	Stack<String> stack;
	Stack<String> stack2;
	Stack<String> stack3;
	Stack<String> stack4;
	
	ArrayList<Stack<String>> stackarray;
	
	Random rand;
	
	public Game(int mode) {
	
		scanner = new Scanner(System.in); /* User input reader */
		stackarray = new ArrayList<Stack<String>>(10); /* Array for storing n number of stacks */
		rand = new Random(); /* Random generator */
		stacks = rand.nextInt(5) + 2; /* Random number of stacks, min 2, max 7 */
		aitype = rand.nextInt(1) + 1; /* Random AI player profile (options 1,2) */
		turn = 1;
		this.gamemode = mode;
		
	}//parseInput
	
	public String readInput() { /* User Input Reader */

		inputBuffer = scanner.next();
		
		//inputBuffer.trim();
		
		return inputBuffer;
	}//readinput
	
	public void randomizeStacks() { /* Shuffle the stacks to have random rumber of objects */
		
		for(int i = 0; i<stacks; i++) { 
			
			Stack<String> p = new Stack<String>();
			
			for(int h = 0; h<rand.nextInt(6)+2; h++) { /* Min 2, Max 8 objects in Stacks */
				p.push("O");
			}//for
			
			stackarray.add(p);
		}//for
		
	}//randomizeStacks
	
	public void printStacks() { /* Prints all NIM stacks to the screen */
		
		int i;
		int h;
		String stackBuffer = "";
		char[] letters = {'a' ,'b','c','d','e','f','g','h','i','j','k'};
		
	//		for(int j = stackarray.size()-1; j>=0; j--) {
	//			System.out.println(stackarray.get(j));
	//		}//for

		
		for(i=10; i>=0; i--) {
			stackBuffer = ""; /* Empty buffer */
			
			for(h=0; h<= stackarray.size()-1; h++) {
				if(stackarray.get(h).size() > i) {
					stackBuffer += "O ";
				}//if
				else {
					stackBuffer += "  ";
				}//else
			}//for
			if(stackBuffer.contains("O ")) {
				System.out.println(stackBuffer);
			} //if
		}//for
		for(h=0; h<=stackarray.size()-1; h++) {
			System.out.print(letters[h]+ " ");
		}
		System.out.println(""); // Linechange


	}//printStacks
	
	public void popStack(int n) { /* Removes an object from stack if there is any */
		
		if(stackarray.get(n).size() > 0) {
			stackarray.get(n).pop();
		}//if
	}//popStack
	
	public void userTurn() { /* Lets user remove objects from stacks */
		
		boolean flag = false;
		String buffer;
		
		while(flag != true) {
			
			System.out.println("Turn " + turn);
			System.out.println("-------");
			printStacks();
			buffer = readInput();
			
			if(buffer.equals("a")) {
				popStack(0);}//if
			else if(buffer.equals("b")) {
				popStack(1); }//else if
			else if(buffer.equals("c")) {
				popStack(2);}//else if
			else if(buffer.equals("d")) {
				popStack(3);}//else if
			else if(buffer.equals("e")) {
				popStack(4);}//else if
			else if(buffer.equals("f")) {
				popStack(5);}//else if
			else if(buffer.equals("g")) {
				popStack(6);}//else if
			else if(buffer.equals("exit")) {
				System.exit(0);}//else if
			else if(buffer.equals("turn")) {
				flag = true;}//else if
			
			if(checkWin() == 1) {
				System.out.println("You have lost.");
				System.exit(0);
			}//if
		}//while
		
	}//userTurn
	
	public int checkWin() { /* Determines if user or computer has lost/won the game */	
		int empty = 0;
		
		for(int i=0; i<stacks; i++) {
			if(stackarray.get(i).size() == 0) {
				empty++;
			}//if	
		}//for
		
		if(empty == stacks) { /* If all stacks all empty, return 1 */
			return 1;
		}//if
		else {
			return 0; /* Else, the game continues */
		}//else
		
	}//checkWin
	
	public void updateScores() {
		/* Print highscores to screen and update them to a file */
		
	}//updateScores
	
	public void run() { //thread
	
		while(!this.isInterrupted()) {
			
			userTurn();
			turn++;
			//printStacks();
			//aiTurn();

		}//while
	}//run

}//class