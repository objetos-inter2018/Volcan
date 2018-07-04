import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea al primer enemigo, Lava.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Lava extends Enemigo
{
    /**
     * Act - do whatever the Lava wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       muevete();
    } 
    
    /**
     * Constructor de la clase, inicializa y escala el png
     */
    public Lava()
    {
        GreenfootImage lava = getImage();
        lava.scale(30, 48);
        setImage(lava);
    }
    
    /**
     * Mueve aleatoriamente la lava en x
     */
    public void muevete()
    {
        int x=getX();
        int y=getY();
        
        World myWorld=getWorld();
        Volcan volcan = (Volcan) myWorld;
        
        this.setLocation(x,y+1);
        
        
        if(y>=460)
        {
            this.getWorldOfType(Volcan.class).removeObject(this);
        }
    }
}
