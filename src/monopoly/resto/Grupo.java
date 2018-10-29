package monopoly.resto;

import java.util.ArrayList;

public class Grupo {
    private String color;
    private ArrayList<Edificio> edificios;
    private ArrayList<Casilla> casillas;
    private int alquiler;
    private int precio;

    public Grupo(String color, int precio, int alquiler) {
        this.color = color;
        this.edificios = new ArrayList<>();
        this.casillas = new ArrayList<>();
        this.precio = precio;
        this.alquiler = alquiler;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Edificio> getEdificios() {
        return edificios;
    }

    public void setEdificios(ArrayList<Edificio> edificios) {
        this.edificios = edificios;
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public int getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
