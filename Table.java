/**
 * An interface representing a table where cards are played and players can
 * occupy places.
 *
 * @param <T> the type of objects that can be added to the table.
 * @param <E> the type of players that can occupy places on the table.
 */
public interface Table<T, E extends GeneralPlayer<T>> {

	/**
	 * The number of places on the table that players can put their cards.
	 */
    int NUMBER_OF_PLACES = 4;

	/**
     * Returns the identifiers of the objects on places 1, 2, 3, and 4 on the table
     * (in that same order). 
     * 
     * @return an array of integers representing the identifiers of all objects placed on the table
     */
    int[] getPlaces();

	/**
	 * Takes a turn for the given player.
	 *
	 * @param player the player to take a turn.
	 */
    void takeTurn(E player);

}
