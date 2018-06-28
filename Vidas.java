import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que Crea el icono de vidas y tiene metodo para restarlas
 * 
 * @author IJRC
 * @version 1.0
 */
public class Vidas extends Actor
{
    int vidas = 3;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("VIDAS: "+vidas, 24, Color.RED, Color.BLACK));
        if(vidas<=0)
        {
            Greenfoot.playSound("GameOver.mp3");
            JuegoPerdido gameOver = new JuegoPerdido();
            Greenfoot.setWorld(gameOver);
            //Greenfoot.stop();
        }
    }    
    
    /**
     * Clase que cuando se manda llamar se resta 1 de la variable vida.
     */
    public void restaVida()
    {
        vidas--;
    }  
    
    /**
     * Clase que contiene las vidas actuales
     * 
     * @return regresa las vidas en entero
     */
    public int veVidas()
    {
        return vidas;
    }
}
