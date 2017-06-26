package DBZ.modelo.personajes;

import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.PersonajeYaEsChocolateException;
import DBZ.modelo.personajes.estados.Estado;
import DBZ.modelo.personajes.estados.EstadoConvertidoEnChocolate;
import DBZ.modelo.personajes.estados.GokuEstado;
import DBZ.modelo.personajes.estados.GokuEstadoNormal;
import DBZ.modelo.tablero.Consumible;
import DBZ.modelo.tablero.Coordenada;
import DBZ.modelo.tablero.IUbicable;
import DBZ.modelo.personajes.interfaces.IPersonaje;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoVillano;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;

public class Goku implements IPersonajeEquipoZ, IUbicable {

	Estado estado;
	boolean convertidoEnChocolate;

    public Goku (Coordenada coordeanda){
    	this.estado = new GokuEstadoNormal();
    	estado.setUbicacion(coordeanda);
    }

    @Override
	public void atacar(IPersonaje atacado) {
    	this.estado.atacar((IPersonajeEquipoZ) atacado);
	}

    public void atacar(IPersonajeEquipoZ personaje){
		this.estado.atacar(personaje);
	}

	public void atacar(IPersonajeEquipoVillano personaje){
		this.estado.atacar(personaje);
	}

	public void mover(Coordenada destino){
		this.estado.mover(destino);
	}

	public void recibirAtaque(int poderBase, int danio){
		this.estado.recibirAtaque(poderBase, danio);
	}

	public void ubicar(Coordenada coordenada){
		this.estado.setUbicacion(coordenada);
	}

	public Coordenada obtenerUbicacion(){
		return this.estado.getUbicacion();
	}

	public int getVida() {
		return this.estado.getVida();
	}

	public boolean vidaMenor30porc(){
		return this.estado.vidaMenor30porc();
	}

    public void ataqueEspecial(IPersonajeEquipoZ atacado) {
    	throw new AtaqueMismoEquipoException();

	}

    public void ataqueEspecial(IPersonajeEquipoVillano atacado){
    	((GokuEstado) this.estado).kamehameha(atacado);
    }

	public void transformar(){
		GokuEstado nuevoEstado = ((GokuEstado) this.estado).transformar();
    	estado = nuevoEstado;
	}

	public void convertirEnChocolate() {
		if(convertidoEnChocolate){
			throw new PersonajeYaEsChocolateException();
		}
		this.estado = (Estado) (new EstadoConvertidoEnChocolate(estado));
	}

	public void terminoTurno() {
		Estado estado = this.estado.terminoTurno();
		if(estado != null){
			this.estado = estado;
			this.convertidoEnChocolate = false;
		}
	}

	public void consumir(Consumible consumible) {
		consumible.consumir(this.estado);
	}

	@Override
	public boolean estaVivo() {
		return this.estado.estaVivo();
	}

	public int getVidaMax() {
		return estado.getVidaMax();
	}

	public int getKi() {
		return this.estado.getKi();
	}


}
