import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mundo que muestra las instrucciones.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Instrucciones extends World
{

    /**
     * Constructor for objects of class Instrucciones.
     * 
     */
    public Instrucciones()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1); 
        addObject(new Regresa(), 528, 76);
    }
}
