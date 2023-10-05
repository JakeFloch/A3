/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Jake Floch
*/
public class CardTable<T, E extends GeneralPlayer<T>> implements Table<T, E> {
    private final CardSet[] places = new CardSet[NUMBER_OF_PLACES]; //of length NUMBER OF PLACES holding the cards at each place on the table
    private int current_place; // the index of the current place in the gameplay

    public CardTable() { //Default Constructor
        current_place = 0;
        Card tempCard = new Card(0, -1); //0 * 100 + (-1) = -1
        for (int i = 0; i < NUMBER_OF_PLACES; i++) {
            places[i] = new CardSet(); //Creates card sets for each place on the board
            places[i].addCard(tempCard); //adds a temporary card to prevent NullPointerException
        }
    }

    //returns (as int[]) the identifiers of the top card at each place on the table
    public int[] getPlaces() {
        int[] retArray = new int[NUMBER_OF_PLACES];
        for (int i = 0; i < NUMBER_OF_PLACES; i++) {
            retArray[i] = places[i].getTopCard().identifier;
        }
        return retArray;
    }
    /*implements the game play for the given player; this method should (1) get the
    played card from the player’s hand, (2) add the played card to the current place on the table,
    (3) determine if there is a match in rank between the played card and any of the other cards
    already on the table; if so, put both cards in the player’s bank and give the player a point,
    (4) update the current place on the table to the next place, and (5) set the player’s turn to false.
    */

    public void takeTurn(E player) {
        Card thisPlayersTopCard = (Card) player.play();
        places[current_place].addCard(thisPlayersTopCard);
        for (int i = 1; i < NUMBER_OF_PLACES; i++) {
            int n = (current_place + i) % NUMBER_OF_PLACES;
            if (places[n].getTopCard().getRank() == thisPlayersTopCard.getRank()) {
                ((CardPlayer) player).bank.addCard(places[n].getTopCard());
                places[current_place].removeTopCard();
                places[n].removeTopCard();
                ((CardPlayer) player).setPoints(((CardPlayer) player).getPoints() + 1);
            }
        }
        ((CardPlayer) player).setTurn(false);
        current_place = (current_place + 1) % NUMBER_OF_PLACES;
    }
}

