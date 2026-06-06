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
                         String director, String biography){
        if(lastMovieIndex == 30){
            System.out.println("System is full, Cannot add more movies");
        }
        else if(findMovie(title,releaseYear,director) != -1) {
            System.out.println("Movie is already in the system");
        }
        else{
            int index = findDirector(director);
            if(index == -1) {

                if (directors[0] == null && movies[0] == null){
                    directors[lastDirectorIndex] = new Director(director,biography);
                    movies[lastMovieIndex] = new Movie(title, releaseYear, directors[lastDirectorIndex],genre);

                } else {
                    lastDirectorIndex++;
                    lastMovieIndex++;
                    directors[lastDirectorIndex] = new Director(director,biography);
                    movies[lastMovieIndex] = new Movie(title, releaseYear, directors[lastDirectorIndex],genre);
                }

            }
            else {
                lastMovieIndex++;
                movies[lastMovieIndex] = new Movie(title, releaseYear, directors[index],genre);
            }
        }
    }

    public void removeMovie(String title, int releaseYear, String director){
        int movieIndex = findMovie(title, releaseYear, director);
        if (movieIndex == -1){
            System.out.println("No such movie exists.");
            return;
        }
        if (isRented(movieIndex)){
            System.out.println("Cannot remove a rented movie.");
            return;
        }
        int directorIndex = findDirector(director);
        if (directorMovies[directorIndex] == 1){
            directors[directorIndex] = null;
            directorMovies[directorIndex] = 0;

            directors[directorIndex] = directors[lastDirectorIndex];
            directors[lastDirectorIndex] = null;
            directorMovies[directorIndex] = directorMovies[lastDirectorIndex];
            directorMovies[lastDirectorIndex] = 0;
        } else if (directorMovies[directorIndex] > 1){
            directorMovies[directorIndex]--;
        }

        movies[movieIndex] = movies[lastMovieIndex];
        movies[lastMovieIndex] = null;
    }

    public void printMovies(){
        int lastUnrentedMoviesIndex = 0;
        int lastRantedMoviesIndex = 0;
        Movie[] UnrentedMovies =  new Movie[MAX];
        Movie[] rantedMovies =  new Movie[MAX];


        for(int i = 0; i < lastMovieIndex; i++) {
            for (int j = 0; j < lastCustomerIndex; j++) {
                if(customers[j].isRenting(movies[i])){
                    rantedMovies[lastRantedMoviesIndex] = movies[i];
                    lastRantedMoviesIndex++;
                    break;
                }
                UnrentedMovies[lastUnrentedMoviesIndex] = movies[i];
                lastUnrentedMoviesIndex++;
            }
        }
        if(lastUnrentedMoviesIndex == 0 && lastRantedMoviesIndex == 0){
            System.out.println("No Unrented movies");
            System.out.println("No Rented movies");
            return;
        }
        if(lastRantedMoviesIndex == 0){
            System.out.println("No Rented movies");
        }else {
            System.out.println("Rented movies: ");
            for(int i = 0; i < lastRantedMoviesIndex; i++){
                System.out.println(rantedMovies[i]);
            }
        }
        if(lastUnrentedMoviesIndex == 0){
            System.out.println("No Unrented movies");
        }else {
            System.out.println("Unrented movies: ");
            for (int i = 0; i < lastUnrentedMoviesIndex; i++) {
                System.out.println(UnrentedMovies[i]);
            }
        }
    }

    public void rentMovie(String name, String id, String title, int releaseYear, String director){
        int customerIndex = findCustomer(id);
        if (lastCustomerIndex >= MAX && customerIndex == -1){
            System.out.println("No room for new customers.");
            return;
        }
        int movieIndex = findMovie(title, releaseYear, director);
        if (movieIndex == -1){
            System.out.println("No such movie exists.");
            return;
        }

        if (customerIndex != -1 && customers[customerIndex].isRenting(movies[movieIndex])){
            System.out.println("Customer already has this movies.");
            return;
        }

        if (customerIndex == -1) {
            Customer customer = new Customer(name, id);
            if (customers[0] == null){
                customers[lastCustomerIndex] = customer;
            } else {
                customers[++lastCustomerIndex] = customer;
            }
            customerIndex = lastCustomerIndex;
        }
        boolean result = customers[customerIndex].rentMovie(movies[movieIndex]);
        if (!result){
            System.out.println("Customer has reached the limit");
        }
    }

    public void returnMovie(String id, String title, int releaseYear, String director){
        int customerIndex = findCustomer(id);
        if (customerIndex == -1){
            System.out.println("Customer not found.");
            return;
        }
        int movieIndex = findMovie(title, releaseYear, director);
        if (movieIndex == -1 || customers[customerIndex].returnMovie(movies[movieIndex])){
            System.out.println("Customer cannot return the movie.");
            return;
        }

        rented[movieIndex]--;

        if (customers[customerIndex].isEmpty()){
            customers[customerIndex] = customers[lastCustomerIndex];
            customers[lastCustomerIndex--] = null;
        }
        return;
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
            if (customers[i].equals(id)){
                return i;
            }
        }
        return -1;
    }


    public boolean isRented(int index){
        return this.rented[index] > 0;
    }
}
