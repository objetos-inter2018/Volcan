import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mundo que es el menu del juego
 * 
 * @author IJRC
 * @version 1.0
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(640, 480, 1); 
        //añadePersonajes();
        añadeOpciones();
    }
    
    public void añadeOpciones()
    {
        addObject(new Start(), getWidth()/2,270);
        addObject(new Controles(), getWidth()/2, 400); 
    }
    
    /*public void añadePersonajes()
    {
        addObject(new Rescatista(), getWidth()/2,320);
    }*/
}
