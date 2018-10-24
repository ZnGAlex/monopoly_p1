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
                this.valor = Valor.COSTE_GRUPO1;
                this.alquiler = Valor.ALQUILER_GRUPO1;
                break;
            case "CYAN":
                this.valor = Valor.COSTE_GRUPO2;
                this.alquiler = Valor.ALQUILER_GRUPO2;
                break;
            case "ROSA":
                this.valor = Valor.COSTE_GRUPO3;
                this.alquiler = Valor.ALQUILER_GRUPO3;
                break;
            case "NARANJA":
                this.valor = Valor.COSTE_GRUPO4;
                this.alquiler = Valor.ALQUILER_GRUPO4;
                break;
            case "ROJO":
                this.valor = Valor.COSTE_GRUPO5;
                this.alquiler = Valor.ALQUILER_GRUPO5;
                break;
            case "AMARILLO":
                this.valor = Valor.COSTE_GRUPO6;
                this.alquiler = Valor.ALQUILER_GRUPO6;
                break;
            case "VERDE":
                this.valor = Valor.COSTE_GRUPO7;
                this.alquiler = Valor.ALQUILER_GRUPO7;
                break;
            case "AZUL":
                this.valor = Valor.COSTE_GRUPO8;
                this.alquiler =Valor.ALQUILER_GRUPO8;
                break;
        }
    }

    @Override
    public String toString() {
        String cadena= "{\n " +
                            "\t tipo: " + this.tipo +
                            ",\n\t grupo: " + this.grupo +
                            ",\n\t propietario: " + this.propietario.getNombre() +
                            ",\n\t valor: " + this.valor +
                            ",\n\t alquiler: " + this.alquiler +
                            ",\n\t ... por hacer ...";
        return cadena;
    }
}
