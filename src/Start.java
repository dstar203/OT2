import java.util.Scanner;


public class Start {

	int mode;
	Scanner scanner;
	String inputBuffer;
	
	public Start() {
		
		mode = 1; // Default mode is normal game
		scanner = new Scanner(System.in);
	}//begin
	
	public String readInput() { /* User Input Reader */

		inputBuffer = scanner.next();
		
		//inputBuffer.trim();
		
		return inputBuffer;
	}//readinput
	
	public void gameInfo() {
		System.out.println("Nim v.0.15 - 12.12.2009");
		System.out.println("-----------------------");
		System.out.println("Valitse pelimuoto:");
		System.out.println("1 = Normaali, 2 = Misére");
	}//gameinfo
	public int gameChoice() { /* Select between two game modes */
		
		if(readInput().equals("1")) {
			System.out.println("Normal game");
			mode = 1;
			}//if
		
		else if(readInput().equals("2")) {
			System.out.println("Misére game");
			mode = 2;
		}//else if
		return mode;
	}//gameChoice

}//class
