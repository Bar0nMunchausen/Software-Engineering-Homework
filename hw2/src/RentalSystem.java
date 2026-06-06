public class RentalSystem {

    public static final int MAX = 30;
    private Movie[] movies;
    private Director[] directors;
    private int[] directorMovies;
    private int[] rented;
    private Customer[] customers;
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

    public void addMovie(String title, Genre genre, int releaseYear,
                         String director, String biography) {
        if (lastMovieIndex == 30) {
            System.out.println("System is full, Cannot add more movies");
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
            lastDirectorIndex++;
            lastMovieIndex++;

        }
        else {
            movies[lastMovieIndex] = new Movie(title, releaseYear, directors[index],genre);
            lastMovieIndex++;
        }
    }


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

    public void printMovies() {
        boolean allRented = true;
        boolean allUnRented = true;
        for (int i = 0; i < lastMovieIndex; i++) {
            if (rented[i] != 0) {
                allUnRented = false;
            }
            if (rented[i] == 0) {
                allRented = false;
            }
        }

        if (lastCustomerIndex == 0 || allUnRented == true) {
            System.out.println("Rented Movies: ");
            System.out.println("No Rented movies.");
            System.out.println("Unrented Movies: ");
            for (int i = 0; i < lastMovieIndex; i++) {
                System.out.println(movies[i].toString());
            }
        } else if (lastMovieIndex == 0) {
            System.out.println("Rented Movies: ");
            System.out.println("No Rented movies.");
            System.out.println("Unrented Movies: ");
            System.out.println("No Unrented movies");

            return;
        } else if (allRented == true) {
            System.out.println("Rented Movies: ");
            for (int i = 0; i < lastMovieIndex; i++) {
                System.out.println(movies[i]);
            }
            System.out.println("Unrented Movies: ");
            System.out.println("No Unrented movies");
        } else {
            System.out.println("Rented Movies: ");
            for (int i = 0; i < lastMovieIndex; i++) {
                if (rented[i] != 0) {
                    System.out.println(movies[i]);
                }
            }
            System.out.println("Unrented Movies: ");
            for (int i = 0; i < lastMovieIndex; i++) {
                if (rented[i] == 0) {
                    System.out.println(movies[i]);
                }
            }
        }
    }



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

    public int findMovie(String title, int releaseYear, String director){
        for (int i = 0; i < lastMovieIndex; i++){
            if (movies[i].equals(title, releaseYear, director)){
                return i;
            }
        }
        return -1;
    }

    public int findDirector(String directorName){
        for(int i = 0; i < lastDirectorIndex; i++){
            if(directors[i].equals(directorName)) {
                return i;
            }
        }
        return -1;
    }

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
