import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays if player can guess the word. They can return back
 * to the start page.
 * 
 * @author Valerie
 * @version Nov. 2/21
 */
public class WinPage extends World
{
    /**
     * Constructor for objects of class WinPage.
     * 
     */
    public WinPage()
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
