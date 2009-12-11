
public class Nim {  // main class which contains the main function


	
	public static void main(String[] args) { // main function, which starts the game
		
		
		System.out.println("Nim v.0.01 - 08.12.2009");
		System.out.println("-----------------------");
		
		System.out.println("1 = Normaali, 2 = Misére");
		
		Game peli = new Game();
		//UI ui = new UI();
		
		peli.gameChoice();
		peli.randomizeStacks();
		peli.start();
		
	}//main
}//Nim
