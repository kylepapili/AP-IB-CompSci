import java.util.Scanner;
import java.util.*;
public class ArrayAlgorithms
{

    int[] testArray = {1,2,5,5,1,2,3,5,2};
    int[] gcfArray = {8, 48, 16, 24};
    /**
     * Constructor for objects of class ArrayAlgorithms
     */
    public ArrayAlgorithms()
    {
        clear();
        int userLength = askForArraySize();
        int userMax = askForArrayMax();
        int[] userArray = populateArray(userLength , userMax);
        
        //Max
        int maximum = extremes(userArray, true);
        System.out.println("Maximum: " + maximum);

        //Min
        int minimum = extremes(userArray, false);
        System.out.println("Minimum: " + minimum);

        //Sum
        int sum = sum(userArray);
        System.out.println("Sum: " + sum);

        //Mean
        float mean = mean(userArray);
        System.out.println("Mean: " + mean);

        printArray(userArray);
        //Median
        float median = median(userArray);
        System.out.println("Median: " + median);
        
        //Mode
        String mode = mode(userArray);
        System.out.println(mode);
        
        //Range
        int range = range(userArray);
        System.out.println("Range: " + range);
        
        //GCF
        int gcf = gcf(gcfArray);
        System.out.println("GCF: " + gcf);
        
        //Reverse
        printArray(userArray);
        int[] reversedArray = reverse(userArray);
        System.out.println("Reversing Array...");
        printArray(reversedArray);
        
        //Is Palindrome
        boolean isPalindrome = isPalindrome(userArray);
        System.out.println("IS Palindrome: " + isPalindrome);
        
        //Smallest Difference
        int smallestDifference = smallestDifference(userArray); 
        System.out.println("Smallest Difference: " + smallestDifference);
    }

    //Algorithms
    public int smallestDifference(int[] array) {
        array = sort(true, array);
        int currentDif = 0;
        for(int i=0; i< array.length; i++) {
            if(i != array.length -1) {
                if ((array[i] - array[i+1]) < currentDif) {
                    currentDif = array[i] - array[i+1];
                }
            }
        }
        return currentDif;
    }
    
    public boolean isPalindrome(int[] array) {
        int[] reversedArray = reverse(array);
        if(reversedArray == array) {
            return true;
        } else {
            return false;
        }
    }
    
    public int[] reverse(int[] array) {
        int length = array.length;
        int[] returnArray = new int[length];
        for(int i=0; i<length; i++) {
            int temp = array[i];
            int oppositeTemp = array[length-(i+1)];
            
            returnArray[i] = oppositeTemp;
            returnArray[length-(i+1)] = temp;
        }
        
        return returnArray;
    }
    
    public int gcf(int[] array) {
        ArrayList<ArrayList> listOfFactors = new ArrayList();
        for (int i=0; i<array.length; i++) {
            int currentNum = array[i];
            ArrayList factors = new ArrayList();
            factors.clear();
            for(int x=1; x<=currentNum; x++) {
                if (currentNum % x == 0) { //is divisible
                    factors.add(x);
                }
            }

            listOfFactors.add(factors);
        }

        ArrayList fullFactorList = new ArrayList();
        for(int i=0; i<listOfFactors.size(); i++) { //Loops through all the lists of factors
            ArrayList currentFactors = listOfFactors.get(i);
            for (int j=0; j<currentFactors.size(); j++) { //Loops through the factors within the current list
                fullFactorList.add(listOfFactors.get(i).get(j)); //Creates a list of all factors. (repeating)
            }
        }

        int repeatAmount = array.length;
        ArrayList listOfPossibleGCFs = new ArrayList();
        //Check to see if each number repeats the array.length amount of times
        for( int i=0; i<fullFactorList.size(); i++) {
            int repeated = 0;
            for (int j=0; j<fullFactorList.size(); j++) {
                if (fullFactorList.get(i) == fullFactorList.get(j)) {
                    if(!(listOfPossibleGCFs.contains(fullFactorList.get(i)))) { //Not already in there
                        repeated ++;
                    }
                }
            }
            if((repeated == repeatAmount)) {
                listOfPossibleGCFs.add(fullFactorList.get(i));
            }
        }
        //Now have a listOfPossibleGCFs, need to convert it to an array
        int[] arrayOfPossibleGCFs = new int[listOfPossibleGCFs.size()];
        for(int i=0; i<listOfPossibleGCFs.size(); i++) {
            int temp = (Integer) (listOfPossibleGCFs.get(i));
            arrayOfPossibleGCFs[i] = temp;
        }
        int[] orderedGCFs = sort(true, arrayOfPossibleGCFs);
        return orderedGCFs[0];
    }
    

