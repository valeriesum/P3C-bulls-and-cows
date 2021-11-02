import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Set;
import java.util.ArrayList;
/**
 * Primary game portion of the program.
 *
 * @author (your name)
 * @version Oct. 30/21
 */
public class MainGame extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("Frog in the Well.mp3");
    //Counter for number of tries
    private static int counter = 5;
    //User guess
    Stack<String> guess = new Stack<String>();
    //Number of letters in word
    private static final int numLetters = 4;
    //Array of the alphabet
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private String theWord;
    //Queue of all user's guesses
    //Queue<

    /**
     * Constructor for objects of class MainGame.
     *
     */
    public MainGame()
    {
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);

        backgroundMusic.setVolume(30);
        backgroundMusic.play(); // Playing background music.

        ArrayList<String> myList = new ArrayList<String>();
        try{
            Reader.readInto(myList);
        } catch(Exception e) {
        }
        theWord = myList.get((int)Math.floor(Math.random()*myList.size()));
    }

    public String returnGuess(){
        return theWord;
    }

    /**
     * This method checks to see if the element imputted by the user is a 
     * letter of the alphabet.
     * 
     * @param letter Inputted letter
     */
    public boolean check(char letter)
    {
        boolean check = false;
        for(char c : alphabet)
        {
            if(letter == c)
            {
                check = true;
            }
        }
        return check;
    }

    public void act()
    {
        String userInput = "";
        //Checks user input periodically
        userInput = Greenfoot.getKey();
        
        //Displays counter for number of tries
        Integer theCounter = new Integer(counter);
        addObject(new Text("Tries Left: " + theCounter.toString(), 32, 0, 0, 0), 95, 50);

        if(counter != 0)
        {
            if(guess.size() < 4)
            {
                if (userInput != null){
                    if(check(userInput.charAt(0))){
                        guess.push(userInput);
                        counter--;
                        addObject(new Text(userInput, 32, 100, 85, 54), 95, 50);
                    }   
                }
            }
        }
        if(counter == 0)
        {
            backgroundMusic.stop(); // Stopping music.
            Greenfoot.setWorld(new LosePage());
        }
    }
}
