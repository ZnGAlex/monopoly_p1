package monopoly.resto;

import java.util.ArrayList;

import monopoly.persona.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

public class Menu {

    public Menu() {
        Tablero tablero = new Tablero();
        HashMap<String, Avatar> avatares = new HashMap<>();
        HashMap<String, Jugador> jugadores = new HashMap<>();
        ArrayList<Jugador> jgdrs = new ArrayList<>();
        boolean lanzoDados = false;

        System.out.println("Cuantos jugadores hay?");
        Scanner s = new Scanner(System.in);
        int numJugadores = s.nextInt();

        if (numJugadores < 2 || numJugadores > 6) {  /*CREACION DE LOS JUGADORES*/
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
                avatares.put(j.getAvatar().getId(), j.getAvatar());
                jgdrs.add(j);
            }
        }
        Turno turno = new Turno(jgdrs);
        tablero.getCasillas().get(0).get(0).setAvatares(avatares);

        while (true) {
            System.out.print("$> ");
            Scanner scanner = new Scanner(System.in);
            String orden = scanner.nextLine();
            String[] partes = orden.split(" ");
            String comando = partes[0];


            switch (comando) {
                case "salir": /*SALIR DEL PROGRAMA*/
                    if (partes.length == 1) {
                        System.out.println("\nGracias por jugar.");
                        return;
                    } else if (!partes[1].equals("carcel")) {
                        turno.turnoActual().salirCarcel();
                    }
                case "describir": /*DESCRIBIR JUGADOR/AVATAR/CASILLA*/
                    if (partes.length > 3)
                        System.out.println("\nComando incorrecto.");
                    else {
                        switch (partes[1]) {
                            case "jugador":
                                if (partes.length < 3) {
                                    System.out.println("Indique el nombre del jugador.");
                                    break;
                                }
                                if (jugadores.get(partes[2]) == null)
                                    System.out.println("El jugador " + partes[2] + " no existe.");
                                else
                                    System.out.println(jugadores.get(partes[2]));
                                break;
                            case "avatar":
                                if (partes.length < 3) {
                                    System.out.println("Indique el nombre del avatar.");
                                    break;
                                }
                                if (jugadores.get(partes[2]) == null)
                                    System.out.println("El avatar " + partes[2] + " no existe.");
                                else
                                    System.out.println(jugadores.get(partes[2]).getAvatar());
                                break;
                            default:
                                if (tablero.casillaByName(partes[1]) == null)
                                    System.out.println("La casilla " + partes[1] + " no existe.");
                                else {
                                    System.out.println(tablero.casillaByName(partes[1]).info());
                                }
                                break;
                        }
                    }
                    break;
                case "jugador": /*MOSTRAR TURNO ACTUAL*/
                    System.out.println("\t nombre: " + turno.turnoActual().getNombre());
                    System.out.println("\t avatar: " + turno.turnoActual().getAvatar().getId());
                    break;
                case "lanzar": /*LANZAR LOS DADOS*/
                    if (!partes[1].equals("dados"))
                        System.out.println("\nComando incorrecto.");
                    else {
                        turno.turnoActual().tirarDadosJugador(tablero);
                        lanzoDados = true;
                    }
                    break;
                case "acabar":
                    if (!partes[1].equals("turno"))
                        System.out.println("Comando incorrecto.");
                    else if (lanzoDados) {
                        turno.siguienteTurno();
                        System.out.println("Turno de " + turno.turnoActual());
                    }
                    else{
                        System.out.println("Debes lanzar los dados antes de acabar tu turno");
                    }
                    break;
                case "ver":
                    if (!partes[1].equals("tablero"))
                        System.out.println("Comando incorrecto.");
                    else System.out.println(tablero);
                    break;
                default:
                    System.out.println("\nComando incorrecto.");
                    break;
            }
        }
    }
}