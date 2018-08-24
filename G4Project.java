import java.util.Scanner;
import java.util.*;
/**
 * Write a description of class G4Project here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class G4Project
{
    
    Scanner sc=new Scanner(System.in);
    public G4Project()
    {
        clear();
        System.out.println("Input A: ");
        String inputA = sc.next();
        int intA = Integer.valueOf(inputA);
        System.out.println("Input B: ");
        String inputB = sc.next();
        double intB = Double.valueOf(inputB);
        Turtle turt = new Turtle();
        logSpiral(intA, intB, turt);
    }

    public void logSpiral(int a, double b, Turtle turt) {
        turt.clear();
        double e = java.lang.Math.E;
        Point currentPoint = new Point(0, 0);
        turt.speed(0.1);
        turt.down();
        for(double i=0; i<100; i=i+0.01) {
            double r = java.lang.Math.pow(a*e, b*(i));
            double x = r*(Math.cos(i));
            double y = r*(Math.sin(i));
            currentPoint.x = (int) Math.round(x);
            currentPoint.y = (int) Math.round(y);
            turt.setPosition(currentPoint.x, currentPoint.y);
        }
    }
    
    public void clear() {
        System.out.println("\f");
    }
    
}

 class Point {
    public int x = 0;
    public int y = 0;
    //constructor
    public Point(int a, int b) {
        x = a;
        y = b;
    }
}
