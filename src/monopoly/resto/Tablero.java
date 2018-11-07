package monopoly.resto;

import monopoly.persona.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {
    private ArrayList<ArrayList<Casilla>> casillas;
    private HashMap<String, Avatar> avatares;
    private HashMap<String, Jugador> jugadores;

    public Tablero() {
        this.casillas = new ArrayList<>();
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
        Casilla solar1GrupoNegro = new Casilla(Valor.SOLAR1_GRUPO_NEGRO, Valor.CASILLA_TIPO_SOLAR, grupo_marron);
        Casilla solar2GrupoNegro = new Casilla(Valor.SOLAR2_GRUPO_NEGRO, Valor.CASILLA_TIPO_SOLAR, grupo_marron);
        Casilla solar1GrupoCyan = new Casilla(Valor.SOLAR1_GRUPO_CYAN, Valor.CASILLA_TIPO_SOLAR, grupo_cyan);
        Casilla solar2GrupoCyan = new Casilla(Valor.SOLAR2_GRUPO_CYAN, Valor.CASILLA_TIPO_SOLAR, grupo_cyan);
        Casilla solar3GrupoCyan = new Casilla(Valor.SOLAR3_GRUPO_CYAN, Valor.CASILLA_TIPO_SOLAR, grupo_cyan);
        Casilla solar1GrupoRosa = new Casilla(Valor.SOLAR1_GRUPO_ROSA, Valor.CASILLA_TIPO_SOLAR, grupo_rosa);
        Casilla solar2GrupoRosa = new Casilla(Valor.SOLAR2_GRUPO_ROSA, Valor.CASILLA_TIPO_SOLAR, grupo_rosa);
        Casilla solar3GrupoRosa = new Casilla(Valor.SOLAR3_GRUPO_ROSA, Valor.CASILLA_TIPO_SOLAR, grupo_rosa);
        Casilla solar1GrupoNaranja = new Casilla(Valor.SOLAR1_GRUPO_NARANJA, Valor.CASILLA_TIPO_SOLAR, grupo_naranja);
        Casilla solar2GrupoNaranja = new Casilla(Valor.SOLAR2_GRUPO_NARANJA, Valor.CASILLA_TIPO_SOLAR, grupo_naranja);
        Casilla solar3GrupoNaranja = new Casilla(Valor.SOLAR3_GRUPO_NARANJA, Valor.CASILLA_TIPO_SOLAR, grupo_naranja);
        Casilla solar1GrupoRojo = new Casilla(Valor.SOLAR1_GRUPO_ROJO, Valor.CASILLA_TIPO_SOLAR, grupo_rojo);
        Casilla solar2GrupoRojo = new Casilla(Valor.SOLAR2_GRUPO_ROJO, Valor.CASILLA_TIPO_SOLAR, grupo_rojo);
        Casilla solar3GrupoRojo = new Casilla(Valor.SOLAR3_GRUPO_ROJO, Valor.CASILLA_TIPO_SOLAR, grupo_rojo);
        Casilla solar1GrupoAmarillo = new Casilla(Valor.SOLAR1_GRUPO_AMARILLO, Valor.CASILLA_TIPO_SOLAR, grupo_amarillo);
        Casilla solar2GrupoAmarillo = new Casilla(Valor.SOLAR2_GRUPO_AMARILLO, Valor.CASILLA_TIPO_SOLAR, grupo_amarillo);
        Casilla solar3GrupoAmarillo = new Casilla(Valor.SOLAR3_GRUPO_AMARILLO, Valor.CASILLA_TIPO_SOLAR, grupo_amarillo);
        Casilla solar1GrupoVerde = new Casilla(Valor.SOLAR1_GRUPO_VERDE, Valor.CASILLA_TIPO_SOLAR, grupo_verde);
        Casilla solar2GrupoVerde = new Casilla(Valor.SOLAR2_GRUPO_VERDE, Valor.CASILLA_TIPO_SOLAR, grupo_verde);
        Casilla solar3GrupoVerde = new Casilla(Valor.SOLAR3_GRUPO_VERDE, Valor.CASILLA_TIPO_SOLAR, grupo_verde);
        Casilla solar1GrupoAzul = new Casilla(Valor.SOLAR1_GRUPO_AZUL, Valor.CASILLA_TIPO_SOLAR, grupo_azul);
        Casilla solar2GrupoAzul = new Casilla(Valor.SOLAR2_GRUPO_AZUL, Valor.CASILLA_TIPO_SOLAR, grupo_azul);
        Casilla salida = new Casilla(Valor.CASILLA_SALIDA, Valor.CASILLA_TIPO_SALIDA);
        Casilla suerte1 = new Casilla(Valor.CASILLA_SUERTE, Valor.CASILLA_TIPO_SUERTE);
        Casilla caja1 = new Casilla(Valor.CASILLA_CAJA, Valor.CASILLA_TIPO_CAJA);
        Casilla impuesto1 = new Casilla(Valor.CASILLA_IMPUESTO, Valor.CASILLA_TIPO_IMPUESTO);
        Casilla transporte1 = new Casilla(Valor.CASILLA_TRANSPORTE, Valor.CASILLA_TIPO_TRANSPORTE);
        Casilla carcel = new Casilla(Valor.CASILLA_CARCEL, Valor.CASILLA_TIPO_CARCEL);
        Casilla servicio1 = new Casilla(Valor.CASILLA_SERVICIO, Valor.CASILLA_TIPO_SERVICIO);
        Casilla transporte2 = new Casilla(Valor.CASILLA_TRANSPORTE2, Valor.CASILLA_TIPO_TRANSPORTE);
        Casilla caja2 = new Casilla(Valor.CASILLA_CAJA, Valor.CASILLA_TIPO_CAJA);
        Casilla parking = new Casilla(Valor.CASILLA_PARKING, Valor.CASILLA_TIPO_PARKING);
        Casilla suerte2 = new Casilla(Valor.CASILLA_SUERTE, Valor.CASILLA_TIPO_SUERTE);
        Casilla transporte3 = new Casilla(Valor.CASILLA_TRANSPORTE3, Valor.CASILLA_TIPO_TRANSPORTE);
        Casilla servicio2 = new Casilla(Valor.CASILLA_SERVICIO, Valor.CASILLA_TIPO_SERVICIO);
        Casilla ircarcel = new Casilla(Valor.CASILLA_IR_CARCEL, Valor.CASILLA_TIPO_IR_CARCEL);
        Casilla caja3 = new Casilla(Valor.CASILLA_CAJA, Valor.CASILLA_TIPO_CAJA);
        Casilla transporte4 = new Casilla(Valor.CASILLA_TRANSPORTE4, Valor.CASILLA_TIPO_TRANSPORTE);
        Casilla suerte3 = new Casilla(Valor.CASILLA_SUERTE, Valor.CASILLA_TIPO_SUERTE);
        Casilla impuesto2 = new Casilla(Valor.CASILLA_IMPUESTO2, Valor.CASILLA_TIPO_IMPUESTO);
        abajo.add(salida);
        abajo.add(solar1GrupoNegro);
        abajo.add(caja1);
        abajo.add(solar2GrupoNegro);
        abajo.add(impuesto1);
        abajo.add(transporte1);
        abajo.add(solar1GrupoCyan);
        abajo.add(suerte1);
        abajo.add(solar2GrupoCyan);
        abajo.add(solar3GrupoCyan);
        this.casillas.add(abajo);
        izquierda.add(carcel);
        izquierda.add(solar1GrupoRosa);
        izquierda.add(servicio1);
        izquierda.add(solar2GrupoRosa);
        izquierda.add(solar3GrupoRosa);
        izquierda.add(transporte2);
        izquierda.add(solar1GrupoNaranja);
        izquierda.add(caja2);
        izquierda.add(solar2GrupoNaranja);
        izquierda.add(solar3GrupoNaranja);
        this.casillas.add(izquierda);
        arriba.add(parking);
        arriba.add(solar1GrupoRojo);
        arriba.add(suerte2);
        arriba.add(solar2GrupoRojo);
        arriba.add(solar3GrupoRojo);
        arriba.add(transporte3);
        arriba.add(solar1GrupoAmarillo);
        arriba.add(solar2GrupoAmarillo);
        arriba.add(servicio2);
        arriba.add(solar3GrupoAmarillo);
        this.casillas.add(arriba);
        derecha.add(ircarcel);
        derecha.add(solar1GrupoVerde);
        derecha.add(solar2GrupoVerde);
        derecha.add(caja3);
        derecha.add(solar3GrupoVerde);
        derecha.add(transporte4);
        derecha.add(suerte3);
        derecha.add(solar1GrupoAzul);
        derecha.add(impuesto2);
        derecha.add(solar2GrupoAzul);
        this.casillas.add(derecha);

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

    
    //metodos
    
    /**
     * Busca una casilla del tablero por su nombre
     * @param nombre Nombre de la casila a buscar
     * @return Casilla si existe. Si no existe return null
     */
    public Casilla casillaByName(String nombre){
        if(nombre == null){
            System.out.println(Valor.ANSI_ROJO + "Nombre nulo." + Valor.ANSI_RESET);
            System.exit(1);
        }
        for(ArrayList<Casilla> n: casillas){
            for(Casilla cas: n){
                if (cas.getNombre().equals(nombre))
                    return cas;
            }
        }
            return null;      
    }

    public String imprimirBordeSuperior() {
        String cadena = Valor.ESQUINA_SUPERIOR_IZQUIERDA;
        for (int i = 0; i < Valor.TAMANHO_LINEA; i++) {
            if (i != 0 && i % Valor.TAMANHO_CASILLA == 0)
                cadena = cadena.concat(Valor.INTERSECCION_SUPERIOR);
            cadena = cadena.concat(Valor.LINEA_HORIZONTAL);
        }
        cadena = cadena.concat(Valor.ESQUINA_SUPERIOR_DERECHA);

        return cadena;
    }

    public String imprimirBordeInferior() {
        String cadena = Valor.ESQUINA_INFERIOR_IZQUIERDA;
        for (int i = 0; i < Valor.TAMANHO_LINEA; i++) {
            if (i != 0 && i % Valor.TAMANHO_CASILLA == 0)
                cadena = cadena.concat(Valor.INTERSECCION_INFERIOR);
            cadena = cadena.concat(Valor.LINEA_HORIZONTAL);
        }
        cadena = cadena.concat(Valor.ESQUINA_INFERIOR_DERECHA);

        return cadena;
    }

    public String imprimirEspacio() {
        String cadena = "";
        /*for (int i = 0; i < Valor.TAMANHO_LINEA - (Valor.TAMANHO_CASILLA  * 2) + 8 ; i++)
            cadena = cadena.concat(" ");*/
        for (int i = 0; i < (Valor.TAMANHO_CASILLA * 9) + 8; i++)
            cadena = cadena.concat(" ");

        return cadena;
    }

    public String imprimirEspacio(boolean casilla) {
        String cadena = "";
        if (casilla) {
            for (int i = 0; i < Valor.TAMANHO_CASILLA; i++)
                cadena = cadena.concat(Valor.LINEA_HORIZONTAL);
        } else {

        }

        return cadena;
    }

    public String imprimirHorizontal() {
        String cadena  = "";
        for (int i = 0; i < Valor.TAMANHO_CASILLA; i++)
            cadena = cadena.concat(Valor.LINEA_HORIZONTAL);

        return cadena;
    }

    @Override
    public String toString() {
        return this.imprimirBordeSuperior() + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(2).get(0) + Valor.LINEA_VERTICAL + this.casillas.get(2).get(1) + Valor.LINEA_VERTICAL + this.casillas.get(2).get(2) + Valor.LINEA_VERTICAL + this.casillas.get(2).get(3) + Valor.LINEA_VERTICAL + this.casillas.get(2).get(4) + Valor.LINEA_VERTICAL + this.casillas.get(2).get(5)  + Valor.LINEA_VERTICAL + this.casillas.get(2).get(6) + Valor.LINEA_VERTICAL + this.casillas.get(2).get(7) + Valor.LINEA_VERTICAL + this.casillas.get(2).get(8) + Valor.LINEA_VERTICAL + this.casillas.get(2).get(9) + Valor.LINEA_VERTICAL + this.casillas.get(3).get(0)  + Valor.LINEA_VERTICAL + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(2).get(0).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(2).get(1).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(2).get(2).stringAvatares() + Valor.LINEA_VERTICAL +  this.casillas.get(2).get(3) .stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(2).get(4).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(2).get(5).stringAvatares()  + Valor.LINEA_VERTICAL +  this.casillas.get(2).get(6).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(2).get(7).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(2).get(8).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(2).get(9).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(0).stringAvatares() + Valor.LINEA_VERTICAL + "\n" +
                Valor.INTERSECCION_IZQUIERDA + this.imprimirEspacio(true) + Valor.INTERSECCION_TOTAL + this.imprimirHorizontal() + Valor.INTERSECCION_INFERIOR + this.imprimirHorizontal() + Valor.INTERSECCION_INFERIOR +  this.imprimirHorizontal() + Valor.INTERSECCION_INFERIOR + this.imprimirHorizontal() + Valor.INTERSECCION_INFERIOR + this.imprimirHorizontal() + Valor.INTERSECCION_INFERIOR + this.imprimirHorizontal() + Valor.INTERSECCION_INFERIOR  + this.imprimirHorizontal() + Valor.INTERSECCION_INFERIOR + this.imprimirHorizontal() + Valor.INTERSECCION_INFERIOR + this.imprimirHorizontal() + Valor.INTERSECCION_TOTAL + this.imprimirHorizontal() + Valor.INTERSECCION_DERECHA + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(9) + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(1) + Valor.LINEA_VERTICAL + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(9).stringAvatares() + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL +  this.casillas.get(3).get(1).stringAvatares() + Valor.LINEA_VERTICAL + "\n" +
                Valor.INTERSECCION_IZQUIERDA + this.imprimirEspacio(true) + Valor.INTERSECCION_DERECHA + this.imprimirEspacio() +  Valor.INTERSECCION_IZQUIERDA + this.imprimirHorizontal() + Valor.INTERSECCION_DERECHA + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(8) + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(2) + Valor.LINEA_VERTICAL + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(8).stringAvatares() + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(2).stringAvatares() + Valor.LINEA_VERTICAL + "\n" +
                Valor.INTERSECCION_IZQUIERDA + this.imprimirEspacio(true) + Valor.INTERSECCION_DERECHA + this.imprimirEspacio() +  Valor.INTERSECCION_IZQUIERDA + this.imprimirHorizontal() + Valor.INTERSECCION_DERECHA + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(7) + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(3) + Valor.LINEA_VERTICAL + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(7).stringAvatares() + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(3).stringAvatares() + Valor.LINEA_VERTICAL + "\n" +
                Valor.INTERSECCION_IZQUIERDA + this.imprimirEspacio(true) + Valor.INTERSECCION_DERECHA + this.imprimirEspacio() +  Valor.INTERSECCION_IZQUIERDA + this.imprimirHorizontal() + Valor.INTERSECCION_DERECHA +  "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(6) + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(4) + Valor.LINEA_VERTICAL + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(6).stringAvatares() + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(4).stringAvatares() + Valor.LINEA_VERTICAL + "\n" +
                Valor.INTERSECCION_IZQUIERDA + this.imprimirEspacio(true) + Valor.INTERSECCION_DERECHA + this.imprimirEspacio() +  Valor.INTERSECCION_IZQUIERDA + this.imprimirHorizontal() + Valor.INTERSECCION_DERECHA +  "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(5) + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(5) + Valor.LINEA_VERTICAL + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(5).stringAvatares() + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(5).stringAvatares() + Valor.LINEA_VERTICAL + "\n" +
                Valor.INTERSECCION_IZQUIERDA + this.imprimirEspacio(true) + Valor.INTERSECCION_DERECHA + this.imprimirEspacio() +  Valor.INTERSECCION_IZQUIERDA + this.imprimirHorizontal() + Valor.INTERSECCION_DERECHA +  "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(4) + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(6) + Valor.LINEA_VERTICAL + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(4).stringAvatares() + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(6).stringAvatares() + Valor.LINEA_VERTICAL + "\n" +
                Valor.INTERSECCION_IZQUIERDA + this.imprimirEspacio(true) + Valor.INTERSECCION_DERECHA + this.imprimirEspacio() +  Valor.INTERSECCION_IZQUIERDA + this.imprimirHorizontal() + Valor.INTERSECCION_DERECHA +  "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(3) + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(7) + Valor.LINEA_VERTICAL + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(3).stringAvatares() + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(7).stringAvatares() + Valor.LINEA_VERTICAL + "\n" +
                Valor.INTERSECCION_IZQUIERDA + this.imprimirEspacio(true) + Valor.INTERSECCION_DERECHA + this.imprimirEspacio() +  Valor.INTERSECCION_IZQUIERDA + this.imprimirHorizontal() + Valor.INTERSECCION_DERECHA +  "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(2) + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(8) + Valor.LINEA_VERTICAL + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(2).stringAvatares() + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(8).stringAvatares() + Valor.LINEA_VERTICAL + "\n" +
                Valor.INTERSECCION_IZQUIERDA + this.imprimirEspacio(true) + Valor.INTERSECCION_DERECHA + this.imprimirEspacio() +  Valor.INTERSECCION_IZQUIERDA + this.imprimirHorizontal() + Valor.INTERSECCION_DERECHA +  "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(1) + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(9) + Valor.LINEA_VERTICAL + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(1).stringAvatares() + Valor.LINEA_VERTICAL + this.imprimirEspacio() + Valor.LINEA_VERTICAL + this.casillas.get(3).get(9).stringAvatares() + Valor.LINEA_VERTICAL + "\n" +
                Valor.INTERSECCION_IZQUIERDA + this.imprimirEspacio(true) + Valor.INTERSECCION_TOTAL + this.imprimirHorizontal() + Valor.INTERSECCION_SUPERIOR + this.imprimirHorizontal() + Valor.INTERSECCION_SUPERIOR +  this.imprimirHorizontal() + Valor.INTERSECCION_SUPERIOR + this.imprimirHorizontal() + Valor.INTERSECCION_SUPERIOR + this.imprimirHorizontal() + Valor.INTERSECCION_SUPERIOR + this.imprimirHorizontal() + Valor.INTERSECCION_SUPERIOR  + this.imprimirHorizontal() + Valor.INTERSECCION_SUPERIOR + this.imprimirHorizontal() + Valor.INTERSECCION_SUPERIOR + this.imprimirHorizontal() + Valor.INTERSECCION_TOTAL + this.imprimirHorizontal() + Valor.INTERSECCION_DERECHA + "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(0) + Valor.LINEA_VERTICAL + this.casillas.get(0).get(9) + Valor.LINEA_VERTICAL + this.casillas.get(0).get(8) + Valor.LINEA_VERTICAL + this.casillas.get(0).get(7) + Valor.LINEA_VERTICAL + this.casillas.get(0).get(6) + Valor.LINEA_VERTICAL + this.casillas.get(0).get(5) + Valor.LINEA_VERTICAL + this.casillas.get(0).get(4) + Valor.LINEA_VERTICAL + this.casillas.get(0).get(3) + Valor.LINEA_VERTICAL + this.casillas.get(0).get(2) + Valor.LINEA_VERTICAL + this.casillas.get(0).get(1) + Valor.LINEA_VERTICAL + this.casillas.get(0).get(0) + Valor.LINEA_VERTICAL +  "\n" +
                Valor.LINEA_VERTICAL + this.casillas.get(1).get(0).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(0).get(9).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(0).get(8).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(0).get(7).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(0).get(6).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(0).get(5).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(0).get(4).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(0).get(3).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(0).get(2).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(0).get(1).stringAvatares() + Valor.LINEA_VERTICAL + this.casillas.get(0).get(0).stringAvatares() + Valor.LINEA_VERTICAL +  "\n" +
                this.imprimirBordeInferior() + "\n";
    }
}
