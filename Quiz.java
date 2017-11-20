import java.util.Scanner;

public class Quiz
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Quiz
     */
    String name = "";
    String[] questions = {"What is two plus two?", "Who invented the telephone? (last name only)", "How many bits in a byte?", 
            "How many Colins in a hall?", "What instrument does Mr. Thomas play?", "What Java data type allows you to store decimals?", 
            "How do pengiuns fly?", "Write a repeat 5 times loop in java (just the first line)", "What year did the first iPhone come out?", 
            "What does HTML stand for?", "What programming language did Apple Invent specifically for iOS development?"};

    String[] answers = {"4", "Bell", "8", "1", "Guitar", "Double", "they don't", "for(int i=0; i<5; i++) {", "2006", 
            "Hyper Text Markup Language", "Swift"};

    String[][] setOfAnswers = new String[][] { {"4", "four"}, {"bell"}, {"eight", "8"}, {"one", "1"}, {"guitar"}, {"float", "double"}, 
            {"they dont", "they don't"}, {"for(int i=0; i<5; i++) {"}, {"2006"}, {"hyper text markup language", "hey there mr. lizard"}, {"swift"}};
    String[] userAnswers = new String[9];
    Scanner sc=new Scanner(System.in);

    Boolean hasAnswered = false;

    public Quiz(){
        clear();
        say("Welcome to the Comp-Sci Quiz");
        say("Who's playing today?");
        name = sc.next();
        clear();
        askIfReady();
    }

    public void askIfReady() {
        clear();
        say("Hey " + name + ", are you ready to test your computer science knowledge?");
        say("Say yes or no");
        String readyToPlay = sc.next();
        Integer result = new Integer(checkIfReady(readyToPlay));
        if (result == 1) {
            //Yes
            startQuiz();
        } else if(result == 2) {
            //No
            say("Ok, good talk " + name + "... see ya later");
        } else {
            askIfReady();
        }
    }

    public void startQuiz() {
        clear();
        say("Ok " + name + ", here we go!");
        waitAndClear(1500);
        for (int question = 0; question<9; question++) {
            hasAnswered = false;
            askQuestion(question);
        }
        endQuiz();
    }

    public void endQuiz() {
        clear();
        say("Pretty good... keep studying and one day you'll be a star!");
    }

    public void askQuestion(int questionNumber) {
        say(questions[questionNumber]);
        timer(questions[questionNumber], questionNumber);
        userAnswers[questionNumber] = sc.next();

        //boolean correct = checkAnswer(userAnswers[questionNumber], answers[questionNumber]);

        boolean correct = checkAllAnswers(userAnswers[questionNumber], questionNumber);
        if(correct) {
            say("That's right!");
            waitAndClear(1000);
            countdown();
        } else {
            say("WRONG!");
            say("The correct answer was " + answers[questionNumber]);
            waitAndClear(1500);
            countdown();
        }
    }

    public void timer(String questionText, int questionNumber) {
        Double currentTime = 5.000;
        for (int i=0; i<5000; i++) {
            if ((userAnswers[questionNumber]) == null) {
                say((userAnswers[questionNumber]));
                clear();
                currentTime = currentTime - 0.001;
                say(questionText);
                System.out.println(round(currentTime, 10));
                waitAndClear(1);
            } else {
                break;
            }
        }
    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public void countdown() {
        say("Next Question in: ");
        say("3");
        waitAndClear(1000);
        say("Next Question in: ");
        say("2");
        waitAndClear(1000);
        say("Next Question in: ");
        say("1");
        waitAndClear(1000);
    }

    public boolean checkAllAnswers(String userAnswer, int questionNumber) {
        boolean returnValue = false;
        boolean keepGoing = true;
        int answersToCheck = setOfAnswers[questionNumber].length;
        for (int i=0; i<(setOfAnswers[questionNumber]).length; i++) {
            if (keepGoing) {
                if (checkAnswer(userAnswer, setOfAnswers[questionNumber][i])) {
                    returnValue = true;
                    keepGoing = false;
                } else {
                    returnValue = false;
                }
            }
        }
        return returnValue;
    }

    public boolean checkAnswer(String userAnswer, String correctAnswer) {
        if ((userAnswer.toLowerCase()).equals(correctAnswer)) {
            return true;
        } else {
            return false;
        }
    }

    public int checkIfReady(String input) {
        String inputCase = input.toLowerCase();
        if (inputCase.equals( "yes") || inputCase.equals("y") || inputCase.equals( "ya") || inputCase.equals("yup")) {
            return 1;
        } else if(inputCase.equals("no") || inputCase.equals("n") || inputCase.equals("nah") || inputCase.equals( "nope")){
            return 2;
        } else {
            return 3;
        }
    }

    public void say(String message) {
        System.out.println(message);
    }

    public void clear() {
        System.out.println("\f");
    }

    public void waitAndClear(int time) {
        try {
            Thread.sleep(time);
            clear();
        } catch (InterruptedException e) {
            // Interrupted exception will occur if
            // the Worker object's interrupt() method
            // is called. interrupt() is inherited
            // from the Thread class.
        }
    }
}
