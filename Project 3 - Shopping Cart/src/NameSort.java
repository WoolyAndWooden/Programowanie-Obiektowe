import java.util.Comparator;

public class NameSort implements Comparator<Produkt>{
    @Override
    public int compare(Produkt o1, Produkt o2){

        return o1.nazwa.toLowerCase().compareTo(o2.nazwa.toLowerCase());
    }
}
