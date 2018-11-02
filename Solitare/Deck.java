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
        Deck testDeck = new Deck(false);
        testDeck.shuffle();
        Deck randDeck = testDeck.deal(25);
        testDeck.printDeck();
        System.out.println("HEHEEHEHEHEE");
        randDeck.printDeck();
    }

    public Deck(ArrayList<Card> cards) {
        this.deck = new ArrayList<Card>(cards.size());
        for (int i = 0; i < cards.size(); i++) {
            this.deck.add(cards.get(i));
        }
    }

    public Deck(Boolean isEmpty)
    {
        if (isEmpty) {
            this.deck = new ArrayList<Card>();
        } else {
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
    }

    public Deck deal(int amount) {
        ArrayList<Card> returnArray = new ArrayList<Card>(amount);
        for(int i = 0; i<amount; i++) {
            returnArray.add(this.deck.get(i));
            this.deck.remove(i);
        }
        Deck returnDeck = new Deck(returnArray);
        return returnDeck;
    }

    public void shuffle() {
        Collections.shuffle(this.deck); //Shuffle Deck
    }

    public void printDeck() {
        for (int i = 0; i<this.deck.size(); i++) {
            System.out.print(i+1);
            System.out.println(". " + this.deck.get(i).prettyName());
        }
    }

    public static void clear() {
        System.out.println("\f");
    }
}
