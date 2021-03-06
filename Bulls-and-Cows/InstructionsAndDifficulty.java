import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The instructions page and available difficulty levels for the game.
 * 
 * @author Valerie  
 * @version Oct. 26/21
 */
public class InstructionsAndDifficulty extends World
{

    /**
     * Constructor for objects of class InstructionsAndDifficulty.
     * 
     */
    public InstructionsAndDifficulty()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
    
    public void act()
    {
        // If player presses enter, the main game begins.
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new MainGame());
        }
    }
}
