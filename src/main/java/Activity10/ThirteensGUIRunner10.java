package Activity10;
/**
 * This is a class that plays the GUI version of the Thirteens game.
 * See accompanying documents for a description of how Thirteens is played.
 */
public class ThirteensGUIRunner10 {

	/**
	 * Plays the GUI version of Thirteens.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		Board10 board = new ThirteensBoard10();
		CardGameGUI10 gui = new CardGameGUI10(board);
		gui.displayGame();
	}
}
