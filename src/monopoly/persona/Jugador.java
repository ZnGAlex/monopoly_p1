package monopoly.persona;

import monopoly.resto.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Jugador {
    private String nombre;
    private Avatar avatar;
    private int fortuna;
    private HashMap<String, Casilla> propiedades;
    private HashMap<String, Casilla> hipotecas;
    private HashMap<String, Edificio> edificios;
    private boolean inCarcel;
    private boolean dadosTirados;
    private int dadosDobles;
    private int turnosEnCarcel;
    private boolean bancarrota;

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
    public Jugador(String nombre, String ficha, Casilla casilla, String id) {
        if (nombre == null) {
            System.out.println(Valor.ANSI_ROJO + "Nombre nulo." + Valor.ANSI_RESET);
            System.exit(1);
        }
        if (ficha == null) {
            System.out.println(Valor.ANSI_ROJO + "Ficha nula." + Valor.ANSI_RESET);
            System.exit(1);
        }
        if (ficha.equalsIgnoreCase("Esfinge") || ficha.equalsIgnoreCase("Coche") || ficha.equalsIgnoreCase("Sombrero") || ficha.equalsIgnoreCase("Pelota"))
            this.avatar = new Avatar(this, ficha, casilla, id);
        else {
            System.out.println(Valor.ANSI_ROJO + "Ficha debe ser: Esfinge, Coche, Sombrero o Pelota");
            System.exit(1);
        }
        this.nombre = nombre;
        this.fortuna = Valor.FORTUNA_INICIAL;
        this.propiedades = new HashMap<>();
        this.hipotecas = new HashMap<>();
        this.edificios = new HashMap<>();
        this.inCarcel = false;
        this.dadosTirados = false;
        this.dadosDobles = 0;
        this.turnosEnCarcel = 0;
        bancarrota = false;
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
        this.inCarcel = false;
        this.dadosTirados = false;
        this.dadosDobles = 0;
        this.turnosEnCarcel = 0;
        bancarrota = false;
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
    
    public void tirarDadosJugador(Tablero tablero){
        Dado dados = new Dado();
        int desplazamiento = 0;
       
        desplazamiento = dados.tirarDados();
        this.dadosTirados = true;

        if (this.inCarcel)
            this.turnosEnCarcel++;
        if (this.inCarcel && this.turnosEnCarcel == 3)
            System.out.println("El jugador ha tirado tres veces en la carcel. Tiene que pagar para salir.");
        else if (this.inCarcel && this.turnosEnCarcel != 3) {
            if (dados.dadosIguales()) {
                System.out.println("El jugador ha sacado dados dobles. Sale de la carcel.");
                this.avatar.moverAvatar(desplazamiento, tablero);
            } else {
                System.out.println("El jugador no ha sacado dados dobles. Permanece en la carcel.");
            }
        } else {
            if (dados.dadosIguales()) {
                System.out.println("Dados dobles.");
                this.setDadosDobles(this.getDadosDobles() + 1);
            }
            if (this.getDadosDobles() == 3) {
                System.out.println("El jugador " + this.nombre + " ha sacado dados dobles tres veces. Va a la carcel.");
                this.avatar.moverAvatarCasilla(tablero.getCasillas().get(Valor.POSICION_CASILLA_CARCEL / 10).get(Valor.POSICION_CASILLA_CARCEL % 10));
            } else {
                System.out.println(this.nombre + " se desplaza " + desplazamiento + " posiciones");
                avatar.moverAvatar(desplazamiento, tablero);
            }
        }
    }
    
    public void encarcelarJugador(Tablero tablero){
        this.avatar.moverAvatarCasilla(tablero.casillaByName("Carcel"));
        this.inCarcel = true;
    }
    
    public void salirCarcel(){
        if(this.inCarcel = true){
            if(Valor.COSTE_SALIR_CARCEL > this.fortuna){
                System.out.println("No tienes suficiente dinero");
            }
            else{
                System.out.println(nombre + " paga " + Valor.COSTE_SALIR_CARCEL +  " y sale de la cárcel. Puede lanzar los dados.");
                this.fortuna -= Valor.COSTE_SALIR_CARCEL;
                this.inCarcel = false;
            }
        }
            
        
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
        if(!this.avatar.getCasilla().getPropietario().equals(this)){
            if(!this.avatar.getCasilla().getPropietario().getNombre().equals("banca")){
                if(this.avatar.getCasilla().getAlquiler()>this.fortuna){
                    System.out.println("No tienes suficiente dinero, quieres hipotecar o declararte en bancarrota");
                }
                else{
                    this.fortuna-=this.avatar.getCasilla().getAlquiler();
                    this.avatar.getCasilla().getPropietario().cobrarAlquiler(this.avatar.getCasilla().getAlquiler());
                }
            }
        }
    }
    
                
    public void hipotecar(){
        boolean flag = true;
        do{
            System.out.println(this.propiedades);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Propiedar a hipotecar: ");
            String prop = scanner.nextLine();

            if(this.propiedades.containsKey(prop)){
                this.hipotecas.put(prop,this.propiedades.get(prop));
                this.propiedades.remove(prop);
                flag = false;
            }
            else{
                System.out.println("No tienes esa propiedad");
            }
        }while(flag);
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

    public boolean getInCarcel() {
        return inCarcel;
    }

    public void setInCarcel(boolean inCarcel) {
        this.inCarcel = inCarcel;
    }

    public boolean getDadosTirados() {
        return dadosTirados;
    }

    public void setDadosTirados(boolean dadosTirados) {
        this.dadosTirados = dadosTirados;
    }

    public int getDadosDobles() {
        return dadosDobles;
    }

    public void setDadosDobles(int dadosDobles) {
        this.dadosDobles = dadosDobles;
    }
}
