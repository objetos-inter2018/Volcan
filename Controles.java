import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea a la imagen de instrucciones.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Controles extends Actor
{
    /**
     * Constructor de Controloes, lo escala a un buen tamaño
     */
    public Controles()
    {
        GreenfootImage resize = getImage();
        resize.scale(152, 104);
        setImage(resize);
    }
    
    /**
     * Cuando le das click avanza al mundo de las instrucciones
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Instrucciones controles = new Instrucciones();
            Greenfoot.setWorld(controles);
        }
    }   
}
