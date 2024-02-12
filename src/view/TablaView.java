package view;

public class TablaView {

    public void megjelenitTabla(char[][] tabla) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(tabla[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void kiirUzenet(String szoveg) {
        System.out.println(szoveg);
    }
}
