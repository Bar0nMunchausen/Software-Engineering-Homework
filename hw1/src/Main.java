import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner; // Note: Do not change this line.
    public static String[] movies = new String[100];
    public static String[] authors = new String[100];
    public static double[] ratings = new double[100];
    public static void manageMovies() {
        String choice;

        System.out.println("Welcome to the Movies Management System!.");
        // add comments here!! + refactor names !!
        System.out.println("""
                1. Add a new movie
                2. Display all movies
                3. Display movie rating
                4. Find the best director
                5. Exit""");

        while (true) {
            System.out.println("Please enter your choice:");
            choice = scanner.next();
            switch (choice){
                case "1":
                    addMovie(); break;
                case "2":
                    displayAll(); break;
                case "3":
                    displayRating(); break;
                case "4":
                    findBest(); break;
                case "5":
                    exit(); break;
            }
        }
    }
    public static void addMovie() {}
    public static void displayAll() {}
    public static void displayRating() {}
    public static void findBest() {}


    public static void exit(){
        System.out.println("Exiting the program. Goodbye!");
        System.exit(0);
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