package Main;

import View.MainScreen;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        // Inicia o tema
        FlatLightFlatIJTheme.setup();
        // Abre a Tela Inicial
        new MainScreen().setVisible(true);
    }
}
