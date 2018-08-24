package Eulers;
import java.util.*;
import java.lang.Number;
import java.math.BigInteger;

public class PieProblem
{

    public class range {
        double min = 0;
        double max = 0;
        boolean icingUp = false;
        public range(double a, double b, boolean icingUp) {
            min = a;
            max = b;
            icingUp = icingUp;
        }

        public void flipSection() {
            icingUp = !icingUp;
        }
    }

    public class pie {
        ArrayList<range> pieRanges = new ArrayList<range>();
        boolean allIcingUp = false;
        //constructor
        public pie() {
            pieRanges = new ArrayList<range>();
        }

        public void flipRange(double min, double max) {
            sortPieRanges();
            for(int i=0; i<pieRanges.size(); i++) {
                if (i != (pieRanges.size() -1)) {
                    range currentRange = pieRanges.get(i);
                    range nextRange = pieRanges.get(i+1);
                    if(rangeToAdd.min > currentRange.min && rangeToAdd.min < nextRange.min) {
                        range leftRange = currentRange;
                        range rightRange = nextRange;
                        range leftFinalRange = new range(leftRange.min, rangeToAdd.min, (leftRange.icingUp)); //Not flipped
                        range middleFinalRange = new range(rangeToAdd.min,); 
                    }
                }
            }
        }

        public void sortPieRanges() {
            for(int i = 0; i<pieRanges.size(); i++) {
                for(int j=0; j<pieRanges.size(); j++) {
                    if (j != (pieRanges.size() -1)) {
                        range currentRange = pieRanges.get(j);
                        range nextRange = pieRanges.get(j+1);
                        if(currentRange.max > nextRange.min) {
                            pieRanges.set(j+1, currentRange);
                            pieRanges.set(j, nextRange);
                        }
                    }
                }
            }
        }

        public boolean checkPie() {
            int length = pieRanges.size();
            for(int i =0; i<length; i++) {
                if(!(pieRanges.get(i)).icingUp) {
                    return false;
                }
            }
            allIcingUp = true;
            return true;
        }
    }

    public PieProblem()
    {
        clear();
        pie MyPie = new pie();
        ArrayList list = new ArrayList();
        list.add(new range(10,20, true));
        list.add(new range(1,10, true));
        list.add(new range(20,30, true));
        list.add(new range(30, 40, true));
        MyPie.pieRanges = list;
        MyPie.sortPieRanges();
        printPieRanges(MyPie.pieRanges);
        MyPie.addRange(new range(24, 32, true));
        printPieRanges(MyPie.pieRanges);

    }

    public void minimumFlips(int a, int b, int c, pie MyPie) {
        char currentIteration = 'x';
        double currentDegree = 0;

        double myX = 360 / a;
        double myY = 360 / b;
        double myZ = 360 / c; 
        range currentRange = new range(currentDegree, currentDegree + myX);

        while (!(MyPie.checkPie())) { //While all icing is not up
            //Need to handle currentRange values greater than 360
            MyPie.sortPieRanges();

            MyPie.pieRanges.add(currentRange);
            switch (currentIteration) {
                case 'x':
                currentRange = new range(currentDegree, currentDegree + myX);
                currentDegree = currentDegree + myX;
                currentIteration = 'y';
                case 'y':
                currentRange = new range(currentDegree, currentDegree + myY);
                currentDegree = currentDegree + myY;
                currentIteration = 'z';
                case 'z':
                currentRange = new range(currentDegree, currentDegree + myZ);
                currentDegree = currentDegree + myZ;
                currentIteration = 'x';
            }
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
