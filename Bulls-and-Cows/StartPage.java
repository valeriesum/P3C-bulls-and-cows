import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Start page for Bulls & Cows.
 * 
 * @author Valerie Sum 
 * @version Oct. 26/21
 */
public class StartPage extends World
{
    /**
     * Constructor for objects of class StartPage.
     * 
     */
    public StartPage()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
    /**
     * Player can press Q to continue.
     */
    public void act() 
    {
        //backgroundMusic.setVolume(30);
        //backgroundMusic.play(); // Playing background music.
        
        // If player presses "Q", the game begins.
        if(Greenfoot.isKeyDown("q"))
        {
            //backgroundMusic.stop(); // Stopping music.
            Greenfoot.setWorld(new InstructionsAndDifficulty());
        }
    }
}
