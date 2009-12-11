
public class Nim {  // main class which contains the main function


	
	public static void main(String[] args) { // main function, which starts the game
		
		int gamemode;
		Game peli = new Game();
		
		System.out.println("Nim v.0.03 - 11.12.2009");
		System.out.println("-----------------------");
		System.out.println("Valitse pelimuoto:");
		System.out.println("1 = Normaali, 2 = Misére");
		
		
		//UI ui = new UI();
		
		gamemode = peli.gameChoice();
		peli.randomizeStacks();
		peli.start();
		
	}//main
}//Nim
