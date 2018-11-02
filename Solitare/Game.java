package Solitare;
import java.util.Scanner;

public class Game
{
    Deck cardPile = new Deck(false);
    Deck cardsOnTable = new Deck(true); //Empty
    Deck discardCards = new Deck(true); //Empty
    Boolean isOver = false;
    Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        clear();
        Game thisGame = new Game();
        while (!(thisGame.isOver)) {
            clear();
            thisGame.promptUser();
        }
    }

    public Game()
    {
        this.cardPile.shuffle();
        this.cardsOnTable = cardPile.deal(9);
    }

    public void updateGame(int cardToRemoveOne, int cardToRemoveTwo) {
        Card cardOne = cardsOnTable.deck.get(cardToRemoveOne - 1);
        Card cardTwo = cardsOnTable.deck.get(cardToRemoveTwo - 1);
        cardsOnTable.deck.remove(cardOne);
        cardsOnTable.deck.remove(cardTwo);
    }

    public void promptUser() { 
        this.cardsOnTable.printDeck();
        System.out.println("First card you would like to remove? (1-9)");
        String responseStr = this.userInput.next();
        int responseIntOne = Integer.parseInt(responseStr);
        System.out.println("Second card you would like to remove? (1-9)");
        String responseStrTwo = this.userInput.next();
        int responseIntTwo = Integer.parseInt(responseStrTwo);
        if (responseIntOne > 0 && responseIntOne < 10 && responseIntTwo > 0 && responseIntTwo < 10) {
            //Good
            updateGame(responseIntOne, responseIntTwo); 
        } else {
            //Do it again
            return;
        }
    }

    public static void clear() {
        System.out.println("\f");
    }
}
