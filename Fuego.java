import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea al obstaculo de fuego.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Fuego extends Enemigo
{
    /**
     * Act - do whatever the Fuego wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    /**
     * Constructor que tiene como proposito reescalar la imagen
     */
    public Fuego()
    {
        GreenfootImage fuego = getImage();
        fuego.scale(40, 42);
        setImage(fuego);
    }
}
