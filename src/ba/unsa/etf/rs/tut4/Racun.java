package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

 public class Racun {

   public static class Stavka {
        public Artikal a;
        public Integer k;

        public Stavka(Artikal a, Integer k) {
            this.a = a;
            this.k = k;
        }
       public String toString() {
           return (a.getSifra().toString() + " " + k + " " + String.format("%.2f", a.getCijena() * k) + "\n");
       }
       public Stavka() { }

       public Artikal getA() {
            return a;
        }

        public Integer getK() {
            return k;
        }

        public void setA(Artikal a) {
            this.a = a;
        }

        public void setK(Integer k) {
            this.k = k;
        }

    };

    public ArrayList<Stavka> stavke;
    public Racun () {
        stavke = new ArrayList<>();
    }

     public void dodajStavku(Artikal a, int ponavlja) {
        stavke.add(new Stavka(a, ponavlja));
    }

    public double ukupanIznos() {
        double suma = 0;
        for(Stavka s : stavke) {
            double cijena = s.a.getCijena();
            if(s.k > 1) cijena = cijena * s.k;
                suma = suma + cijena;
        }
        return suma;
    }
}
