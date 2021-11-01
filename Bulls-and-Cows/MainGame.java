import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
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
}
