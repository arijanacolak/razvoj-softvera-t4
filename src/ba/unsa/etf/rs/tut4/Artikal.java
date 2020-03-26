package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;
import java.util.Objects;

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

    /*public boolean equals(Object o) {
        if(!(o instanceof Artikal)) return false;
        Artikal a = (Artikal) o;
        return (this.sifra.equals(a.sifra) && this.naziv.equals(a.naziv) && this.cijena == a.cijena);
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artikal artikal = (Artikal) o;

        if (Double.compare(artikal.cijena, cijena) != 0) return false;
        if (sifra != null ? !sifra.equals(artikal.sifra) : artikal.sifra != null) return false;
        return naziv != null ? naziv.equals(artikal.naziv) : artikal.naziv == null;
    }


    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> lista) {
        if(lista.size() > 1) {
            for (int i = 0; i < lista.size()-1; i++) {
                for (int j = i+1; j < lista.size(); j++) {
                    if (lista.get(i).equals(lista.get(j))) {
                        lista.remove(j);
                        j--;
                    }
                }
            }
        }
        return lista;
    }
}