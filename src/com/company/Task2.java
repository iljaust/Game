package com.company;

public class Task2 {

    public boolean checkForRepeat(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) return true;
            }
        }
        return false;
    }
}
