import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

final public class Registry {
    //Collections
    static public LinkedHashSet<String> WorkersIds = new LinkedHashSet<>();
    static public LinkedHashSet<Worker> Workers = new LinkedHashSet<>();
    static public LinkedHashSet<String> BuildingsId = new LinkedHashSet<>();
    static public LinkedHashSet<Building> Buildings = new LinkedHashSet<>();
    static public LinkedHashSet<String> Desks = new LinkedHashSet<>();

    //Adding buildings
    static public void AddBuilding(String buildingId, String cityName, String streetName,
                              Integer numBuilding, Integer numHouse){
        if(!BuildingsId.contains(buildingId)){
            Buildings.add(new Building(buildingId, cityName, streetName,
                    numBuilding, numHouse));
            BuildingsId.add(buildingId);
        }
    }
    //Adding workers
    static public void AddWorker(String id, String name, String surname,
                                 Integer age, Integer experience, String buildingId,
                                 /*for WorkerB, if not this type, set null*/
                                 String deskId, Integer iq,
                                 /*For WorkerF, if not this type, set null*/
                                 Integer strength,
                                 /*for WorkerH, if not this type, set null*/
                                 Efficiency efficiency, Double fee){
        if(!Registry.WorkersIds.contains(id)){
            if(Registry.BuildingsId.contains(buildingId)){
                boolean added = true;
                if(id.charAt(0) == 'B'){
                    if(deskId == null || iq == null) throw new IllegalArgumentException("Worker specific parameters are" +
                            "null");
                    if(Registry.Desks.contains(deskId)) throw new IllegalArgumentException("Desk already occupied");
                    Worker p = new WorkerB(id, name, surname,
                            age, experience, buildingId, deskId, iq);
                    Registry.Workers.add(p);
                    if(Registry.Workers.contains(p))    Registry.Desks.add(deskId);

                }
                else if(id.charAt(0) == 'F'){
                    if(strength == null) throw new IllegalArgumentException("Worker specific parameters are" +
                            "null");
                    Registry.Workers.add(new WorkerF(id, name, surname,
                            age, experience, buildingId, strength));
                }
                else if(id.charAt(0) == 'H'){
                    if(efficiency == null || fee == null) throw new IllegalArgumentException("Worker specific parameters are" +
                            "null");
                    Registry.Workers.add(new WorkerH(id, name, surname,
                            age, experience, buildingId, efficiency, fee));
                }
                else added = false;
                if(added) Registry.WorkersIds.add(id);
            }
        }
    }
    // Place for adding multiple workers
    static public void AddMultipleWorkers(ArrayList<String> id, ArrayList<String> name, ArrayList<String> surname,
                                          ArrayList<Integer> age, ArrayList<Integer> experience, ArrayList<String> buildingId,
            /*for WorkerB, if not this type, set null*/
                                          ArrayList<String> deskId, ArrayList<Integer> iq,
            /*For WorkerF, if not this type, set null*/
                                          ArrayList<Integer> strength,
            /*for WorkerH, if not this type, set null*/
                                          ArrayList<Efficiency> efficiency, ArrayList<Double> fee){
        //Check if sizes are equal
        if(id.size() != name.size() && id.size() != surname.size() && id.size() != age.size() &&
                id.size() != experience.size() && id.size() != buildingId.size() &&
                id.size() != deskId.size() && id.size() != iq.size() &&
                id.size() != strength.size() &&
                id.size() != efficiency.size() && id.size() != fee.size())   throw new IllegalArgumentException("" +
                "Sizes of arguement arrays not equal");

        for(int i = 0; i < id.size(); i++)  Registry.AddWorker(id.get(i), name.get(i), surname.get(i),
                                                                    age.get(i), experience.get(i), buildingId.get(i),
                                                                    deskId.get(i), iq.get(i),
                                                                    strength.get(i),
                                                                    efficiency.get(i), fee.get(i));
    }


    //Remove worker with precise ID
    static public void RemoveWorker(String id){
        if(Registry.WorkersIds.contains(id)){
            boolean removed = false;
            Iterator<Worker> i = Registry.Workers.iterator();
            Worker p = i.next();
            while(i.hasNext() && p.getId() != id) p = i.next();
            Registry.Workers.remove(p);
            if(!Registry.Workers.contains(p)) removed = true;
            if(removed) Registry.WorkersIds.remove(id);
        }
    }

    //Sorting stuff
    static public void SortBySurname(){
        ArrayList<Worker> Sorting = new ArrayList<>(Registry.Workers);
        Sorting.sort(new SurnameSort());
        Registry.Workers.clear();
        Registry.Workers = new LinkedHashSet<>(Sorting);
    }
    static public void SortByAge(){
        ArrayList<Worker> Sorting = new ArrayList<>(Registry.Workers);
        Sorting.sort(new AgeSort());
        Registry.Workers.clear();
        Registry.Workers = new LinkedHashSet<>(Sorting);
    }
    static public void SortByExperience(){
        ArrayList<Worker> Sorting = new ArrayList<>(Registry.Workers);
        Sorting.sort(new ExperienceSort());
        Registry.Workers.clear();
        Registry.Workers = new LinkedHashSet<>(Sorting);
    }
    static public void SortByWorth(){
        ArrayList<Worker> Sorting = new ArrayList<>(Registry.Workers);
        Sorting.sort(new WorthSort());
        Registry.Workers.clear();
        Registry.Workers = new LinkedHashSet<>(Sorting);
    }

    //Showing
    static public void Show(){
        Iterator<Worker> i = Registry.Workers.iterator();
        while(i.hasNext()) System.out.print(i.next().toString()+"\n");
    }
    static public void ShowFromCity(String city){
        ArrayList<String> compBuildings = new ArrayList<>();
        Iterator<Building> b = Registry.Buildings.iterator();
        Building b1 = null;
        while(b.hasNext()){
            b1 = b.next();
            if(b1.getCityName() == city)compBuildings.add(b1.getBuildingId());
        }
        Iterator<Worker> i = Registry.Workers.iterator();
        Worker p = null;
        while(i.hasNext()){
            p = i.next();
            if(compBuildings.contains(p.getBuildingId())) System.out.print(p.toString()+"\n");
        }
    }

}
