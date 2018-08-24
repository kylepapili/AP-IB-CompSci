import java.util.*;
public class hsctfOk
{
    ArrayList<String> messageChain = new ArrayList<String>();

    public hsctfOk()
    {
        clear();
        messageChain.add("OK");
        messageChain.add("KOOK");
        generateMessages();
        String finalMessage = messageChain.get(messageChain.size()-1);
        for( int i=0; i<messageChain.size(); i++) {
            int length = messageChain.get(i).length();
            System.out.print(length + ", ");
        }
    }
    
    public void generateMessages() {
        for(int i=1; i<17; i++) {
            System.out.print(i + ", ");
            String currentMessage = messageChain.get(i);
            char[] arrayOfChar = currentMessage.toCharArray();
            ArrayList arrayListOfChar = new ArrayList<>();
            char[] newCharArray = arrayOfChar;
            for(int j=0; j<arrayOfChar.length; j++) {
                String currentStus = new String (newCharArray);
                char currentChar = arrayOfChar[j];
                if(Character.toString(currentChar).matches("K")) {
                    char o = 'O';
                    char k = 'K';
                    arrayListOfChar.add(o);
                    arrayListOfChar.add(k);
                }
                if(Character.toString(currentChar).matches("O")) {
                    char o = 'O';
                    char k = 'K';
                    arrayListOfChar.add(k);
                    arrayListOfChar.add(o);
                }
            }
            
            char[] finalCharArray = convert(arrayListOfChar);
            String finalString = new String(finalCharArray);
            messageChain.add(finalString);
        }
    }
    
    public ArrayList convert(char[] array) {
        ArrayList arrayListOfChar = new ArrayList<>(Arrays.asList(array));
        return arrayListOfChar;
    }
    
    
    public char[] convert(ArrayList arrayList) {
        char[] returnArray = new char[arrayList.size()];
        for( int i =0; i<arrayList.size(); i++) {
            returnArray[i] = (char) arrayList.get(i);
        }
        
        return returnArray;
    }
    

    public char[] depositElements(char[] from, char[] to, int index) {
        int originalIndex = index;
        char[] newArray = new char[(to.length + from.length) - 1];
        if (index == 0) {

            for(int i = 0; i < from.length; i++) {
                newArray[index++] = from[i];
            }
            newArray[ from.length ] = to[ originalIndex + 1 ];

        } else {

            int j = 0;
            while ( j<originalIndex ) {
                newArray[j] = to[j];
                j++;
            }

            for (int i = 0; i<from.length; i++) {
                newArray[ index++ ] = from[i];
            }
        }
        return newArray;
    }
    
    
    public void printArrayList(ArrayList arrayList) {
        System.out.println("Here is Your Arraylist!");
        for (int i = 0; i<arrayList.size(); i++) {
            boolean lastTurn = (i==arrayList.size()-1);
            if (lastTurn) {
                System.out.println(arrayList.get(i));
            } else {
                System.out.print(arrayList.get(i) + ", ");
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
