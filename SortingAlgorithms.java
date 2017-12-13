import java.util.Scanner;
/**
 * Write a description of class SortingAlgorithms here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SortingAlgorithms
{
    // instance variables - replace the example below with your own
    private int x;
    private int[] classArray = {11, 12, 15, 16, 112, 112, 123, 145};
    int[] numbersArray = new int[200];
    
    private int searchInt;
    private int userLength;
    private int userMax;
    /**
     * Constructor for objects of class SortingAlgorithms
     */

    public void askForSearchNumber() {
        System.out.println("What number would you like to search for?");
        Scanner sc=new Scanner(System.in);
        String searchTerm = sc.next();
        searchInt = Integer.parseInt(searchTerm);
    }

    public void askForArraySize() {
        System.out.println("How big do you want the array to be?");
        Scanner sc=new Scanner(System.in);
        String sizeTerm = sc.next();
        userLength = Integer.parseInt(sizeTerm);

        System.out.println("What do you want the max number to be?");
        String maxTerm = sc.next();
        userMax = Integer.parseInt(maxTerm);
    }

    public SortingAlgorithms()
    {
        clear();
        askForSearchNumber();
        askForArraySize();
        System.out.println("User Length: " + userLength + ", User Max: " + userMax);
        populateArray(200, 1000);
        System.out.println("Random Array Generated ");
        for (int i=0; i<numbersArray.length; i++) {
            System.out.print(numbersArray[i] + ", ");
        }
        System.out.println("");
        System.out.println("Sequentially searching for " + searchInt + " because order does NOT matter");
        String secondResult = sequentialSearch(searchInt, numbersArray);
        System.out.println(secondResult);

        int[] finalArray = sortAlgorithm(true, numbersArray);
        System.out.println("Sorting the Array from greatest to least ");
        for (int i=0; i<finalArray.length; i++) {
            System.out.print(finalArray[i] + ", ");
        }
        finalArray = sortAlgorithm(false, numbersArray);
        System.out.println("");
        System.out.println("Sorting the Array from least to greatest ");

        for (int i=0; i<finalArray.length; i++) {
            System.out.print(finalArray[i] + ", ");
        }
        System.out.println("");
        System.out.println("Binary searching for " + searchInt + " because order matters ");
        String result = binarySearch(searchInt, numbersArray);
        System.out.println("Result of Binary Search: ");
        System.out.println(result);
        System.out.println("");
        System.out.println("Selection Sorting Array: ");
        result = selectionSort(numbersArray);
        System.out.println("Result of Selection Sorting: ");
        System.out.println(result);
        
    }

    public int[] sortAlgorithm(boolean greatestToLeast, int[] arrayToSearch) {
        for (int x=0; x<arrayToSearch.length; x++) {
            for (int i =0; i<arrayToSearch.length; i++) {
                int valueOne = arrayToSearch[i];
                if (i == arrayToSearch.length - 1) {
                    break;
                } else {
                    int valueTwo = arrayToSearch[i+1];
                    if ((!(valueOne < valueTwo)) && greatestToLeast == false) {
                        arrayToSearch[i] = valueTwo;
                        arrayToSearch[i+1] = valueOne;
                    } else if ((!(valueOne > valueTwo)) && greatestToLeast == true) {
                        arrayToSearch[i] = valueTwo;
                        arrayToSearch[i+1] = valueOne;
                    }
                }
            }
        }

        return arrayToSearch;
    }

    public String sequentialSearch(int target, int[] arrayToSearch) {
        boolean answerFound= false;
        for(int counter =0; counter<(arrayToSearch.length-1); counter++) {
            if(arrayToSearch[counter] == target) {
                answerFound = true;
                return (target + " found at position " + counter);
            }
        }

        return (target + " was not found in the array");
    }

    public String binarySearch(int target, int[] arrayToSearch) {
        int min = 0;
        int max = arrayToSearch.length - 1;
        boolean found = false;
        int answerPosition = 0;
        int midPos=0;
        int midNum=0;
        while (found == false && min <= max) {
            midPos = (min + max)/2;
            if(arrayToSearch[midPos] == target) {
                found = true;
                answerPosition = midPos;
            } else if(target > arrayToSearch[midPos]) {
                min = midPos+1;
            } else {
                max = midPos-1;
            }
        }
        if (found == false) {
            return "Target Value " + target + " was not found";
        } else {
            return "Target Value " + target + " was found at position " + answerPosition;
        }
    }
    
    public String selectionSort (int[] arrayToSort) {
        int bottom = 0; 
        int smallest= 0;
        int temp = 0;
        String returnValue = "";
        for (bottom = 0; bottom<(arrayToSort.length-1); bottom++) {
            smallest = bottom;
            for (int current=bottom+1; current<(arrayToSort.length); current++) {
                if (arrayToSort[current]<arrayToSort[smallest]) {
                    smallest = current;
                }
            }
            temp = arrayToSort[smallest];
            arrayToSort[smallest] = arrayToSort[bottom];
            arrayToSort[bottom] = temp;
        }
        returnValue = "Sorted Array: ";
        for (int i=0; i<arrayToSort.length; i++) {
            returnValue = returnValue + arrayToSort[i] + ", ";
        }
        
        return returnValue;
    }

    public void clear() {
        System.out.println("\f");
    }

    public void populateArray(int length, int max) {
        System.out.println("Max: " + max);
        for (int i=0; i<length; i++) {
            int currentNum = random(0, max);
            numbersArray[i] = currentNum;
        }
    }
    
    public static int random(int min, int max) {
        return (int) Math.floor(max*Math.random())+min;
    }
}
