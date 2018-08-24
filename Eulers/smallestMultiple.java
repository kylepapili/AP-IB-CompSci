package Eulers;
import java.util.*;
import java.lang.Number;
import java.math.BigInteger;

public class smallestMultiple
{
    public smallestMultiple()
    {
        System.out.println("Number is: " + smallestDivisible());
    }

    public int smallestDivisible() {
        boolean isEvenlyDivisible = false;
        int currentNum = 1;
        
        while (!(isEvenlyDivisible)) {
            isEvenlyDivisible = isEvenlyDivisble(currentNum);
            currentNum = currentNum + 1;
        }
        return currentNum - 1;
    }

    public boolean isEvenlyDivisble(int number) {
        for(int i=1; i<21; i++) {
            if(!(number % i == 0)) {
                return false;
            }
        }
        return true;
    }

    //Helper Functions
    public int sum(ArrayList array) {
        int arrayLength = array.size();
        int currentSum = 0;
        for(int i = 0; i<array.size(); i++) {
            currentSum = currentSum + ((Integer) array.get(i));
        }
        return currentSum;
    }

    public int sum(int[] array) {
        int arrayLength = array.length;
        int currentSum = 0;
        for(int i = 0; i<array.length; i++) {
            currentSum = currentSum + array[i];
        }
        return currentSum;
    }

    public void printArray(int[] array) {
        System.out.println("Here is Your Array!");
        for (int i = 0; i<array.length; i++) {
            boolean lastTurn = (i==array.length-1);
            if (lastTurn) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }

    public void clear() {
        System.out.println("\f");
    }
}
