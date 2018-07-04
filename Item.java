import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends Actor
{
    /**
     * Act - do whatever the Item wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        resize();
    }    
    
    /**
     * Metodo que escala la imagen de la pocima, es un metodo polimorfico que reescribe las clases concretas
     * de PocionResistencia, PocionVelocidad, PocionLentitud
     */
    public void resize()
    {
        GreenfootImage pocima = getImage();
        pocima.scale(24, 35);
        setImage(pocima);
    }
}
