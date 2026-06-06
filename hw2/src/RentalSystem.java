public class RentalSystem {

    public static final int MAX = 30;
    private Movie[] movies;
    private Director[] directors;
    private int[] rented;
    private Customer[] customers;
    private int lastMovieIndex;
    private int lastDirectorIndex;

    public RentalSystem(){
        this.movies = new Movie[MAX];
        this.directors = new Director[MAX];
        this.customers = new Customer[MAX];
        this.rented = new int[MAX];
        this.lastMovieIndex = 0;
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
            if(!findDirector(director)) {

            }

            movies[]
            lastMovieIndex++;
        }
    }
    public int findDirector(String directorName){
       for(int i = 0; i < directors.length; i++){
           if(directorName.equals(directors[i])) {
               return i;
           }
       }
        return -1;
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

    public void returnMovie(String id, String title, int releaseYear, String director){
        return;
    }

    public int findMovie(String title, int releaseYear, String director){
        return 0;

    }
}
