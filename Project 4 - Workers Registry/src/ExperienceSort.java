import java.util.Comparator;

public class ExperienceSort implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        return o1.getExperience().compareTo(o2.getExperience());
    }
}
