package main;

import controller.TablaController;
import modell.TablaModel;
import view.TablaView;
import view.KiralynokGUI;

public class Main {
    public static void main(String[] args) {
        TablaModel model = new TablaModel();
        TablaView view = new TablaView();
        TablaController controller = new TablaController(model, view);
//        KiralynokGUI gui = new KiralynokGUI();

        controller.kezdetiAllapot();
        controller.kiralyokElhelyezese(8);
        controller.uresOszlopokSorokSzama();
    }
}
