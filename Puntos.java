import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que lleva la cuenta de puntos.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Puntos extends Marcador
{
    int puntos = 0;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("PUNTOS: "+puntos, 24, Color.RED, Color.BLACK));
        if(puntos<=0)
        {
            //JuegoPerdido gameOver = new JuegoPerdido();
            //Greenfoot.setWorld(gameOver);
            //Greenfoot.stop();
        }
    }    
    
    /**
     * Clase que cuando se manda llamar se suma 1 a la variable puntos
     */
    public void sumar()
    {
        puntos++;
    }  
    
    public int getVidas()
    {
        return puntos;
    }
    
    /**
     * Clase que contiene las vidas actuales
     * 
     * @return regresa las vidas en entero
     */
    public int vePuntos()
    {
        return puntos;
    }    
}
