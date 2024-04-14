package Main;

import Controller.ApiController;
import Model.Movie;
import View.MainScreen;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Inicia o tema
        FlatLightFlatIJTheme.setup();
        
        ApiController api = ApiController.getInstance();

        
        //System.out.println(api.searchMovie("tt0816692", true));
        
        // Abre a Tela Inicial
       new MainScreen().setVisible(true);
    }
}
