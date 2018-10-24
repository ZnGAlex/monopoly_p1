package monopoly;

import monopoly.persona.*;
import monopoly.resto.*;

public class Monopoly {

    public static void main(String[] args) {
        String nombre = "pedro";
        Jugador j = new Jugador(nombre, "Esfinge");
        System.out.println(j);
        System.out.println(j.getAvatar());
    }
    
}
