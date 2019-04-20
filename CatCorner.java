import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class CatCorner extends JFrame
{

    private final int MAX_LEVEL = 20;
    private JFrame frame;

    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel gameWindow;
    private JPanel mainPanel;

    private JLabel infoPanel;
    private JLabel catCornerLabel;
    private JLabel instructions;
    private JLabel backgroundPanelN;
    private JLabel backgroundPanelS;
    private JLabel backgroundPanelE;
    private JLabel backgroundPanelW;

    private CatColors catColors;

    private byte level;



    private boolean wildCatsOn;
    private boolean gameOver;

    public CatCorner()
    {
        frame = new JFrame("Cat Corner");

        initializeLabels();

        northPanel = new JPanel(new BorderLayout(3,3));
        southPanel = new JPanel(new BorderLayout(3,3));
        mainPanel  = new JPanel(new BorderLayout(3,3));
        gameWindow = new JPanel(new GridLayout(5, 0));

        northPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLACK);
        mainPanel.setBackground(Color.BLACK);


        northPanel.add(gameWindow, BorderLayout.CENTER);
        northPanel.add(infoPanel, BorderLayout.EAST);
        southPanel.add(catCornerLabel, BorderLayout.NORTH);
        southPanel.add(instructions, BorderLayout.SOUTH);


        mainPanel.add(southPanel, BorderLayout.SOUTH);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        //mainPanel.setSize(new Dimension(780, 860));

        /*frame.add(backgroundPanelN, BorderLayout.NORTH);
        frame.add(backgroundPanelW, BorderLayout.WEST);
        frame.add(backgroundPanelE, BorderLayout.EAST);
        frame.add(backgroundPanelS, BorderLayout.SOUTH);*/
        frame.setBackground(Color.BLACK);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setMaximumSize(new Dimension(1920,1080));
        frame.setMinimumSize(new Dimension(790, 870));
        frame.setSize(frame.getMinimumSize());
        frame.setResizable(true);
        //frame
        frame.setVisible(true);


        catColors = new CatColors();

        level = 1;
        wildCatsOn = false;
        gameOver = false;

        CatBoard board = new CatBoard(level, false, catColors);
        gameWindow.add(board.getCurrentBoard());
        frame.add(mainPanel, BorderLayout.CENTER);

    }

    void playGame()
    {
        while(level <= MAX_LEVEL && !gameOver) {


            if(level == 5) {
                wildCatsOn = true;
            }
            level++;
            /*if(timeIsUp()) {
                gameOver = true;
            }*/
        }
        //displayFinalScreen(score, level)
    }


    void initializeLabels() {

        BufferedImage image;
        String path = "D:\\0-DOWNLOADS\\CatCorner-master\\CatCorner-master\\src\\panels\\";
        try {
            image = ImageIO.read(new File(path + "infoPanel.png"));
            infoPanel = new JLabel(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            image = ImageIO.read(new File(path + "catCornerLabel.png"));
            catCornerLabel = new JLabel(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            image = ImageIO.read(new File(path + "instructions.png"));
            instructions = new JLabel(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            image = ImageIO.read(new File(path + "backgroundPanelE.png"));
            backgroundPanelE = new JLabel(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            image = ImageIO.read(new File(path + "backgroundPanelN.png"));
            backgroundPanelN = new JLabel(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            image = ImageIO.read(new File(path + "backgroundPanelW.png"));
            backgroundPanelW = new JLabel(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            image = ImageIO.read(new File(path + "backgroundPanelS.png"));
            backgroundPanelS = new JLabel(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
