
/**
 * Write a description of class Shapes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shapes
{
    // instance variables - replace the example below with your own
    private int x;
    private Turtle myTurtle = new Turtle();
    /**
     * Constructor for objects of class Shapes
     */
    public Shapes()
    {
        // initialise instance variables
        x = 0;
        myTurtle.setPosition(0,0);
        myTurtle.speed(0);
        //leaf();
        //branch();
        //flower();
        //square(50);
        //squares(500, 5);
        //rowOfSquares(200, 3);
        //rotatedSquares(100, 3);
        //checkers(16, 16);
        //house(100);
    }

    public void house(int scale) {
        sideOne(scale);
        
        double tempX = myTurtle.getX();
        double tempY = myTurtle.getY();
        double newX = tempX + scale;
        double newY = tempY;
        myTurtle.up();
        myTurtle.setPosition(newX, newY);
        myTurtle.down();
        
        door(scale);
        
        tempX = myTurtle.getX();
        tempY = myTurtle.getY();
        newX = tempX + (2*scale);
        newY = tempY;
        myTurtle.up();
        myTurtle.setPosition(newX, newY);
        myTurtle.down();
        
        sideTwo(scale);
        
        tempX = myTurtle.getX();
        tempY = myTurtle.getY();
        newX = tempX + (4*scale);
        newY = tempY;
        myTurtle.up();
        myTurtle.setPosition(newX, newY);
        myTurtle.down();
        
        door(scale);
        
        tempX = myTurtle.getX();
        tempY = myTurtle.getY();
        newX = tempX + (-7*scale);
        newY = tempY + (5*scale);
        myTurtle.up();
        myTurtle.setPosition(newX, newY);
        myTurtle.down();
        
        roof(scale);
    }

    public void parallelogram(int scale) {
        for (int i=0; i<2; i++) {
            myTurtle.forward(9*scale);
            myTurtle.left(120);
            myTurtle.forward(3*scale);
            myTurtle.left(60);
        }
    }

    public void sideTwo(int scale) {
        for (int i=0; i<2; i++) {
            myTurtle.forward(9*scale);
            myTurtle.left(90);
            myTurtle.forward(5*scale);
            myTurtle.left(90);
        }
    }

    public void door(int scale) {
        for (int i=0; i<2; i++) {
            myTurtle.forward(scale);
            myTurtle.left(90);
            myTurtle.forward(2*scale);
            myTurtle.left(90);
        }
    }

    public void triangle(int scale) {
        for (int i=0; i<3; i++) {
            myTurtle.forward(3*scale);
            myTurtle.left(120);
        }
    }

    public void roof(int scale) {
        triangle(scale);
        double tempX = myTurtle.getX();
        double tempY = myTurtle.getY();
        myTurtle.setPosition((tempX + (3*scale)), tempY);
        parallelogram(scale);
    }

    public void sideOne(int scale) {
        for (int i=0; i<scale; i++) {
            myTurtle.forward(3*scale);
            myTurtle.left(90);
            myTurtle.forward(5*scale);
            myTurtle.left(90);
        }
    }

    public void checkers(int x, int y) {
        myTurtle.home();
        myTurtle.setDirection(0);
        for (int i=0; i<y; i++) {
            rowOfSquares(x, (180/x));
            double tempX = myTurtle.getX();
            double tempY = myTurtle.getY();
            double newX = tempX + ((-1*x)*(180/x));
            double newY = tempY + (-180/y);
            myTurtle.up();
            myTurtle.setPosition(newX, newY);
            myTurtle.down();
        }
    }

    public void rotatedSquares(int length, int numberOfSquares) {
        for (int i=0; i<numberOfSquares; i++) {
            squares(length, numberOfSquares);
            myTurtle.right(360/numberOfSquares);

        }
    }

    public void square(int length) {
        for (int i=0; i<4; i++) {
            myTurtle.forward(length);
            myTurtle.right(90);
        }
    }

    public void rowOfSquares(int length, int numberOfSquares) {
        myTurtle.setDirection(0);
        for (int i=0; i<numberOfSquares; i++) {
            square(length);
            myTurtle.forward(length);
        }
    }

    public void squares(int length, int numberOfSquares) {
        for (int i=0; i<numberOfSquares; i++) {
            square((i)*(length/10));
        }
    }

    public void leaf() {
        for (int i = 0; i<2; i++) {
            for (int x=0; x<15; x++) {
                myTurtle.forward(2);
                myTurtle.right(6);
            }
            myTurtle.right(90);
        }
    }

    public void leaves() {
        for (int i=0; i<5; i++){
            leaf();
            myTurtle.right(72);
        }
    }

    public void branch() {
        myTurtle.forward(40);
        leaf();
        myTurtle.forward(50);
        leaves();
        myTurtle.forward(-90);
    }

    public void flower() {
        for (int i=0; i<6; i++) {
            branch();
            myTurtle.right(60);
        }
    }
}
