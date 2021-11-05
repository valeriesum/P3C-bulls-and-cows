import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Set;
import java.util.ArrayList;
/**
 * Primary game portion of the program.
 *
 * @author David, Catherine, Valerie
 * @version Nov. 5/21
 */
public class MainGame extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("Frog in the Well.mp3");
    GreenfootSound moo = new GreenfootSound("moo.mp3");

    //Counter for number of tries
    private static final int COUNTER = 10;
    
    //User guess
    Stack<Character> guess = new Stack<Character>();
    Stack<Character> displayGuess = new Stack<Character>();
    
    //Number of letters in word
    private static final int numLetters = 4;
    
    //Array of the alphabet
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
    private String theWord;
    private String userInput;
    private char currentLetter;
    private int counter;

    //Counters for number of bulls and cows
    public int bulls = 0;
    public int cows = 0;

    private boolean enterDown;

    
    private Integer theCounter;

    int y = 100; //Coordinate for displaying words on sidebar.


    /**
     * Constructor for objects of class MainGame.
     *
     */
    public MainGame()
    {
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);

        backgroundMusic.setVolume(30);
        moo.setVolume(30);
        backgroundMusic.play(); // Playing background music.

        ArrayList<String> myList = new ArrayList<String>();
        try{
            Reader.readInto(myList);
        } catch(Exception e) {
        }
        theWord = myList.get((int)Math.floor(Math.random()*myList.size()));
        counter = COUNTER;

        counter = Math.max(0,counter);
        //System.out.println(theWord);
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
     * Takes in 10 guesses from user. Counter decreases by one every try.
     */
    public void act()
    {
        userInput = "";
        //Checks user input periodically
        userInput = Greenfoot.getKey();

        bulls = 0;
        cows = 0;
        theCounter = new Integer(counter);
        //Displaying objects on the screen.
        if(counter > 0 && guess.size() < 4)
        {

            checkGuessInput();

        }
        checkKeys();
    }

    private void checkGuessInput(){
        if (userInput != null){

                if(check(userInput)){
                    char programInput = userInput.charAt(0);
                    guess.push(programInput);
                    displayGuess.push(programInput);
                    if (guess.size()==1){
                        addObject(new Text(programInput, 85, 0, 0, 0, 255, 216, 137), 330, 480);
                    } else if (guess.size()==2){
                        addObject(new Text(programInput, 85, 0, 0, 0, 255, 216, 137), 430, 480);
                    } else if (guess.size()==3){
                        addObject(new Text(programInput, 85, 0, 0, 0, 255, 216, 137), 540, 480);
                    } else if (guess.size()==4){
                        addObject(new Text(programInput, 85, 0, 0, 0, 255, 216, 137), 640, 480);
                    }

                }
                removeObjects(getObjectsAt(95,50,null));
                addObject(new Text("Tries Left: " + theCounter, 32, 255, 255, 255, 0, 0, 0), 95, 50);
            }
    }
    
    private void checkKeys(){
        //Deleting letters off the screen and stack
        if (Greenfoot.isKeyDown("backspace")){

            if(guess.size()==1){
                removeObjects(getObjectsAt(330, 470,null));
                guess.pop();
                displayGuess.pop();
            } else if(guess.size()==2){
                removeObjects(getObjectsAt(430, 470,null));
                guess.pop();
                displayGuess.pop();
            } else if(guess.size()==3){
                removeObjects(getObjectsAt(530, 470,null));
                guess.pop();
                displayGuess.pop();
            } else if(guess.size()==4){
                removeObjects(getObjectsAt(630, 470,null));
                guess.pop();
                displayGuess.pop();
            }
        }
        //checks if Enter key is pressed and only reads it once
        if (enterDown != Greenfoot.isKeyDown("enter")){
            enterDown = !enterDown;
            if (enterDown){
                
                checkBullsAndCows();
                displayCurrentBullsAndCows();
                displayPreviousBullsAndCows();

                while(!displayGuess.isEmpty()){
                    displayGuess.pop();
                }

                clearScreen();
                counter--;
                if(counter == 0) //Player loses
                {
                    backgroundMusic.stop(); // Stopping music.
                    Greenfoot.setWorld(new LosePage());
                }
                else if(bulls == 4) //Player wins
                {
                    backgroundMusic.stop(); // Stopping music.
                    Greenfoot.setWorld(new WinPage());
                }
                //resets bulls and cows
                bulls = 0;
                cows = 0;

                moo.play();
            }
        } 
    }

    /**
     * This method deletes all letters from guess off the screen.
     */
    public void clearScreen(){
        removeObjects(getObjectsAt(330, 470,null));
        removeObjects(getObjectsAt(430, 470,null));
        removeObjects(getObjectsAt(530, 470,null));
        removeObjects(getObjectsAt(630, 470,null));
    }

    /**
     * Counts number of bulls and cows per guess.
     *
     * @return correct If entire word is correct, it returns true.
     */
    public boolean checkBullsAndCows()
    {
        boolean correct = true;
        char duplicateLetter = currentLetter;
        for(int i = guess.size(); i > 0; i--) //Repeats for all letters in guess
        {
            if (!guess.isEmpty()){
                currentLetter = guess.pop();
            }
            //Letter perfectly matches letter in answer (bulls)
            if(currentLetter == theWord.charAt(i-1))
            {
                bulls++;
                duplicateLetter = currentLetter;
            }
            //Letter is in incorrect position, but is in the answer (cows)
            else if(currentLetter != theWord.charAt(i-1) && theWord.contains(Character.toString(currentLetter)))
            {
                cows++;
                if (currentLetter == duplicateLetter){
                    cows = 0;
                }
            }
            //Guess must be the same as answer for it to be correct.
            else if(currentLetter != theWord.charAt(i-1))
            {
                correct = false;
            }
        }
        return correct;
    }

    /**
     * Displays number of bulls and cows for current guess.
     */
    public void displayCurrentBullsAndCows()
    {
        Integer theBulls = new Integer(bulls);
        Integer theCows = new Integer(cows);
        addObject(new Text(theBulls.toString(), 40, 0, 0, 0, 255, 255, 255), 356, 385);
        addObject(new Text(theCows.toString(), 40, 0, 0, 0, 255, 255, 255), 630, 385);
    }

    /**
     * Display number of bulls cows from previous guesses on sidebar.
     */
    public void displayPreviousBullsAndCows()
    {
        Integer theBulls = new Integer(bulls);
        Integer theCows = new Integer(cows);
        
        //Concatenating letters of guess into word. 
        String text = "";
        for(Character c: displayGuess)
        {
            text = Character.toString(c) + text;
        }
        text = text + "\n";

        String bcText = "Bulls: " + theBulls.toString() + ", Cows: " + theCows.toString();
        addObject(new Text(text + bcText, 25, 0, 0, 0, 236, 163, 61), 100, y);
        y += 50;
    }
}
