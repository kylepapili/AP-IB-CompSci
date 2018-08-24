import java.util.*;
import java.lang.Number;
import java.math.BigInteger;
import java.util.Arrays;

public class BlockChain
{

    ArrayList<Block> BlockChain = new ArrayList<>();

    public BlockChain()
    {
        clear();
        String[] testList = {"a", "b", "c"};
        String[] testListTwo = {"d", "e", "f"};

        String[] genesisTransactions = {"I found $50", "I gave $30 to Satoshi"};
        Block genesisBlock = new Block(0, genesisTransactions);

        String[] BlockTwoTransactions = {"Satoshi gave me $10", "I spent $20"};
        Block BlockTwo = new Block(genesisBlock.blockHash, BlockTwoTransactions);

        System.out.println("Genesis Block: " + genesisBlock.blockHash);
        System.out.println("Block Two: " + BlockTwo.blockHash);
        System.out.println("Block Two Previous: " + BlockTwo.previousHash);
    }

    //Classes
    public class Block {
        private int previousHash;
        private String[] transactions;
        private int blockHash;

        //Setters
        public Block(int previousHash, String[] transactions) {
            this.previousHash = previousHash;
            this.transactions = transactions;

            Object[] contents = {Arrays.hashCode(this.transactions), previousHash};
            this.blockHash = Arrays.hashCode(contents);
        }

        //Helper Functions
        public String printBlockInfo() {
            String returnStatement = ("{ previousHash: " + this.previousHash + ", transactions: ");
            String arrayPrint = "[ ";
            for(int i=0; i<transactions.length; i++)  {
                if(i== transactions.length - 1) {
                    arrayPrint = arrayPrint + "Transaction #" + i + ": " + transactions[i] + "]";
                } else { 
                    arrayPrint = arrayPrint + "Transaction #" + i + ": " + transactions[i] + ", ";
                }
            }
            return returnStatement + arrayPrint + " }";
        }

        //Getters
        public int getPreviousHash() {
            return this.previousHash;
        }

        public String[] getTransactions() {
            return this.transactions;
        }

        private int currentHash;
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
