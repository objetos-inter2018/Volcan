import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea a la imagen Start del menu.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Start extends OpcionesMainMenu
{   
    /**
     * Contiene la imagen que da inicio al juego
     */
    public Start()
    {
        GreenfootImage resize = getImage();
        resize.scale(238, 87);
        setImage(resize);
    }
    
    /**
     * Cuando le das click avanza al mundo del juego y reproduce
     * un pequeño sonido
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.playSound("start.wav");
            Volcan game = new Volcan();
            Greenfoot.setWorld(game);
        }
    }      
}
