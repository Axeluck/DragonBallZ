package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class Entrega1Tests {

	@Test
	public void test1ColocarYMoverAGoku() {
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku();
		goku.Ubicar(new Coordenada(1,1));
		goku.mover(new Coordenada(3,3));
		
		Coordenada coord = tablero.obtenerPosicionDe(goku);
		
		org.junit.Assert.assertEquals(3, coord.getCoordX());
	}
	
	@Test(expected=CeldaOcupadaException.class)
	public void test2Colocar2PersonajesMismaCelda(){
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		goku.Ubicar(new Coordenada(1,1));
		gohan.Ubicar(new Coordenada(1,1));
	}
	
	
	
	@Test
	public void test4TransformaPersonaje(){
		Goku goku = new Goku();
		Goku.transformar();
		
		org.junit.Assert.assertTrue(Goku.estado() == "KaioKen");
	}
	
	@Test
	public void test5TransformaYMueve(){
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku();
		goku.Ubicar(new Coordenada(1,1));
		goku.mover(new Coordenada(4,4));
		
		Coordenada coord = tablero.obtenerPosicionDe(goku);
		
		org.junit.Assert.assertEquals(4, coord.getCoordX());;
		
	}
	
	

}
