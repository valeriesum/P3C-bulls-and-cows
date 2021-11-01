import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    Stack<String> guess = new Stack<String>();
    
    private static int numLetters = 4;
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
    
    public void act()
    {
        while(!guessCorrect)
        {
            while(guess.size() < 4)
            {
                
            }    
        }
}
