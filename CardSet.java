/**
 * A class that represents a set of playing cards.
 */
public class CardSet {
    /**
     * The maximum number of cards that can be in the set.
     */
    private final int MAX_CARDS;
    /**
     * The current number of cards in the set. Used to index into the set array.
     */
    private int num_cards;
    /**
     * Stores the cards in the set.
     */
    private final Card[] set;

    /**
     * Creates a new CardSet with default maximum size 52 (a  full deck).
     * The set is initially empty.
     */
    public CardSet(){
        MAX_CARDS = 52;
        num_cards = 0;
        set = new Card[MAX_CARDS];
    }

    /**
     * Creates a new CardSet with given maximum size.
     * The set is initially empty.
     *
     * @param max_cards The maximum number of cards in the set.
     */
    public CardSet(int max_cards){
        MAX_CARDS = max_cards;
        num_cards = 0;
        set = new Card[MAX_CARDS];
    }

    /**
     * Gets the current number of cards in the set.
     *
     * @return The number of cards in the set.
     */
    public int getNumCards(){
        return num_cards;
    }

    /**
     * Adds the current card to the (top) of the set.
     *
     * @param c The Card to add to the set.
     */
    public void addCard(Card c){
        set[num_cards++] = c;
    }

    /**
     * Removes and returns the top card from the set.
     *
     * @return The top Card.
     */
    public Card removeTopCard(){
        if(num_cards == 0){
            return null;
        }
        return set[--num_cards];
    }

    /**
     * Gets (without removing) the top card of the set.
     *
     * @return The top card.
     */
    public Card getTopCard(){
        if(num_cards == 0){
            return null;
        }
        return set[num_cards-1];
    }

    /**
     * Builds a String the lists all of the cards in the set.
     *
     * @return String listing all cards in the set.
     */
    public String setToString(){
        String ret = "";
        for(int i=0; i<num_cards; i++){
            ret += (set[i].identifier + ", ");
        }
        return ret.substring(0, ret.length()-2);
    }
}
