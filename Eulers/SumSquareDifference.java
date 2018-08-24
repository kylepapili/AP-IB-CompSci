package Eulers;
import java.util.*;
import java.lang.Number;
import java.math.BigInteger;

public class SumSquareDifference
{

    public SumSquareDifference()
    {
        clear();
        int sqOfSum = squareOfSum(100);
        int sumOfSq = sumOfSquares(100);
        System.out.println("Difference: " + (sumOfSq - sqOfSum));
    }
    
    public int squareOfSum(int max) {
        int currentSum = 0;
        for( int i=0; i<=max; i++) {
            currentSum = currentSum + i;
        }
        return (currentSum*currentSum);
    }
    
    public int sumOfSquares(int max) {
        int currentSum = 0;
        for( int i=0; i<=max; i++) {
            int squared = i*i;
            currentSum = currentSum + squared;
        }
        return currentSum;
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
