package com.company;

public class Task1 {

   public int[] getIndex(int[] array,int numb){
       for (int i = 0; i < array.length; i++) {
           for (int j = i + 1; j < array.length; j++) {
               if (array[j] == numb - array[i])
                   return new int[]{i,j};
           }
       }
       return new int[0];
   }
}
