package com.company.game;

import java.util.Random;
import java.util.Scanner;


public class GameLogic {

    Figure firstPlayerStep;
    Figure secondPlayerStep;


    public void gameStart() {
        System.out.println("Let's start the game ! ");
        System.out.println("Rock, Scissors or Paper ?");

        firstPlayerStep = playerChoice();
         System.out.println("Your choice: " + firstPlayerStep );

        secondPlayerStep = compChoice();
        System.out.println("Computer choice: " + secondPlayerStep);

        System.out.println(result());
    }

    public Figure compChoice(){
        Random rand = new Random();
        return switch (rand.nextInt(3)) {
            case 0 -> Figure.ROCK;
            case 1 -> Figure.SCISSORS;
            default -> Figure.PAPER;
        };
    }

    public Figure playerChoice(){
        Scanner inputScanner = new Scanner(System.in);
        String s = inputScanner.nextLine();
        s = s.toUpperCase();
        char firstLetter = s.charAt(0);
        if (firstLetter == 'R' || firstLetter == 'S' || firstLetter == 'P') {
            switch (firstLetter) {
                case 'R':
                    return Figure.ROCK;
                case 'S':
                    return Figure.SCISSORS;
                case 'P':
                    return Figure.PAPER;
            }
        }
        return playerChoice();
    }

    public String result(){
        String s = "You win!";
        String a = "You lost!";
        String b = "It's TIE !";
        if (firstPlayerStep == secondPlayerStep ){
            return b;
        }
        return switch (firstPlayerStep) {
            case ROCK -> (secondPlayerStep== Figure.SCISSORS ? s : a);
            case PAPER -> (secondPlayerStep == Figure.ROCK ? s : a);
            case SCISSORS -> (secondPlayerStep == Figure.PAPER ? s : a);
        };
    }
}
