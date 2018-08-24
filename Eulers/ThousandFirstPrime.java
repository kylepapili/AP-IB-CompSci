package Eulers;
import java.util.*;
import java.lang.Number;
import java.math.BigInteger;


public class ThousandFirstPrime
{
    public ThousandFirstPrime()
    {
        clear();
        ArrayList finalArray = primeNumbers(10001);
        System.out.println(finalArray);
        int max = finalArray.size();
        System.out.println("Biggest Prime: " + finalArray.get(max-1));
    }
    
    public ArrayList primeNumbers(int max) {
        ArrayList returnArray = new ArrayList();
        BigInteger currentMax = BigInteger.ZERO;
        
        for(int i=0; i<(max + 1); i++) {
            boolean notPrime = true;
            while (notPrime) {
                //System.out.print(currentMax + ", ");
                currentMax = currentMax.add(BigInteger.ONE);
                if(isPrime(currentMax)) {
                    notPrime = false;
                }
            }
            returnArray.add(currentMax);
        }
        return returnArray;
    }
    
    public boolean isPrime(BigInteger number) {
        BigInteger half = (number).divide(new BigInteger("2"));
        for (BigInteger bi = half; bi.compareTo(BigInteger.ONE) > 0; bi = bi.subtract(BigInteger.ONE)) {
            if((number.mod(bi)).equals(BigInteger.ZERO)) {
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
