import java.util.Scanner;
import java.lang.Object;
import java.util.Random;
public class TicTacToe
{
    static int space1=0;
    static int space2=0;
    static int space3=0;
    static int space4=0;
    static int space5=0;
    static int space6=0;
    static int space7=0;
    static int space8=0;
    static int space9=0;
    static int thereIsWin = 0;
    public static void main(String[] args)
    {    
        /**_____________________
        GAME INTRODUCTION: 
        Get user choice
        Setup Board
        Explain Game
        Begin Game
        _____________________*/
        Scanner user_input = new Scanner( System.in );
        Turtle joe = new Turtle();
        joe.speed(.1);
        drawBoard( joe );
        //Getting User Selection
        System.out.println("Welcome To The Game!");
        System.out.println("You will play the computer, would you like to be X's or O's?");
        String userPlayer; //userPlayer: 1=X's, 0=O's
        userPlayer = user_input.next();
        userPlayer = userPlayer.toLowerCase();
        userPlayerChoice(joe, userPlayer);
    }

    /**_____________________
    Decipher whether user want's X's or O's
    Once user choice has been determined: 
    startGame()
    _____________________*/
    static void userPlayerChoice(Turtle t, String userSelection) {
        if( userSelection.equals("x") ) {
            int userPlayerInt = 1;
            startGame(t, userPlayerInt);
        }
        else if( userSelection.equals("o") ) {
            int userPlayerInt = 0;
            startGame(t, userPlayerInt);
        } else {
            System.out.println("Please type in either 'x' or 'o'");
            userPlayerChoiceRedo(t);
        }
    }

    /**_____________________
    If the user puts something other than X or O originally, take their input again
    _____________________*/

    static void userPlayerChoiceRedo(Turtle t) {
        Scanner user_input = new Scanner( System.in );
        String userPlayerRedo;
        userPlayerRedo = user_input.next();
        userPlayerRedo = userPlayerRedo.toLowerCase();
        userPlayerChoice(t, userPlayerRedo);
    }
    //_____________________________________________________________________________________________________

    /**_____________________
    Start the game, computer goes first
    _____________________*/
    static void startGame(Turtle t, int userPlayerInt) {
        System.out.println("Okay Let's BEGIN!");
        int turnCheck = 2; //2 = even = computer turn
        if(userPlayerInt == 1) {
            drawO(t, 5, turnCheck, userPlayerInt);
            turnCheck = turnCheck + 1;
        }
        else if(userPlayerInt == 0) {
            drawX(t, 5, turnCheck, userPlayerInt);
            turnCheck = turnCheck + 1;
        }
    }

