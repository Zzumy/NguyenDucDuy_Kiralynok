package modell;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TablaModel {

    private char[][] tabla = new char[8][8];

    public TablaModel() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = '.';
            }
        }
    }

    public void elhelyezKiralyok(int db) {
        Random rand = new Random();
        for (int i = 0; i < db; i++) {
            int x, y;
            do {
                x = rand.nextInt(8);
                y = rand.nextInt(8);
            } while (tabla[x][y] != '.');
            tabla[x][y] = 'K';
        }
    }

    public int uresOszlopokSzama() {
        int db = 0;
        for (int i = 0; i < 8; i++) {
            boolean ures = true;
            for (int j = 0; j < 8; j++) {
                if (tabla[j][i] != '.') {
                    ures = false;
                    break;
                }
            }
            if (ures) {
                db++;
            }
        }
        return db;
    }

    public int uresSorokSzama() {
        int db = 0;
        for (int i = 0; i < 8; i++) {
            boolean ures = true;
            for (int j = 0; j < 8; j++) {
                if (tabla[i][j] != '.') {
                    ures = false;
                    break;
                }
            }
            if (ures) {
                db++;
            }
        }
        return db;
    }

    public void fajlbaIr() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("tablak64.txt", true));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                writer.print(tabla[i][j]);
            }
            writer.println();
        }
        writer.println();
        writer.close();
    }

    public char[][] getTabla() {
        return tabla;
    }
}
