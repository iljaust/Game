package com.company.game;

import java.util.Random;
import java.util.Scanner;

import static com.company.game.Figure.*;

public class GameLogic {
    Figure firstPlayerStep;
    Figure secondPlayerStep;


    public void gameStart() {
        System.out.println("Let's start the game ! ");
        System.out.println("Rock, Scissors or Paper ?");

         Figure firstPlayerStep = playerChoice();
         System.out.println("Your choice: " + firstPlayerStep );

         Figure secondPlayerStep = compChoice();
        System.out.println("Computer choice: " + secondPlayerStep);

         String s = result(secondPlayerStep);
        System.out.println(s);


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
                    return Figure.PAPER;
                case 'P':
                    return Figure.SCISSORS;
            }
        }
        return playerChoice();
    }

    public String result(Figure comp){
        String s = "You win!";
        String a = "You lost!";
        String b = "It's TIE !";
        if (secondPlayerStep == comp ){
            return b;
        }
        return switch (secondPlayerStep) {
            case ROCK -> (comp == Figure.SCISSORS ? s : a);
            case PAPER -> (comp == Figure.ROCK ? s : a);
            case SCISSORS -> (comp == Figure.PAPER ? s : a);
        };
    }
}