    /**_____________________
    Function for each game turn, it just see's who's turn it is and runs the apporpriate function
    _____________________*/
    static void gameTurn(Turtle t, int userPlayerInt, int turnCheck) {
        /**_____________________
        Check to see if the user or computer has won, if so set thereIsWin to 1 for X's win and -1 for O's win
        _____________________*/
        if(space1 == 1 && space2 == 1 && space3 == 1) { //1,2,3
            thereIsWin = 1;
        } else if(space1 == -1 && space2 == -1 && space3 == -1) {
            thereIsWin = -1;
        }
        if(space4 == 1 && space5 == 1 && space6 == 1) {//4,5,6
            thereIsWin = 1;
        } else if(space4 == -1 && space5 == -1 && space6 == -1) {
            thereIsWin = -1;
        }
        if(space7 == 1 && space8 == 1 && space9 == 1) {//7,8,9
            thereIsWin = 1;
        } else if(space7 == -1 && space8 == -1 && space9 == -1) {
            thereIsWin = -1;
        }
        if(space1 == 1 && space4 == 1 && space7 == 1) { //1, 4, 7
            thereIsWin = 1;
        } else if(space1 == -1 && space4 == -1 && space7 == -1) { 
            thereIsWin = -1;
        }
        if(space2 == 1 && space5 == 1 && space8 == 1) { //2, 5, 8
            thereIsWin = 1;
        } else if(space2 == -1 && space5 == -1 && space8 == -1) { 
            thereIsWin = -1;
        }
        if(space3 == 1 && space6 == 1 && space9 == 1) { //3, 6, 9
            thereIsWin = 1;
        } else if(space3 == -1 && space6 == -1 && space9 == -1) { 
            thereIsWin = -1;
        }
        if(space1 == 1 && space5 == 1 && space9 == 1) { //1, 5, 9
            thereIsWin = 1;
        } else if(space1 == -1 && space5 == -1 && space9 == -1) { 
            thereIsWin = -1;
        }
        if(space3 == 1 && space5 == 1 && space7 == 1) { //3, 5, 7
            thereIsWin = 1;
        } else if(space3 == -1 && space5 == -1 && space7 == -1) { 
            thereIsWin = -1;
        }
        if(space1 != 0 && space2 != 0 && space3 != 0 && space4 != 0 && space5 != 0 && space6 != 0 && space7 != 0 && space8 != 0 && space9 != 0) {
            if(thereIsWin == 0) {
                thereIsWin = 5; //5 means that it was a tie. No winner
            }
        }

        if(thereIsWin == 0) {
            if ( (turnCheck & 1) == 0 ) { //If turnCheck is an even number
                System.out.println("Okay, now I'll go!"); //It is the computer's turn
                computerTurn(t, userPlayerInt, turnCheck);
            } else { //If turnCheck is an odd number
                userTurn(t, userPlayerInt, turnCheck); //It is the user's turn
            }
        } else if(thereIsWin == 1) {
            System.out.println("X's WIN!!!");
            System.out.println("THANKS FOR PLAYING!!");
            System.exit(0);
        } else if(thereIsWin == -1) {
            System.out.println("O's WIN!!!");
            System.out.println("THANKS FOR PLAYING!!");
            System.exit(0);
        } else if(thereIsWin == 5) {
            System.out.println("TIE!!!");
            System.out.println("THANKS FOR PLAYING!!");
            System.exit(0);
        }
    }

