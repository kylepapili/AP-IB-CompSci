package Eulers;
import java.util.*;
import java.lang.Number;
import java.math.BigInteger;

public class LargestThreeDigitPalindrome
{
    public LargestThreeDigitPalindrome() {
        clear();
        System.out.print("Largest Palindrome: " + largestPalindromeProduct());
    }

    public int largestPalindromeProduct() {
        int currentGreatest = 0; 
        int currentX = 0;
        int currentY = 0;
        for(int x=0; x<1000; x++) {
            for(int i=0; i<10; i++) {
                for(int j=0; j<10; j++) {
                    for(int k=0; k<10; k++) {
                        //System.out.print("i: " + i + ", j: " + j + ", k: " + k);
                        String digits = "" + i + j + k;
                        int currentNum = Integer.valueOf(digits);
                        int currentProduct = currentNum*x;
                        if(isPalindrome(currentProduct)) {
                            if((currentProduct) > currentGreatest) {
                                currentGreatest = currentProduct;
                                currentX = x;
                                currentY = currentNum;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Factors: " + currentX + ", " + currentY);
        return currentGreatest;
    }

    public static boolean isPalindrome(int integer) {
        int palindrome = integer;
        int reverse = 0;
        // Compute the reverse
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }
        // The integer is palindrome if integer and reverse are equal
        return integer == reverse; // Improved by Peter Lawrey
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
