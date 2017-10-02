public class MyFirstDraw
{
    public static void main(String args[])
    {
        Turtle myTurtle = new Turtle();
        Turtle myT2 = new Turtle();
        int i;
        myTurtle.down();
        
        for (i=0; i<30; i++)
        {
            myTurtle.forward(i*10);
            myTurtle.left(45);
        }
        myT2.down();
    }
}
