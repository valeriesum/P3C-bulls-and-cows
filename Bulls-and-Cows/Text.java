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
    public Text(char content, int size, int r, int g, int b, int br, int bg, int bb) 
    {
        Color textColor = new Color(r, g, b);
        Color background = new Color(br, bg, bb);
        setImage(new GreenfootImage(Character.toString(content), size, textColor, background));
    }   
    public Text(String content, int size, int r, int g, int b, int br, int bg, int bb) 
    {
        Color textColor = new Color(r, g, b);
        Color background = new Color(br, bg, bb);
        setImage(new GreenfootImage(content, size, textColor, background));
    }   
}