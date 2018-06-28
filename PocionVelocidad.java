import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea la pocion de la velocidad.
 * 
 * @author IJRC
 * @version 1.0
 */
public class PocionVelocidad extends Actor
{
    /**
     * Se llama al metodo aumentaVelocidad
     */
    public void act() 
    {
        aumentaVelocidad();
    }  
    
    /**
     * Se escala la imagen de pocima
     */
    public PocionVelocidad()
    {
        GreenfootImage pocima = getImage();
        pocima.scale(24, 35);
        setImage(pocima);
    }
    
    public void aumentaVelocidad()
    {
        //World myWorld=getWorld();
        Rescatista rescatista=new Rescatista();
        //Actor Rescatista;
        //Rescatista=getOneObjectAtOffset(0, 0, Rescatista.class);
        /*if(Rescatista!=null)
        {
            //rescatista.controles(10);
            myWorld.removeObject(this);
        }*/
        
    }
}
