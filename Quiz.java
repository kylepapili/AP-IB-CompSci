import java.util.Scanner;
public class Quiz
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Quiz
     */
    String name = "";
    String[] questions = {"What is two plus two?", "How are you", "what is nine plus 10?"};
    String[] answers = {"4", "good", "21"};
    String[] userAnswers;
    Scanner sc=new Scanner(System.in);

    public Quiz(){
        clear();
        say("Welcome to the Comp-Sci Quiz");
        say("Who's playing today?");
        name = sc.next();
        clear();
        boolean waiting = true;
        say("Hey " + name + ", are you ready to test your computer science knowledge?");
        say("Say yes or no");
        String readyToPlay = sc.next();
        Integer result = new Integer(checkIfReady(readyToPlay));
        Integer one = new Integer(1);
        Integer two = new Integer(2);
        if (result.intValue() == one.intValue()) {
            //Yes
            say("yes");
            //startQuiz();
        } else if(result.intValue() == two.intValue()) {
            //No
            say("no");
            //say("Ok, good talk " + name + "... see ya later");
        } else {
            say("other");
            //askIfReady();
        }
    }
    

    public void askIfReady() {
        clear();
        say("Hey " + name + ", are you ready to test your computer science knowledge?");
        say("Say yes or no");
        String readyToPlay = sc.next();
    }

    public void startQuiz() {
        clear();
        say("Ok " + name + ", here we go!");
        waitAndClear(1500);
        for (int question = 0; question<9; question++) {
            askQuestion(question);
        }
    }

    public void askQuestion(int questionNumber) {
        say(questions[questionNumber]);
        userAnswers[questionNumber] = sc.next();
        boolean correct = checkAnswer(userAnswers[questionNumber], answers[questionNumber]);
        if(correct) {
            say("That's right!");
        } else {
            say("WRONG!");
            say("The correct answer was " + answers[questionNumber]);
            waitAndClear(3000);
        }
    }

    public boolean checkAnswer(String userAnswer, String correctAnswer) {
        if (userAnswer.toLowerCase() == correctAnswer) {
            return true;
        } else {
            return false;
        }
    }

    public int checkIfReady(String input) {
        String inputCase = input.toLowerCase();
        if (inputCase == "yes" || inputCase == "y" || inputCase == "ya" || inputCase == "yup") {
            return 1;
        } else if(inputCase == "no" || inputCase == "n" || inputCase == "nah" || inputCase == "nope"){
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
