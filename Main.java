
/**
 * Write a description of class Pong here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.BorderLayout;

import javax.swing.JFrame;

import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        PongPanel pongPanel = new PongPanel();
        frame.add(pongPanel, BorderLayout.CENTER);
        
        frame.setSize(500, 500);
        
        frame.setVisible(true);
        
    }
}
