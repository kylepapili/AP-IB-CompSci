package Solitare;

/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    public String suit = "";
    public int value = 0;

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
        if (this.value < 10 && this.value > 1) { //Normal Number Card
            name = Integer.toString(this.value);
        } else {
            switch (this.value) {
                case 11:
                    name = "Jack";
                case 12:
                    name = "Queen";
                case 13:
                    name = "King";
                case 1:
                    name = "Ace";
            }
        }
        
        return (name + " of " + this.suit + "s");
    }
}
