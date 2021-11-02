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

    public void act()
    {
        String userInput = "";
        //Checks user input periodically
        userInput = Greenfoot.getKey();
        
        Integer theCounter = new Integer(counter);
        addObject(new Text("Tries Left: " + theCounter.toString(), 32), 95, 50);
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
                            addObject(new Text(programInput, 100), 330, 475);
                        } else if (guess.size()==2){
                            addObject(new Text(programInput, 100), 430, 475); 
                        } else if (guess.size()==3){
                            addObject(new Text(programInput, 100), 530, 475);
                        } else if (guess.size()==4){
                            addObject(new Text(programInput, 100), 630, 475);
                        }
                        if (Greenfoot.isKeyDown("Backspace")){
                            guess.pop();
                        }
                    }   
                }
            }
        }
    }
}
