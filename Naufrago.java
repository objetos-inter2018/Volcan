import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea al actor Naufrago.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Naufrago extends Actor
{
    /**
     * Act - do whatever the Naufrago wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       int x=getX();
       int y=getY();
       this.setLocation(x+1, y);
    }    
    
    public Naufrago()
    {
        GreenfootImage lava = getImage();
        lava.scale(40, 100);
        setImage(lava);
    }
    
}
