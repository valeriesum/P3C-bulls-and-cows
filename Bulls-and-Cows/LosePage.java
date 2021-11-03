import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays if player can not guess the word within 5 tries. They can return 
 * back to the start page.
 * 
 * @author Valerie 
 * @version Oct. 30/21
 */
public class LosePage extends World
{

    /**
     * Constructor for objects of class LosePage.
     * 
     */
    public LosePage()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
    
    public void act()
    {
        //If user presses X, they are returned back to start page.
        if(Greenfoot.isKeyDown("x"))
        {
            Greenfoot.setWorld(new StartPage());
        }
    }
}
