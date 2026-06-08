/**
 * Represents the main class of the Rental System assignment.
 * This class provides method that connects other classes.
 * It provides the adding, renting, returning and printing opportunities of the movies
 */
public class RentalSystem {
    /**
     * The maximum number of consumers/movies at one time.
     */
    public static final int MAX = 30;
    private Movie[] movies;
    private Director[] directors;
    /**
     * Each index in directorMovies represents the number of movies by the director at that index in directors array.
     */
    private int[] directorMovies;
    /**
     * Each index in rented represents the number of costumers that rented the movie at that index in movies array.
     */
    private int[] rented;
    private Customer[] customers;
    /**
     * Represents the last empty index of the corresponding array
     * NOTE: all the values are pushed to the start of the array when the array is being modified.
     */
    private int lastCustomerIndex;
    private int lastMovieIndex;
    private int lastDirectorIndex;

    public RentalSystem(){
        this.movies = new Movie[MAX];
        this.directors = new Director[MAX];
        this.directorMovies = new int[MAX];
        this.customers = new Customer[MAX];
        this.rented = new int[MAX];
        this.lastMovieIndex = 0;
        this.lastDirectorIndex = 0;
        this.lastCustomerIndex = 0;
    }

    /**
     * Adds the movie to the system and performs necessary checks.
     *
     * @param title     The title of the movie that is being added.
     * @param genre     The genre of the movie that is being added.
     * @param releaseYear     The release year of the movie that is being added.
     * @param director     The director's name of the movie that is being added.
     * @param biography     The biography of the director of the movie that is being added.
     */
    public void addMovie(String title, Genre genre, int releaseYear,
                         String director, String biography) {
        if (lastMovieIndex == MAX) {
            System.out.println("System is full. Cannot add more movies");
            return;
        }
        if(findMovie(title,releaseYear,director) != -1) {
            System.out.println("Movie is already in the system.");
            return;
        }

        int index = findDirector(director);
        if(index == -1) {
            directors[lastDirectorIndex] = new Director(director,biography);
            movies[lastMovieIndex] = new Movie(title, releaseYear, directors[lastDirectorIndex],genre);
            directorMovies[lastDirectorIndex]++;
            lastDirectorIndex++;
            lastMovieIndex++;

        }
        else {
            movies[lastMovieIndex] = new Movie(title, releaseYear, directors[index],genre);
            directorMovies[index]++;
            lastMovieIndex++;
        }
    }

    /**
     * Removes the movie from the system and performs necessary checks.
     *
     * @param title     The title of the movie that is being removed.
     * @param releaseYear     The release year of the movie that is being removed.
     * @param director     The director's name of the movie that is being removed.
     */
    public void removeMovie(String title, int releaseYear, String director){
        int movieIndex = findMovie(title, releaseYear, director);
        if (movieIndex == -1){
            System.out.println("No such movie exists.");
            return;
        }
        if (isRented(movieIndex)){
            System.out.println("Cannot remove rented movie.");
            return;
        }
        int directorIndex = findDirector(director);
        if (directorMovies[directorIndex] == 1){
            directors[directorIndex] = null;
            directorMovies[directorIndex] = 0;

            directors[directorIndex] = directors[lastDirectorIndex - 1];
            directors[lastDirectorIndex - 1] = null;
            directorMovies[directorIndex] = directorMovies[lastDirectorIndex - 1];
            directorMovies[lastDirectorIndex - 1] = 0;

            lastDirectorIndex--;
        } else if (directorMovies[directorIndex] > 1){
            directorMovies[directorIndex]--;
        }
        rented[movieIndex] = rented[lastMovieIndex - 1];
        rented[lastMovieIndex - 1] = 0;

        movies[movieIndex] = movies[lastMovieIndex - 1];
        movies[lastMovieIndex - 1] = null;
        lastMovieIndex--;
    }

