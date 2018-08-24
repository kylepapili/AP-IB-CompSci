
public class hsctf100
{
    //Crypto 100 text2numbers
    int[] problemArray = {23, 5, 12, 12, 27, 20, 8, 5, 27, 6, 12, 1, 7, 27, 9, 19, 27, 8, 9, 4, 4, 5, 14, 27, 8, 5, 18, 5, 27, 2, 21, 20, 27, 6, 9, 18, 19, 20, 27, 23, 5, 27, 8, 1, 22, 5, 27, 19, 15, 13, 5, 27, 20, 5, 24, 20, 27, 20, 15, 27, 3, 15, 14, 6, 21, 19, 5, 27, 25, 15, 21, 27, 14, 15, 23, 27, 20, 8, 5, 27, 6, 12, 1, 7, 27, 9, 19, 27, 9, 14, 27, 6, 1, 3, 20, 27, 19, 5, 3, 18, 5, 20, 19, 28, 1, 18, 5, 28, 8, 9, 4, 4, 5, 14, 28, 9, 14, 28, 20, 8, 9, 19, 28, 12, 9, 19, 20, 27, 4, 15, 14, 20, 27, 9, 14, 3, 12, 21, 4, 5, 27, 20, 8, 5, 27, 16, 1, 18, 20, 19, 27, 20, 8, 1, 20, 27, 1, 18, 5, 27, 19, 5, 16, 5, 18, 1, 20, 5, 4, 27, 23, 9, 20, 8, 27, 19, 16, 1, 3, 5, 19};
    String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " ", "_"};
    
    public hsctf100()
    {
        clear();
        String result = "";
        for( int i=0; i<problemArray.length; i++) {
            int currentNum = problemArray[i];
            System.out.println(currentNum);
            System.out.println((alphabet[currentNum-1]));
            result = result + (alphabet[currentNum-1]);
        }
        System.out.println(result);
    }

    public int convertToTernary(int numberToConvert) {
        int digits = (int)(Math.log10(numberToConvert)+1);
        String numberStr = String.valueOf(numberToConvert);
        char[] charArray = numberStr.toCharArray();
        double sum = 0;
        for(int i=0; i<digits; i++) {
            double currentDigit = numberToConvert % Math.pow(10, i);
            double thingToAdd = currentDigit*Math.pow(3, i);
            sum = sum + currentDigit;
        }
    }
    
    
    public void clear() {
        System.out.println("\f");
    }
}
