
public class Nim {  // main class which contains the main function

	public static void main(String[] args) { // main function, which starts the game
		
		int mode;
		
		//UI ui = new UI();
		
		Start alku = new Start(); /* Initialize start-up */
		alku.gameInfo(); /* Print info about the game */
		mode = alku.gameChoice(); /* Select game mode, default = 1 */ 
		Game peli = new Game(mode); /* Initialize game */
		peli.randomizeStacks(); /* Shuffle stacks */
		peli.start();
		
	}//main
	
}//Nim
