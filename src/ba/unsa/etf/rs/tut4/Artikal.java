package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Artikal {
    private String sifra, naziv;
    private double cijena;

    public Artikal(String toString) {
    }

    public Artikal(String sifra, String naziv, double cijena) {
        setSifra(sifra);
        setNaziv(naziv);
        setCijena(cijena);
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        if(sifra.isEmpty()) throw new IllegalArgumentException("Šifra je prazna");
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv.isEmpty()) throw new IllegalArgumentException("Naziv je prazan");
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if(cijena < 0) throw new IllegalArgumentException("Cijena je negativna");
        this.cijena = cijena;
    }

    public String toString() {
        return (sifra + "," + naziv + "," + cijena);
    }

    public boolean equals(Object o) {
        if(!(o instanceof Artikal)) return false;
        Artikal a = (Artikal) o;
        return (this.sifra.equalsIgnoreCase(a.sifra) && this.naziv.equalsIgnoreCase(a.naziv) && this.cijena == a.cijena);
    }

    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> lista) {
        if (lista.size() > 1) {
            for (int i = 0; i < lista.size(); i++) {
                for (int j = 1; j < lista.size(); j++) {
                    if (lista.get(i).equals(lista.get(j))) {
                        lista.remove(lista.get(i));
                    }
                }
            }
        }
        return lista;
    }
}