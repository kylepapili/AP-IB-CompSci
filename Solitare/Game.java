package Solitare;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game
{
    Deck cardPile = new Deck(false);
    Deck cardsOnTable = new Deck(true); //Empty
    Deck discardCards = new Deck(true); //Empty
    Boolean isOver = false;
    Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            clear();
            Game thisGame = new Game();
            while (!(thisGame.isOver)) {
                clear();
                thisGame.promptUser();
            } 
            clear();
            System.out.println("You won! Nice job!!!");
        }
    }

    public Game()
    {
        this.cardPile.shuffle();
        this.cardsOnTable = cardPile.deal(9);
    }

    public boolean checkSum(int valueOne, int valueTwo) {
        if (valueOne + valueTwo == 11) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSum(Card cardOne, Card cardTwo, Card cardThree) {
        if ((cardOne.value + cardTwo.value + cardThree.value == 30) && (cardOne.name != cardTwo.name && cardOne.name != cardThree.name && cardThree.name != cardTwo.name)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateGame(int cardToRemoveOne, int cardToRemoveTwo) {
        Card cardOne = cardsOnTable.deck.get(cardToRemoveOne - 1);
        Card cardTwo = cardsOnTable.deck.get(cardToRemoveTwo - 1);

        if (checkSum(cardOne.value, cardTwo.value)) {
            cardsOnTable.deck.remove(cardOne);
            cardsOnTable.deck.remove(cardTwo);
            checkWin();
            if (this.isOver) {
                return;
            }
            if(cardPile.deck.size() >= 2) {
                cardsOnTable.deck.addAll((cardPile.deal(2)).deck);
            } else if(cardPile.deck.size() == 1) {
                cardsOnTable.deck.addAll((cardPile.deal(1)).deck);
            }
        }
    }

    public void updateGame(int cardToRemoveOne, int cardToRemoveTwo, int cardToRemoveThree) {
        Card cardOne = cardsOnTable.deck.get(cardToRemoveOne - 1);
        Card cardTwo = cardsOnTable.deck.get(cardToRemoveTwo - 1);
        Card cardThree = cardsOnTable.deck.get(cardToRemoveThree - 1);

        if (checkSum(cardOne, cardTwo, cardThree)) {
            cardsOnTable.deck.remove(cardOne);
            cardsOnTable.deck.remove(cardTwo);
            cardsOnTable.deck.remove(cardThree);

            checkWin();
            if (this.isOver) {
                return;
            }
            if(cardPile.deck.size() >= 3) {
                cardsOnTable.deck.addAll((cardPile.deal(3)).deck);
            } else if(cardPile.deck.size() == 1 || cardPile.deck.size() == 2) {
                cardsOnTable.deck.addAll((cardPile.deal(1)).deck);
            }
        }
    }

    public void checkWin() {
        if (cardPile.deck.size() == 0 && cardsOnTable.deck.size() == 0) {
            this.isOver = true;
        }
    }

    public void promptUser() { 
        this.cardsOnTable.printDeck();
        System.out.println("Would you like to remove 2 or 3 cards? (2, 3)");
        String responseStr = this.userInput.next();
        int decisionInt = Integer.parseInt(responseStr);
        if ( decisionInt == 2 ) {
            System.out.println("First card you would like to remove? (1-9)");
            responseStr = this.userInput.next();
            int responseIntOne = Integer.parseInt(responseStr);
            System.out.println("Second card you would like to remove? (1-9)");
            String responseStrTwo = this.userInput.next();
            int responseIntTwo = Integer.parseInt(responseStrTwo);
            if (responseIntOne > 0 && responseIntOne < (cardsOnTable.deck.size() + 1) && responseIntTwo > 0 && responseIntTwo < (cardsOnTable.deck.size() + 1) && responseIntOne != responseIntTwo) {
                //Good response
                updateGame(responseIntOne, responseIntTwo); 
            } else {
                //Do it again
                return;
            }
        } else if (decisionInt == 3) {
            System.out.println("First card you would like to remove? (1-9)");
            responseStr = this.userInput.next();
            int responseIntOne = Integer.parseInt(responseStr);
            System.out.println("Second card you would like to remove? (1-9)");
            String responseStrTwo = this.userInput.next();
            int responseIntTwo = Integer.parseInt(responseStrTwo);
            System.out.println("Third card you would like to remove? (1-9)");
            String responseStrThree = this.userInput.next();
            int responseIntThree = Integer.parseInt(responseStrThree);
            if (responseIntOne > 0 && responseIntOne < (cardsOnTable.deck.size() + 1) && responseIntTwo > 0 && responseIntTwo < (cardsOnTable.deck.size() + 1) && responseIntOne != responseIntTwo && responseIntThree > 0 && responseIntThree < (cardsOnTable.deck.size() + 1) && responseIntThree != responseIntTwo && responseIntThree != responseIntOne) {
                //Good response
                updateGame(responseIntOne, responseIntTwo, responseIntThree); 
            } else {
                //Do it again
                System.out.println("Input Error, please try again.");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } finally {
                    return;
                }
            }
        }
    }

    public static void clear() {
        System.out.println("\f");
    }
}
