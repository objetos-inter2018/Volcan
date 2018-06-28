import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea el mundo de juego, y añade los actores a la pantalla en posiciones x y y.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Volcan extends World
{
    public int spwGota, offset;
    private GreenfootImage background;
    Vidas vidas=new Vidas();
    Puntos puntos=new Puntos();
    PocionVelocidad pocimaVelocidad = new PocionVelocidad();
    PocionLentitud pocimaLentitud= new PocionLentitud();
    PocionResistencia pocimaResistencia= new PocionResistencia();
    Naufrago naufrago = new Naufrago();
    /**
     * Constructor para objetos de clase Volcan.
     * 
     */
    public Volcan()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1,false); //Para que los objetos salgan de ese recuadro
        offset=0;
        background = new GreenfootImage("juegoWorld.png");
        añadePersonajes();
    }
   
    /**
     * Clase que hace que el actor actue, en este caso se crean gotas de lava aleatoriamente y se plasman en y positivas
     */
    public void act()
    {
        spwGota = (spwGota+1)%80;
        int aleatorio=Greenfoot.getRandomNumber(400);
        if (spwGota == 0)
        {
            addObject(new Lava(), aleatorio,10);
        }
    }
    
    /**
     * Clase que añade actores al mundo
     */
    public void añadePersonajes()
    {
        addObject(new Rescatista(), getWidth()/2,320);

        this.addObject(pocimaVelocidad, 400 , 350);        
        this.addObject(pocimaLentitud, 200 , 350);
        //this.addObject(pocimaResistencia, 100, 350);
        
        addObject(naufrago, 500, 350);
        addObject(vidas, 45, 10);
        addObject(puntos, 585, 10);
        
        this.scrollBackgroundX(0);
        this.scrollBackgroundY(0);
    }
    
    /**
     * Clase que hace el scroll en el eje de las x
     */  
    public void scrollBackgroundX(int distX)
    {
        GreenfootImage worldImage = new GreenfootImage(640,480);
        if(offset+distX >= -640 && offset+distX <=0)
        {
            offset+=distX;
            worldImage.drawImage(background, offset, 0);
            this.setBackground(worldImage);
            pocimaLentitud.setLocation(pocimaLentitud.getX()+distX, pocimaLentitud.getY());
            naufrago.setLocation(naufrago.getX()+distX, naufrago.getY());
        }
    }
    
    /**
     * Clase que hace scroll en eje de las Y
     */
     public void scrollBackgroundY(int distY)
    {
        GreenfootImage worldImage = new GreenfootImage(640,480);
        if(offset+distY >= -480 &&offset+distY <=0)
        {
            offset+=distY;
            worldImage.drawImage(background, 0, offset);
            this.setBackground(worldImage);
        }
    }
    
    /**
     * Clase que consigue vidas
     * 
     * @return Regresa las vidas de tipo Vidas para clase Rescatista
     */
    public Vidas getVidas()
    {
        return vidas;
    }
    
    /**
     * Clase que almacena los puntos del jugador
     * 
     * @return las vidas del personaje Rescatista
     */
    public Puntos getPuntos()
    {
        return puntos;
    }
}
