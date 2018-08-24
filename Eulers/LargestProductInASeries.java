package Eulers;
import java.util.*;
import java.lang.Number;
import java.math.BigInteger;

public class LargestProductInASeries
{
    public LargestProductInASeries()
    {
        clear();
        String largeNum = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        ArrayList digits = interpretNumber(largeNum);
        //System.out.print("Digits[0]: " + digits.get(1));
        System.out.print("Greatest Product Of Adjacent Digits: " + greatestProductOfAdjacentDigits(13, digits));
        
        
    }

    public BigInteger greatestProductOfAdjacentDigits(int amountOfDigits, ArrayList digits) {
        int length = digits.size();
        int currentMax = 0;
        BigInteger currentGreatestProduct = BigInteger.ZERO;
        for(int i=0; i<(length - amountOfDigits); i++) {
            BigInteger currentProduct = BigInteger.ONE;
            currentMax = i + amountOfDigits;
            for(int j = i; j<currentMax; j++) {
                System.out.print(j + "-");
                int currentValue = (Integer) digits.get(j);
                BigInteger bi = BigInteger.valueOf(currentValue);
                currentProduct = currentProduct.multiply(bi);
            }
            if(currentProduct.compareTo(currentGreatestProduct) > 0) {
                currentGreatestProduct = currentProduct;
                System.out.println("\ni: " + i);
            }
        }
        return currentGreatestProduct;
    }

    public ArrayList interpretNumber(String numStr) {
        ArrayList returnArray = new ArrayList();
        for (int i = 0; i < numStr.length(); i++){
            char d =numStr.charAt(i);
            String c = Character.toString(d);
            int currentInt = Integer.valueOf(c);
            returnArray.add(currentInt);
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
