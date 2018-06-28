import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Clase que crea al actor principal "Rescatista".
 * 
 * @author IJRC
 * @version 1.0
 */
public class Rescatista extends Actor
{
    /**
     * Variables, en este caso vel, dictamina la velocidad de Rescatista
     */
    public int vel;

    /**
     * Constructor de rescatista, que inicializa la velocidad
     * y ademas escala la imagen .png
     */
    public Rescatista()
    {
        GreenfootImage resca = getImage();
        resca.scale(50, 66);
        setImage(resca);
        vel = 3;
    }
    
    /**
     * Actua y manda llamar los demas metodos
     */
    public void act() 
    {
        buscaPocionVel();
        buscaPocionLen();
        buscaLava();
        buscaNaufrago();
        controles();
    } 
    
    public void cambiaVelocidad(int newVel)
    {
        vel=newVel;
    }
    
    
    /**
     * Metodo que se ejecuta solo cuando el rescatista toca una pocion de velocidad
     */
    public void buscaPocionVel()
    {
        if(isTouching(PocionVelocidad.class))
        {
            removeTouching(PocionVelocidad.class);
            vel=5;
        }
    }
    
    /**
     * Metodo que se ejecuta solo cuando el rescatista toca una pocion de lentitud
     */
    public void buscaPocionLen()
    {
        if(isTouching(PocionLentitud.class))
        {
            removeTouching(PocionLentitud.class);
            vel=1;
        }
    }
    
    /**
     * Metodo que se ejecuta cuando Rescatista toca a la clase Lava, se decrementan las vidas y se elimina la gota
     */
    public void buscaLava()
    {
        World myWorld=getWorld();
        Volcan vol = (Volcan) myWorld;
        Vidas vida= vol.getVidas();
        if(isTouching(Lava.class))
        {
            //Vidas vidas=volcan.getVidas();
            //vidas.restaVida();
            removeTouching(Lava.class);
            vida.restaVida();
        }
    }
    
    /**
     * Metodo que suma puntos cuando se salva a un naufrago
     */
    public void buscaNaufrago()
    {
        World myWorld=getWorld();
        Volcan vol = (Volcan) myWorld;
        Puntos punto= vol.getPuntos();
        if(isTouching(Naufrago.class) && Greenfoot.isKeyDown("space"))
        {
            //Vidas vidas=volcan.getVidas();
            //vidas.restaVida();
            removeTouching(Naufrago.class);
            punto.sumaPuntos();
        }
    }
    
    /**
     * Clase que mueve al personaje dependiendo las teclas oprimidas
     * e interactua con el metodo scroll de el world "Volcan"
     */
    public void controles()
    {
        int x=getX();
        int y=getY();
        
        if(Greenfoot.isKeyDown("down"))
        {
            if(y>=475)
                this.getWorldOfType(Volcan.class).scrollBackgroundY(-4);
            else
                this.setLocation(x, y+vel);
        }
        
        if(Greenfoot.isKeyDown("up")&&y>=285)
        {
            if(y<=2)
                this.getWorldOfType(Volcan.class).scrollBackgroundY(4);
            else
                this.setLocation(x,y-vel);
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            if(x<=2)
                this.getWorldOfType(Volcan.class).scrollBackgroundX(4);
            else
                this.setLocation(x-vel, y);
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            if(x>=638)
            {
                this.getWorldOfType(Volcan.class).scrollBackgroundX(-4);
            }else{
                this.setLocation(x+vel, y);
            }
        }
    }
}
