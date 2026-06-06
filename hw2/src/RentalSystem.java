public class RentalSystem {

    public static final int MAX = 30;
    private Movie[] movies;
    private int[] rented;
    private Customer[] customers;

    public RentalSystem(){
        this.movies = new Movie[MAX];
        this.customers = new Customer[MAX];
        this.rented = new int[MAX];
    }

    public void addMovie(String title, Genre genre, int releaseYear, String director, String biography){
        return;
    }

    public void removeMovie(String title, int releaseYear, String director){

        return;
    }

    public void printMovies(){
        return;
    }

    public void rentMovie(String name, String id, String title, int releaseYear, String director){
        return;
    }

    public int findMovie(String title, int releaseYear, String director){
        return 0;

    }
}
