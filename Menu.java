import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que muestra el objeto que va hasta el menu principal.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Menu extends OpcionesMainMenu
{
    /**
     * Cuando este actor es pulsado se dirige al menu principal del juego
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
     * Constructor que hace la imagen un poco mas pequeña
     */
    public Menu()
    {
        GreenfootImage resize = getImage();
        resize.scale(255, 95);
        setImage(resize);
    }
}
