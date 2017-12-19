package Eulers;
import java.util.*;

/**
 * Write a description of class LargestPrime here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LargestPrime
{

    /**
     * Constructor for objects of class LargestPrime
     */
    public LargestPrime()
    {
        clear();
        long number = 600851475143L;
        for(int i=0; i<8; i++) { 
            long eigth = (long) Math.floor(number / 8);
            long currentMax = ((i+1)*eigth);
            System.out.println(primeFactors(currentMax));
        }
    }

    public ArrayList primeFactors(long number) {
        ArrayList factors = new ArrayList();
        for(long x=1L; x<number; x++) {
            System.out.print(x + ", ");
            if (number % x == 0 && isPrime(x)) { //is divisible and its a prime number
                factors.add(x);
            }
        }
        return factors;
    }

    public boolean isPrime(long number) {
        for(long i=1L; i<number; i++) {
            if(number % i == 0 && i != 1 && i != number) {;
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
