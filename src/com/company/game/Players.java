package com.company.game;

public enum Players {
    PLAYER("YOU WIN!"),COMPUTER("YOU LOST!");

    String announcement;

    Players(String announcement){
        this.announcement= announcement;
    }

    @Override
    public String toString()
    {
        return this.announcement;
    }

}
