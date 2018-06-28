import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que lleva el conteo de los puntos en el juego.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Puntos extends Actor
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
     * Clase que cuando se manda llamar se resta 1 de la variable vida.
     */
    public void sumaPuntos()
    {
        puntos++;
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
