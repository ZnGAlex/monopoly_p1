package monopoly.resto;

import monopoly.persona.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Casilla {
    private String nombre;
    private String tipo;
    private Grupo grupo;
    private Jugador propietario;
    private int valor;
    private int alquiler;
    private HashMap<String, Avatar> avatares;
    private HashMap<String, Edificio> edificios;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Jugador getPropietario() {
        return propietario;
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public HashMap<String, Avatar> getAvatares() {
        return avatares;
    }

    public void setAvatares(HashMap<String, Avatar> avatares) {
        this.avatares = avatares;
    }

    public HashMap<String, Edificio> getEdificios() {
        return edificios;
    }

    public void setEdificios(HashMap<String, Edificio> edificios) {
        this.edificios = edificios;
    }

    // constructores

    public Casilla (String nombre, String tipo, Grupo grupo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.grupo = grupo;
        this.propietario = null;
        switch (grupo.getColor()) {
            case Valor.GRUPO_NEGRO:
                this.valor = Valor.COSTE_GRUPO_NEGRO;
                this.alquiler = Valor.ALQUILER_GRUPO_NEGRO;
                break;
            case Valor.GRUPO_CYAN:
                this.valor = Valor.COSTE_GRUPO_CYAN;
                this.alquiler = Valor.ALQUILER_GRUPO_CYAN;
                break;
            case Valor.GRUPO_ROSA:
                this.valor = Valor.COSTE_GRUPO_ROSA;
                this.alquiler = Valor.ALQUILER_GRUPO_ROSA;
                break;
            case Valor.GRUPO_NARANJA:
                this.valor = Valor.COSTE_GRUPO_NARANJA;
                this.alquiler = Valor.ALQUILER_GRUPO_NARANJA;
                break;
            case Valor.GRUPO_ROJO:
                this.valor = Valor.COSTE_GRUPO_ROJO;
                this.alquiler = Valor.ALQUILER_GRUPO_ROJO;
                break;
            case Valor.GRUPO_AMARILLO:
                this.valor = Valor.COSTE_GRUPO_AMARILLO;
                this.alquiler = Valor.ALQUILER_GRUPO_AMARILLO;
                break;
            case Valor.GRUPO_VERDE:
                this.valor = Valor.COSTE_GRUPO_VERDE;
                this.alquiler = Valor.ALQUILER_GRUPO_VERDE;
                break;
            case Valor.GRUPO_AZUL:
                this.valor = Valor.COSTE_GRUPO_AZUL;
                this.alquiler =Valor.ALQUILER_GRUPO_AZUL;
                break;
        }
        this.avatares = new HashMap<>();
        this.edificios = new HashMap<>();
    }
    
    public Casilla (String nombre, String tipo){
        if (nombre == null) {
            System.out.println(Valor.ANSI_ROJO + "Nombre nulo." + Valor.ANSI_RESET);
            System.exit(1);
        }
        if (tipo == null) {
            System.out.println(Valor.ANSI_ROJO + "Tipo nulo." + Valor.ANSI_RESET);
            System.exit(1);
        }
        this.nombre = nombre;
        this.tipo = tipo;
        this.grupo = null;
        this.alquiler = 0;
        this.propietario = null;
        this.valor = 0;
        this.avatares = new HashMap<>();
        this.edificios = null;
    }

    public String info() {
        String cadena = "{\n " +
                "\t tipo: " + this.tipo +
                ",\n\t grupo: " + this.grupo +
                ",\n\t propietario: " +
                ",\n\t valor: " + this.valor +
                ",\n\t alquiler actual: " + this.alquiler +
                ",\n\t alquiler inicial: " + this.valor * 0.9 +
                ",\n\t valor hotel: " + this.valor * 0.6 + " (mas cuatro casas)" +
                ",\n\t valor casa: " + this.valor * 0.6 +
                ",\n\t valor piscina: " + this.valor * 0.4 +
                ",\n\t valor pista de deporte: " + this.valor * 1.25 +
                ",\n\t alquiler una casa: " + this.valor * 0.9 * 5 +
                ",\n\t alquiler dos casas: " + this.valor * 0.9 * 15 +
                ",\n\t alquiler tres casas: " + this.valor * 0.9 * 35 +
                ",\n\t alquiler cuatro casas: " + this.valor * 0.9 * 50 +
                ",\n\t alquiler hotel: " + this.valor * 0.9 * 70 +
                ",\n\t alquiler piscina: " + this.valor * 25 +
                ",\n\t alquiler pista de deporte: " + this.valor * 25 +
                "\n}";
        return cadena;
    }

    public String stringAvatares() {
        String cadena_avatares = "";
        String cadena = "";
        if (this.avatares.size() != 0) {
            Iterator avatares_it = this.avatares.values().iterator();
            while (avatares_it.hasNext()) {
                Avatar a = (Avatar) avatares_it.next();
                cadena_avatares = cadena_avatares.concat("&" + a.getId());
            }
        }
        cadena = cadena.concat(cadena_avatares);
        int t = Valor.TAMANHO_CASILLA - cadena_avatares.length();
        for (int i = 0; i < t; i++)
            cadena = cadena.concat(" ");

        return cadena;
    }

    public String printNombreColor() {
        String nombre = "";
        int t;
        if (this.nombre.length() < Valor.TAMANHO_CASILLA) {
            t = Valor.TAMANHO_CASILLA - this.nombre.length();
            if (t%2 == 0) {
                for (int i = 0; i < t / 2; i++)
                    nombre = nombre.concat(" ");
                if (this.grupo != null)
                    nombre = nombre.concat(this.grupo.obtenerColorPrint() + this.nombre + Valor.ANSI_RESET);
                else
                    nombre = nombre.concat(this.nombre);
                for (int i = 0; i < t / 2; i++)
                    nombre = nombre.concat(" ");
            } else {
                for (int i = 0; i < (t / 2) + 1; i++)
                    nombre = nombre.concat(" ");
                if (this.grupo != null)
                    nombre = nombre.concat(this.grupo.obtenerColorPrint() + this.nombre + Valor.ANSI_RESET);
                else
                    nombre = nombre.concat(this.nombre);
                for (int i = 0; i < t / 2; i++)
                    nombre = nombre.concat(" ");
            }
        } else
            nombre = this.grupo.obtenerColorPrint() + this.nombre + Valor.ANSI_RESET;
        return nombre;
    }

    @Override
    public String toString() {
       String cadena = this.printNombreColor();

       return cadena;
    }
}
