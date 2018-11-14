package monopoly.persona;

import monopoly.resto.*;

import java.util.HashMap;
import java.util.Iterator;

public class Jugador {
    private String nombre;
    private Avatar avatar;
    private int fortuna;
    private HashMap<String, Casilla> propiedades;
    private HashMap<String, Casilla> hipotecas;
    private HashMap<String, Edificio> edificios;
    private int inCarcel;

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
    public Jugador(String nombre, String ficha, Casilla casilla) {
        if (nombre == null) {
            System.out.println(Valor.ANSI_ROJO + "Nombre nulo." + Valor.ANSI_RESET);
            System.exit(1);
        }
        if (ficha == null) {
            System.out.println(Valor.ANSI_ROJO + "Ficha nula." + Valor.ANSI_RESET);
            System.exit(1);
        }
        if (ficha.equalsIgnoreCase("Esfinge") || ficha.equalsIgnoreCase("Coche") || ficha.equalsIgnoreCase("Sombrero") || ficha.equalsIgnoreCase("Pelota"))
            this.avatar = new Avatar(this, ficha, casilla);
        else {
            System.out.println(Valor.ANSI_ROJO + "Ficha debe ser: Esfinge, Coche, Sombrero o Pelota");
            System.exit(1);
        }
        this.nombre = nombre;
        this.fortuna = Valor.FORTUNA_INICIAL;
        this.propiedades = new HashMap<>();
        this.hipotecas = new HashMap<>();
        this.edificios = new HashMap<>();
        this.inCarcel = 0;
    }

    public Jugador(String nombre) {
        if (nombre == null) {
            System.out.println(Valor.ANSI_ROJO + "Nombre nulo." + Valor.ANSI_RESET);
            System.exit(1);
        }
        this.nombre = nombre;
        this.fortuna = Valor.FORTUNA_BANCA;
        this.propiedades = new HashMap<>();
        this.hipotecas = new HashMap<>();
        this.edificios = new HashMap<>();
        this.avatar = null;
        this.inCarcel = 0;
    }


    // Metodos

    public String obtenerPropiedades() {
        String cadena = "";

        if (this.propiedades.size() == 0)
            cadena = "no tiene propiedades";
        else {
            Iterator propiedades_i = this.propiedades.values().iterator();
            while (propiedades_i.hasNext()) {
                Casilla propiedad = (Casilla) propiedades_i.next();
                cadena = cadena.concat(propiedad.getNombre() + " ");
            }
        }

        return cadena;
    }

    public String obtenerHipotecas() {
        String cadena = "";

        if (this.hipotecas.size() == 0)
            cadena = "no tiene hipotecas";
        else {
            Iterator hipotecas_i = this.hipotecas.values().iterator();
            while (hipotecas_i.hasNext()) {
                Casilla hipoteca = (Casilla) hipotecas_i.next();
                cadena = cadena.concat(hipoteca.getNombre() + " ");
            }
        }

        return cadena;
    }

    public String obtenerEdificios() {
        String cadena = "";

        if (this.edificios.size() == 0)
            cadena = "no tiene edificios";
        else {
            Iterator edificios_i = this.edificios.values().iterator();
            while (edificios_i.hasNext()) {
                Casilla edificio = (Casilla) edificios_i.next();
                cadena = cadena.concat(edificio.getNombre() + " ");
            }
        }
        return cadena;
    }
    
    public boolean tirarDadosJugador(Tablero tablero){
        Dado dados = new Dado();
        int desplazamiento = 0;
       
        desplazamiento = dados.tirarDados();
        System.out.println(this.nombre + " se desplaza " + desplazamiento + " posiciones");
        avatar.moverAvatar(desplazamiento, tablero);
        
        return dados.dadosIguales();
    }
    
    public void encarcelarJugador(Tablero tablero){
        this.avatar.moverAvatarCasilla(tablero.casillaByName("Carcel"));
        this.inCarcel = 1;
    }
    
    public void salirCarcel(){
        System.out.println(nombre + " paga " + Valor.COSTE_SALIR_CARCEL +  " y sale de la cárcel. Puede lanzar los dados.");
    }
    
    public void pagarImpuesto(int impuesto){
        if(impuesto > this.fortuna){
            
        }
        else{
            this.fortuna -= impuesto;
            Valor.DINERO_PARKING += impuesto;
        }
    }
    
    public void cobrarParking(){
        this.fortuna+=Valor.DINERO_PARKING;
        Valor.DINERO_PARKING = 0;
    }
    
    public void pagarAlquiler(){
        if(!this.avatar.getCasilla().getPropietario().getNombre().equals("banca")){
            if(this.avatar.getCasilla().getAlquiler()>this.fortuna){
                
            }
            else{
                this.fortuna-=this.avatar.getCasilla().getAlquiler();
                this.avatar.getCasilla().getPropietario().cobrarAlquiler(this.avatar.getCasilla().getAlquiler());
            }
        }
    }
    
    public void cobrarAlquiler(int dinero){
        this.fortuna += dinero;
    }
   

    public void comprarCasilla() {
        Casilla c = this.avatar.getCasilla();
        if(!c.getPropietario().getNombre().equals("banca") || c.getValor() == 0){
            System.out.println("La casilla no se puede comprar");
        }
        else if(this.fortuna > c.getValor()){
            this.fortuna = fortuna - c.getValor();
            this.propiedades.put(c.getNombre(), c);
            c.setPropietario(this);
            System.out.println("El jugador " + this.nombre + " compra la casilla " + c.getNombre() + " por " + c.getValor() + "€");
            System.out.println("Su fortuna actual es " + this.fortuna + "€");
        }
        
        else{
            System.out.println("No tienes suficiente dinero");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o instanceof Jugador))
            return true;
        if (getClass() != o.getClass())
            return false;
        final Jugador jugador = (Jugador) o;
        if (this.nombre.equals(jugador.nombre) && this.avatar.equals(jugador.avatar))
            return true;

        return true;
    }

    @Override
    public String toString() {
        String cadena = "{\n" +
                            "\t nombre: " + this.nombre +
                            ",\n\t avatar: " + this.avatar.getId() +
                            ",\n\t fortuna: " + this.fortuna +
                            ",\n\t propiedades: [" + this.obtenerPropiedades() +
                            "]\n\t hipotecas: [" + this.obtenerHipotecas() +
                            "]\n\t edificios: [" + this.obtenerEdificios() + "]\n}";
        return cadena;
    }

}
