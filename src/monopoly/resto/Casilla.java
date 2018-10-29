package monopoly.resto;

import monopoly.persona.*;

import java.util.HashMap;

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
            case "MARRON":
                this.valor = Valor.COSTE_GRUPO_MARRON;
                this.alquiler = Valor.ALQUILER_GRUPO_MARRON;
                break;
            case "CYAN":
                this.valor = Valor.COSTE_GRUPO_CYAN;
                this.alquiler = Valor.ALQUILER_GRUPO_CYAN;
                break;
            case "ROSA":
                this.valor = Valor.COSTE_GRUPO_ROSA;
                this.alquiler = Valor.ALQUILER_GRUPO_ROSA;
                break;
            case "NARANJA":
                this.valor = Valor.COSTE_GRUPO_NARANJA;
                this.alquiler = Valor.ALQUILER_GRUPO_NARANJA;
                break;
            case "ROJO":
                this.valor = Valor.COSTE_GRUPO_ROJO;
                this.alquiler = Valor.ALQUILER_GRUPO_ROJO;
                break;
            case "AMARILLO":
                this.valor = Valor.COSTE_GRUPO_AMARILLO;
                this.alquiler = Valor.ALQUILER_GRUPO_AMARILLO;
                break;
            case "VERDE":
                this.valor = Valor.COSTE_GRUPO_VERDE;
                this.alquiler = Valor.ALQUILER_GRUPO_VERDE;
                break;
            case "AZUL":
                this.valor = Valor.COSTE_GRUPO_AZUL;
                this.alquiler =Valor.ALQUILER_GRUPO_AZUL;
                break;
        }
        this.avatares = new HashMap<>();
        this.edificios = new HashMap<>();
    }

    @Override
    public String toString() {
        String cadena= "{\n " +
                            "\t tipo: " + this.tipo +
                            ",\n\t grupo: " + this.grupo +
                            ",\n\t propietario: " + this.propietario.getNombre() +
                            ",\n\t valor: " + this.valor +
                            ",\n\t alquiler: " + this.alquiler +
                            ",\n\t valor hotel: " +
                            ",\n\t valor casa: " +
                            ",\n\t valor piscina: " +
                            ",\n\t valor pista de deporte: " +
                            ",\n\t alquiler una casa: " +
                            ",\n\t alquiler dos casas: " +
                            ",\n\t alquiler tres casas: " +
                            ",\n\t alquiler cuatro casas: " +
                            ",\n\t alquiler hotel: " +
                            ",\n\t alquiler piscina: " +
                            ",\n\t alquiler pista de deporte: " +
                        "\n}";
        return cadena;
    }
}
