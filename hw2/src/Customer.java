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

    public boolean isEmpty(){
        for (int i = 0; i < MAX; i++){
            if (rentedMovies[i] != null){
                return false;
            }
        }
        return true;
    }

    public boolean rentMovie(Movie movie){
        for (int i = 0; i < MAX; i++){
            if (rentedMovies[i] == null){
                rentedMovies[i] = movie;
                return true;
            }
        }
        return false;
    }

    public boolean returnMovie(Movie movie){
        for (int i = 0; i < MAX; i++){
            if (rentedMovies[i].equals(movie)){
                rentedMovies[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean isRenting(Movie movie){
        for (int i = 0; i < MAX; i++){
            if (rentedMovies[i] != null && rentedMovies[i].equals(movie)){
                return true;
            }
        }
        return false;
    }

    public boolean equals(String otherId){
        return this.id.equals(otherId);
    }

}
