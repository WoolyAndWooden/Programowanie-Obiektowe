import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class KoszykTest {

    //Test dodawania elementów
    @Test
    public void testAdd(){
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));

        assertEquals(100, koszyk.produkty.get(0).cena, 0);

        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));

        assertEquals(100, koszyk.produkty.get(0).cena, 0);
        assertEquals(50, koszyk.produkty.get(1).cena, 0);
    }

    //Na kolekcji
    @Test
    public void testNajdrozszy() {
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));
        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("2", "monitor", 1000));
        koszyk.DodajProdukt(new Produkt("1", "sluchawki", 250));
        koszyk.DodajProdukt(new Produkt("2", "zasilacz", 500));

        koszyk.produkty.sort(new PriceSort());
        assertEquals(1000, koszyk.Najdrozszy().cena, 0);
    }
    @Test
    public void testNajdrozszyDiscount() {
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));
        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("2", "monitor", 1000));
        koszyk.DodajProdukt(new Produkt("1", "sluchawki", 250));
        koszyk.DodajProdukt(new Produkt("2", "zasilacz", 500));

        koszyk.produkty.sort(new DiscountPriceSort());
        assertEquals(1000, koszyk.Najdrozszy().cenaPromocyjna, 0);
    }
    @Test
    public void testNajtanszy(){
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));
        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("2", "monitor", 1000));
        koszyk.DodajProdukt(new Produkt("1", "sluchawki", 250));
        koszyk.DodajProdukt(new Produkt("2", "zasilacz", 500));

        assertEquals(0, koszyk.Najtanszy().cena, 0);
    }
    @Test
    public void testNajtanszyDiscount(){
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));
        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("2", "monitor", 1000));
        koszyk.DodajProdukt(new Produkt("1", "sluchawki", 250));
        koszyk.DodajProdukt(new Produkt("2", "zasilacz", 500));

        assertEquals(0, koszyk.Najtanszy().cenaPromocyjna, 0);
    }
    @Test
    public void testnNajdrozszy(){
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));
        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("2", "monitor", 1000));
        koszyk.DodajProdukt(new Produkt("1", "sluchawki", 250));
        koszyk.DodajProdukt(new Produkt("2", "zasilacz", 500));

        koszyk.produkty.sort(new PriceSort());
        ArrayList<Produkt> sut = koszyk.nNajdrozszy(2);

        assertEquals(1000, sut.get(0).cena, 0);
        assertEquals(500, sut.get(1).cena, 0);

        ArrayList<Produkt> sut2 = koszyk.nNajdrozszy(10);

        for(int i = 0; i < koszyk.produkty.size() - 1; i++) assertEquals(koszyk.produkty.get(i).cena, sut2.get(i).cena, 0);
    }
    @Test
    public void testnNajdrozszyDiscount(){
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));
        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("2", "monitor", 1000));
        koszyk.DodajProdukt(new Produkt("1", "sluchawki", 250));
        koszyk.DodajProdukt(new Produkt("2", "zasilacz", 500));

        koszyk.produkty.sort(new PriceSort());
        ArrayList<Produkt> sut = koszyk.nNajdrozszyDiscount(2);

        assertEquals(1000, sut.get(0).cenaPromocyjna, 0);
        assertEquals(500, sut.get(1).cenaPromocyjna, 0);

        ArrayList<Produkt> sut2 = koszyk.nNajdrozszyDiscount(10);

        for(int i = 0; i < koszyk.produkty.size() - 1; i++) assertEquals(koszyk.produkty.get(i).cenaPromocyjna, sut2.get(i).cenaPromocyjna, 0);
    }
    @Test
    public void testnNajtanszy(){
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));
        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("2", "monitor", 1000));
        koszyk.DodajProdukt(new Produkt("1", "sluchawki", 250));
        koszyk.DodajProdukt(new Produkt("2", "zasilacz", 500));

        ArrayList<Produkt> sut = koszyk.nNajtanszy(4);

        assertEquals(200, sut.get(3).cena, 0);

        ArrayList<Produkt> sut2 = koszyk.nNajtanszy(10);

        for(int i = 0; i < koszyk.produkty.size() - 1; i++) assertEquals(koszyk.produkty.get(i).cena, sut2.get(i).cena, 0);
    }
    @Test
    public void testnNajtanszyDiscount(){
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));
        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("2", "monitor", 1000));
        koszyk.DodajProdukt(new Produkt("1", "sluchawki", 250));
        koszyk.DodajProdukt(new Produkt("2", "zasilacz", 500));

        ArrayList<Produkt> sut = koszyk.nNajtanszyDiscount(4);

        assertEquals(200, sut.get(3).cenaPromocyjna, 0);

        ArrayList<Produkt> sut2 = koszyk.nNajtanszyDiscount(10);

        for(int i = 0; i < koszyk.produkty.size() - 1; i++) assertEquals(koszyk.produkty.get(i).cenaPromocyjna, sut2.get(i).cenaPromocyjna, 0);
    }
    @Test
    public void testNameSortAsc(){
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));
        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("2", "monitor", 1000));
        koszyk.DodajProdukt(new Produkt("1", "sluchawki", 250));
        koszyk.DodajProdukt(new Produkt("2", "zasilacz", 500));

        koszyk.NameSortAsc();
        assertEquals("klawiatura", koszyk.produkty.get(0).nazwa);
    }
    @Test
    public void testNameSortDesc(){
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));
        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("2", "monitor", 1000));
        koszyk.DodajProdukt(new Produkt("1", "sluchawki", 250));
        koszyk.DodajProdukt(new Produkt("2", "zasilacz", 500));

        koszyk.NameSortDesc();
        assertEquals("Kubek Firmowy", koszyk.produkty.get(5).nazwa);
    }
    @Test
    public void testValue(){
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));
        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("2", "monitor", 1000));
        koszyk.DodajProdukt(new Produkt("1", "sluchawki", 250));
        koszyk.DodajProdukt(new Produkt("2", "zasilacz", 500));

        assertEquals(2100, koszyk.Value(), 0);
    }

    //Testy promocji
    @Test
    public void testFreebies(){
        Koszyk koszyk = new Koszyk();

        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));
        koszyk.DodajProdukt(new Produkt("2", "podkladka", 50));
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("2", "monitor", 1000));
        koszyk.DodajProdukt(new Produkt("1", "sluchawki", 250));
        koszyk.DodajProdukt(new Produkt("2", "zasilacz", 500));

        for(int i = koszyk.produkty.size() - 1; i != 4; i--) assertEquals(0, koszyk.produkty.get(i).cenaPromocyjna, 0);
    }
    @Test
    public void testFreeMug(){
        Koszyk koszyk = new Koszyk();
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));

        assertEquals("Kubek Firmowy", koszyk.produkty.get(1).nazwa);
    }
    @Test
    public void testOver300(){
        Koszyk koszyk = new Koszyk();
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.DodajProdukt(new Produkt("1", "myszka", 100));

        assertEquals(285, koszyk.wartoscPromocyjna, 0);
    }
    @Test(expected = NullPointerException.class)
    public void testKupon30Offexception(){
        Koszyk koszyk = new Koszyk();

        koszyk.UseCoupon("kupon30off");
    }
    public void testKupon30Off(){
        Koszyk koszyk = new Koszyk();
        koszyk.DodajProdukt(new Produkt("1", "klawiatura", 200));
        koszyk.UseCoupon("kupon30off");
        assertEquals(140, koszyk.produkty.get(0).cenaPromocyjna, 0);
    }
}
