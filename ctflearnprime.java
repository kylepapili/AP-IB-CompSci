
import java.util.*;
import java.lang.Number;
import java.math.BigInteger;
public class ctflearnprime
{
    public ctflearnprime()
    {
        int sum = 50847534;
        clear();
        for( int i=999999999; i>987163160; i=i-2) {
            System.out.print(i + ", ");
            BigInteger bi = BigInteger.valueOf(i);
            if( isPrime(bi) ) {
                sum = sum - 1;
            }
        }

        System.out.println("SUM: " + sum);
    }

    public boolean isPrime(BigInteger number) {
        BigInteger half = (number).divide(new BigInteger("2"));
        BigInteger root = sqrt(number);
        for (BigInteger bi = root; bi.compareTo(BigInteger.ONE) > 0; bi = bi.subtract(BigInteger.ONE)) {
            if((number.mod(bi)).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }

    public static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }

    public ArrayList listOfFactors(BigInteger number) {
        ArrayList factors = new ArrayList();

        for (BigInteger bi = BigInteger.valueOf(1); bi.compareTo(number) < 0; bi = bi.add(BigInteger.ONE)) {
            if(number.mod(bi).equals(BigInteger.ZERO) && !(factors.contains(bi))) {
                factors.add(bi);
            }
        }
        return factors;
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
