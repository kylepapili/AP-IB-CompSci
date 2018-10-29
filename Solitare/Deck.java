package Solitare;
import java.util.*;

/**
 * Deck Class
 */
public class Deck
{
    public ArrayList<Card> deck = new ArrayList<Card>(52);
    public static void main(String[] args)
    {
        clear();
        Deck testDeck = new Deck();
        testDeck.printDeck();
    }

    public Deck()
    {
        for( int i = 0; i<4; i++) { //Suit
            String suit = "";
            switch (i) {
                case 0: suit = "Heart";
                    break;
                case 1: suit = "Club";
                    break;
                case 2: suit = "Spaid";
                    break;
                case 3: suit = "Diamond";
                    break;
            }
            for (int j = 2; j<15; j++) {
                this.deck.add(new Card(suit, Integer.toString(j)));
            }
        }
    }
    
    public void printDeck() {
        for (int i = 0; i<this.deck.size(); i++) {
            System.out.println(this.deck.get(i).prettyName());
        }
    }

    public static void clear() {
        System.out.println("\f");
    }
}
