package monopoly.persona;

import monopoly.resto.*;

public class Avatar {
    private String id;
    private String ficha;
    private Jugador jugador;
    private Casilla casilla;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    // constructores

    public Avatar(Jugador jugador, String ficha) {
        Character n = (char) Math.ceil(Math.random() * 255);
        this.id = n.toString();
        this.jugador = jugador;
        if (ficha.equals("Esfinge") || ficha.equals("Coche") || ficha.equals("Sombrero") || ficha.equals("Pelota")) {
            this.ficha = ficha;
        } else {
            throw new IllegalArgumentException("Ficha debe ser: Esfinge, Coche, Sombrero o Pelota");
        }
    }

    @Override
    public String toString() {
        String cadena= "{\n \t id: " + this.id + "\n\t tipo: " + this.ficha + "\n\t casilla: placeholder" + "\n\t jugador: " + this.jugador.getNombre() ;
        return cadena;
    }
}
