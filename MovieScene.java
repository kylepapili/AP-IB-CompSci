
/**
 * Write a description of class MovieScene here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class MovieScene
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class MovieScene
     */
    public MovieScene()
    {
        // initialise instance variables
        //intro();
        chorus();
    }
    public void chorus() {
        clear();
        say("Strangers...");
        waitAndClear(1200);
        waitAndClear(900);
        say("Waiting...");
        waitAndClear(1060);
        waitAndClear(1030);
        say("Bum");
        waitAndClear(208);
        waitAndClear(208);
        say("Bum");
        waitAndClear(208);
        say("up and down the");
        waitAndClear(1400);
        say("BOULEVARD!!!!");
        waitAndClear(1360);
        say("Their Shadows....");
        waitAndClear(1230);
        waitAndClear(940);
        say("Searching...");
        waitAndClear(1400);
        say("In the niiighttt");
        waitAndClear(2710);
        waitAndClear(500);
        say("Bum");
        waitAndClear(208);
        waitAndClear(208);
        say("Bum");
        waitAndClear(950);
        say("Streetlights");
        waitAndClear(1050);
        waitAndClear(1030);
        say("people");
        waitAndClear(1573);
        say("living just to find emotion");
        waitAndClear(3071);
        say("Hiding");
        waitAndClear(1147);
        say("Somewhere...");
        waitAndClear(1315);
        say("In the NIIGHTT");
        waitAndClear(2482);
    }
    public void intro() {
        clear();
        say("Just a small town girl");
        waitAndClear(3834);
        say("living in a LONELY WORLD!!!");
        waitAndClear(4824);
        say("she took the midnight train...");
        waitAndClear(1800);
        say("Going anywhereeeee....");
        waitAndClear(4349);
        waitAndClear(2577);
        say("Just a city boy!");
        waitAndClear(3834);
        say("Born and raised in SOUTH Detroit!");
        waitAndClear(3592);
        say("HE took the midnight train...");
        waitAndClear(1800);
        say("Going anywhereeeee....");
        waitAndClear(4349);
        waitAndClear(2577);
        say("A singer in a smoky room");
        waitAndClear(3383);
        say("Smell of wine and cheap perfume!");
        waitAndClear(3399);
        say("For a smile they can share the night");
        waitAndClear(3494);
        say("It goes ON");
        waitAndClear(1459);
        say("and ON");
        waitAndClear(1000);
        say("AND ON");
        waitAndClear(1000);
        say("AND ONNNNN");
        waitAndClear(1000);
    }
    public void clear() {
        System.out.println("\f");
    }
    public void say(String message) {
        System.out.println(message);
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
