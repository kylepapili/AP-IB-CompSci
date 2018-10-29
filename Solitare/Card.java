package Solitare;

/**
 * Card Class with all attributes, methods, and inializers
 */


public class Card
{
    public String suit = "";
    public int value = 0;
    public static void main(String[] args)
    {
        Card testCard = new Card("Spaid", "10");
        System.out.println(testCard.prettyName());
    }

    public Card(String suit , String value)
    {
        this.suit = suit;
        this.value = Integer.parseInt(value);
    }

    //Accessor Methods
    public String getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    public String prettyName() {
        String name = "";
        if (this.value <= 10 && this.value > 1) { //Normal Number Card
            name = Integer.toString(this.value);
        } else {
            switch (this.value) {
                case 11:
                    name = "Jack";
                    break;
                case 12:
                    name = "Queen";
                    break;
                case 13:
                    name = "King";
                    break;
                case 14:
                    name = "Ace";
                    break;
            }
        }

        return (name + " of " + this.suit + "s");
    }
    
    public void clear() {
        System.out.println("\f");
    }
}
