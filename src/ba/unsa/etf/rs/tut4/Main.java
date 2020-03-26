package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Artikal> lista = new ArrayList<>();
        lista.add(new Artikal("ABC", "Proizvod", 100));
        lista.add(new Artikal("DEF", "Usluga", 200));
        lista.add(new Artikal("ABC", "Proizvod", 100));
        if(lista.get(0).equals(lista.get(1)))
            System.out.println("Sretan rad na tutorijalu 4!");
    }
}
