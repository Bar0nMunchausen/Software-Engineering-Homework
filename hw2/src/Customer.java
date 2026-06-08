/**
 * Represents the Customer class.
 * Has properties like name, id, rentedMovies (array of instances).
 * Handles the basic construction method, rent and return movie methods, helper methods
 */
public class Customer {
    private String name;
    private String  id;
    private Movie[] rentedMovies;

    private static final int MAX = 5;

    public Customer(String name, String id){
        this.name = name;
        this.id = id;
        this.rentedMovies = new Movie[MAX];
    }
    /**
     * Checks whether the customer doesn't have any movies rented.
     *
     * @return True if no movie was rented by this customer. False otherwise.
     */
    public boolean isEmpty(){
        for (int i = 0; i < MAX; i++){
            if (rentedMovies[i] != null){
                return false;
            }
        }
        return true;
    }

    /**
     * Processes the rent of the movie by this customer.
     * Checks for an empty movie address. If found, adds the movie to that address and returns true.
     * Otherwise, returns false as the movie wasn't rented.
     *
     * @param movie     The movie instance that is wanted rented.
     * @return True if succeeded to rent the movie. False otherwise.
     */
    public boolean rentMovie(Movie movie){
        for (int i = 0; i < MAX; i++){
            if (rentedMovies[i] == null){
                rentedMovies[i] = movie;
                return true;
            }
        }
        return false;
    }

    /**
     * Processes the return of the movie by this customer.
     * Tries to find the movie that wanted to be returned and if found, then the address is emptied.
     *
     * @param movie     The instance of the movie that wanted to be returned.
     * @return True if succeeded to return the movie. False otherwise.
     */
    public boolean returnMovie(Movie movie){
        for (int i = 0; i < MAX; i++){
            if (rentedMovies[i] != null && rentedMovies[i].equals(movie)){
                rentedMovies[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the customer is renting a given movie.
     *
     * @param movie     The instance of the movie that is being checked.
     * @return True if the movie is being rented. False otherwise.
     */
    public boolean isRenting(Movie movie){
        for (int i = 0; i < MAX; i++){
            if (rentedMovies[i] != null && rentedMovies[i].equals(movie)){
                return true;
            }
        }
        return false;
    }

    public boolean equals(String otherID){
        return this.id.equals(otherID);
    }

}
