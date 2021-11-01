import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The actual text that will be displayed on the InstructionPage screen.
 * 
 * @author Valerie Sum
 * @version Oct. 30/21
 */
public class Text extends Actor
{
    /**
     * Creates text image.
     * Based off https://www.youtube.com/watch?v=NjP3MMJnvGc
     * 
     * @param content The sentences that are wanted to be displayed.
    */
    public Text(String content) 
    {
      setImage(new GreenfootImage(content, 28, Color.WHITE, Color.BLACK));
    }    
}