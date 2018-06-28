import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mundo que muestra GAME OVER.
 * 
 * @author IJRC
 * @version 1.0
 */
public class JuegoPerdido extends World
{

    /**
     * Constructor for objects of class JuegoPerdido.
     * 
     */
    public JuegoPerdido()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1); 
        addObject(new IntentaDenuevo(),  getWidth()/2, 300);
        addObject(new Menu(), getWidth()/2, 400);
    }
}
