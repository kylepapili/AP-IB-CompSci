import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.Timer;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

public class PongPanel extends JPanel implements ActionListener , KeyListener{
    //Ball Properties
    private int ballX = 250;
    private int ballY = 250;
    private int diameter = 20;
    private int ballDeltaX = -1;
    private int ballDeltaY = 3;
    
    //Control Properties
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean wPressed = false;
    private boolean sPressed = false;
   
    private int paddleSpeed = 5;
    
    //Player One Paddle Properties
    private int playerOneX = 25;
    private int playerOneY = 250;
    private int playerOneWidth = 10;
    private int playerOneHeight = 50;
    
    //Player Two Paddle Properties
    private int playerTwoX = 465;
    private int playerTwoY = 250;
    private int playerTwoWidth = 10;
    private int playerTwoHeight = 50;
    
    //Player Scores
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    
    
    public PongPanel() {
     setBackground(Color.BLACK);   
     
     //Listen for keypresses
     setFocusable(true);
     addKeyListener(this);
     
     Timer timer = new Timer(1000/60, this); //60 FPS
     timer.start();
    }
    
    
    
    public void paintComponent(Graphics g){
     super.paintComponent(g);
     
     g.setColor(Color.WHITE);
     
     g.fillOval(ballX, ballY, diameter, diameter);
     
     g.fillRect(playerOneX, playerOneY, playerOneWidth, playerOneHeight);
     g.fillRect(playerTwoX, playerTwoY, playerTwoWidth, playerTwoHeight);
    }
    
    public void actionPerformed(ActionEvent e){
        step();
    }
    
    public void step() {
        //Key Listeners for player 1
        if (upPressed) {
            if (playerOneY-paddleSpeed > 0) {
                playerOneY -= paddleSpeed;
            }
        }
        if (downPressed) {
            if (playerOneY + paddleSpeed + playerOneHeight < getHeight()) {
                playerOneY += paddleSpeed;
            }
        }
        
        //Key Listeners for player 2
        if (wPressed) {
            if (playerTwoY-paddleSpeed > 0) {
                playerTwoY -= paddleSpeed;
            }
        }
        if (sPressed) {
            if (playerTwoY + paddleSpeed + playerTwoHeight < getHeight()) {
                playerTwoY += paddleSpeed;
            }
        }
        
        //Location ball is moving to
        int nextBallLeft = ballX + ballDeltaX;
        int nextBallRight = ballX + diameter + ballDeltaX;
        int nextBallTop = ballY + ballDeltaY;
        int nextBallBottom = ballY + diameter + ballDeltaY;
        
        //Player One Paddle Positions
        int playerOneRight = playerOneX + playerOneWidth;
        int playerOneTop = playerOneY;
        int playerOneBottom = playerOneY + playerOneHeight;
        
        //Player Two Paddle Positions
        int playerTwoRight = playerTwoX + playerTwoWidth;
        int playerTwoTop = playerTwoY;
        int playerTwoBottom = playerTwoY + playerTwoHeight;
        
        //If on top or bottom of screen, ball should bounce
        if (nextBallTop < 0 || nextBallBottom > getHeight()) {
            ballDeltaY *= -1;
        }
        
        //If ball hits left side
        if (nextBallLeft < 0) {
            //Will it intersect with the paddle
            if (nextBallTop > playerOneBottom || nextBallBottom < playerOneTop) {
                System.out.println("Player Two Scored");
                playerTwoScore ++;
                ballX = 250;
                ballY = 250;
            } else {
                ballDeltaX *= -1;
            }
        }
        
        //If ball hits right side
        if (nextBallRight > getWidth()) {
            ballDeltaX *= -1;
            
            if (nextBallTop > playerTwoBottom || nextBallBottom < playerTwoTop) {
                System.out.println("Player One Scored");
                playerOneScore ++;
                ballX = 250;
                ballY = 250;
            } else {
                ballDeltaX *= -1;
            }
        }
        
        //Move the ball
        ballX += ballDeltaX;
        ballY += ballDeltaY;
        
        //Repaint
        repaint();
    }
    
    public void keyTyped(KeyEvent e) {
        
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            wPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            sPressed = true;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            wPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            sPressed = false;
        }
    }
}
