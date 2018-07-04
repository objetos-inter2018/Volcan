import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea la pocion de lentitud.
 * 
 * @author IJRC
 * @version 1.0
 */
public class PocionLentitud extends Item
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
     * Utiliza el metodo de la clase padre item para reescalar esta imagen
     */
    public PocionLentitud()
    {
        this.resize();
    }
}
