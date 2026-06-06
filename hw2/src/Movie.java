public class Movie {
    private String title;
    private Genre genre;
    private int releaseYear;
    private Director director;

    private int id;
    public Movie(String title, int releaseYear, Director director, Genre genre) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
        this.genre = genre;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public Director getDirectorName() {
        return director;
    }
    public void setDirectorName(Director directorName) {
        this.director = directorName;
    }

    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
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
