package kiralynok;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.io.File;

public class Tabla {

    private char[][] T = new char[8][8];
    private char UresCella;

    public Tabla(char c) {
        this.UresCella = c;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.T[i][j] = this.UresCella;
            }
        }
    }

    public void Megjelenit() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(this.T[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void Elhelyez(int db) {
        Random rand = new Random();
        for (int i = 0; i < db; i++) {
            int x, y;
            do {
                x = rand.nextInt(8);
                y = rand.nextInt(8);
            } while (this.T[x][y] != this.UresCella);

            this.T[x][y] = 'K';
        }
    }

    public boolean UresOszlop(int m) {
        for (int i = 0; i < 8; i++) {
            if (this.T[i][m] != this.UresCella) {
                return false;
            }
        }
        return true;
    }

    public boolean UresSor(int m) {
        for (int i = 0; i < 8; i++) {
            if (this.T[m][i] != this.UresCella) {
                return false;
            }
        }
        return true;
    }

    public int UresOszlopokSzama() {
        int db = 0;
        for (int i = 0; i < 8; i++) {
            if (UresOszlop(i)) {
                db++;
            }
        }
        return db;
    }

    public int UresSorokSzama() {
        int db = 0;
        for (int i = 0; i < 8; i++) {
            if (UresSor(i)) {
                db++;
            }
        }
        return db;
    }

    public void FajlbaIr() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("tablak64.txt", true));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                writer.print(this.T[i][j]);
            }
            writer.println();
        }
        writer.println();
        writer.close();
    }

    public void Kiir(String szoveg) {
        System.out.println(szoveg);
    }

    public static void main(String[] args) throws IOException {
        Tabla t = new Tabla('.');
        t.Kiir("4. feladat: Az üres tábla:");
        t.Megjelenit();

        t.Elhelyez(8);
        t.Kiir("6. feladat: A feltöltött tábla:");
        t.Megjelenit();

        t.Kiir("9. feladat: Üres oszlopok és sorok száma:");
        t.Kiir("Oszlopok: " + t.UresOszlopokSzama());
        t.Kiir("Sorok: " + t.UresSorokSzama());

        Tabla[] tt = new Tabla[65];
        File file = new File("tablak64.txt");
        if (file.exists()) {
            file.delete();
        }

        for (int x = 1; x <= 64; x++) {
            tt[x] = new Tabla('*');
            tt[x].Elhelyez(x);
            tt[x].FajlbaIr();
        }
    }
}
