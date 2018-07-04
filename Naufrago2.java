import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea al primer naufrago del juego.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Naufrago2 extends Naufrago
{
    /**
     * Constuctor que llama a metodo de clase personaje que hace un resize a la imagen, y sobreescribe a ese metodo
     * se utiliza como metodo polimorfico que sobrescribe un metodo concreto
     */
    public Naufrago2()
    {
        //this.resizePersonaje(51, 90);
        GreenfootImage Naufragoestat = getImage();
        Naufragoestat.scale(51, 90);
        setImage(Naufragoestat);
    }
    
    public void act() 
    {
    }    
 
}