    /**
     * Prints the movies in the format that was requested.
     */
    public void printMovies() {
        int rentCounter = 0;
        int unrentCounter = 0;
        for (int i = 0; i < lastMovieIndex; i++){
            if (rented[i] > 0) {
                rentCounter++;
            } else {
                unrentCounter++;
            }
        }

        System.out.println("Rented Movies: ");
        if (rentCounter == 0) {
            System.out.println("No Rented movies.");
        } else {
            for (int i = 0; i < lastMovieIndex; i++) {
                if (rented[i] > 0) {
                    System.out.println(movies[i]);
                }
            }
        }
        System.out.println("Unrented Movies: ");
        if (unrentCounter == 0) {
            System.out.println("No Unrented movies.");
        } else {
            for (int i = 0; i < lastMovieIndex; i++) {
                if (rented[i] == 0) {
                    System.out.println(movies[i]);
                }
            }
        }
    }


    /**
     * Handles the process of renting the movie by the customer.
     *
     * @param name     The customer's name that wants to rent the movie.
     * @param id     The customer's ID that wants to rent the movie.
     * @param title     The title of the movie that is being rented.
     * @param releaseYear     The release year of the movie that is being rented.
     * @param director     The director's name of the movie that is being rented.
     */
    public void rentMovie(String name, String id, String title, int releaseYear, String director){
        int customerIndex = findCustomer(id);
        if (lastCustomerIndex == MAX && customerIndex == -1){
            System.out.println("No room for new customers.");
            return;
        }
        int movieIndex = findMovie(title, releaseYear, director);
        if (movieIndex == -1){
            System.out.println("No such movie exists.");
            return;
        }

        if (customerIndex != -1 && customers[customerIndex].isRenting(movies[movieIndex])){
            System.out.println("Customer already has this movie");
            return;
        }

        if (customerIndex == -1) {
            Customer customer = new Customer(name, id);
            customers[lastCustomerIndex] = customer;
            lastCustomerIndex++;
            customerIndex = lastCustomerIndex - 1;
        }
        boolean result = customers[customerIndex].rentMovie(movies[movieIndex]);
        if (result){
            rented[movieIndex]++;
        }
        else {
            System.out.println("The customer has reached the limit");
        }
    }
    /**
     * Adds movie to the system and performs necessary checks.
     *
     * @param id     The customer's ID that wants to return the movie.
     * @param title     The title of the movie that is being returned.
     * @param releaseYear     The release year of the movie that is being returned.
     * @param director     The director's name of the movie that is being returned.
     */
    public void returnMovie(String id, String title, int releaseYear, String director){
        int customerIndex = findCustomer(id);
        if (customerIndex == -1){
            System.out.println("Customer not found.");
            return;
        }
        int movieIndex = findMovie(title, releaseYear, director);
        if (movieIndex == -1 || !customers[customerIndex].returnMovie(movies[movieIndex])){
            System.out.println("Customer cannot return the movie.");
            return;
        }

        rented[movieIndex]--;

        if (customers[customerIndex].isEmpty()){
            customers[customerIndex] = customers[--lastCustomerIndex];
            customers[lastCustomerIndex] = null;
        }
    }

    /**
     * Returns the index of the searched movie.
     *
     * @param title     The title of the movie that is being searched.
     * @param releaseYear     The release year of the movie that is being searched.
     * @param director     The director's name of the movie that is being searched.
     * @return Index of the movie from movies array. -1 if the movie is not found
     */
    public int findMovie(String title, int releaseYear, String director){
        for (int i = 0; i < lastMovieIndex; i++){
            if (movies[i].equals(title, releaseYear, director)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the searched director.
     *
     * @param directorName     The name of the director that is being searched.
     * @return Index of the director from directors array. -1 if the director is not found
     */
    public int findDirector(String directorName){
        for(int i = 0; i < lastDirectorIndex; i++){
            if(directors[i].equals(directorName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the searched customer.
     *
     * @param id     The ID of the customer that is being searched.
     * @return Index of the customer from customers array. -1 if the customer is not found
     */
    public int findCustomer(String id){
        for (int i = 0; i < lastCustomerIndex; i++){
            if (customers[i] != null && customers[i].equals(id)){
                return i;
            }
        }
        return -1;
    }

    public boolean isRented(int index){
        return this.rented[index] > 0;
    }
}
