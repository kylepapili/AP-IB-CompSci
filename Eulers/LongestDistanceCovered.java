package Eulers;
import java.util.*;
import java.lang.Number;
import java.math.BigInteger;


public class LongestDistanceCovered
{
    public LongestDistanceCovered()
    {
        double greatestDistance = 0;
        for(double i=0; i<46; i=i+0.0000000000001) {
            double currentDistance = findDistanceForAngle(i);
            if(currentDistance > greatestDistance) {
                greatestDistance = currentDistance;
            }
        }
    }

    public double findDistanceForAngle(double angle) {
        double velocityY = 20*Math.cos(angle);
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

    public void printPieRanges(ArrayList<range> array) {
        System.out.println("Here is Your Array!");
        for (int i = 0; i<array.size(); i++) {
            boolean lastTurn = (i==array.size()-1);
            range currentRange = array.get(i);
            if (lastTurn) {
                System.out.println("[Min: " + currentRange.min + ", Max: " + currentRange.max + "]");
            } else {
                System.out.print("[Min: " + currentRange.min + ", Max: " + currentRange.max + "], ");
            }
        }
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

    public void clear() {
        System.out.println("\f");
    }
}
