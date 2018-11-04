package monopoly.resto;

import monopoly.persona.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

public class Menu {


    Tablero tablero;
    
    public Menu() {
        Tablero tablero = new Tablero();

        HashMap<String, Avatar> avatares = new HashMap<>();

        System.out.println("Cuantos jugadores hay?");
        Scanner s = new Scanner(System.in);
        int numJugadores = s.nextInt();

        HashMap<String, Jugador> jugadores = new HashMap<>();

        if (numJugadores < 2 || numJugadores > 6) {
            System.out.println("Numero de jugadores: de 2 a 6.");
            System.exit(1);
        } else {
            for (int i = 0; i < numJugadores; i++) {
                Scanner datos = new Scanner(System.in);
                System.out.print("Introduzca el nombre del jugador: ");
                String nombre = datos.nextLine();
                System.out.print("Escoja una ficha (esfinge, coche, sombrero o pelota): ");
                String ficha = datos.nextLine();
                Jugador j = new Jugador(nombre, ficha, tablero.getCasillas().get(0).get(0));
                jugadores.put(nombre, j);
                avatares.put(nombre,j.getAvatar());
            }
        }



        boolean salir = false;

        tablero = new Tablero();

        tablero.getCasillas().get(0).get(0).setAvatares(avatares);


        System.out.println(tablero);

        salir = false;

        while (!salir) {
            System.out.print("$> ");
            Scanner scanner = new Scanner(System.in);
            String orden = scanner.nextLine();
            String[] partes = orden.split(" ");
            String comando = partes[0];

            String nombre_casilla = "";
            int n = 0;

            switch(comando) {
                case "salir":
                    if (partes.length != 1)
                        System.out.println("\nComando incorrecto.");
                    else
                        System.out.println("\nGracias por jugar.");
                    return;
                case "describir":

                    if (partes.length < 2 || partes.length > 3)
                        System.out.println("\nComando incorrecto.");
                    else {
                        switch(partes[1]){
                            case "jugador":
                                if (jugadores.get(partes[2]) == null)
                                    System.out.println("El jugador " + partes[2] + " no existe.");
                                else
                                    System.out.println(jugadores.get(partes[2]));
                                break;
                            case "avatar":
                                if(tablero.getJugadores().get(partes[2]) == null)
                                    System.out.println("El avatar " + partes[2] + " no existe.");
                                else
                                    tablero.getJugadores().get(partes[2]).toString();
                                
                                break;
                            default:
                                String unido = "";
                                for(int i=1; i< partes.length;i++){
                                    unido = unido.concat(partes[i] + "");
                                }
                                if(tablero.casillaByName(unido) == null)
                                    System.out.println("La casilla " + unido + " no existe.");
                                else
                                    tablero.casillaByName(unido).info();
                        }
                    }
                    if (partes.length == 3) {
                        if (jugadores.get(partes[2]) == null)
                            System.out.println("El jugador " + partes[2] + " no existe.");
                        else
                            System.out.println(jugadores.get(partes[2]));
                    } else  if (partes.length == 2) {
                        nombre_casilla = partes[1];
                        for (int i = 0; i < tablero.getCasillas().size(); i++) {
                            for (int j = 0; j < tablero.getCasillas().get(i).size(); j++) {
                                if (nombre_casilla.equals(tablero.getCasillas().get(i).get(j).getNombre())) {
                                    System.out.println(tablero.getCasillas().get(i).get(j).info());
                                    n++;
                                }
                            }
                        }
                        if (n == 0) {
                            System.out.println("Esa casilla no existe.");

                        }
                    }
                    break;
                default:
                    System.out.println("\nComando incorrecto.");
                    break;
            }
        }
    }
}
