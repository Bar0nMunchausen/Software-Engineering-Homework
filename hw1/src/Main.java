import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner; // Note: Do not change this line.
    public static int MAX_SIZE = 100;
    public static String[] movies = new String[MAX_SIZE];
    public static String[] authors = new String[MAX_SIZE];
    public static double[] ratings = new double[MAX_SIZE];
    public static int numberOfMovies = 0;
    public static void manageMovies() {
        String choice;

        System.out.println("Welcome to the Movies Management System!.");
        // add comments here!! + refactor names !!
        while (true) {
            System.out.println("""
                1. Add a new movie
                2. Display all movies
                3. Display movie rating
                4. Find the best director
                5. Exit""");
            System.out.println("Please enter your choice:");
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    addMovie(scanner); break;
                case "2":
                    displayAll(); break;
                case "3":
                    displayRating(); break;
                case "4":
                    findBest(); break;
                case "5":
                    exit(); return;
            }
        }
    }
    public static void addMovie(Scanner scanner) {
        System.out.println("Enter movie name:");
        String movieName = scanner.nextLine();

        System.out.println("Enter rating:");
        double rating = scanner.nextDouble();
        scanner.nextLine();
        if(rating < 0 || rating > 10) {
            System.out.println("Invalid rating");
            System.exit(0);
        }
        System.out.println("Enter director name:");
        String directorName = scanner.nextLine();

        if(!movieExist(movieName,directorName)) {
            if (numberOfMovies < 100) {
                movies[numberOfMovies] = movieName;
                authors[numberOfMovies] = directorName;
                ratings[numberOfMovies] = rating;
                numberOfMovies++;
                System.out.println("Movie " + movieName + " added successfully!");
            }
            else {
                System.out.println("Movies limit reached");
                System.exit(0);
            }
        } else {
            updateMovie(movieName,rating);
        }
    }
    public static boolean movieExist(String movieName,String directorName){
           for (int i = 0; i < numberOfMovies; i++) {
               if(movies[i].equals(movieName) && authors[i].equals(directorName)) return true;
           }
           return false;
    }
    public static void updateMovie(String movieName,double rating) {
        for (int i = 0; i < numberOfMovies; i++) {
            if(movies[i].equals(movieName)) {
                ratings[i] = rating;
            }
        }

    }
    public static void displayAll() {
        if (numberOfMovies == 0) {
            System.out.println("No movies are available");
            return;
        }
        if(authors == null) return;
        String[] uniqueSortedAuthors = Arrays.stream(authors.clone())
                .distinct()
                .sorted()
                .toArray(String[]::new);
        for(String author: uniqueSortedAuthors) {
            for (int i = 0; i < numberOfMovies; i++) {
                if(!authors[i].equals(author)) continue;
                System.out.println("Name: " + movies[i] + " rating: " + authors[i] +
                        " director: " + ratings[i]);
            }
        }
    }
    public static void displayRating() {
        System.out.println("Enter movie name:");
        String movieName = scanner.nextLine();

        for (int i = 0; i < numberOfMovies; i++){
            if (movieName.equals(movies[i])){
                System.out.printf("Rating for %s: %.1f%n", movieName, ratings[i]);
                return;
            }
        }
        System.out.printf("No movie found with name %s%n", movieName);

    }
    public static void findBest() {
        if (numberOfMovies == 0){
            System.out.println("No movies are available.");
        }
        String[] copyAuthors = new String[numberOfMovies];
        System.arraycopy(authors, 0, copyAuthors, 0, numberOfMovies);

        String currAuthor = "";
        String bestAuthor = "";
        double bestRating = 0.0d;
        double sumRatings = 0.0d;
        int countMovies = 0;
        double avg = 0.0;

        for (int i = 0; i < numberOfMovies; i++){
            if (copyAuthors[i].isEmpty()) continue;
            currAuthor = copyAuthors[i];
            for (int j = i; j < numberOfMovies; j++){
                if (currAuthor.equals(copyAuthors[j])){
                    countMovies++;
                    sumRatings += ratings[j];
                    copyAuthors[j] = "";
                }
            }
            avg = sumRatings / countMovies;
            if (avg > bestRating){
                bestRating = avg;
                bestAuthor = currAuthor;
            }
            sumRatings = 0;
            countMovies = 0;
        }

        System.out.printf("Best director: %s with an average rating of: %.1f%n", bestAuthor, bestRating);
    }


    public static void exit(){
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
            } catch(Exception e){
                System.out.println("Exception " + e);
            }
            System.out.println("Test number " + i + " ended.");
            System.out.println("-----------------------------------------------");
        }
        System.out.println("All tests have ended.");
    }
}