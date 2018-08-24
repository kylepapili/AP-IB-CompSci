import java.util.*;
import java.lang.Number;
import java.math.BigInteger;

public class HolidayBrainTeaser
{
    public HolidayBrainTeaser()
    {
        clear();
        ArrayList lockers = ConstructLockers();
        System.out.println("Construct: ");
        printArray(lockers);

        ArrayList lockersTwo = FirstStudent(lockers);
        System.out.println("First Student: ");
        printArray(lockers);

        // ArrayList lockersThree = SecondStudent(lockersTwo);
        // System.out.println("Second Student: ");
        // printArray(lockers);

        ArrayList lockersFour = RestOfStudents(lockersTwo);
        System.out.println("Rest of Students: ");
        printArray(lockersFour);

        int countOfStudents = countStudents(lockers);
        System.out.println("Students Without Gifts: " + countOfStudents);
    }

    public int countStudents(ArrayList array) {
        int returnSum = 0;
        for( int i=0; i<array.size(); i++) {
            if((Integer) array.get(i) == 0) {
                returnSum = returnSum+1;
            }
        }
        return returnSum;
    }

    public ArrayList RestOfStudents(ArrayList array) {
        for(int i = 2; i<array.size(); i++) {
            for(int j=0; j<array.size(); j=j+i) {
                int value = ((Integer) array.get(j));
                if( value == 1) {
                    array.set(j, 0);
                } else {
                    array.set(j, 1);
                }
            }
        }
        return array;
    }

    public ArrayList ThirdStudent(ArrayList array) {
        for(int i =0; i<array.size(); i++) {
            if(i % 3 == 0) {
                int value = ((Integer) array.get(i));
                if( value == 1) {
                    array.set(i, 0);
                } else {
                    array.set(i, 1);
                }
            }
        }
        return array;
    }

    public ArrayList SecondStudent(ArrayList array) {
        for(int i =0; i<array.size(); i++) {
            if(i % 2 == 0) {
                int value = ((Integer) array.get(i));
                array.set(i, 1);
            }
        }
        return array;
    }

    public ArrayList FirstStudent(ArrayList array) {
        for(int i =0; i<array.size(); i++) {
            int value = ((Integer) array.get(i));
            array.set(i, 0);
        }
        return array;
    }

    public ArrayList ConstructLockers() {
        ArrayList returnArray = new ArrayList();
        for(int i =0; i<1001; i++) {
            returnArray.add(1);
        }

        return returnArray;
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

    public void printArray(ArrayList array) {
        System.out.println("Here is Your Array!");
        for (int i = 0; i<array.size(); i++) {
            boolean lastTurn = (i==(array.size())-1);
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
