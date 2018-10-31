package monopoly.resto;

import monopoly.persona.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {
    private ArrayList<ArrayList<Casilla>> casillas;
    private HashMap<String, Avatar> avatares;
    private HashMap<String, Jugador> jugadores;

    public Tablero() {
        ArrayList<ArrayList<Casilla>> tablero = new ArrayList<>();
        ArrayList<Casilla> abajo = new ArrayList<>();
        ArrayList<Casilla> izquierda = new ArrayList<>();
        ArrayList<Casilla> derecha = new ArrayList<>();
        ArrayList<Casilla> arriba = new ArrayList<>();
        HashMap<String, Grupo> grupos = new HashMap<>();
        Grupo grupo_marron = new Grupo(Valor.GRUPO_NEGRO, Valor.COSTE_GRUPO_NEGRO, Valor.ALQUILER_GRUPO_NEGRO);
        Grupo grupo_cyan = new Grupo(Valor.GRUPO_CYAN, Valor.COSTE_GRUPO_CYAN, Valor.ALQUILER_GRUPO_CYAN);
        Grupo grupo_rosa = new Grupo(Valor.GRUPO_ROSA, Valor.COSTE_GRUPO_ROSA, Valor.ALQUILER_GRUPO_ROSA);
        Grupo grupo_naranja = new Grupo(Valor.GRUPO_NARANJA, Valor.COSTE_GRUPO_NARANJA, Valor.ALQUILER_GRUPO_NARANJA);
        Grupo grupo_rojo = new Grupo(Valor.GRUPO_ROJO, Valor.COSTE_GRUPO_ROJO, Valor.ALQUILER_GRUPO_ROJO);
        Grupo grupo_amarillo = new Grupo(Valor.GRUPO_AMARILLO, Valor.COSTE_GRUPO_AMARILLO, Valor.ALQUILER_GRUPO_AMARILLO);
        Grupo grupo_verde = new Grupo(Valor.GRUPO_VERDE, Valor.COSTE_GRUPO_VERDE, Valor.ALQUILER_GRUPO_VERDE);
        Grupo grupo_azul = new Grupo(Valor.GRUPO_AZUL, Valor.COSTE_GRUPO_AZUL, Valor.ALQUILER_GRUPO_AZUL);
        grupos.put(Valor.GRUPO_NEGRO, grupo_marron);
        grupos.put(Valor.GRUPO_CYAN, grupo_cyan);
        grupos.put(Valor.GRUPO_ROSA, grupo_rosa);
        grupos.put(Valor.GRUPO_NARANJA, grupo_naranja);
        grupos.put(Valor.GRUPO_ROJO, grupo_rojo);
        grupos.put(Valor.GRUPO_AMARILLO, grupo_amarillo);
        grupos.put(Valor.GRUPO_VERDE, grupo_verde);
        grupos.put(Valor.GRUPO_AZUL, grupo_azul);
        Casilla solar1GrupoNegro = new Casilla(Valor.SOLAR1_GRUPO_NEGRO, Valor.CASILLa_TIPO_SOLAR, grupo_marron);
        Casilla solar2GrupoNegro = new Casilla(Valor.SOLAR2_GRUPO_NEGRO, Valor.CASILLa_TIPO_SOLAR, grupo_marron);
        Casilla solar1GrupoCyan = new Casilla(Valor.SOLAR1_GRUPO_CYAN, Valor.CASILLa_TIPO_SOLAR, grupo_cyan);
        Casilla solar2GrupoCyan = new Casilla(Valor.SOLAR2_GRUPO_CYAN, Valor.CASILLa_TIPO_SOLAR, grupo_cyan);
        Casilla solar3GrupoCyan = new Casilla(Valor.SOLAR3_GRUPO_CYAN, Valor.CASILLa_TIPO_SOLAR, grupo_cyan);
        Casilla solar1GrupoRosa = new Casilla(Valor.SOLAR1_GRUPO_ROSA, Valor.CASILLa_TIPO_SOLAR, grupo_rosa);
        Casilla solar2GrupoRosa = new Casilla(Valor.SOLAR2_GRUPO_ROSA, Valor.CASILLa_TIPO_SOLAR, grupo_rosa);
        Casilla solar3GrupoRosa = new Casilla(Valor.SOLAR3_GRUPO_ROSA, Valor.CASILLa_TIPO_SOLAR, grupo_rosa);
        Casilla solar1GrupoNaranja = new Casilla(Valor.SOLAR1_GRUPO_NARANJA, Valor.CASILLa_TIPO_SOLAR, grupo_naranja);
        Casilla solar2GrupoNaranja = new Casilla(Valor.SOLAR2_GRUPO_NARANJA, Valor.CASILLa_TIPO_SOLAR, grupo_naranja);
        Casilla solar3GrupoNaranja = new Casilla(Valor.SOLAR3_GRUPO_NARANJA, Valor.CASILLa_TIPO_SOLAR, grupo_naranja);
        Casilla solar1GrupoRojo = new Casilla(Valor.SOLAR1_GRUPO_ROJO, Valor.CASILLa_TIPO_SOLAR, grupo_rojo);
        Casilla solar2GrupoRojo = new Casilla(Valor.SOLAR2_GRUPO_ROJO, Valor.CASILLa_TIPO_SOLAR, grupo_rojo);
        Casilla solar3GrupoRojo = new Casilla(Valor.SOLAR3_GRUPO_ROJO, Valor.CASILLa_TIPO_SOLAR, grupo_rojo);
        Casilla solar1GrupoAmarillo = new Casilla(Valor.SOLAR1_GRUPO_AMARILLO, Valor.CASILLa_TIPO_SOLAR, grupo_amarillo);
        Casilla solar2GrupoAmarillo = new Casilla(Valor.SOLAR2_GRUPO_AMARILLO, Valor.CASILLa_TIPO_SOLAR, grupo_amarillo);
        Casilla solar3GrupoAmarillo = new Casilla(Valor.SOLAR3_GRUPO_AMARILLO, Valor.CASILLa_TIPO_SOLAR, grupo_amarillo);
        Casilla solar1GrupoVerde = new Casilla(Valor.SOLAR1_GRUPO_VERDE, Valor.CASILLa_TIPO_SOLAR, grupo_verde);
        Casilla solar2GrupoVerde = new Casilla(Valor.SOLAR2_GRUPO_VERDE, Valor.CASILLa_TIPO_SOLAR, grupo_verde);
        Casilla solar3GrupoVerde = new Casilla(Valor.SOLAR3_GRUPO_VERDE, Valor.CASILLa_TIPO_SOLAR, grupo_verde);
        Casilla solar1GrupoAzul = new Casilla(Valor.SOLAR1_GRUPO_AZUL, Valor.CASILLa_TIPO_SOLAR, grupo_azul);
        Casilla solar2GrupoAzul = new Casilla(Valor.SOLAR2_GRUPO_AZUL, Valor.CASILLa_TIPO_SOLAR, grupo_azul);
        abajo.add(solar1GrupoNegro);
        abajo.add(solar2GrupoNegro);
        abajo.add(solar1GrupoCyan);
        abajo.add(solar2GrupoCyan);
        abajo.add(solar2GrupoCyan);
        
    }

    public ArrayList<ArrayList<Casilla>> getCasillas() {
        return casillas;
    }

    public void setCasillas(ArrayList<ArrayList<Casilla>> casillas) {
        this.casillas = casillas;
    }

    public HashMap<String, Avatar> getAvatares() {
        return avatares;
    }

    public void setAvatares(HashMap<String, Avatar> avatares) {
        this.avatares = avatares;
    }

    public HashMap<String, Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(HashMap<String, Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
