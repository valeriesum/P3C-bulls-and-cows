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
        if(counter != 0)
        {
            // Repeats 4 times, number of letters
            if(guess.size() < 4)
            {
                if (userInput != null){
                    if(check(userInput.charAt(0))){
                        guess.push(userInput);
                    }   
                }
            }
        }
    }
}
