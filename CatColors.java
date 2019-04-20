import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

// clasa care adreseaza lucrul cu imaginile. creez vectori de vectori de butoane care pot fi folosite

public class CatColors
{


    private JButton[][] catButtons; //fata
    private JButton[][] footprintButtons; //dos
    private JButton[][] wCatButtons; //fata wildcards - de la 3 in sus
    private JButton[][] wFootprintButtons; //dos wildcards

    private final int MAX_SIZE = 6;
    private int WILDCARDS = 4;
    private int pictureNumber;


    private String pathName;
    private LevelsAttributes levelsAttributes;

    CatColors()
    {
        buildCats();
    }

    public void buildCats()
    {

        catButtons = new JButton[MAX_SIZE + 1][]; // vreau sa pot folosi indexul 6
        footprintButtons = new JButton[MAX_SIZE + 1][];  //vectorii de butoane contin imaginile pentru fiecare buton
        wCatButtons = new JButton[MAX_SIZE + 1][];
        wFootprintButtons = new JButton[MAX_SIZE + 1][];
        levelsAttributes = new LevelsAttributes();


        pathName = "D:/0-DOWNLOADS/CatCorner-master/CatCorner-master/src/resources/";

        // de la mare la mic
        for(int i = 1; i <= 2; i ++){ //MAX_SIZE
            createCatsButtons(i);
            createFootprintButtons(i);


            /*if(i >= 4)
            {
                createCatsButtonsW(i);
                createFootprintButtonsW(i);
            }*/
        }
    }

    public void createCatsButtonsW(int i)
    {

        BufferedImage image;
        String pathName = "D:/0-DOWNLOADS/CatCorner-master/CatCorner-master/src/resources/" + i + "/";

        //functia determina numele fisierelor si adauga icoanele la butoane
        for(int j = 1; j <= 2; j++)     //catButtons[i].length
        {
            try {
                image = ImageIO.read(new File(pathName + CatColor.valueOf(j) + ".png"));
                catButtons[i][j].setIcon(new ImageIcon(image));

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void createFootprintButtonsW(int i)
    {
        BufferedImage image;
        String pathName = "D:/0-DOWNLOADS/CatCorner-master/CatCorner-master/src/resources/" + i + "/";

        //functia determina numele fisierelor si adauga icoanele la butoane
        for(int j = 1; j <= 2; j++) //footprintButtons[i].length
        {
            for(int k = 1; k <= WILDCARDS; k ++)
            try {
                image = ImageIO.read(new File(pathName + FootprintsColor.valueOf(j) + ".png"));
                footprintButtons[i][j].setIcon(new ImageIcon(image));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createFootprintButtons(int i)
    {
        Image image;
        String pathName = "D:/0-DOWNLOADS/CatCorner-master/CatCorner-master/src/resources/" + i + "/";
        footprintButtons[i] = new JButton[5];

        //functia determina numele fisierelor si adauga icoanele la butoane
        for(int j = 1; j <= 2; j++)//footprintButtons[i].length
        {
                try {

                footprintButtons[i][j] = new JButton();
                image = ImageIO.read(new File(pathName + FootprintsColor.valueOf(j) + ".png"));

                footprintButtons[i][j].setIcon(new ImageIcon(image));
                System.out.println("incarc din:" + pathName + FootprintsColor.valueOf(j) + ".png");
            }
            catch (IOException e) {
                e.printStackTrace();


            }
        }
    }

    public void createCatsButtons(int i)
    {

        Image image;
        String pathName =  "D:/0-DOWNLOADS/CatCorner-master/CatCorner-master/src/resources/" + i + "/";
        catButtons[i] = new JButton[5];
        //functia determina numele fisierelor si adauga icoanele la butoane
        for(int j = 1; j <= 2; j++) //catButtons[i].length
        {
            try {
               // System.out.println("ex: ");
                catButtons[i][j] = new JButton();
                image = ImageIO.read(new File(pathName + CatColor.valueOf(j) + ".png"));
                catButtons[i][j].setIcon(new ImageIcon(image));
                //System.out.println("afiseaza?");
            }
            catch (IOException e) {
                e.printStackTrace();

            }
        }

    }

    public JButton[] getPossibleCats(int level)
    {

        this.pictureNumber = levelsAttributes.getLevelSize(level) - 4;
        return catButtons[pictureNumber];
    }

    public JButton[] getPossibleWildCats(int level)
    {

        this.pictureNumber = levelsAttributes.getLevelSize(level) - 4;
        return wCatButtons[pictureNumber];
    }

    public JButton[] getPossibleFootprints(int level)
    {
        this.pictureNumber = levelsAttributes.getLevelSize(level) - 4;
        return footprintButtons[pictureNumber];
    }

    public JButton[] getPossibleWildFootprints(int level)
    {
        this.pictureNumber = levelsAttributes.getLevelSize(level) - 4;
        return wFootprintButtons[pictureNumber];
    }

    public JButton generateButton(int i)
    {

        JButton myButton = new JButton();
        if (i == 1)
        {
            myButton = new JButton();
            String currentValue = pathName + 1 + "/";
            Image image = null;
            try {
                image = ImageIO.read(new File(currentValue + CatColor.valueOf(i) + ".png"));
            } catch (IOException e) {
                System.out.println(currentValue + CatColor.valueOf(i) + ".png");
            }
            myButton.setIcon(new ImageIcon(image));

        }
        else if (i == 2)
        {
            myButton = new JButton();
            String currentValue = pathName + 1 + "/";
            Image image = null;
            try {
                image = ImageIO.read(new File(currentValue + CatColor.valueOf(i) + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            myButton.setIcon(new ImageIcon(image));

        }
        return myButton;
    }
}