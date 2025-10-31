package Activity11;
import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard11 extends Board11 {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard11() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if (selectedCards.size() == 2) {
			return findPairSum11(selectedCards).size() > 0;
		} else if (selectedCards.size() == 3) {
			return findJQK(selectedCards).size() > 0;
		} else {
			return false;
		}
	}

	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> cIndexes = cardIndexes();
		return findPairSum11(cIndexes).size() > 0 || findJQK(cIndexes).size() > 0;
	}

	private List<Integer> findPairSum11(List<Integer> selectedCards) {
		List<Integer> result = new ArrayList<>();
		for (int sk1 = 0; sk1 < selectedCards.size(); sk1++) {
			int k1 = selectedCards.get(sk1).intValue();
			for (int sk2 = sk1 + 1; sk2 < selectedCards.size(); sk2++) {
				int k2 = selectedCards.get(sk2).intValue();
				if (cardAt(k1).pointValue() + cardAt(k2).pointValue() == 11) {
					result.add(k1);
					result.add(k2);
					return result;
				}
			}
		}
		return result;
	}

	private List<Integer> findJQK(List<Integer> selectedCards) {
		List<Integer> result = new ArrayList<>();
		boolean foundJack = false;
		boolean foundQueen = false;
		boolean foundKing = false;
		int jackIndex = -1, queenIndex = -1, kingIndex = -1;
		for (Integer kObj : selectedCards) {
			int k = kObj.intValue();
			String rank = cardAt(k).rank();
			if (!foundJack && rank.equals("jack")) {
				foundJack = true;
				jackIndex = k;
			} else if (!foundQueen && rank.equals("queen")) {
				foundQueen = true;
				queenIndex = k;
			} else if (!foundKing && rank.equals("king")) {
				foundKing = true;
				kingIndex = k;
			}
		}
		if (foundJack && foundQueen && foundKing) {
			result.add(jackIndex);
			result.add(queenIndex);
			result.add(kingIndex);
		}
		return result;
	}

	public boolean playIfPossible() {
		if (playPairSum11IfPossible()) {
			return true;
		} else if (playJQKIfPossible()) {
			return true;
		}
		return false;
	}

	private boolean playPairSum11IfPossible() {
		List<Integer> indexes = findPairSum11(cardIndexes());
		if (indexes.size() > 0) {
			replaceSelectedCards(indexes);
			return true;
		}
		return false;
	}

	private boolean playJQKIfPossible() {
		List<Integer> indexes = findJQK(cardIndexes());
		if (indexes.size() > 0) {
			replaceSelectedCards(indexes);
			return true;
		}
		return false;
	}
}
