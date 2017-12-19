import java.util.*;

public class EvenFibonacciSum
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class EvenFibonacciSum
     */
    public EvenFibonacciSum()
    {
        clear();
        ArrayList fibonacciSequence = fibonacciGenerator();
        int currentSum = 0;
        for(int i=0; i<fibonacciSequence.size(); i++) {
            int currentVal = (Integer) fibonacciSequence.get(i);
            if(currentVal % 2 == 0) { //is even
                currentSum = currentSum + currentVal;
            }
            System.out.print(fibonacciSequence.get(i) + ", ");
        }
        System.out.println("\nThe Sum Of Even Values Is: " + currentSum);
    }

    public ArrayList fibonacciGenerator() {
        ArrayList returnArray = new ArrayList();
        returnArray.add(1);
        returnArray.add(2);
        int currentSum = 0;
        int i = 2;
        while (currentSum < 4000000) {
            int previousTwo = (Integer) (returnArray.get(i-2));
            int previousOne = (Integer) (returnArray.get(i-1));
            currentSum = previousTwo + previousOne;
            returnArray.add(currentSum);
            i++;
        }
        return returnArray;
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
