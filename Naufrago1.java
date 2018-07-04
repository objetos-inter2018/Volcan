import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea al actor Naufrago.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Naufrago1 extends Naufrago
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    /**
     * Act - do whatever the Naufrago wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x=getX();
        int y=getY();
        this.setLocation(x+1, y);
        switchImage();
    }    
    
    /**
     * Constructor que carga las imagenes para la animacion y las escala a un menor tamaño
     */
    public Naufrago1()
    {
        //GreenfootImage lava = getImage();
        image1= new GreenfootImage("NaufragoA.png");
        image2= new GreenfootImage("NaufragoB.png");
        image1.scale(40, 100);
        image2.scale(40, 100);
        setImage(image1);
    }
    
    /**
     * Metodo que hace que ocurra la animacion
     */
    public void switchImage()
    {
        if(getImage()== image1)
            setImage(image2);
        else
            setImage(image1);    
    }
}
