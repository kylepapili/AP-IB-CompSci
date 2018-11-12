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
    String endMessage = "";
    public static void main(String[] args) {
        Game thisGame = new Game();
        thisGame.runGame();
    }

    public Game()
    {
        this.cardPile.shuffle();
        this.cardsOnTable = cardPile.deal(9);
    }

    public void runGame() {
        while (true) {
            clear();
            this.isOver = false;
            while (!(this.isOver)) {
                clear();
                this.promptUser();
                if (checkImpossibleWin()) {
                    this.isOver = true;
                    this.endMessage = "No further sums of 11 available.";
                }
            } 
            clear();
            //Do it again
            this.cardPile = new Deck(false);
            this.cardsOnTable = new Deck(true); //Empty
            this.cardPile.shuffle();
            this.cardsOnTable = cardPile.deal(9);
            System.out.println(endMessage);
            try {
                TimeUnit.SECONDS.sleep(3);
            } finally {
                this.runGame();
                break;
            }
        }
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

    public void checkWin() {
        if (cardPile.deck.size() == 0 && cardsOnTable.deck.size() == 0) {
            this.isOver = true;
            this.endMessage = "Congratulations, you won!";
        } 
    }

    public boolean checkImpossibleWin() {
        for ( int i = 0; i < this.cardsOnTable.deck.size(); i ++) {
            Card thisCard = this.cardsOnTable.deck.get(i);
            for (int j = 0; j < this.cardsOnTable.deck.size(); j++) {
                Card cardToCompare = this.cardsOnTable.deck.get(j);
                if (thisCard.prettyName() != cardToCompare.prettyName()) {
                    //Cards are not the same
                    if (thisCard.value + cardToCompare.value == 11) {
                        return false;
                    }
                }
            }
        }

        for ( int i = 0; i < this.cardsOnTable.deck.size(); i ++) {
            Card firstCard = this.cardsOnTable.deck.get(i);
            for (int j = 0; j < this.cardsOnTable.deck.size(); j++) {
                Card secondCard = this.cardsOnTable.deck.get(j);
                for (int k = 0; k < this.cardsOnTable.deck.size(); k++) {
                    Card thirdCard = this.cardsOnTable.deck.get(k);
                    //Make sure none are the same
                    if (!(firstCard.prettyName() == secondCard.prettyName() || firstCard.prettyName() == thirdCard.prettyName() || thirdCard.prettyName() == secondCard.prettyName())) {
                        //Check to see that they are different names
                        if (firstCard.name != secondCard.name && firstCard.name != thirdCard.name && secondCard.name != thirdCard.name) {
                            if (firstCard.isFaceCard && secondCard.isFaceCard && thirdCard.isFaceCard) {
                                if (firstCard.value + secondCard.value + thirdCard.value == 30) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
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
                System.out.println("Input Error, please try again.");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } finally {
                    return;
                }
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

    public static void clear() {
        System.out.println("\f");
    }
}
