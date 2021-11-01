import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Set.*;
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
    private int counter = 5;
    //User guess
    Stack<String> guess = new Stack<String>();
    //Number of letters in word
    private static int numLetters = 4;
    //Array of the alphabet
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
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
    }
    
    /**
     * This method 
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
        while(counter != 0)
        {
            while(guess.size() < 4)
            {
                check(Greenfoot.getKey().charAt(0));
            }    
        }
    }
}
