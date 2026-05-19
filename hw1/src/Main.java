import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static Scanner scanner; // Note: Do not change this line.
    public static final int MAX_SIZE = 100;
    public static final double MIN_RATING = 0;
    public static final double MAX_RATING = 10;
    public static String[] movies;
    public static String[] directors;
    public static double[] ratings;
    public static int numberOfMovies = 0;

    /** Core movie management function. */
    public static void manageMovies() {
        String choice;
        movies = new String[MAX_SIZE];
        directors = new String[MAX_SIZE];
        ratings = new double[MAX_SIZE];
        numberOfMovies = 0;

        System.out.println("Welcome to the Movies Management System!.");

        // main routing loop
        while (true) {
            System.out.println("""
                    1. Add a new movie
                    2. Display all movies
                    3. Display movie rating
                    4. Find the best director
                    5. Exit""");
            System.out.println("Please enter your choice:");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addMovie(scanner);
                    break;
                case "2":
                    displayAll();
                    break;
                case "3":
                    displayRating();
                    break;
                case "4":
                    findBest();
                    break;
                case "5":
                    exit();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    /** Adds a movie to the first empty array index. */
    public static void addMovie(Scanner scanner) {
        System.out.println("Enter movie name:");
        String movieName = scanner.nextLine();

        System.out.println("Enter rating:");
        double rating = scanner.nextDouble();
        scanner.nextLine();
        if (rating < MIN_RATING || rating > MAX_RATING) {
            System.out.println("Invalid rating");
            return;
        }
        System.out.println("Enter director name:");
        String directorName = scanner.nextLine();

        // check if the movie already exists or if the limit has been reached
        if (!movieExist(movieName)) {
            if (numberOfMovies < MAX_SIZE) {
                movies[numberOfMovies] = movieName;
                directors[numberOfMovies] = directorName;
                ratings[numberOfMovies] = rating;
                numberOfMovies++;
            } else {
                System.out.println("Movies limit reached");
                return;
            }
        } else {
            updateMovie(movieName, rating);
        }
        System.out.println("Movie " + movieName + " added successfully!");
    }

    /** Returns true if the movie with the corresponding director exists. */
    public static boolean movieExist(String movieName) {
        for (int i = 0; i < numberOfMovies; i++) {
            if (movies[i].equals(movieName)) return true;
        }
        return false;
    }

    /** Updates the existing movie with the new rating. */
    public static void updateMovie(String movieName, double rating) {
        for (int i = 0; i < numberOfMovies; i++) {
            if (movies[i].equals(movieName)) {
                ratings[i] = rating;
            }
        }

    }

    /** Displays all the existing movies with theirs directors and ratings. */
    public static void displayAll() {
        if (numberOfMovies == 0) {
            System.out.println("No movies are available");
            return;
        }
        if (directors == null) return;
        // sort the directors in lexicographical ascending order
        String[] uniqueSortedDirectors = Arrays.stream(directors)
                .filter(Objects::nonNull)
                .distinct()
                .toArray(String[]::new);
        // print movies and rating of each director
        for (String author : uniqueSortedDirectors) {
            for (int i = 0; i < numberOfMovies; i++) {
                if (!directors[i].equals(author)) continue;
                System.out.println("Name: " + movies[i] + " rating: " + ratings[i] +
                        " director: " + directors[i]);
            }
        }
    }

    /** Displays the rating of the entered movie. */
    public static void displayRating() {
        System.out.println("Enter movie name:");
        String movieName = scanner.nextLine();

        for (int i = 0; i < numberOfMovies; i++) {
            if (movieName.equals(movies[i])) {
                System.out.printf("Rating for %s: %.1f%n", movieName, ratings[i]);
                return;
            }
        }
        System.out.printf("No movie found with name %s%n", movieName);

    }

    /** Find the director with the best average rating. */
    public static void findBest() {
        if (numberOfMovies == 0) {
            System.out.println("No movies are available");
            return;
        }
        // copied the array so the changes won't affect the initial data
        String[] copyDirectors = new String[numberOfMovies];
        System.arraycopy(directors, 0, copyDirectors, 0, numberOfMovies);

        String currentDirector = "";
        String bestAuthor = "";
        double bestRating = 0.0d;
        double sumRatings = 0.0d;
        int countMovies = 0;
        double average = 0.0;

        // go over each director until the end, increasing the sum and count
        // make the "visited" directors empty, to skip unnecessary loops
        for (int i = 0; i < numberOfMovies; i++) {
            if (copyDirectors[i].isEmpty()) continue;
            currentDirector = copyDirectors[i];
            for (int j = i; j < numberOfMovies; j++) {
                if (currentDirector.equals(copyDirectors[j])) {
                    countMovies++;
                    sumRatings += ratings[j];
                    copyDirectors[j] = "";
                }
            }
            // find the best average rating
            average = sumRatings / countMovies;
            if (average > bestRating) {
                bestRating = average;
                bestAuthor = currentDirector;
            }
            sumRatings = 0;
            countMovies = 0;
        }

        System.out.printf("Best director: %s with an average rating of: %.2f%n", bestAuthor, bestRating);
    }


    /** Prints the exit message. */
    public static void exit() {
        System.out.println("Exiting the program. Goodbye!");
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];

        scanner = new Scanner(new File(path));
        int numberOfTests = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numberOfTests; i++) {
            System.out.println("Test number " + i + " starts.");
            try {
                manageMovies();
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
            System.out.println("Test number " + i + " ended.");
            System.out.println("-----------------------------------------------");
        }
        System.out.println("All tests have ended.");
    }
}