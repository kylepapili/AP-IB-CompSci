import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener, KeyListener{
    
    private boolean showTitleScreen = true;
    private boolean playing = false;
    private boolean gameOver = false;
    
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean wPressed = false;
    private boolean sPressed = false;
    
    private float ballX = 250;
    private float ballY = 250;
    private float diameter = 20;
    private float ballDeltaX = -1;
    private float ballDeltaY = 3;
    
    private float playerOneX = 25;
    private float playerOneY = 250;
    private float playerOneWidth = 10;
    private float playerOneHeight = 50;
    
    private float playerTwoX = 465;
    private float playerTwoY = 250;
    private float playerTwoWidth = 10;
    private float playerTwoHeight = 50;
    
    private float paddleSpeed = 5;
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    
    //Upgrade Properties
    private int level = 0;
    
    //construct a PongPanel
    public PongPanel(){
        setBackground(Color.BLACK);
        
        //listen to key presses
        setFocusable(true);
        addKeyListener(this);
        
        //call step() 60 fps
        Timer timer = new Timer(1000/60, this);
        timer.start();
        level = 1;
        ballDeltaX = -1f;
        paddleSpeed = 5f;
        System.out.println("Level: " + level);
    }
    
    public void actionPerformed(ActionEvent e){
        step();
    }
    
    public void step(){
        
        if(playing){
            //move player 1
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
            
            //move player 2
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

            
            //where will the ball be after it moves?
            float nextBallLeft = ballX + ballDeltaX;
            
            float nextBallRight = ballX + diameter + ballDeltaX;
            float nextBallTop = ballY + ballDeltaY;
            float nextBallBottom = ballY + diameter + ballDeltaY;
            
            float playerOneRight = playerOneX + playerOneWidth;
            float playerOneTop = playerOneY;
            float playerOneBottom = playerOneY + playerOneHeight;
            
            float playerTwoLeft = playerTwoX;
            float playerTwoTop = playerTwoY;
            float playerTwoBottom = playerTwoY + playerTwoHeight;
            
            //ball bounces off top and bottom of screen
            if (nextBallTop < 0 || nextBallBottom > getHeight()) {
                ballDeltaY *= -1;
            }
            
            //will the ball go off the left side?
            if (nextBallLeft < playerOneRight) {
                //is it going to miss the paddle?
                if (nextBallTop > playerOneBottom || nextBallBottom < playerOneTop) {
                    
                    playerTwoScore ++;
                    incrimentLevel();
                    
                    if (playerTwoScore == 3) {
                        playing = false;
                        
                        gameOver = true;
                        level = 0;
                    }
                    ballX = 250;
                    ballY = 250;
                    }
                    else {
                        incrimentLevel();
                        ballDeltaX *= -1;
                    }
            }
            
            //will the ball go off the right side?
            if (nextBallRight > playerTwoLeft) {
                //is it going to miss the paddle?
                if (nextBallTop > playerTwoBottom || nextBallBottom < playerTwoTop) {
                    
                    playerOneScore ++;
                    incrimentLevel();
                    if (playerOneScore == 3) {
                        playing = false;
                        gameOver = true;
                        level = 0;
                    }
                    
                    ballX = 250;
                    ballY = 250;
                    }
                    else {
                    incrimentLevel();
                    ballDeltaX *= -1;
                }
            }
                
            //move the ball
            ballX += ballDeltaX;
            ballY += ballDeltaY;
        }
        
        //stuff has moved, tell this JPanel to repaint itself
        repaint();
    }
    
    public void incrimentLevel() {
        //Incriment Level
        level+= 1;
        System.out.println("Level: " + level);
        
        
        //Incriment Ball Speed
        if(ballDeltaX < 0) {
            ballDeltaX = ballDeltaX - 0.25f;
        } else {
            ballDeltaX = ballDeltaX + 0.25f;
        }
        //Incriment Paddle Speed (every other)
        if ( (level & 1) == 0 ) { 
            if (paddleSpeed < 10) {
                paddleSpeed += 0.5f; 
            }
        }
        System.out.println("ballDeltaX: " + ballDeltaX);
        System.out.println("paddleSpeed: " + paddleSpeed);
    }
    //paint the game screen
        public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        
        if (showTitleScreen) {
            
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
            g.drawString("Pong", 165, 100);
            
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            
            g.drawString("Press 'P' to play.", 175, 400);
        }
        else if (playing) {
            
            float playerOneRight = playerOneX + playerOneWidth;
            float playerTwoLeft = playerTwoX;
            
            //draw dashed line down center
            for (int lineY = 0; lineY < getHeight(); lineY += 50) {
                g.drawLine(250, lineY, 250, lineY+25);
            }
            
            //draw "goal lines" on each side
            int playerOneRightInt = Math.round(playerOneRight);
            int playerTwoLeftInt = Math.round(playerOneRight);
            
            g.drawLine(playerOneRightInt, 0, playerOneRightInt, getHeight());
            g.drawLine(playerTwoLeftInt, 0, playerTwoLeftInt, getHeight());
            
            //draw the scores
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
            g.drawString(String.valueOf(playerOneScore), 100, 100);
            g.drawString(String.valueOf(playerTwoScore), 400, 100);
            
            //Convert to Ints
            int ballXInt = Math.round(ballX);
            int ballYInt = Math.round(ballY);
            int playerOneXInt = Math.round(playerOneX);
            int playerTwoXInt = Math.round(playerTwoX);
            int diameterInt = Math.round(diameter);
            int playerOneYInt = Math.round(playerOneY);
            int playerTwoYInt = Math.round(playerTwoY);
            int playerOneWidthInt = Math.round(playerOneWidth);
            int playerOneHeightInt = Math.round(playerOneHeight);
            int playerTwoWidthInt = Math.round(playerTwoWidth);
            int playerTwoHeightInt = Math.round(playerTwoHeight);
            
            //draw the ball
            g.fillOval(ballXInt, ballYInt, diameterInt, diameterInt);
            
            //draw the paddles
            g.fillRect(playerOneXInt, playerOneYInt, playerOneWidthInt, playerOneHeightInt);
            
            g.fillRect(playerTwoXInt, playerTwoYInt, playerTwoWidthInt, playerTwoHeightInt);
        }
        else if (gameOver) {
            
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
            g.drawString(String.valueOf(playerOneScore), 100, 100);
            g.drawString(String.valueOf(playerTwoScore), 400, 100);
            
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
            if (playerOneScore > playerTwoScore) {
                g.drawString("Player 1 Wins!", 165, 200);
            }
            else {
                g.drawString("Player 2 Wins!", 165, 200);
            }
            
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            g.drawString("Press space to restart.", 150, 400);
        }
    }
    
    public void keyTyped(KeyEvent e) {
    }
    
    public void keyPressed(KeyEvent e) {
        if (showTitleScreen) {
            if (e.getKeyCode() == KeyEvent.VK_P) {
                showTitleScreen = false;
                playing = true;
            }
        }
        else if(playing){
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = true;
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
            else if (e.getKeyCode() == KeyEvent.VK_W) {
                wPressed = true;
            }
            else if (e.getKeyCode() == KeyEvent.VK_S) {
                sPressed = true;
            }
        }
        else if (gameOver) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                gameOver = false;
                showTitleScreen = true;
                playerOneY = 250;
                playerTwoY = 250;
                
                ballX = 250;
                ballY = 250;
                playerOneScore = 0;
                playerTwoScore = 0;
            }
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if (playing) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = false;
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = false;
            }
            else if (e.getKeyCode() == KeyEvent.VK_W) {
                wPressed = false;
            }
            else if (e.getKeyCode() == KeyEvent.VK_S) {
                sPressed = false;
            }
        }
    }

}