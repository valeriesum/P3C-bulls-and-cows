import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The instructions page and available difficulty levels for the game.
 * 
 * @author Valerie Sum 
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
        
        //Creating buttons for difficulty levels
        Button beginner = new Button();
        addObject(beginner, 150, 500);
        String begLabel = "Beginner\n3 Letters";
        addObject(new Text(begLabel), 150, 500);
        
        Button regular = new Button();
        addObject(regular, 400, 500);
        String regLabel = "Regular\n4 Letters";
        addObject(new Text(regLabel), 400, 500);
        
        Button intermediate = new Button();
        addObject(intermediate, 650, 500);
        String interLabel = "Intermediate\n5 Letters";
        addObject(new Text(interLabel), 650, 500);
    }
}
