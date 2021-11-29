
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener{

    private Image apple;
    private Image point;
    private Image head;
    
    private final int POINT_SIZE = 10;    // 300 * 300 = 90000 / 100 = 900
    private final int ALL_POINTS = 900;
    private final int RANDOM_POSITION = 29;
    
    private int apple_x;
    private int apple_y;
    
    private final int x[] = new int [ALL_POINTS];
    private final int y[] = new int [ALL_POINTS];
    
    private boolean left = false;
    private boolean right =  true;
    private boolean up =  false;
    private boolean down =  false;
    private boolean inGame = true;
    
    private int score;
    
    private Timer timer;

    Board(){
        
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(300, 300));
        
        setFocusable(true);
        
        loadImages();
        initGame();
    }
    
    public void loadImages(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("snake/icons/apple.png"));
        apple  = i1.getImage();
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("snake/icons/dot.png"));
        point = i2.getImage();
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("snake/icons/head.png"));
        head = i3.getImage();
    }
    
    public void initGame(){
        
        score = 3;
        
        for(int z = 0 ; z < score ; z++){
            x[z] = 50 - z * POINT_SIZE; // x[0] y[0] // x[1] y[1] // x[2] y[2]
            y[z] = 50;
        }
        
        locateApple();
