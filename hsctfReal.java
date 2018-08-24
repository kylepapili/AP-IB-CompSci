

public class hsctfReal
{
    public hsctfReal()
    {
        clear();
        int[] fourUnshuffled = unshuffle4("ertskzgmlpdkqyw");
        int[] threeUnshuffled = unshuffle3(fourUnshuffled);
        int[] twoUnshuffled = shuffle2(threeUnshuffled);
        String oneUnshuffled = unshuffle1(twoUnshuffled);
        
        System.out.println(oneUnshuffled);
    }
    
    public static int[] unshuffle4(String input)
    {
        String rand = "!0&#81%$7##&439";
        char[] word = input.toCharArray();
        int[] add = new int[word.length];
        for(int i=word.length-1; i>= 0; i--) {
            add[i] = (int) (word[i] - rand.charAt(i));
        }
        return add;
    }
    
    public static String shuffle4(String f, int[] add)
    {
        char[] word = new char[15];
        for (int i = add.length - 1; i >= 0; i--)
        {
            word[i] = (char)(add[i] + f.charAt(i)); 
        }
        String b = new String(word);
        return b;
    }
    
    public static int[] unshuffle3(int[] input) {
        int[] amend = {66,62,9,17,44,12,58,7,98,27,5,62,14,63,59};
        int[] output = new int[15];
        for(int i = input.length - 1; i >= 0; i--)
        {
            if(amend[i] % 2 == 1) //odd
            {
                output[i] = input[i] - amend[i];
            }
            else
            {
                output[i] = input[i];
            }
        }
        return output;
    }
    
    public static int[] shuffle3(int[] add)
    {
        int[] amend = {66,62,9,17,44,12,58,7,98,27,5,62,14,63,59};
        int[] temp = new int[15];
        for(int i = add.length - 1; i >= 0; i--)
        {
            if(amend[i] % 2 == 1) //odd
            {
                temp[i] = add[i] + amend[i];
            }
            else
            {
                temp[i] = add[i];
            }
        }
        return temp;
    }
    
    public static int[] shuffle2(int[] add)
    {
        for(int i = 0; i < add.length / 2; i++)
        {
            int temp = add[i];
            add[i] = add[add.length - i - 1];
            add[add.length - i - 1] = temp;
        }
        return add;
    }

    
    public static String unshuffle1(int[] numArray) {
        char[] temp = new char[numArray.length];
        for(int i = 0; i<numArray.length; i++) {
            char ch = (char) (numArray[i] + 48);
            temp[i] = ch;
        }
        
        String returnStr = new String(temp);
        return returnStr;
    }
    
    public static int[] shuffle1(String word)
    {
        char[] temp = word.toCharArray();
        int[] num = new int[word.length()];
        for (int i = 0; i < word.length(); i++) 
        {
            num[i] = temp[i]-'0';
        }
        return num;
    }
    public void clear() {
        System.out.println("\f");
    }
}