    public int range(int[] array) {
        int[] sortedArray = sort(true, array);
        int max = sortedArray[sortedArray.length-1];
        int min = sortedArray[0];
        return max-min;
    }
    
    public String mode(int[] array) {
        int currentModeAmount = 0;
        int currentMode = 0;
        int currentCheck = 0;
        int tempModeAmount = 0;
        ArrayList multipleModes = new ArrayList();
        ArrayList checkedValues = new ArrayList();
        boolean hasMultipleModes = false;
        for(int i = 0; i<array.length; i++) {
            currentCheck = array[i];
            tempModeAmount = 0;
            for (int j = 0; j<array.length; j++) {
                if (currentCheck == array[j]) {
                    tempModeAmount++;
                }
            }
            if ( checkedValues.contains(array[i])){
                //System.out.println("!Current Mode: " + currentMode + ", Array[i]: " + array[i] + ", Bool: " + (currentMode != array[i]));
                break;
            } else {
                if (tempModeAmount > currentModeAmount) {
                    //System.out.println("*Current Mode: " + currentMode + ", Array[i]: " + array[i] + ", Bool: " + (currentMode != array[i]));
                    hasMultipleModes = false;
                    multipleModes.clear();
                    currentModeAmount = tempModeAmount;
                    currentMode = array[i];
                } else if (tempModeAmount == currentModeAmount && currentMode != array[i] && !(multipleModes.contains(array[i]))) {
                    //System.out.println("**Current Mode: " + currentMode + ", Array[i]: " + array[i] + ", Bool: " + (currentMode != array[i]));
                    hasMultipleModes = true;
                    multipleModes.add(array[i]);
                } else {
                    //System.out.println("***Current Mode: " + currentMode + ", Array[i]: " + array[i] + ", Bool: " + (currentMode != array[i]));
                }
                checkedValues.add(array[i]);
            }
        } 
        String returnString = "";
        if (hasMultipleModes) {
            returnString = returnString + ("There are " + multipleModes.size() + " modes in this array. They are ");
            returnString = returnString + (multipleModes);
        } else {
            returnString = returnString + "There is one mode in this array. It is " + currentMode;
            returnString = returnString + ". It appears " + currentModeAmount + " times.";
        }

        return returnString;
    }

    public float median(int[] array) {
        int[] sortedArray = sort(true, array);
        int middle = (int)Math.floor(sortedArray.length / 2);
        if(sortedArray.length % 2 == 0) { //Array is even
            int current = sortedArray[middle];
            int lower = sortedArray[middle - 1];
            int[] currentAndLower = {current, lower};
            return mean(currentAndLower);
        } else { //Array is odd
            return sortedArray[middle];
        }
    }

    public float mean(int[] array) {
        int sum = sum(array);
        return (sum / array.length);
    }

    public int sum(int[] array) {
        int arrayLength = array.length;
        int currentSum = 0;
        for(int i = 0; i<array.length; i++) {
            currentSum = currentSum + array[i];
        }
        return currentSum;
    }

    public int extremes(int[] array, boolean findMax) {
        int arrayLength = array.length;
        int currentExtreme = array[0];
        if (findMax) {
            for(int i = 0; i<array.length; i++) {
                if (currentExtreme < array[i]) {
                    currentExtreme = array[i];
                }
            }
        } else {
            for(int i = 0; i<array.length; i++) {
                if (currentExtreme > array[i]) {
                    currentExtreme = array[i];
                }
            }
        }

        return currentExtreme;
    }

    //Extra Functions
    public int[] sort(boolean greatestToLeast, int[] arrayToSearch) {
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

    public static int random(int min, int max) {
        return (int) Math.floor(max*Math.random())+min;
    }

    public int askForArraySize() {
        System.out.println("How big do you want the array to be?");
        Scanner sc=new Scanner(System.in);
        String sizeTerm = sc.next();
        return Integer.parseInt(sizeTerm);
    }

    public int askForArrayMax() {
        System.out.println("What do you want the maximum value in the array to be?");
        Scanner sc=new Scanner(System.in);
        String sizeTerm = sc.next();
        return Integer.parseInt(sizeTerm);
    }

    public int[] populateArray(int length, int max) {
        int[] numbersArray = new int[length];
        for (int i=0; i<length; i++) {
            int currentNum = random(0, max);
            numbersArray[i] = currentNum;
        }
        return numbersArray;
    }

}
