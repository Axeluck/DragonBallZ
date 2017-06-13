package modelo.personajes.estados;


import modelo.personajes.IPersonajeEquipoVillano;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.excepciones.AtaqueMismoEquipoException;

public class MajinBooEstadoBooOriginal extends Estado {

    public MajinBooEstadoBooOriginal(Coordenada pUbicacion) {
        super(pUbicacion);
        ki = ki - 50;
        poder = 60;
        distanciaAtaque = 3;
        velocidadMov = 4;
    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje) {
        throw new AtaqueMismoEquipoException();
    }
}