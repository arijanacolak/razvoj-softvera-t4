package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Controller {


    public TextArea text1;
    public TextArea text2;

    public void dodajArtikle(ActionEvent actionEvent) {
        ArrayList<Artikal> lista  = new ArrayList<Artikal>();
        String s = new String();
        s = text1.getText();
        String[] s1 = new String[100];
        s1 = s.split("\n");
        for(int i = 0; i < s1.length; i++) {
            String[] s2 = new String[3];
            s2 = s1[i].split(",");
            Artikal a = new Artikal();
            a.setSifra(s2[0]);
            a.setNaziv(s2[1]);
            a.setCijena(Double.parseDouble(s2[2]));
            lista.add(a);
        }
        lista = Artikal.izbaciDuplikate(lista);
        for (Object o : lista){
            text2.appendText(o + "");
        }
           // text2.appendText(lista.toString());

    }
}
