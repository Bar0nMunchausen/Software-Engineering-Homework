public class Customer {
    private String name;
    private String  id;
    private Movie[] rented_movies;

    private static final int MAX = 5;

    public Customer(String name, String id){
        this.name = name;
        this.id = id;
        this.rented_movies = new Movie[MAX];
    }

    public boolean isEmpty(){
        for (int i = 0; i < MAX; i++){
            if (rented_movies[i] != null){
                return false;
            }
        }
        return true;
    }

    public boolean rentMovie(Movie movie){
        for (int i = 0; i < MAX; i++){
            if (rented_movies[i] == null){
                rented_movies[i] = movie;
                return true;
            }
        }
        return false;
    }

    public boolean returnMovie(Movie movie){
        for (int i = 0; i < MAX; i++){
            if (rented_movies[i].equals(movie)){
                rented_movies[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean isRenting(Movie movie){
        for (int i = 0; i < MAX; i++){
            if (rented_movies[i].equals(movie)){
                return true;
            }
        }
        return false;
    }


}
