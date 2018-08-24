package Eulers;
import java.util.*;
import java.lang.Number;
import java.math.BigInteger;

public class HighlyDivisbleTriangularNumber
{
    public HighlyDivisbleTriangularNumber()
    {
        clear();
        BigInteger count = new BigInteger("500000000");
        int numberOfFactors = 0;
        while(numberOfFactors < 500) {
            BigInteger currentNum = triangularNumberFromMax(count);
            count = count.add(BigInteger.ONE);
            numberOfFactors = NumberOfFactors(currentNum);
            System.out.println("Number: " + count + ", factors: " + numberOfFactors);
        }
        System.out.println("Count: " + count);
    }

    //Triangular Number Functions
    public BigInteger triangularNumberFromMax(BigInteger max) {
        BigInteger sum = BigInteger.ZERO;
        while(max.compareTo(BigInteger.ZERO) > 0){
            sum = sum.add(max);
            max = max.subtract(BigInteger.ONE);
        }
        return sum;
    }

    public int NumberOfFactors(BigInteger number) {
        ArrayList factors = new ArrayList();
        factors.clear();
        BigInteger half = number.divide(new BigInteger("2"));
        int NumberOfFactors = 0;
        for (BigInteger bi = BigInteger.valueOf(0);
        bi.compareTo(half) < 0;
        bi = bi.add(BigInteger.ONE)) {
            System.out.print(bi + ", ");
            if(number.mod(bi).equals(BigInteger.ZERO)) {
                NumberOfFactors = NumberOfFactors + 1;
            }
        }

        return NumberOfFactors;
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
