package controller;

import modell.TablaModel;
import view.TablaView;
import java.io.IOException;

public class TablaController {

    private TablaModel model;
    private TablaView view;

    public TablaController(TablaModel model, TablaView view) {
        this.model = model;
        this.view = view;
    }

    public void kezdetiAllapot() {
        view.kiirUzenet("4. feladat: Az üres tábla:");
        view.megjelenitTabla(model.getTabla());
    }

    public void kiralyokElhelyezese(int db) {
        model.elhelyezKiralyok(db);
        view.kiirUzenet("6. feladat: A feltöltött tábla:");
        view.megjelenitTabla(model.getTabla());
    }

    public void uresOszlopokSorokSzama() {
        view.kiirUzenet("9. feladat: Üres oszlopok és sorok száma:");
        view.kiirUzenet("Oszlopok: " + model.uresOszlopokSzama());
        view.kiirUzenet("Sorok: " + model.uresSorokSzama());
    }

    public void fajlbaIr() throws IOException {
        model.fajlbaIr();
    }
}
