package com.company.game;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    Field field = new Field();
    private final Player human = Player.PLAYER;
    private final Player pc = Player.COMPUTER;


    public static final String  TIE = "It's tie!";
    public static final String GREETING_MESSAGE = "Let's start the game !";
    public static final String ASK_FOR_CHOICE = "Rock, Scissors or Paper ?";
    public static final String YOUR_CHOICE = "Your choice: ";
    public static final String COM_CHOICE = "Computer choice: ";
    public static final String WINNER = "The winner is: ";

    public void gameStart() {
        System.out.println(GREETING_MESSAGE);
        System.out.println(ASK_FOR_CHOICE);

        field.setFirstPlayerStep(playerChoice());
         System.out.println(YOUR_CHOICE + field.getFirstPlayerStep());

         field.setSecondPlayerStep(compChoice());
        System.out.println(COM_CHOICE + field.getSecondPlayerStep());

        if (compareChoice() != null)
            System.out.println(WINNER + compareChoice());
        else System.out.println(TIE);

    }

    private Figure compChoice(){
        Random rand = new Random();
        return switch (rand.nextInt(3)) {
            case 0 -> Figure.ROCK;
            case 1 -> Figure.SCISSORS;
            default -> Figure.PAPER;
        };
    }

    private Figure playerChoice(){
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

    private Player compareChoice(){
        if (field.getFirstPlayerStep() == field.getSecondPlayerStep() ){
            return null;
        }
        return switch (field.getFirstPlayerStep()) {
            case ROCK -> (field.getSecondPlayerStep() == Figure.SCISSORS ? human : pc);
            case PAPER -> (field.getSecondPlayerStep() == Figure.ROCK ? human : pc);
            case SCISSORS -> (field.getSecondPlayerStep() == Figure.PAPER ? human : pc);
        };
    }
}
