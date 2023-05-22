package hangman;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args){
        System.out.println("Hangman!");

        Noose noose = new Noose();

        System.out.println("Enter word: ");

        Scanner scanner = new Scanner(System.in);
        String wordToGuess = scanner.nextLine();

        Word word = new Word(wordToGuess);

        while (!noose.isComplete() && !word.isGuessed()){
            System.out.println();

            System.out.println(noose);
            System.out.println();

            System.out.println(word);
            System.out.println();

            System.out.println("Enter a letter to guess");
            char c = scanner.nextLine().charAt(0);

            if (word.guessLetter(c)){
                System.out.println("Correct!");
            }
            else {
                System.out.println("Incorrect");
                noose.advance();
            }

            System.out.println(noose);
            System.out.println();

            System.out.println(word);
            System.out.println();

            if(noose.isComplete()){
                System.out.println("You lose! The word was: " + wordToGuess);
            }
            else {
                System.out.println("You win!");
            }
        }
    }
}
