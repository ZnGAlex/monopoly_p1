package monopoly.persona;

import java.util.ArrayList;
import monopoly.resto.*;

public class Avatar {
    private String id;
    private String ficha;
    private Jugador jugador;
    private Casilla casilla;
    
    
    // constructores

    public Avatar(Jugador jugador, String ficha, Casilla casilla) {
        if(jugador != null && ficha != null){
            Character n = (char) Math.ceil(Math.random() * 255);
            this.id = n.toString();
            this.jugador = jugador;
            this.ficha = ficha;
            this.casilla = casilla;
        }
        else{
            System.out.println("ERROR CONSTRUCTOR AVATAR: jugador o ficha nulo/s\n");
            System.exit(1);
        }
    }

    // getters y setters
    
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
    
    // metodos
    
    public void moverAvatar(int avance,Tablero tablero){
       if(avance < 0){
            System.out.println(Valor.ANSI_ROJO + "Avance negativo.");
            System.exit(1);
       }
       if(tablero == null){
            System.out.println(Valor.ANSI_ROJO + "Tablero nulo.");
            System.exit(1);
       }
       int posicionActual = this.casilla.getPosicion();
       int lado = (posicionActual + avance) / 10;
       int posicionNueva = (posicionActual + avance) % 10;
       this.casilla.eliminarAvatar(this);
        this.casilla = tablero.getCasillas().get(lado).get(posicionNueva);
       tablero.getCasillas().get(lado).get(posicionNueva).getAvatares().put(this.getId(), this);
       /*for(ArrayList<Casilla> n : tablero.getCasillas()){
           if(n.contains(this.casilla)){
               int newPos = n.indexOf(casilla) + avance;             
               while(newPos > n.size()){
                   newPos -= 10;
                   n = tablero.getCasillas().get((tablero.getCasillas().indexOf(n)+1)%4);  // Siguiente lado del tablero
               }
               this.casilla = n.get(newPos);
           }
       }
       this.casilla.añadirAvatar(this);*/
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
