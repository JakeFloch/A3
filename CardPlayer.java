/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Jake Floch
*/
public class CardPlayer<Card> extends GeneralPlayer<Card> {
    private int points; //the number of points the player has earned in the game
    private boolean turn; //true if it is this player’s turn

    private final CardSet hand = new CardSet(); // the cards this player has in their hand to be played
    public CardSet bank = new CardSet(); //the (public) set of matching cards the player has earned during gameplay

    public CardPlayer() { // Default Constructor
        super();
        points = 0;
        turn = false;
    }

    public CardPlayer(String playerName) { //String Constructor
        super(playerName);
        points = 0;
        turn = false;
    }
    public int getPoints() {
        return points;
    } //returns the number of points the player has earned

    public void setPoints(int p) {points = p;} //sets the number of points the player has earned to the given value

    public Boolean isTurn() {return turn;} //returns true if it is the player’s turn

    public void setTurn(Boolean t) {turn = t;} //sets the player’s turn to the given boolean value

    public CardSet getHand() {return hand;} //returns the CardSet representing the player’s hand

    public <Card> void addToHand(Card c) {
        hand.addCard(c);
    }

    //adds the given card to the player’s hand

    public String handToString() {return name + " has " + hand.getNumCards() + " cards in the bank: " + hand.setToString();} //returns a String representation of the player’s hand including the name of the player, number of cards, and the identifiers of all cards in the hand

    public String bankToString() {return name + " has " + bank.getNumCards() + " cards in the bank: " + bank.setToString();} // returns a String representation of the player’s bank including the name of the player, number of cards, and the identifiers of all cards in the hand

    public Card play() { //returns the Card played from the player’s hand (and removes the played card from the hand)
        Card temp = (Card) hand.getTopCard();
        hand.removeTopCard();
        return temp;
    }
}
