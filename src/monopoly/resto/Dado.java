package monopoly.resto;

import java.util.Random;

public class Dado {
    private int dado1;
    private int dado2;

    public static int tirarDados() {
        Random random = new Random();

        return random.nextInt((6-1) + 1) + 1 + random.nextInt((6-1)+1)+1;
    }

    public int getDado1() {
        return dado1;
    }

    public void setDado1(int dado1) {
        this.dado1 = dado1;
    }

    public int getDado2() {
        return dado2;
    }

    public void setDado2(int dado2) {
        this.dado2 = dado2;
    }
}
