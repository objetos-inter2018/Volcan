import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que dirige la dificultad del juego.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Dificultad extends Marcador
{
    private int dif, puntos;
    /**
     * Act - do whatever the Dificultad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World myWorld=getWorld();
        Volcan vol = (Volcan) myWorld;
        Puntos punto= vol.getPuntos();
        puntos=punto.vePuntos();
        
        if(puntos<=3)
            setImage(new GreenfootImage("Dificultad: "+"Facil", 24, Color.RED, Color.BLACK));
        else
            if(puntos==5)
                setImage(new GreenfootImage("Dificultad: "+"Intermedio", 24, Color.RED, Color.BLACK));
                else
                if(puntos>=7)
                    setImage(new GreenfootImage("Dificultad: "+"Dificil", 24, Color.RED, Color.BLACK));
    }    
    /**
     * metodo que sube la dificultad y utiliza al metodo polimorfico de la clase marcador
     */
    public void sumar()
    {
        dif++;
    }
    
    /**
     * metodo que regresa la dificultad, 1 facil, 2 intermedio, 3 dificil
     * 
     * @return dificultad de la clase
     */
    public int regresaDificultad()
    {
        return dif;
    }
    
    public int getVidas()
    {
        return puntos;
    }
    
    /**
     * Metodo que interactua y regresa los puntos en entero
     * 
     * @return puntuacion actual
     */
    public int regresaPuntos()
    {
        return puntos;
    }
}