    /**_____________________
    Computer AI Section, COMING SOON
    _____________________*/
    static void computerTurn(Turtle t, int userPlayerInt, int turnCheck) {
        System.out.println("Computer Turn: Please wait...");
        int turnChoice = 0;
        /**_____________________
        CHECK IF THE COMPUTER/USER HAS THE ABILITY TO WIN!!!
        _____________________*/
        if(userPlayerInt == 1) { //if the user is X
            //CHECK IF THE COMPUTER HAS THE ABILITY TO WIN
            //Top Row Check
            if(space1 == -1 && space2 == -1) {
                if(space3 == 0 && turnChoice == 0) {
                    drawO(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space2 == -1 && space3 == -1) {
                if(space1 == 0 && turnChoice == 0) {
                    drawO(t, 1, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == -1 && space3 == -1) {
                if(space2 == 0 && turnChoice == 0) {
                    drawO(t, 2, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //RIGHT COLUMN CHECK
            if(space3 == -1 && space6 == -1) {
                if(space9 == 0 && turnChoice == 0) {
                    drawO(t, 9, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space3 == -1 && space9 == -1) {
                if(space6 == 0 && turnChoice == 0) {
                    drawO(t, 6, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space6 == -1 && space9 == -1) {
                if(space3 == 0 && turnChoice == 0) {
                    drawO(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //BOTTOM ROW CHECK
            if(space7 == -1 && space8 == -1) {
                if(space9 == 0 && turnChoice == 0) {
                    drawO(t, 9, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space7 == -1 && space9 == -1) {
                if(space8 == 0 && turnChoice == 0) {
                    drawO(t, 8, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space8 == -1 && space9 == -1) {
                if(space7 == 0 && turnChoice == 0) {
                    drawO(t, 7, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //LEFT COLUMN CHECK
            if(space1 == -1 && space4 == -1) {
                if(space7 == 0 && turnChoice == 0) {
                    drawO(t, 7, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == -1 && space7 == -1) {
                if(space4 == 0 && turnChoice == 0) {
                    drawO(t, 4, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space4 == -1 && space7 == -1) {
                if(space1 == 0 && turnChoice == 0) {
                    drawO(t, 1, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //MIDDLE ROW CHECK
            if(space4 == -1 && space5 == -1) {
                if(space6 == 0 && turnChoice == 0) {
                    drawO(t, 6, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space4 == -1 && space6 == -1) {
                if(space5 == 0 && turnChoice == 0) {
                    drawO(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space5 == -1 && space6 == -1) {
                if(space4 == 0 && turnChoice == 0) {
                    drawO(t, 4, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //MIDDLE COLUMN CHECK
            if(space2 == -1 && space5 == -1) {
                if(space8 == 0 && turnChoice == 0) {
                    drawO(t, 8, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space2 == -1 && space8 == -1) {
                if(space5 == 0 && turnChoice == 0) {
                    drawO(t, 5, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space5 == -1 && space8 == -1) {
                if(space2 == 0 && turnChoice == 0) {
                    drawO(t, 2, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //DIAGONAL TL-BR CHECK
            if(space1 == -1 && space5 == -1) {
                if(space9 == 0 && turnChoice == 0) {
                    drawO(t, 9, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == -1 && space9 == -1) {
                if(space5 == 0 && turnChoice == 0) {
                    drawO(t, 5, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space5 == -1 && space9 == -1) {
                if(space1 == 0 && turnChoice == 0) {
                    drawO(t, 1, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //DIAGONAL TR-BL CHECK
            if(space3 == -1 && space5 == -1) {
                if(space7 == 0 && turnChoice == 0) {
                    drawO(t, 7, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space3 == -1 && space7 == -1) {
                if(space5 == 0 && turnChoice == 0) {
                    drawO(t, 5, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space5 == -1 && space7 == -1) {
                if(space3 == 0 && turnChoice == 0) {
                    drawO(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }

            //CHECK IF THE USER HAS THE ABILITY TO WIN
            if(space1 == 1 && space2 == 1) {
                if(space3 == 0 && turnChoice == 0) {
                    drawO(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space2 == 1 && space3 == 1) {
                if(space1 == 0 && turnChoice == 0) {
                    drawO(t, 1, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == 1 && space3 == 1) {
                if(space2 == 0 && turnChoice == 0) { 
                    drawO(t, 2, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == 1 && space4 == 1) {
                if(space7 == 0 && turnChoice == 0) {
                    drawO(t, 7, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space4 == 1 && space7 == 1) {
                if(space1 == 0 && turnChoice == 0) {
                    drawO(t, 1, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == 1 && space7 == 1) {
                if(space4 == 0 && turnChoice == 0) {
                    drawO(t, 4, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space3 == 1 && space6 == 1) {
                if(space9 == 0 && turnChoice == 0) {
                    drawO(t, 9, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space3 == 1 && space9 == 1) {
                if(space6 == 0 && turnChoice == 0) {
                    drawO(t, 6, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space6 == 1 && space9 == 1) {
                if(space3 == 0 && turnChoice == 0) {
                    drawO(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == 1 && space2 == 1) {
                if(space3 == 0 && turnChoice == 0) {
                    drawO(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space7 == 1 && space8 == 1) {
                if(space9 == 0 && turnChoice == 0) {
                    drawO(t, 9, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space8 == 1 && space9 == 1) {
                if(space7 == 0 && turnChoice == 0) {
                    drawO(t, 7, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space7 == 1 && space9 == 1) {
                if(space8 == 0 && turnChoice == 0) {
                    drawO(t, 8, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
        }
        /**_____________________
        THE USER CAN'T WIN SOOO... We'll Go...
        _____________________*/
        if ( userPlayerInt == 1) {
            if ( turnCheck >= 4 ) {
                Random rand = new Random();
                int randomNum = rand.nextInt((4 - 1) + 1) + 1;
                if(randomNum == 1) {
                    if(space1 == 0 && turnChoice == 0) {
                        drawO(t, 1, turnCheck, userPlayerInt);
                        turnChoice = 1;
                    } else if(!(space1!=0 && space3 !=0 && space7 !=0 && space9 !=0)){
                        computerTurn(t, userPlayerInt, turnCheck);
                    }
                }
                if(randomNum == 2) {
                    if(space3 == 0 && turnChoice == 0) {
                        drawO(t, 3, turnCheck, userPlayerInt);
                        turnChoice = 1;
                    } else if(!(space1!=0 && space3 !=0 && space7 !=0 && space9 !=0)){
                        computerTurn(t, userPlayerInt, turnCheck);
                    }
                }
                if(randomNum == 3) {
                    if(space7 == 0 && turnChoice == 0) {
                        drawO(t, 7, turnCheck, userPlayerInt);
                        turnChoice = 1;
                    } else if(!(space1!=0 && space3 !=0 && space7 !=0 && space9 !=0)){
                        computerTurn(t, userPlayerInt, turnCheck);
                    }
                }
                if(randomNum == 4) {
                    if(space9 == 0 && turnChoice == 0) {
                        drawO(t, 9, turnCheck, userPlayerInt);
                        turnChoice = 1;
                    } else if(!(space1!=0 && space3 !=0 && space7 !=0 && space9 !=0)){
                        computerTurn(t, userPlayerInt, turnCheck);
                    }
                }
                if( space1 != 0 && space3 != 0 && space7 !=0 && space9 != 0) { //if all the corners are taken
                    Random rand2 = new Random();
                    int randomNum2 = rand2.nextInt((4 - 1) + 1) + 1;
                    if(randomNum2 == 1) {
                        if(space2 == 0 && turnChoice ==0) {
                            drawO(t, 2, turnCheck, userPlayerInt);
                            turnChoice = 1;
                        } else {
                            computerTurn(t, userPlayerInt, turnCheck);
                        }
                    }
                    if(randomNum2 == 2) {
                        if(space4 == 0 && turnChoice ==0) {
                            drawO(t, 4, turnCheck, userPlayerInt);
                            turnChoice = 1;
                        } else {
                            computerTurn(t, userPlayerInt, turnCheck);
                        }
                    }
                    if(randomNum2 == 3) {
                        if(space6 == 0 && turnChoice ==0) {
                            drawO(t, 6, turnCheck, userPlayerInt);
                            turnChoice = 1;
                        } else {
                            computerTurn(t, userPlayerInt, turnCheck);
                        }
                    }
                    if(randomNum2 == 4) {
                        if(space8 == 0 && turnChoice ==0) {
                            drawO(t, 8, turnCheck, userPlayerInt);
                            turnChoice = 1;
                        } else {
                            computerTurn(t, userPlayerInt, turnCheck);
                        }
                    }
                }
            }
        }

        /**NOW FOR O's
        ----------------------*/

        if(userPlayerInt == 0) { //if the user is X
            //CHECK IF THE COMPUTER HAS THE ABILITY TO WIN
            //Top Row Check
            if(space1 == 1 && space2 == 1) {
                if(space3 == 0 && turnChoice == 0) {
                    drawX(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space2 == 1 && space3 == 1) {
                if(space1 == 0 && turnChoice == 0) {
                    drawX(t, 1, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == 1 && space3 == 1) {
                if(space2 == 0 && turnChoice == 0) {
                    drawX(t, 2, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //RIGHT COLUMN CHECK
            if(space3 == 1 && space6 == 1) {
                if(space9 == 0 && turnChoice == 0) {
                    drawX(t, 9, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space3 == 1 && space9 == 1) {
                if(space6 == 0 && turnChoice == 0) {
                    drawX(t, 6, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space6 == 1 && space9 == 1) {
                if(space3 == 0 && turnChoice == 0) {
                    drawX(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //BOTTOM ROW CHECK
            if(space7 == 1 && space8 == 1) {
                if(space9 == 0 && turnChoice == 0) {
                    drawX(t, 9, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space7 == 1 && space9 == 1) {
                if(space8 == 0 && turnChoice == 0) {
                    drawX(t, 8, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space8 == 1 && space9 == 1) {
                if(space7 == 0 && turnChoice == 0) {
                    drawX(t, 7, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //LEFT COLUMN CHECK
            if(space1 == 1 && space4 == 1) {
                if(space7 == 0 && turnChoice == 0) {
                    drawX(t, 7, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == 1 && space7 == 1) {
                if(space4 == 0 && turnChoice == 0) {
                    drawX(t, 4, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space4 == 1 && space7 == 1) {
                if(space1 == 0 && turnChoice == 0) {
                    drawX(t, 1, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //MIDDLE ROW CHECK
            if(space4 == 1 && space5 == 1) {
                if(space6 == 0 && turnChoice == 0) {
                    drawX(t, 6, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space4 == 1 && space6 == 1) {
                if(space5 == 0 && turnChoice == 0) {
                    drawX(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space5 == 1 && space6 == 1) {
                if(space4 == 0 && turnChoice == 0) {
                    drawX(t, 4, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //MIDDLE COLUMN CHECK
            if(space2 == 1 && space5 == 1) {
                if(space8 == 0 && turnChoice == 0) {
                    drawX(t, 8, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space2 == 1 && space8 == 1) {
                if(space5 == 0 && turnChoice == 0) {
                    drawX(t, 5, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space5 == 1 && space8 == 1) {
                if(space2 == 0 && turnChoice == 0) {
                    drawX(t, 2, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //DIAGONAL TL-BR CHECK
            if(space1 == 1 && space5 == 1) {
                if(space9 == 0 && turnChoice == 0) {
                    drawX(t, 9, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == 1 && space9 == 1) {
                if(space5 == 0 && turnChoice == 0) {
                    drawX(t, 5, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space5 == 1 && space9 == 1) {
                if(space1 == 0 && turnChoice == 0) {
                    drawX(t, 1, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            //DIAGONAL TR-BL CHECK
            if(space3 == 1 && space5 == 1) {
                if(space7 == 0 && turnChoice == 0) {
                    drawX(t, 7, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space3 == 1 && space7 == 1) {
                if(space5 == 0 && turnChoice == 0) {
                    drawX(t, 5, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space5 == 1 && space7 == 1) {
                if(space3 == 0 && turnChoice == 0) {
                    drawX(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }

            //CHECK IF THE USER HAS THE ABILITY TO WIN
            if(space1 == -1 && space2 == -1) {
                if(space3 == 0 && turnChoice == 0) {
                    drawX(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space2 == -1 && space3 == -1) {
                if(space1 == 0 && turnChoice == 0) {
                    drawX(t, 1, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == -1 && space3 == -1) {
                if(space2 == 0 && turnChoice == 0) { 
                    drawX(t, 2, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == -1 && space4 == -1) {
                if(space7 == 0 && turnChoice == 0) {
                    drawX(t, 7, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space4 == -1 && space7 == -1) {
                if(space1 == 0 && turnChoice == 0) {
                    drawX(t, 1, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == -1 && space7 == -1) {
                if(space4 == 0 && turnChoice == 0) {
                    drawX(t, 4, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space3 == -1 && space6 == -1) {
                if(space9 == 0 && turnChoice == 0) {
                    drawX(t, 9, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space3 == -1 && space9 == -1) {
                if(space6 == 0 && turnChoice == 0) {
                    drawX(t, 6, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space6 == -1 && space9 == -1) {
                if(space3 == 0 && turnChoice == 0) {
                    drawX(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space1 == -1 && space2 == -1) {
                if(space3 == 0 && turnChoice == 0) {
                    drawX(t, 3, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space7 == -1 && space8 == -1) {
                if(space9 == 0 && turnChoice == 0) {
                    drawX(t, 9, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space8 == -1 && space9 == -1) {
                if(space7 == 0 && turnChoice == 0) {
                    drawX(t, 7, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
            if(space7 == -1 && space9 == -1) {
                if(space8 == 0 && turnChoice == 0) {
                    drawX(t, 8, turnCheck, userPlayerInt);
                    turnChoice = 1;
                }
            }
        }
        /**_____________________
        THE USER CAN'T WIN SOOO... We'll Go...
        _____________________*/
        if ( userPlayerInt == 0) {
            if ( turnCheck >= 4 ) {
                Random rand = new Random();
                int randomNum = rand.nextInt((4 - 1) + 1) + 1;
                if(randomNum == 1) {
                    if(space1 == 0 && turnChoice == 0) {
                        drawX(t, 1, turnCheck, userPlayerInt);
                        turnChoice = 1;
                    } else if(!(space1!=0 && space3 !=0 && space7 !=0 && space9 !=0)){
                        computerTurn(t, userPlayerInt, turnCheck);
                    }
                }
                if(randomNum == 2) {
                    if(space3 == 0 && turnChoice == 0) {
                        drawX(t, 3, turnCheck, userPlayerInt);
                        turnChoice = 1;
                    } else if(!(space1!=0 && space3 !=0 && space7 !=0 && space9 !=0)){
                        computerTurn(t, userPlayerInt, turnCheck);
                    }
                }
                if(randomNum == 3) {
                    if(space7 == 0 && turnChoice == 0) {
                        drawX(t, 7, turnCheck, userPlayerInt);
                        turnChoice = 1;
                    } else if(!(space1!=0 && space3 !=0 && space7 !=0 && space9 !=0)){
                        computerTurn(t, userPlayerInt, turnCheck);
                    }
                }
                if(randomNum == 4) {
                    if(space9 == 0 && turnChoice == 0) {
                        drawX(t, 9, turnCheck, userPlayerInt);
                        turnChoice = 1;
                    } else if(!(space1!=0 && space3 !=0 && space7 !=0 && space9 !=0)){
                        computerTurn(t, userPlayerInt, turnCheck);
                    }
                }
                if( space1 != 0 && space3 != 0 && space7 !=0 && space9 != 0) { //if all the corners are taken
                    Random rand2 = new Random();
                    int randomNum2 = rand2.nextInt((4 - 1) + 1) + 1;
                    if(randomNum2 == 1) {
                        if(space2 == 0 && turnChoice ==0) {
                            drawX(t, 2, turnCheck, userPlayerInt);
                            turnChoice = 1;
                        } else {
                            computerTurn(t, userPlayerInt, turnCheck);
                        }
                    }
                    if(randomNum2 == 2) {
                        if(space4 == 0 && turnChoice ==0) {
                            drawX(t, 4, turnCheck, userPlayerInt);
                            turnChoice = 1;
                        } else {
                            computerTurn(t, userPlayerInt, turnCheck);
                        }
                    }
                    if(randomNum2 == 3) {
                        if(space6 == 0 && turnChoice ==0) {
                            drawX(t, 6, turnCheck, userPlayerInt);
                            turnChoice = 1;
                        } else {
                            computerTurn(t, userPlayerInt, turnCheck);
                        }
                    }
                    if(randomNum2 == 4) {
                        if(space8 == 0 && turnChoice ==0) {
                            drawX(t, 8, turnCheck, userPlayerInt);
                            turnChoice = 1;
                        } else {
                            computerTurn(t, userPlayerInt, turnCheck);
                        }
                    }
                }
            }
        }
    }

    static void userTurn(Turtle t, int userPlayerInt, int turnCheck) {
        Scanner user_input = new Scanner( System.in );
        System.out.println("Player Turn: Please enter your selection");
        String userGo;
        userGo = user_input.next();
        //IF THE USER IS X'S...
        if (userPlayerInt == 1) {
            if(userGo.equals("1")) {
                if(space1 == 0) {
                    drawX(t, 1, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("2")) {
                if(space2 == 0) {
                    drawX(t, 2, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("3")) {
                if(space3 == 0) {
                    drawX(t, 3, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("4")) {
                if(space4 == 0) {
                    drawX(t, 4, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("5")) {
                if(space5 == 0) {
                    drawX(t, 5, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("6")) {
                if(space6 == 0) {
                    drawX(t, 6, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("7")) {
                if(space7 == 0) {
                    drawX(t, 7, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("8")) {
                if(space8 == 0) {
                    drawX(t, 8, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("9")) {
                if(space9 == 0) {
                    drawX(t, 9, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            } else {
                userTurn(t, userPlayerInt, turnCheck);
            }
        }

        //IF THE USER IS O'S...
        if (userPlayerInt == 0) {
            if(userGo.equals("1")) {
                if(space1 == 0) {
                    drawO(t, 1, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("2")) {
                if(space2 == 0) {
                    drawO(t, 2, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("3")) {
                if(space3 == 0) {
                    drawO(t, 3, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("4")) {
                if(space4 == 0) {
                    drawO(t, 4, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("5")) {
                if(space5 == 0) {
                    drawO(t, 5, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("6")) {
                if(space6 == 0) {
                    drawO(t, 6, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("7")) {
                if(space7 == 0) {
                    drawO(t, 7, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("8")) {
                if(space8 == 0) {
                    drawO(t, 8, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            }

            else if(userGo.equals("9")) {
                if(space9 == 0) {
                    drawO(t, 9, turnCheck, userPlayerInt);
                } else {
                    userTurn(t, userPlayerInt, turnCheck);
                }
            } else {
                userTurn(t, userPlayerInt, turnCheck);
            }
        }
    }




    /**
    BELOW IS ALL SETUP FUNCTIONS... Boring
     */

    
    
    


    //Just Draw's the board...
    static void drawBoard(Turtle joe) {
        joe.home();
        joe.up();
        joe.setPosition(-150,50);
        joe.down();
        joe.setDirection( 0 );
        joe.forward(300);
        joe.up();
        joe.setPosition(50,150);
        joe.setDirection( -90 );
        joe.down();
        joe.forward(300);
        joe.up();
        joe.setPosition(150, -50);
        joe.down();
        joe.setDirection(180);
        joe.forward(300);
        joe.up();
        joe.setPosition(-50, -150);
        joe.setDirection(90);
        joe.down();
        joe.forward(300);
        joe.up();
        joe.home();
    }

    static void drawX(Turtle t, int xSpace, int turnCheck, int userPlayerInt) {
        if (xSpace == 1) {
            t.up();
            t.setPosition(-150, 150);
            t.setDirection(-45);
            t.down();
            t.forward(141.421356237);
            t.up();
            t.setPosition(-50, 150);
            t.setDirection(-135);
            t.down();
            t.forward(141.421356237);
            space1=1;
        }
        if (xSpace == 2) {
            t.up();
            t.setPosition(-50, 150);
            t.setDirection(-45);
            t.down();
            t.forward(141.421356237);
            t.up();
            t.setPosition(50, 150);
            t.setDirection(-135);
            t.down();
            t.forward(141.421356237);
            space2=1;
        }
        if (xSpace == 3) {
            t.up();
            t.setPosition(150, 150);
            t.setDirection(-135);
            t.down();
            t.forward(141.421356237);
            t.up();
            t.setPosition(50, 150);
            t.setDirection(-45);
            t.down();
            t.forward(141.421356237);
            space3=1;
        }
        if (xSpace == 4) {
            t.up();
            t.setPosition(-150, 50);
            t.setDirection(-45);
            t.down();
            t.forward(141.421356237);
            t.up();
            t.setPosition(-50, 50);
            t.setDirection(-135);
            t.down();
            t.forward(141.421356237);
            space4=1;
        }
        if (xSpace == 5) {
            t.up();
            t.setPosition(-50, 50);
            t.setDirection(-45);
            t.down();
            t.forward(141.421356237);
            t.up();
            t.setPosition(50, 50);
            t.setDirection(-135);
            t.down();
            t.forward(141.421356237);
            space5=1;
        }
        if (xSpace == 6) {
            t.up();
            t.setPosition(50, 50);
            t.setDirection(-45);
            t.down();
            t.forward(141.421356237);
            t.up();
            t.setPosition(150, 50);
            t.setDirection(-135);
            t.down();
            t.forward(141.421356237);
            space6=1;
        }
        if (xSpace == 7) {
            t.up();
            t.setPosition(-150, -50);
            t.setDirection(-45);
            t.down();
            t.forward(141.421356237);
            t.up();
            t.setPosition(-50, -50);
            t.setDirection(-135);
            t.down();
            t.forward(141.421356237);
            space7=1;
        }
        if (xSpace == 8) {
            t.up();
            t.setPosition(-50, -50);
            t.setDirection(-45);
            t.down();
            t.forward(141.421356237);
            t.up();
            t.setPosition(50, -50);
            t.setDirection(-135);
            t.down();
            t.forward(141.421356237);
            space8=1;
        }
        if (xSpace == 9) {
            t.up();
            t.setPosition(50, -50);
            t.setDirection(-45);
            t.down();
            t.forward(141.421356237);
            t.up();
            t.setPosition(150, -50);
            t.setDirection(-135);
            t.down();
            t.forward(141.421356237);
            space9=1;
        }
        turnCheck = turnCheck + 1;
        gameTurn(t, userPlayerInt, turnCheck);
    }

    static void drawO(Turtle t, int oSpace, int turnCheck, int userPlayerInt){
        if (oSpace == 1) {
            t.up();
            t.setPosition(-100, 150);
            t.setDirection(0);
            t.down();
            for(int i=0; i<360; i++) {
                t.forward(0.87266462599);
                t.right(1);
            }
            space1=-1;
        }
        if (oSpace == 2) {
            t.up();
            t.setPosition(0, 150);
            t.setDirection(0);
            t.down();
            for(int i=0; i<360; i++) {
                t.forward(0.87266462599);
                t.right(1);
            }
            space2=-1;
        }
        if (oSpace == 3) {
            t.up();
            t.setPosition(100, 150);
            t.setDirection(0);
            t.down();
            for(int i=0; i<360; i++) {
                t.forward(0.87266462599);
                t.right(1);
            }
            space3=-1;
        }
        if (oSpace == 4) {
            t.up();
            t.setPosition(-100, 50);
            t.setDirection(0);
            t.down();
            for(int i=0; i<360; i++) {
                t.forward(0.87266462599);
                t.right(1);
            }
            space4=-1;
        }
        if (oSpace == 5) {
            t.up();
            t.setPosition(0, 50);
            t.setDirection(0);
            t.down();
            for(int i=0; i<360; i++) {
                t.forward(0.87266462599);
                t.right(1);
            }
            space5=-1;
        }
        if (oSpace == 6) {
            t.up();
            t.setPosition(100, 50);
            t.setDirection(0);
            t.down();
            for(int i=0; i<360; i++) {
                t.forward(0.87266462599);
                t.right(1);
            }
            space6=-1;
        }
        if (oSpace == 7) {
            t.up();
            t.setPosition(-100, -50);
            t.setDirection(0);
            t.down();
            for(int i=0; i<360; i++) {
                t.forward(0.87266462599);
                t.right(1);
            }
            space7=-1;
        }
        if (oSpace == 8) {
            t.up();
            t.setPosition(0, -50);
            t.setDirection(0);
            t.down();
            for(int i=0; i<360; i++) {
                t.forward(0.87266462599);
                t.right(1);
            }
            space8=-1;
        }
        if (oSpace == 9) {
            t.up();
            t.setPosition(100, -50);
            t.setDirection(0);
            t.down();
            for(int i=0; i<360; i++) {
                t.forward(0.87266462599);
                t.right(1);
            }
            space9=-1;
        }
        turnCheck = turnCheck + 1;
        gameTurn(t, userPlayerInt, turnCheck);
    }
}

