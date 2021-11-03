import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Set;
import java.util.ArrayList;
/**
 * Primary game portion of the program.
 *
 * @author David, Catherine, Valerie
 * @version Nov. 2/21
 */
public class MainGame extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("Frog in the Well.mp3");
    //Counter for number of tries
    private static final int COUNTER = 10;
    //User guess
    Stack<Character> guess = new Stack<Character>();
    //Number of letters in word
    private static final int numLetters = 4;
    //Array of the alphabet
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private String theWord;
    private char currentLetter;
    private int counter;

    //Counters for number of bulls and cows
    public int bulls = 0;
    public int cows = 0;

    private String keyStateOld;
    private String keyStateNew;

    private boolean enterDown;

    //Queue to store player's previous guesses
    Queue<Stack> oldGuesses = new Queue<Stack>();

    int y = 100;

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
        counter = COUNTER;

        counter = Math.max(0,counter);

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

        bulls = 0;
        cows = 0;
        Integer theCounter = new Integer(counter);
        if(counter >0)
        {
            if(guess.size() <= 4)
            {
                if (userInput != null){

                    if(check(userInput)){
                        char programInput = userInput.charAt(0);
                        guess.push(programInput);
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

        }
        if (Greenfoot.isKeyDown("backspace")&&!guess.isEmpty()){

            if(guess.size()==1){
                removeObjects(getObjectsAt(330, 470,null));
                guess.pop();
            } else if(guess.size()==2){
                removeObjects(getObjectsAt(430, 470,null));
                guess.pop();
            } else if(guess.size()==3){
                removeObjects(getObjectsAt(530, 470,null));
                guess.pop();
            } else if(guess.size()==4){
                removeObjects(getObjectsAt(630, 470,null));
                guess.pop();
            }

        }
        if (enterDown != Greenfoot.isKeyDown("enter")){
            enterDown = !enterDown;
            if (enterDown){
                displayPreviousBullsAndCows();
                checkBullsAndCows();
                displayCurrentBullsAndCows();
                clearScreen();
                counter--;
                
            }
        }// record change
        if(counter == 0) //Player loses
        {
            backgroundMusic.stop(); // Stopping music.
            Greenfoot.setWorld(new LosePage());
        }
        else if(bulls == 4)
        {
            backgroundMusic.stop(); // Stopping music.
            Greenfoot.setWorld(new WinPage());
        }
    }

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
        for(int i = guess.size(); i > 0; i--)
        {
            if (!guess.isEmpty()){
                currentLetter = guess.pop();
            }
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

    /**
     * Displays number of bulls and cows for currernt guess.
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

        String text = "";
        for(Character c: guess)
        {
            text = Character.toString(c) + text;
        }
        text = text + "\n";

        String bcText = "Bulls: " + theBulls.toString() + ", Cows: " + theCows.toString();
        addObject(new Text(text + bcText, 25, 0, 0, 0, 236, 163, 61), 100, y);
        y += 50;
    }
}
