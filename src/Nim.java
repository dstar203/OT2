
/**
 *  Ohjelmointityö II - Nim.09
 *  --------------------------
 *  Tekijä Lauri Majamaa, Informaatioverkostot -07 TTK/STO
 *  Opiskelijanumero 1927867
 * 	Sähköposti laurimaj@paju.oulu.fi
 *  
 * 
 */
public class Nim {  
	
	/**
	 * Nim game main function. Initializes ui and game objects and starts the game.
	 * 
	 * @param args Command line arguments, currently not implemented.
	 */
	public static void main(String[] args) { // main function, which starts the game
		
		//UI ui = new UI(); Possible future GUI
		ConsoleUI ui = new ConsoleUI(); // Initialize ui for banner printing
		
		// Print banner
		ui.println("Nim v.0.35 - 21.2.2010");
		ui.println("-----------------------");
		
		Start newGame = new Start();
		
		newGame.begin();
		

		
	}
	
}
