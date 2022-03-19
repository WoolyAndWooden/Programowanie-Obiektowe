import java.util.Comparator;

public class DiscountPriceSort implements Comparator<Produkt>{
    @Override
    public int compare(Produkt o1, Produkt o2){
        Double c1 = o1.cenaPromocyjna;
        Double c2 = o2.cenaPromocyjna;

        return c1.compareTo(c2);
    }
}
