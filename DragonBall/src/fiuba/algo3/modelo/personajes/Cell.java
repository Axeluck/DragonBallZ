package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.personajes.Personaje;
import fiuba.algo3.modelo.tablero.Tablero;

public class Cell extends Personaje{
	
    public Cell (Tablero pTablero){
    	super(pTablero);
        vida = 500;
        poder = 20;
        distanciaAtaque = 3;
        velocidadMov = 2;
        ki = 0;
    }
    
    public Cell (){
        vida = 500;
        poder = 20;
        distanciaAtaque = 3;
        velocidadMov = 2;
        ki = 0;
    }

    /*
    public void semiPerfecto(){
        poder = 40;
        distanciaAtaque = 4;
        velocidadMov = 3;
    }

    public void perfecto(){
        poder = 80;
        distanciaAtaque  = 4;
        velocidadMov = 4;
    }

    public void absorber(){
        ki = ki - 5;
        vida = vida + 20;
    }
    */
}

