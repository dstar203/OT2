/**
 * 
 * Game starter class
 *
 */
public class Start {

	private int mode;
	ConsoleUI ui;
	/**
	 * Class constructor
	 */
	public Start() {
		mode = 1; // default normal game
		ui = new ConsoleUI();
	}
	
	

	public void begin() {
		ui.println("Choose gamemode:");
		ui.println("1 = Normal, 2 = Misére");
		
		mode = ui.gameChoice(); // Select game mode, default = 1 
		Game peli = new Game(mode);
		peli.randomizeStacks(); // Shuffle stacks
		peli.start(); // Start game thread
		
	}


}
