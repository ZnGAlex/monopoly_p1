package monopoly.resto;

import java.util.*;

import monopoly.persona.*;

public class Menu {

    public Menu() {
        Tablero tablero = new Tablero();
        HashMap<String, Avatar> avatares = new HashMap<>();
        HashMap<String, Jugador> jugadores = new HashMap<>();
        ArrayList<Jugador> jgdrs = new ArrayList<>();
        boolean iniciarJuego = false;
        
        do{
            System.out.println(tablero);
            System.out.print("$> ");
            Scanner scanner = new Scanner(System.in);
            String orden = scanner.nextLine();
            String[] partes = orden.split(" ");
            String comando = partes[0];    
            
            switch(comando){
                case "crear":
                    if(!partes[1].equals("jugador") || partes.length != 4){
                        System.out.println("Comando incorrecto.");
                    }
                    else{
                        Character id;
                        boolean seRepite;
                        do {
                            seRepite = false;
                            id = (char) Math.ceil(Math.random() * 255);
                            Iterator it= avatares.values().iterator();
                            while (it.hasNext()) {
                                Avatar av = (Avatar) it.next();
                                if (av.getId().equals(id.toString()))
                                    seRepite = true;
                            }
                        } while (id < 48 || (id > 57 && id < 65) || (id > 90 && id < 97) || id > 122 || seRepite);
                        Jugador j = new Jugador(partes[2], partes[3], tablero.getCasillas().get(0).get(0), id.toString());
                        jugadores.put(partes[2], j);
                        avatares.put(j.getAvatar().getId(), j.getAvatar());
                        jgdrs.add(j);
                        tablero.getCasillas().get(0).get(0).setAvatares(avatares);
                        if(jgdrs.size() == 6)
                            iniciarJuego = true;
                    }
                    break;
                case "iniciar":
                    if (partes.length != 2)
                        System.out.println("Comando incorrecto. Inicie con iniciar juego");
                    if(!partes[1].equals("juego")){
                        System.out.println("Comando incorrecto.");
                    }
                    else if(jgdrs.size() < 2){
                        System.out.println("Jugadores insuficientes.");
                    }
                    else{
                        iniciarJuego = true;
                    }
            }
        }while(!iniciarJuego);

        Turno turno = new Turno(jgdrs);
        tablero.getCasillas().get(0).get(0).setAvatares(avatares);

        System.out.println(tablero);

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
                                if (!avatares.containsKey(partes[2]))
                                    System.out.println("El avatar " + partes[2] + " no existe.");
                                else
                                    System.out.println(avatares.get(partes[2]));
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
                    else if (turno.turnoActual().getDadosTirados()) {
                        System.out.println("El jugador " + turno.turnoActual().getNombre() + " ya ha lanzado los dados.");
                    }  else {
                        turno.turnoActual().tirarDadosJugador(tablero);
                    }
                    System.out.println(tablero);
                    break;
                case "acabar":
                    if (!partes[1].equals("turno"))
                        System.out.println("Comando incorrecto.");
                    else if (turno.turnoActual().getDadosTirados()) {
                        turno.siguienteTurno();
                        System.out.println("Turno de " + turno.turnoActual().getNombre());
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
                case "listar":
                    switch(partes[1]){
                        case "jugadores":
                            for(Jugador jugador: jgdrs){
                                System.out.println(jugador);
                            }
                            break;
                        case "avatares":
                            for(Avatar avatar: avatares.values()){
                                System.out.println(avatar);
                            }
                            break;
                        case "enventa":
                            System.out.println(tablero);
                            for(Casilla casilla: tablero.casillasEnVenta()){
                               System.out.println(casilla.shortInfo());
                            }
                            break;
                        default:
                            System.out.println("Comando incorrecto.");
                    }
                    break;
                case "comprar":
                    if (partes.length > 2) {
                        System.out.println("Comando incorrecto.");
                    } else {
                        if (turno.turnoActual().getAvatar().getCasilla().getNombre().equals(partes[1])) {
                            for (ArrayList<Casilla> lado : tablero.getCasillas()) {
                                for (Casilla casilla : lado) {
                                    if (casilla.getNombre().equals(partes[1])) {
                                        if (casilla.getValor() == 0)
                                            System.out.println("La casilla " + casilla.getNombre() + " no se puede comprar.");
                                        else if (casilla.getValor() > turno.turnoActual().getFortuna())
                                            System.out.println("El jugador no dispone de dinero suficiente.");
                                        else {
                                            turno.turnoActual().comprarCasilla(casilla);
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("El jugador no esta en la casilla.");
                        }
                            else
                                System.out.println("No estas en " + partes[1]);
                                
                    }
                    break;
                default:
                    System.out.println("\nComando incorrecto.");
                    break;
            }
        }
    }
}