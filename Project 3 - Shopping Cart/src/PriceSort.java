import java.util.Comparator;

public class PriceSort implements Comparator<Produkt>{
    @Override
    public int compare(Produkt o1, Produkt o2){
        Double c1 = o1.cena;
        Double c2 = o2.cena;

        return c1.compareTo(c2);
    }
}
