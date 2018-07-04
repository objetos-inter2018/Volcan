import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que es superclase de actores.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Personaje extends Actor
{
    /**
     * Act - do whatever the Personaje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    /**
     * Metodo que modifica de tamaño un personaje
     */    
    public void resizePersonaje(int x, int y)
    {
        GreenfootImage naufrago = getImage();
        naufrago.scale(x, y);
        setImage(naufrago);
    }
}
