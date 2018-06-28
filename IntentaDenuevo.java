import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea el objeto intentar de nuevo.
 * 
 * @author IJRC
 * @version 1.0
 */
public class IntentaDenuevo extends Actor
{
    /**
     * Cuando es pulsado este objeto, se vuelve a iniciar el juego.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.playSound("start.wav");
            Volcan juego = new Volcan();
            Greenfoot.setWorld(juego);
        }
    }    
    
    public IntentaDenuevo()
    {
        GreenfootImage resize = getImage();
        resize.scale(204, 56);
        setImage(resize);
    }
}
