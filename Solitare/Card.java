package Solitare;

/**
 * Card Class with all attributes, methods, and inializers
 */

public class Card
{
    public String suit = "";
    public int value = 0;
    public String name = "";
    public boolean isFaceCard = false;

    public Card(String suit , String value)
    {
        this.suit = suit;
        int numValue = Integer.parseInt(value);
        if (numValue <= 10 && numValue > 1) { //Normal Number Card
            this.name = Integer.toString(numValue);
            this.value = numValue;
            this.isFaceCard = false;
        } else {
            switch (numValue) {
                case 11:
                this.isFaceCard = true;
                this.name = "Jack";
                this.value = 10;
                break;
                case 12:
                this.isFaceCard = true;
                this.name = "Queen";
                this.value = 10;
                break;
                case 13:
                this.isFaceCard = true;
                this.name = "King";
                this.value = 10;
                break;
                case 14:
                this.isFaceCard = true;
                this.name = "Ace";
                this.value = 1;
                break;
            }
        }
    }

    //Accessor Methods
    public String getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    public String prettyName() {
        return (this.name + " of " + this.suit + "s");
    }

    public void clear() {
        System.out.println("\f");
    }
}
