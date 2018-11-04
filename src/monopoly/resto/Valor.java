package monopoly.resto;

import java.util.ArrayList;

public class Valor {
    public static final int COSTE_INICIAL = 100000;
    public static final int COSTE_GRUPO_NEGRO = COSTE_INICIAL;
    public static final int ALQUILER_GRUPO_NEGRO = COSTE_INICIAL / 2;
    public static final int COSTE_GRUPO_CYAN = (int) (COSTE_GRUPO_NEGRO * 1.3);
    public static final int ALQUILER_GRUPO_CYAN = COSTE_GRUPO_CYAN / 2;
    public static final int COSTE_GRUPO_ROSA = (int) (COSTE_GRUPO_CYAN * 1.3);
    public static final int ALQUILER_GRUPO_ROSA = COSTE_GRUPO_ROSA / 2;
    public static final int COSTE_GRUPO_NARANJA = (int) (COSTE_GRUPO_ROSA * 1.3);
    public static final int ALQUILER_GRUPO_NARANJA = COSTE_GRUPO_NARANJA / 2;
    public static final int COSTE_GRUPO_ROJO = (int) (COSTE_GRUPO_NARANJA * 1.3);
    public static final int ALQUILER_GRUPO_ROJO = COSTE_GRUPO_ROJO / 2;
    public static final int COSTE_GRUPO_AMARILLO = (int) (COSTE_GRUPO_ROJO * 1.3);
    public static final int ALQUILER_GRUPO_AMARILLO = COSTE_GRUPO_AMARILLO / 2;
    public static final int COSTE_GRUPO_VERDE = (int) (COSTE_GRUPO_AMARILLO * 1.3);
    public static final int ALQUILER_GRUPO_VERDE = COSTE_GRUPO_VERDE / 2;
    public static final int COSTE_GRUPO_AZUL = (int) (COSTE_GRUPO_VERDE * 1.3);
    public static final int ALQUILER_GRUPO_AZUL = COSTE_GRUPO_AZUL / 2;
    public static final int FORTUNA_INICIAL = 500000; // temporal
    public static final int CANTIDAD_PASAR_SALIDA = ((COSTE_GRUPO_NEGRO + COSTE_GRUPO_AZUL)*2 + (COSTE_GRUPO_CYAN + COSTE_GRUPO_ROSA + COSTE_GRUPO_NARANJA + COSTE_GRUPO_ROJO + COSTE_GRUPO_AMARILLO + COSTE_GRUPO_VERDE)*3)/22;
    public static final int COSTE_SALIR_CARCEL = (int)(CANTIDAD_PASAR_SALIDA * 0.25);
    public static final String GRUPO_NEGRO = "Negro";
    public static final String GRUPO_CYAN = "Cyan";
    public static final String GRUPO_ROSA = "Rosa";
    public static final String GRUPO_NARANJA = "Naranja";
    public static final String GRUPO_ROJO = "Rojo";
    public static final String GRUPO_AMARILLO = "Amarillo";
    public static final String GRUPO_VERDE = "Verde";
    public static final String GRUPO_AZUL = "Azul";
    public static final String ANSI_RESET = "\u001b[0m";
    public static final String ANSI_CLS = "\u001b[2J";
    public static final String ANSI_BOLD = "\u001b[1m";
    public static final String ANSI_NEGRO = "\u001b[30m";
    public static final String ANSI_DARK_GREY = "\u001b[90m";
    public static final String ANSI_ROJO = "\u001b[31m";
    public static final String ANSI_RED_BRIGHT = "\u001b[91m";
    public static final String ANSI_VERDE = "\u001b[32m";
    public static final String ANSI_GREEN_BRIGHT = "\u001b[92m";
    public static final String ANSI_NARANJA = "\u001b[33m";
    public static final String ANSI_AMARILLO = "\u001b[93m";
    public static final String ANSI_AZUL = "\u001b[34m";
    public static final String ANSI_BLUE_BRIGHT = "\u001b[94m";
    public static final String ANSI_ROSA = "\u001b[35m";
    public static final String ANSI_MAGENTA_BRIGHT = "\u001b[95m";
    public static final String ANSI_CYAN = "\u001b[36m";
    public static final String ANSI_CYAN_BRIGHT = "\u001b[96m";
    public static final String ANSI_GRIS = "\u001b[37m";
    public static final String ANSI_BLANCO = "\u001b[97m";
    public static final String SOLAR1_GRUPO_NEGRO = "Orgrimmar";
    public static final String SOLAR2_GRUPO_NEGRO = "Ventormenta";
    public static final String SOLAR1_GRUPO_CYAN = "Lunargenta";
    public static final String SOLAR2_GRUPO_CYAN = "Entrañas";
    public static final String SOLAR3_GRUPO_CYAN = "CimadelTrueno";
    public static final String SOLAR1_GRUPO_ROSA = "Forjaz";
    public static final String SOLAR2_GRUPO_ROSA = "Darnassus";
    public static final String SOLAR3_GRUPO_ROSA = "Exodar";
    public static final String SOLAR1_GRUPO_NARANJA = "Dalaran";
    public static final String SOLAR2_GRUPO_NARANJA = "BosqueCancionEterna";
    public static final String SOLAR3_GRUPO_NARANJA = "BosquedeElwynn";
    public static final String SOLAR1_GRUPO_ROJO = "ClarosdeTirisfal";
    public static final String SOLAR2_GRUPO_ROJO = "Durotar";
    public static final String SOLAR3_GRUPO_ROJO = "Vallefresno";
    public static final String SOLAR1_GRUPO_AMARILLO = "LaderasdeTrabalomas";
    public static final String SOLAR2_GRUPO_AMARILLO = "MontañasdeAlterac";
    public static final String SOLAR3_GRUPO_AMARILLO = "TierrasAltasdeArathi";
    public static final String SOLAR1_GRUPO_VERDE = "Frondavil";
    public static final String SOLAR2_GRUPO_VERDE = "CostaOscura";
    public static final String SOLAR3_GRUPO_VERDE = "LosBaldios";
    public static final String SOLAR1_GRUPO_AZUL = "CraterdeUn'Goro";
    public static final String SOLAR2_GRUPO_AZUL = "CoronadeHielo";
    public static final String CASILLA_TIPO_SOLAR = "solar";
    public static final String CASILLA_SALIDA = "Salida";
    public static final String CASILLA_IMPUESTO = "Impuesto1";
    public static final String CASILLA_IMPUESTO2 = "Impuesto2";
    public static final String CASILLA_TRANSPORTE = "Transporte1";
    public static final String CASILLA_TRANSPORTE2 = "Transporte2";
    public static final String CASILLA_TRANSPORTE3 = "Transporte3";
    public static final String CASILLA_TRANSPORTE4 = "Transporte4";
    public static final String CASILLA_SUERTE = "Suerte";
    public static final String CASILLA_CAJA = "Caja";
    public static final String CASILLA_CARCEL = "Carcel";
    public static final String CASILLA_SERVICIO = "Servicio";
    public static final String CASILLA_IR_CARCEL = "Ir a carcel";
    public static final String CASILLA_PARKING = "Parking";
    public static final String CASILLA_TIPO_TRANSPORTE = "transporte";
    public static final String CASILLA_TIPO_SERVICIO = "servicio";
    public static final String CASILLA_TIPO_SUERTE = "suerte";
    public static final String CASILLA_TIPO_COMUNIDAD = "comunidad";
    public static final String CASILLA_TIPO_CARCEL = "carcel";
    public static final String CASILLA_TIPO_PARKING = "parking";
    public static final String CASILLA_TIPO_SALIDA = "salida";
    public static final String CASILLA_TIPO_IMPUESTO = "impuesto";
    public static final String CASILLA_TIPO_IR_CARCEL = "ir_carcel";
    public static final String CASILLA_TIPO_CAJA = "caja";
    public static final String LINEA_HORIZONTAL = new String(Character.toChars(0x2500));
    public static final String LINEA_VERTICAL = new String(Character.toChars(0x2502));
    public static final String ESQUINA_SUPERIOR_IZQUIERDA = new String(Character.toChars(0x250c));
    public static final String ESQUINA_SUPERIOR_DERECHA = new String(Character.toChars(0x2510));
    public static final String ESQUINA_INFERIOR_IZQUIERDA = new String(Character.toChars(0x2514));
    public static final String ESQUINA_INFERIOR_DERECHA = new String(Character.toChars(0x2518));
    public static final String INTERSECCION_IZQUIERDA = new String(Character.toChars(0x251c));
    public static final String INTERSECCION_DERECHA = new String(Character.toChars(0x2524));
    public static final String INTERSECCION_SUPERIOR = new String(Character.toChars(0x252c));
    public static final String INTERSECCION_INFERIOR = new String(Character.toChars(0x2534));
    public static final String INTERSECCION_TOTAL = new String(Character.toChars(0x253c));
    public static final int TAMANHO_CASILLA = Valor.SOLAR3_GRUPO_AMARILLO.length() + 5; // aumentamos algo o tamaño para que non quede tan axustada a casilla
    public static final int TAMANHO_LINEA = TAMANHO_CASILLA * 11;

    public void aumentarValor5(Tablero t){
        for(ArrayList<Casilla> a: t.getCasillas()){
            for(Casilla casilla: a){
                casilla.setValor((int) (1.05 * casilla.getValor()));
            }
        }
    }


}
