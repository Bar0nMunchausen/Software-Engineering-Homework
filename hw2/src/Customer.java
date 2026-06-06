public class Customer {
    private String name;
    private int id;
    private Movie[] rented_movies;

    public Customer(String name, int id){
        this.name = name;
        this.id = id;
        this.rented_movies = new Movie[5];
    }


}
