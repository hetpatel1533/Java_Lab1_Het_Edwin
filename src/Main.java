/*
* Name: Het Patel and Edwin Abraham
* Course: OOP3200 - 07
* Student ID: 100849572 / 100852671
*           Lab 1 - JAVA
* */

import java.util.InputMismatchException;
import java.util.Scanner;


// Main class
public class Main {
    public static void main(String[]args)
    {
        //Player's name
        String[]names = {"Professor Tom","Edwin","Het"};

        //game_scores
        int GAMENUMBER = 2;

        // using the 2D array.
        int[][] game_scores = new int[names.length][GAMENUMBER];

        // making two new functions to read and show the names and game scores.
        reading_the_scores(names,game_scores);
        System.out.println();
        showing_display(names,game_scores);
    }

    // Using the first method to read the scores.
    public static void reading_the_scores(String[] names, int[][] scores)
    {

        // using the for loop and exception to show the errors if users enter wrong values.
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                try {
                    System.out.print("Please enter " + names[i] + "'s score for Game " + (j + 1) + ": ");
                    scores[i][j] = input.nextInt();
                    while (scores[i][j]<0 || scores[i][j]>300)
                    {
                        System.out.println("Invalid input. Value must be between 0 to 300. Please try again.");
                        System.out.print("Please enter " + names[i] + "'s score for Game#" + (j + 1) + ": ");
                        scores[i][j] = input.nextInt();
                    }
                }
                catch (InputMismatchException ex)
                {
                    System.out.println("Invalid input. Only numeric values are acceptable. Please try again.");
                    j=j-1;
                    input.nextLine();
                }

            }

        }
    }

    // using the another method to display all the values.
    public static void showing_display(String[] names, int[][] scores)
    {
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            finalResult.append(String.format("Score Details for %s: %nGAME 1: %5s%nGAME 2: %5s%nAverage for %s: %s %n%n", names[i], scores[i][0],scores[i][1], names[i], ((double) (scores[i][0] + scores[i][1])) / 2));
        }
        System.out.println(finalResult);
    }
}