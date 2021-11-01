import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates buttons that will set the difficulty level.
 * 
 * @author Valerie Sum 
 * @version Oct. 30/21
 */
public class Button extends Actor
{
    //Indicates number of letters (difficulty) for the main game
    public static int difficulty;
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Beginner Level
        if(Greenfoot.mousePressed(this) && getX() == 150)
        {
            difficulty = 3;
            Greenfoot.setWorld(new MainGame());
        }
        //Regular Level
        else if(Greenfoot.mousePressed(this) && getX() == 400)
        {
            difficulty = 4;
            Greenfoot.setWorld(new MainGame());
        }
        //Intermediate Level
        else if(Greenfoot.mousePressed(this) && getX() == 650)
        {
            difficulty = 5;
            Greenfoot.setWorld(new MainGame());
        }
    }    
}
