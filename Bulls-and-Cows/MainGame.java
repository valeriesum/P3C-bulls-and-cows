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
    Stack<Character> guess = new Stack<Character>();
    //Number of letters in word
    private static final int numLetters = 4;
    //Array of the alphabet
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private String theWord;

    //Counters for number of bulls and cows
    public int bulls = 0;
    public int cows = 0;

    //Queue to store player's previous guesses
    Queue<Stack> oldGuesses = new Queue<Stack>();

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
     * This method checks to see if the element inputted by the user is a 
     * letter of the alphabet.
     * 
     * @param letter Inputted letter
     */
    public boolean check(String input)
    {
        boolean check = false;
        for(int i = 0; i < alphabet.length; i ++)
        {
            if(input.equals( Character.toString(alphabet[i])))
            {
                check = true;
            }
        }
        return check;
    }

    /**
     * Takes in 5 guesses from user. Counter decreases by one every try.
     */
    public void act()
    {
        String userInput = "";
        //Checks user input periodically
        userInput = Greenfoot.getKey();

        Integer theCounter = new Integer(counter);

        addObject(new Text("Tries Left: " + theCounter, 32, 255, 255, 255, 0, 0, 0), 95, 50);

        if(counter != 0)
        {
            // Repeats 4 times, number of letters
            if(guess.size() < 4)
            {
                if (userInput != null){

                    if(check(userInput)){
                        char programInput = userInput.charAt(0);
                        guess.push(programInput);
                        if (guess.size()==1){
                            addObject(new Text(programInput, 100, 0, 0, 0, 255, 216, 137), 330, 470);
                        } else if (guess.size()==2){
                            addObject(new Text(programInput, 100, 0, 0, 0, 255, 216, 137), 430, 470); 
                        } else if (guess.size()==3){
                            addObject(new Text(programInput, 100, 0, 0, 0, 255, 216, 137), 530, 470);
                        } else if (guess.size()==4){
                            addObject(new Text(programInput, 100, 0, 0, 0, 255, 216, 137), 630, 470);
                        }
                        if (Greenfoot.isKeyDown("backspace")){
                            guess.pop();
                            if(guess.size()==4){
                                removeObjects(getObjectsAt(630, 470,null));
                            } else if(guess.size()==3){
                                removeObjects(getObjectsAt(530, 470,null));
                            } else if(guess.size()==2){
                                removeObjects(getObjectsAt(430, 470,null));
                            } else if(guess.size()==1){
                                removeObjects(getObjectsAt(330, 470,null));
                            }
                        }
                    }   
                }
            }
        }
        if (Greenfoot.isKeyDown("backspace")&&!guess.isEmpty()){
            
            if(guess.size()==1){
                removeObjects(getObjectsAt(330, 470,null));
            } else if(guess.size()==2){
                removeObjects(getObjectsAt(430, 470,null));
            } else if(guess.size()==3){
                removeObjects(getObjectsAt(530, 470,null));
            } else if(guess.size()==4){
                removeObjects(getObjectsAt(630, 470,null));
            }
            guess.pop();
        }
        if(Greenfoot.isKeyDown("enter"))
        {
            displayBullsAndCows();
        }
    }

    /**
     * Counts number of bulls and cows per guess.
     * 
     * @return correct If entire word is correct, it returns true.
     */
    public boolean checkBullsAndCows()
    {
        boolean correct = true;
        for(int i = 4; i > 0; i--)
        {
            char currentLetter = guess.pop();
            if(currentLetter != theWord.charAt(i) && theWord.contains(Character.toString(currentLetter)))
            {
                cows++;
            }
            else if(currentLetter == theWord.charAt(i))
            {
                bulls++;
            }
            else if(currentLetter != theWord.charAt(i))
            {
                correct = false;
            }
        }
        return correct;
    }

    //Displays number of bulls and cows
    public void displayBullsAndCows()
    {
        Integer theBulls = new Integer(bulls);
        Integer theCows = new Integer(cows);
        addObject(new Text(theBulls.toString(), 40, 0, 0, 0, 255, 255, 255), 356, 385);
        addObject(new Text(theCows.toString(), 40, 0, 0, 0, 255, 255, 255), 630, 385);
    }
}
