import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.logging.Level;

public class CatBoard extends LevelsAttributes
{

    private JButton[] myCats;
    private JButton[] possibleCats;
    private JButton[] possibleWildCats;
    private JButton[] possibleFootprints;
    private JButton[] possibleWildFootprints;

    private JPanel currentBoard;


    private byte levelSize;
    private int levelCats;
    private byte numberOfCats;
    private boolean isTurned;


    private CatColors catColors;





    public CatBoard(int level, boolean wildCatOn, CatColors allCats)
    {

        LevelsAttributes levelsAttributes = new LevelsAttributes();

        levelSize = levelsAttributes.getLevelSize(level);

        myCats = new JButton[levelSize * levelSize + 1];

        catColors = new CatColors();
        currentBoard = new JPanel();

        currentBoard.setBackground(Color.BLACK);
        currentBoard.setLayout(new GridLayout(0,5 ));

        numberOfCats = levelsAttributes.getLevelCats(level);

        possibleCats = allCats.getPossibleCats(level);
        possibleFootprints = allCats.getPossibleFootprints(level);

        if(wildCatOn){

            possibleWildCats = allCats.getPossibleWildCats(level);
            possibleWildFootprints = allCats.getPossibleWildFootprints(level);
        }

        // in momentul de fata, stiu exact ce butoane pot sa folosesc
        //initializeMyCats();
        initializeButtons(wildCatOn);
        addButtonsToPanel();


    }

    JPanel getCurrentBoard()
    {
        return currentBoard;
    }

    void addButtonsToPanel ()
    {
        int i;
        //System.out.println("LUNGIME:" +myCats.length);
        for (i = 1; i < myCats.length; i++)
        {
            System.out.println("adaug butonul: " + i);
           currentBoard.add(myCats[i]);
           myCats[i].setBorderPainted(false);
        }
    }


    public void initializeButtons(boolean wildCatOn)
    {

        if(wildCatOn){

            initializeCatsW();
        }
        else {

            initializeCats();
        }
    }

    void initializeCats()
    {

            int randomCat;
            for(int i = 1; i < myCats.length; i ++) {

                //1=PURPLE  2=YELLOW    3=GREEN     4=ORANGE    5=RED
                randomCat = (int) (Math.random() * numberOfCats + 1);
                myCats[i] = new JButton();
                myCats[i] = catColors.generateButton(randomCat);
                myCats[i].setBackground(Color.BLACK);
                System.out.println(i+"random cat:"+randomCat);
                System.out.println("myCats[" + i + "] = possibleCats[" + randomCat + "]");
            }
    }

    void initializeCatsW()
    {
        int randomCat;
        Random rand = new Random();
        boolean val;

        for(int i = 1; i <= myCats.length; i ++){

            val = rand.nextInt(20) == 0; //probabilitate de 1/20
            randomCat = (int) (Math.random() * numberOfCats + 1);

            if(!val)
            {
                myCats[i] = possibleCats[randomCat];
            }
            else
            {
                myCats[i] = possibleWildCats[randomCat];
            }
        }
    }

}

