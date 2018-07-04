import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea el mundo de juego, y añade los actores a la pantalla en posiciones x y y.
 * 
 * @author IJRC
 * @version 1.0
 */
public class Volcan extends World
{
    public int spwGota, spwNaufrago, spwNau, spwRap, spwLen, spwVid, offset, offsety;
    public int numGotas, numPocr, numPocl, numPocv, numNau1, numNau2, numFue;
    private GreenfootImage background;
    Vidas vidas=new Vidas();
    Puntos puntos=new Puntos();
    Dificultad dificultad=new Dificultad();
    PocionVelocidad pocimaVelocidad;
    PocionLentitud pocimaLentitud;
    PocionResistencia pocimaResistencia;
    Naufrago1 naufrago;
    Naufrago2 naufrago2;
    Fuego fuego;
    
    /**
     * Constructor para objetos de clase Volcan.
     * 
     */
    public Volcan()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1,false); //Para que los objetos salgan de ese recuadro
        offset=0;
        offsety=0;
        numPocr=numPocl=numPocv=numNau1=numNau2=numFue=1;
        numGotas=80;
        background = new GreenfootImage("juegoWorld.png");
        añadePersonajes();
    }
   
    /**
     * Clase que hace que el actor actue, en este caso se crean gotas de lava aleatoriamente y se plasman en y positivas
     */
    public void act()
    {
       gotasLava();
       apareceNaufragos();
       apareceNaufrago();
       aparecePocimas();
       apareceFuego();
       nivelesDificultad();
    }
    
    /**
     * Metodo que spawnea las gotas de lava utilizando un random, que se modifica de acuerdo a que nivel vamos
     */
    public void gotasLava()
    {
        spwGota = (spwGota+1)%numGotas;
        int aleatorio=Greenfoot.getRandomNumber(640);
        if (spwGota == 0)
        {
            addObject(new Lava(), aleatorio,10);
        }
    }
    
    /**
     * Metodo que aparece los naufragos y estos caminan 
     */
    public void apareceNaufragos()
    {
        spwNaufrago = (spwNaufrago+1)%200;
        int aleatorio=Greenfoot.getRandomNumber(480);
        int aleatorioY=getRandomNumberLim(285, 481);
        if (spwNaufrago == 0)
        {
            naufrago=new Naufrago1();
            this.addObject(naufrago, 10,aleatorioY);
            numNau1++;
        }
    }
    
    /**
     * Metodo que aparecen los naufragos que se quedan en la pantalla sin moverse
     */
    public void apareceNaufrago()
    {
        spwNau = (spwNau+1)%30;
        int aleatorio=Greenfoot.getRandomNumber(480);
        int aleatorioY=getRandomNumberLim(285, 481);
        if (spwNau == 0)
        {
            naufrago2=new Naufrago2();
            this.addObject(naufrago2, aleatorio ,aleatorioY);
            numNau2++;
        }
    }
    
    /**
     * Metodo que hace el spawn de pocimas en el mundo ademas suma al contador para saber cuantas pocimas se crean de cada una
     * 
     */
    public void aparecePocimas()
    {
        //pocimaVelocidad=new PocionVelocidad();
        //this.addObject(pocimaVelocidad, 600, 400);
        /*POCIMA RAPIDEZ*/
        spwRap = (spwRap+1)%700;
        int aleatorioRapX=Greenfoot.getRandomNumber(640);
        int aleatorioRapY=getRandomNumberLim(285, 481);
        if (spwRap == 0)
        {
            pocimaVelocidad=new PocionVelocidad();
            this.addObject(pocimaVelocidad, aleatorioRapX ,aleatorioRapY);
            numPocr++;
        }
        
        /* POCIMA LENTITUD*/
        spwLen = (spwLen+1)%700;
        int aleatorioLenX=Greenfoot.getRandomNumber(640);
        int aleatorioLenY=getRandomNumberLim(285, 481);
        if(spwLen== 0)
        {
            pocimaLentitud=new PocionLentitud();
            this.addObject(pocimaLentitud, aleatorioLenX ,aleatorioLenY);
            numPocl++;
        }
        
        /*POCIMA VIDA*/
        spwVid = (spwVid+1)%700;
        int aleatorioVidX=Greenfoot.getRandomNumber(640); 
        int aleatorioVidY=getRandomNumberLim(285, 481);
        if(spwRap== 0)
        {
            pocimaResistencia=new PocionResistencia();
            this.addObject(pocimaResistencia, aleatorioVidX ,aleatorioVidY);
            numPocv++;
        }
    }
    
    /**
     * Metodo que añada el segundo tipo de obstaculo que es el fuego
     *
     */
    public void apareceFuego()
    {
        spwNau = (spwNau+1)%800;
        int aleatorio=Greenfoot.getRandomNumber(480);
        int aleatorioY=getRandomNumberLim(285, 481);
        if (spwNau == 0)
        {
            fuego=new Fuego();
            this.addObject(fuego, aleatorio ,aleatorioY);
            numFue++;
        }
    }
    
    /**
     * Metodo que disminuye la variable que hace referencia a las pocimas creadas de rapidez
     */
    public void disminuyePocima()
    {
        numPocr--;
    }
    /**
     * Metodo que disminuye la variable que hace referencia a las pocimas creadas de lentitud
     */
    public void disminuyePocimaL()
    {
        numPocl--;
    }
    /**
     * Metodo que disminuye la variable que hace referencia a las pocimas creadas de vida
     */
    public void disminuyePocimaV()
    {
        numPocv--;
    }
    /**
     * Metodo que disminuye la variable que hace referencia a los naufragos creados de tipo 1 (movibles)
     */
    public void disminuyeNau1()
    {
        numNau1--;
    }
    /**
     * Metodo que disminuye la variable que hace referencia a los naufragos creados de tipo 2 (estaticos)
     */
    public void disminuyeNau2()
    {
        numNau2--;
    }
    
    /**
     * Metodo que disminuye la variable que hace referencia al fuego 
     */
    public void disminuyeFuego()
    {
        numFue--;
    }
    
    /**
     * Metodo que regresa el numero de pocimas de rapidez en el mundo
     * 
     * @return numero de pocimas de rapidez
     */
    public int numeroPociones()
    {
        return numPocr;
    }
    /**
     * Metodo que regresa el numero de pocimas de lentitud en el mundo
     * 
     * @return numero de pocimas de lentitud
     */
    public int numeroPocionesL()
    {
        return numPocl;
    }
    /**
     * Metodo que regresa el numero de pocimas de vida en el mundo
     * 
     * @return numero de pocimas de vida
     */
    public int numeroPocionesV()
    {
        return numPocv;
    }
    /**
     * Metodo que regresa el numero de naufragos de tipo 2 en el mundo
     * 
     * @return numero de naufragos tipo 2
     */
    public int numNau2()
    {
        return numNau2;
    }

    /**
     * Metodo que verifica que nivel esta actualmente, y conforme la puntuacion suba
     * modifica el random para que se creen mas enemigos
     */
    public void nivelesDificultad()
    {
        int niv=puntos.vePuntos();
        if(niv<=3)
            numGotas=80;
        else
            if(niv==5)
                numGotas=50;
                else
                if(niv>=7)
                    numGotas=30;
    }
    
    /**
     * Clase que añade actores al mundo
     */
    public void añadePersonajes()
    {
        addObject(new Rescatista(), getWidth()/2,320);

        //this.addObject(pocimaVelocidad, 400 , 350);   
        pocimaVelocidad=new PocionVelocidad();
        this.addObject(pocimaVelocidad, 5, 0);
        
        //this.addObject(pocimaLentitud, 200 , 350);
        pocimaLentitud=new PocionLentitud();
        this.addObject(pocimaLentitud, 0 , 320);
        
        pocimaResistencia=new PocionResistencia();
        this.addObject(pocimaResistencia, 0,639);
        
        fuego=new Fuego();
        this.addObject(fuego, 450, 400);
        
        naufrago=new Naufrago1();
        addObject(naufrago, 10, 350);//Primer naufrago para que se cree junto con el mundo
        
        naufrago2=new Naufrago2();
        addObject(naufrago2, 630, 350);
        
        addObject(vidas, 45, 10);
        addObject(puntos, 580, 10);
        addObject(dificultad, getWidth()/2, 10);
        
        this.scrollBackgroundX(0);
        this.scrollBackgroundY(0);
    }
    
    /**
     * Clase que hace el scroll en el eje de las x
     * ademas que deja plantados los objetos en donde se deben de quedar en el eje de las x
     */  
    public void scrollBackgroundX(int distX)
    {
        int prueba=numPocr;
        GreenfootImage worldImage = new GreenfootImage(640,480);
        if(offset+distX >= -640 && offset+distX <=0)
        {
            offset+=distX;
            worldImage.drawImage(background, offset, offsety);
            this.setBackground(worldImage);
            if(numPocl>=3)
                pocimaLentitud.setLocation(pocimaLentitud.getX()+distX, pocimaLentitud.getY());
            if(numPocr>=3)
                pocimaVelocidad.setLocation(pocimaVelocidad.getX()+distX, pocimaVelocidad.getY());
            if(numPocv>=3)
                pocimaResistencia.setLocation(pocimaResistencia.getX()+distX, pocimaResistencia.getY());
            if(numNau1>=1)
                naufrago.setLocation(naufrago.getX()+distX, naufrago.getY());
            if(numNau2>=1)
                naufrago2.setLocation(naufrago2.getX()+distX, naufrago2.getY());
            if(numFue>=1)
                fuego.setLocation(fuego.getX()+distX, fuego.getY());
        }
    }
    
    /**
     * Clase que hace scroll en eje de las Y
     * ademas que deja plantados los objetos en donde se deben de quedar en el eje de las y
     */
     public void scrollBackgroundY(int distY)
    {
        GreenfootImage worldImage = new GreenfootImage(640,480);
        if(offsety+distY >= -480 &&offsety+distY <=0)
        {
            offsety+=distY;
            worldImage.drawImage(background, offset, offsety);
            this.setBackground(worldImage);
            if(numPocl>=3)
                pocimaLentitud.setLocation(pocimaLentitud.getX(), pocimaLentitud.getY()+distY);
            if(numPocr>=3)
                pocimaVelocidad.setLocation(pocimaVelocidad.getX(), pocimaVelocidad.getY()+distY);
            if(numPocv>=3)
                pocimaResistencia.setLocation(pocimaResistencia.getX(), pocimaResistencia.getY()+distY);
            if(numNau1>=1)
                naufrago.setLocation(naufrago.getX(), naufrago.getY()+distY);
            if(numNau2>=1)
                naufrago2.setLocation(naufrago2.getX(), naufrago2.getY()+distY);
            if(numFue>=1)
                fuego.setLocation(fuego.getX(), fuego.getY()+distY);
        }
    }
    
    public void checkPoc(int distX)
    {
        if(offset+distX >= -640 && offset+distX <=0)
        {
            pocimaVelocidad.setLocation(pocimaVelocidad.getX()+distX, pocimaVelocidad.getY());
        }
    }
    
    /**
     * Metodo que consigue vidas
     * 
     * @return Regresa las vidas de tipo Vidas para clase Rescatista
     */
    public Vidas getVidas()
    {
        return vidas;
    }
    
    /**
     * Metodo que almacena los puntos del jugador
     * 
     * @return las vidas del personaje Rescatista
     */
    public Puntos getPuntos()
    {
        return puntos;
    }
    
    /**
     * Metodo que almacena los puntos del jugador
     * 
     * @return las dificultad del juego
     */
    public Dificultad getDificultad()
    {
        return dificultad;
    }
    
    /**
     * Metodo que genera numero random con dos limites
     * 
     * @return el numero random generado
     * 
     * @param los limites de minimo y maximo
     */
    public int getRandomNumberLim(int start,int end)
    {
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal+start;
    }
}
