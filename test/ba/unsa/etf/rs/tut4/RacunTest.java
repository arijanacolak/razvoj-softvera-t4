package ba.unsa.etf.rs.tut4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RacunTest {

    @Test
    void test1() {
        Racun r = new Racun();
        r.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);
        r.dodajStavku(new Artikal("JAJ", "Jaje", 0.25), 5);
        assertEquals(3.45, r.ukupanIznos());
    }

    @Test
    void testPrazno() {
        Racun r = new Racun();
        assertEquals(0, r.ukupanIznos());
    }

    @Test
    void getStavke() {
        Racun.Stavka stavka = new Racun.Stavka(); //(new Artikal("HLBNOO", "Hljeb", 1.00), 3);
        stavka.setA(new Artikal("HLBNOO", "Hljeb", 1.00));
        stavka.setK(3);
        assertEquals("Hljeb", stavka.getA().getNaziv());
        assertEquals(1.00, stavka.getA().getCijena());
        assertEquals("HLBNOO", stavka.getA().getSifra());
        assertEquals(3, stavka.getK());
    }


    @Test
    void testToString() {
        Racun.Stavka st = new Racun.Stavka(new Artikal("HLBOO", "Hljeb", 1.20), 2);
        assertEquals("HLBOO 2 2.40\n", st.toString());

    }
}