import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Clase que crea al actor principal "Rescatista".
 * 
 * @author IJRC
 * @version 1.0
 */
public class Rescatista extends Personaje
{   
    /**
     * Variables, en este caso vel, dictamina la velocidad de Rescatista
     */
    public int vel, puntos;
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image1INV;
    private GreenfootImage image2INV;
    /**
     * Constructor de rescatista, que inicializa la velocidad
     * y ademas escala la imagen .png
     */
    public Rescatista()
    {
        /*GreenfootImage resca = getImage();
        resca.scale(50, 66);
        setImage(resca);*/
        image1= new GreenfootImage("RescatistaA.png");
        image2= new GreenfootImage("RescatistaB.png");
        
        image1INV= new GreenfootImage("RescatistaInvA.png");
        image2INV= new GreenfootImage("RescatistaInvB.png");
        
        //331x438
        image1.scale(66, 86);
        image2.scale(66, 86);
        
        image1INV.scale(66, 86);
        image2INV.scale(66, 86);
        
        setImage(image1);
        vel = 3;
    }
    
    /**
     * Actua y manda llamar los demas metodos
     */
    public void act() 
    {
        //switchImage(); //Se implementa en controles
        buscaPocionVel();
        buscaPocionLen();
        buscaPocimaVida();
        buscaLava();
        buscaFuego();
        buscaNaufrago();
        subeDificultad();
        controles();
    }    
    
    /**
     * Metodo que switcea la imagen para que asemeje que esta corriendo
     */
    public void switchImage()
    {
        if(getImage()== image1)
            setImage(image2);
        else
            setImage(image1);    
    }
    
    /**
     * Metodo que switcea la imagen para que asemeje que esta corriendo pero invertida
     */
    public void switchImageInv()
    {
        if(getImage()== image1INV )//|| getImage()== image)
            setImage(image2INV);
        else
            setImage(image1INV);    
    }
    
    /**
     * Metodo que se ejecuta solo cuando el rescatista toca una pocion de velocidad y utiliza
     * una clase del mundo Volcan para disminuir el numero de pocimas de ese tipo
     * que hay en el mundo
     */
    public void buscaPocionVel()
    {
        if(isTouching(PocionVelocidad.class))
        {
            removeTouching(PocionVelocidad.class);
            //removeObject(PocionVelocidad.class);
            this.getWorldOfType(Volcan.class).disminuyePocima();
            vel=5;
        }
    }
    
    /**
     * Metodo que se ejecuta solo cuando el rescatista toca una pocion de lentitud y utilixa
     * una clase del mundo Volcan para disminuir el numero de pocimas de ese tipo que hay en el mundo
     */
    public void buscaPocionLen()
    {
        if(isTouching(PocionLentitud.class))
        {
            removeTouching(PocionLentitud.class);
            this.getWorldOfType(Volcan.class).disminuyePocimaL();
            vel=1;
        }
    }
    /**
     * Metodo que cuando encuentra una pocima de vida la suma a la clase vidas en +1
     */
    public void buscaPocimaVida()
    {
        World myWorld=getWorld();
        Volcan vol = (Volcan) myWorld;
        Vidas vida= vol.getVidas();
        if(isTouching(PocionResistencia.class))
        {
            removeTouching(PocionResistencia.class);
            this.getWorldOfType(Volcan.class).disminuyePocimaV();
            vida.sumar();
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
            removeTouching(Lava.class);
            Greenfoot.playSound("Fire.wav");
            vida.restaVida();
        }
    }
    
    /**
     * Metodo que se ejecuta cuando Rescatista toca a la clase Fuego, se decrementan las vidas y se elimina el fuego
     * ademas obtiene una clase del mundo Volcan para disminuir el numero de pocimas de ese tipo que hay en el mundo
     */
    public void buscaFuego()
    {
        World myWorld=getWorld();
        Volcan vol = (Volcan) myWorld;
        Vidas vida= vol.getVidas();
        if(isTouching(Fuego.class))
        {
            removeTouching(Fuego.class);
            Greenfoot.playSound("Fire.wav");
            this.getWorldOfType(Volcan.class).disminuyeFuego();
            vida.restaVida();
        }
    }
    
    /**
     * Metodo que suma puntos cuando se salva a un naufrago y obtiene 
     * una clase del mundo Volcan para disminuir el numero de naufragos de ese tipo que hay en el mundo
     */
    public void buscaNaufrago()
    {
        World myWorld=getWorld();
        Volcan vol = (Volcan) myWorld;
        Puntos punto= vol.getPuntos();
        Dificultad dificultad=vol.getDificultad();
        if(isTouching(Naufrago1.class) && Greenfoot.isKeyDown("space"))
        {            
            removeTouching(Naufrago1.class);
            this.getWorldOfType(Volcan.class).disminuyeNau1();
            punto.sumar();
        }else{
            if(isTouching(Naufrago2.class) && Greenfoot.isKeyDown("space"))
            {
                removeTouching(Naufrago2.class);
                this.getWorldOfType(Volcan.class).disminuyeNau2();
                punto.sumar();
            }
        }
    }
    
    /**
     * Metodo que retorna puntos
     * 
     * @return entero de puntos actuales.
     */
    public int regresaPuntos()
    {
        return puntos;
    }
    
    /**
     * Metodo que sube dificultad no funciona al cien, se implemento mejor en la clase "dificultad"
     */
    public void subeDificultad()
    {
        World myWorld=getWorld();
        Volcan vol = (Volcan) myWorld;
        Dificultad dificultad=vol.getDificultad();
        if(puntos==1)
            dificultad.sumar();
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
            switchImageInv();
        }
        
        if(Greenfoot.isKeyDown("up"))//&&y>=285)
        {
            if(y<=2)
                this.getWorldOfType(Volcan.class).scrollBackgroundY(4);
            else
                this.setLocation(x,y-vel);
            switchImage();
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            if(x<=2)
                this.getWorldOfType(Volcan.class).scrollBackgroundX(4);
            else
                this.setLocation(x-vel, y);
            switchImageInv();
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            if(x>=638)
            {
                this.getWorldOfType(Volcan.class).scrollBackgroundX(-4);
            }else{
                this.setLocation(x+vel, y);
            }
            switchImage();
        }
    }
}
