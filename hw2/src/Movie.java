public class Movie {
    private String title;
    private Genre genre;
    private int releaseYear;
    private Director director;

    public Movie(String title, int releaseYear, Director director, Genre genre) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
        this.genre = genre;
    }

    public boolean equals(Movie other) {
        return (this.title.equals(other.title) &&
                this.releaseYear == other.releaseYear &&
                this.director.equals(other.director));
    }

    public boolean equals(String title, int releaseYear, String director) {
        return (this.title.equals(title) &&
                this.releaseYear == releaseYear &&
                this.director.equals(director));
    }

    @Override
    public String toString() {
        return ("Title: " + this.title + ", Genre: " + this.genre.toString() +
                ", Year: " +releaseYear +" director: " + director.toString());
    }
}
