package Eulers;
import java.util.*;
import java.lang.Number;
import java.math.BigInteger;

public class sumOfPrimes
{

    public sumOfPrimes()
    {
        int currentNum = 0;
        ArrayList returnArray = new ArrayList();
        while (currentNum < 2000000) {
            System.out.print(currentNum + ", ");
            currentNum++;
            if(isPrime(currentNum)) {
                returnArray.add(currentNum);
            }
        }
        
        int sum = sum(returnArray);
        System.out.println("Sum is: " + sum);
    }
    
    public boolean isPrime(int number) {
        int half = ((number) / 2);
        for (int bi = half; bi>1; bi = bi - 1) {
            if((number % (bi)) == 0) {
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

    public void printArrayList(ArrayList array) {
        System.out.println("Here is Your Array!");
        for (int i = 0; i<array.size(); i++) {
            boolean lastTurn = (i==array.size()-1);
            if (lastTurn) {
                System.out.println(array.get(i));
            } else {
                System.out.print(array.get(i) + ", ");
            }
        }
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
