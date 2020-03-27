package ba.unsa.etf.rs.tut4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;

public class Controller {


    public TextArea text1;
    public TextArea text2;
    public ChoiceBox choiceB;
    public Spinner spinner;
    public TextArea aktuelni_racun;

    public void dodajArtikle(ActionEvent actionEvent) {
        ArrayList<Artikal> lista  = new ArrayList<Artikal>();
        ArrayList<String> lista1  = new ArrayList<String>();
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
            lista1.add(a.getSifra());
        }
        ObservableList<String> cursors = FXCollections.observableArrayList(lista1);
        choiceB.setItems(cursors);
        lista = Artikal.izbaciDuplikate(lista);
        for (Object o : lista){
            text2.appendText(o + "");
        }
           // text2.appendText(lista.toString());
    }

    public void dodajNaRacun(ActionEvent actionEvent) {
        int value = (Integer) spinner.getValue();
        String s = new String();
        s = choiceB.getValue().toString();
        ArrayList<Racun.Stavka> s2 = new ArrayList<>();

            Racun.Stavka stavka = new Racun.Stavka();
            Artikal b = new Artikal();
            /*String s3 = new String();*/
            String s3 = new String();
            s3 = text2.getText();
            ArrayList<Artikal> lista = new ArrayList<Artikal>();
            String[] s4 = new String[100];
            s4 = s3.split("\n");
            for (int i = 0; i < s4.length; i++) {
                String[] s5 = new String[3];
                s5 = s4[i].split(",");
                Artikal a = new Artikal();
                a.setSifra(s5[0]);
                a.setNaziv(s5[1]);
                a.setCijena(Double.parseDouble(s5[2]));
                if (s.equals(a.getSifra())) {
                    b.setNaziv(a.getNaziv().toString());
                    b.setCijena(a.getCijena());
                }
                lista.add(a);
            }
            stavka.setK(value);
            stavka.setA(b);
            s2.add(stavka);

       /* for(int i = 0; i < s2.size(); i++)
             aktuelni_racun.setText(s2.get(i).toString() + "\n");
    }*/
        for(Racun.Stavka st : s2) {
            aktuelni_racun.setText(stavka.toString() + "\n");
           // System.out.println(st + "\n");
        }
    }


}
