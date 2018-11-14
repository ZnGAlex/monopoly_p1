package monopoly.persona;

import java.util.ArrayList;
import monopoly.resto.*;

public class Avatar {
    private String id;
    private String ficha;
    private Jugador jugador;
    private Casilla casilla;
    
    
    // constructores

    public Avatar(Jugador jugador, String ficha, Casilla casilla, String id) {
        if(jugador != null && ficha != null){
            this.id = id;
            this.jugador = jugador;
            this.ficha = ficha;
            this.casilla = casilla;
        }
        else{
            System.out.println("Error creando avatar.");
            System.exit(1);
        }
    }

    // getters y setters
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null) {
            System.out.println("Id nulo.");
            System.exit(1);
        }
        this.id = id;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        if (ficha == null) {
            System.out.println("Ficha nula.");
            System.exit(1);
        }
        this.ficha = ficha;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        if (jugador == null) {
            System.out.println("Jugador nulo.");
            System.exit(1);
        }
        this.jugador = jugador;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        if (casilla == null) {
            System.out.println("Casilla nula.");
            System.exit(1);
        }
        this.casilla = casilla;
    }
    
    // metodos
    
    public void moverAvatar(int avance,Tablero tablero, Turno turno){
       if(avance < 0){
            System.out.println(Valor.ANSI_ROJO + "Avance negativo.");
            System.exit(1);
       }
       if(tablero == null){
            System.out.println(Valor.ANSI_ROJO + "Tablero nulo.");
            System.exit(1);
       }
       int posicionActual = this.casilla.getPosicion();
       int lado = ((posicionActual + avance) / 10) % 4;
       int posicionNueva = (posicionActual + avance) % 10;
       
       System.out.println("Desde " + this.casilla.getNombre() + " hasta " + tablero.getCasillas().get(lado).get(posicionNueva).getNombre());
       this.casilla.eliminarAvatar(this);
       this.casilla = tablero.getCasillas().get(lado).get(posicionNueva);
       this.casilla.getAvatares().put(this.id, this);
       
       switch(tablero.getCasillas().get(lado).get(posicionNueva).getPosicion()){
            case Valor.POSICION_CASILLA_IR_CARCEL:
                this.jugador.encarcelarJugador(tablero);
                this.jugador.setDadosTirados(false);
                System.out.println("El jugador va a la carcel.");
                turno.siguienteTurno();
               break;
            case Valor.POSICION_CASILLA_IMPUESTO1:
                System.out.println("El jugador paga un impuesto de " + Valor.ALQUILER_IMPUESTO1);
                this.jugador.pagarImpuesto(Valor.ALQUILER_IMPUESTO1,tablero, turno);
                break;
            case Valor.POSICION_CASILLA_IMPUESTO2:
                System.out.println("El jugador paga un impuesto de " + Valor.ALQUILER_IMPUESTO2);
                this.jugador.pagarImpuesto(Valor.ALQUILER_IMPUESTO2,tablero, turno);
                break;
            case Valor.POSICION_CASILLA_CAJA1: case Valor.POSICION_CASILLA_CAJA2: case Valor.POSICION_CASILLA_CAJA3:
                break;
            case Valor.POSICION_CASILLA_SUERTE1: case Valor.POSICION_CASILLA_SUERTE2: case Valor.POSICION_CASILLA_SUERTE3:
                break;
            case Valor.POSICION_CASILLA_PARKING:
                System.out.println("El jugador cobra el dinero del Parking");
                this.jugador.cobrarParking();
                break;
            default:
                this.jugador.pagarAlquiler(tablero,turno);
       }
    }
    
    public void moverAvatarCasilla(Casilla destino){
        if(casilla == null){
            System.out.println(Valor.ANSI_ROJO + "Avance negativo.");
            System.exit(1);
        }
        this.casilla.eliminarAvatar(this);
        this.casilla = destino;
        this.casilla.anhadirAvatar(this);
        
    }
    
    @Override
    public String toString() {
        String cadena= "{\n " +
                            "\t id: " + this.id +
                            ",\n\t tipo: " + this.ficha +
                            ",\n\t casilla: " + this.casilla.getNombre() +
                            ",\n\t jugador: " + this.jugador.getNombre() + "\n}" ;
        return cadena;
    }
}
