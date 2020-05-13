package com.company.game;

public class Field {

    private Figure firstPlayerStep;
    private Figure secondPlayerStep;

    private final Players human = Players.PLAYER;
    private final Players pc = Players.COMPUTER;

    public Figure getFirstPlayerStep() {
        return firstPlayerStep;
    }

    public void setFirstPlayerStep(Figure figure) {
        this.firstPlayerStep = figure;
    }

    public Figure getSecondPlayerStep() {
        return secondPlayerStep;
    }

    public void setSecondPlayerStep(Figure figure) {
        this.secondPlayerStep = figure;
    }

    public Players getHuman(){
        return human;
    }

    public Players getPc(){
        return pc;
    }

}
