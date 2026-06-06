public class Movie {
    private String title;
    private Genre genre;
    private int releaseYear;
    private String directorName;

    private int id;
    public Movie(String title, int releaseYear, String directorName, Genre genre) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.directorName = directorName;
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
    public String getDirectorName() {
        return directorName;
    }
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
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
                this.directorName.equals(other.directorName));
    }

    @Override
    public String toString() {
        return ("Title: " + this.title + ", Genre: " + this.genre.toString() +
                ", Year: " +releaseYear +" director: " + directorName);
    }
}
