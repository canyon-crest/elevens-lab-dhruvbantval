package Activity1;
/**
 * This is a class that tests the Card class.
 */
public class CardTester1 {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card1 card1 = new Card1("king", "diamond", 13);
		Card1 card2 = new Card1("queen", "clover", 12);
		Card1 card3 = new Card1("10", "hearts", 10);
		System.out.println(card1.rank());
		System.out.println(card2.getClass());
		System.out.println(card3.pointValue());
		System.out.println(card1.equals(card1));

	}
}
