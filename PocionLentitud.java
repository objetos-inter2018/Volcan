import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea la pocion de lentitud.
 * 
 * @author IJRC
 * @version 1.0
 */
public class PocionLentitud extends Actor
{
    /**
     * Act - do whatever the PocionLentitud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       int x= getX();
       int y=getY();
    }   
    
    /**
     * Se escala la imagen de pocima
     */
    public PocionLentitud()
    {
        GreenfootImage pocima = getImage();
        pocima.scale(24, 35);
        setImage(pocima);
    }
}
