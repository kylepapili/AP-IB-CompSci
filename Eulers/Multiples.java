package Eulers;
import java.util.*;

public class Multiples
{

    /**
     * Constructor for objects of class Multiples
     */
    public Multiples()
    {
        ArrayList multiplesArray = listMultiples();
        for(int i=0; i<multiplesArray.size(); i++) {
            System.out.print(multiplesArray.get(i) + ", ");
        }
        int sum = sum(multiplesArray);
        System.out.println("\nThe Sum Of The Multiples is: " + sum);
    }
    
    public ArrayList listMultiples() {
        ArrayList returnArray = new ArrayList();
        for (int i=0; i<1000; i++) {
            if ((isAMultiple(i, 3)) || (isAMultiple(i, 5))) {
                returnArray.add(i);
            }
        }
        return returnArray;
    }

    public boolean isAMultiple(int num, int of) {
        if (num % of == 0) {
            return true;
        } else {
            return false;
        }
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
