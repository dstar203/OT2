/* Import libraries */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class Game extends Thread {
	
	private BufferedReader reader;
	private String inputBuffer;
	private int valinta;
	Stack<String> stack;
	Stack<String> stack2;
	Stack<String> stack3;
	Stack<String> stack4;
	ArrayList<Stack<String>> stackarray;
	Random rand;
	
	public Game() {
	
		reader = new BufferedReader(new InputStreamReader(System.in)); /* User input reader */
		stackarray = new ArrayList<Stack<String>>(10); /* Array for storing n number of stacks */
		rand = new Random(); /* Random generator */
		
	}//parseInput
	public int option() {
		return valinta;
	}//option
	
	public String readInput() { /* User Input Reader */
		/*
		try {
			reader.skip(System.in.available()); // Only allows input when user can type
		}//try
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//catch*/
		
		try {
			inputBuffer = reader.readLine();
		}//try
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//catch
		
		return inputBuffer;
	}//readinput
	
	public void gameChoice() {

		
		if(readInput().equals("1")) {
			System.out.println("Normal game");
			valinta = 1;
			}//if
		
		else if(readInput().equals("2")) {
			System.out.println("Misére game");
			valinta = 2;
		}//else if
	}//gameChoice
	
	public void randomizeStacks() {
		
		for(int i = 0; i<rand.nextInt(5)+2; i++) { /* Min 2, Max 7 Stacks generated */
			
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
	
	public void popStack(int n) {
		
		if(stackarray.get(n).size() > 0) {
			stackarray.get(n).pop();
		}//if
	}//popStack
	
	public void userTurn() {
		
		if(readInput().equals("a")) {
			popStack(0);}//if
		else if(readInput().equals("b")) {
			popStack(1); }//else if
		else if(readInput().equals("c")) {
			popStack(2);}//else if
		else if(readInput().equals("d")) {
			popStack(3);}//else if
		else if(readInput().equals("e")) {
			popStack(4);}//else if
		else if(readInput().equals("exit")) {
			System.exit(0);
		}//else if
		
	}//userTurn
	
	public void run() { //thread
	
		while(!this.isInterrupted()) {
			

			printStacks();
			userTurn();
			printStacks();
			//aiTurn();
			



		}//while
	}//run

}//class