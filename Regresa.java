import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase de objeto que regresa al menu cuando se pierde.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Regresa extends OpcionesMainMenu
{
    /**
     * Condicional que cuando se toque este objeto se cree el mundo de menu
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            MyWorld menu = new MyWorld();
            Greenfoot.setWorld(menu);
        }
    }    
    
    /**
     * Constructor de regresa, escala la imagen
     */
    public Regresa()
    {
        GreenfootImage resize = getImage();
        resize.scale(240, 90);
        setImage(resize);
    }
}
