import java.util.Comparator;

public class SurnameSort implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        return o1.getSurname().toLowerCase().compareTo(o2.getSurname().toLowerCase());
    }
}
