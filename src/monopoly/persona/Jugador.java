package monopoly.persona;

import monopoly.resto.*;

import java.util.HashMap;

public class Jugador {
    private String nombre;
    private Avatar avatar;
    private int fortuna;
    private HashMap<String, Casilla> propiedades;
    private HashMap<String, Casilla> hipotecas;
    private HashMap<String, Edificio> edificios;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public int getFortuna() {
        return fortuna;
    }

    public void setFortuna(int fortuna) {
        this.fortuna = fortuna;
    }

    public HashMap<String, Casilla> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(HashMap<String, Casilla> propiedades) {
        this.propiedades = propiedades;
    }

    public HashMap<String, Casilla> getHipotecas() {
        return hipotecas;
    }

    public void setHipotecas(HashMap<String, Casilla> hipotecas) {
        this.hipotecas = hipotecas;
    }

    public HashMap<String, Edificio> getEdificios() {
        return edificios;
    }

    public void setEdificios(HashMap<String, Edificio> edificios) {
        this.edificios = edificios;
    }

    // setter y getter

    // constructores
    public Jugador(String nombre, String ficha) {
        if (nombre == null) {
            System.out.println((char)27 + "[31m" + "Nombre nulo.");
            System.exit(-1);
        }
        if (ficha == null) {
            System.out.println((char)27 + "[31m" + "Ficha nula.");
            System.exit(-1);
        }
        if (ficha.equals("Esfinge") || ficha.equals("Coche") || ficha.equals("Sombrero") || ficha.equals("Pelota"))
            this.avatar = new Avatar(this, ficha);
        else
            throw new IllegalArgumentException("Ficha debe ser: Esfinge, Coche, Sombrero o Pelota");
        this.nombre = nombre;
        System.out.println(this.avatar);
    }

}
