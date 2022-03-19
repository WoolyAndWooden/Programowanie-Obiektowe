import org.junit.*;

import java.util.ArrayList;
import java.util.Iterator;


import static org.junit.Assert.*;

public class WorkersTest {

    //Adding
    @Test
    public void addBuilding(){
        Registry.AddBuilding("0", "Warszawa", "Wawelska",
                1, 1);
        Iterator<Building> iter = Registry.Buildings.iterator();
        Building p = null;
        while(iter.hasNext()) p = iter.next();
        assertEquals("0", p.getBuildingId());
        assertEquals("Warszawa", p.getCityName());
        assertEquals("Wawelska", p.getStreetName());
        Integer x = 1;
        assertEquals(x, p.getNumHouse());
        assertEquals(x, p.getNumBuilding());
    }
    @Test
    public void addWorker(){
        //Nie doda, jeśli nie istnieje budynek
        Registry.AddWorker("B001", "Adam", "Nowak",
                20, 2, "0",
                "000", 100,
                /*nulls*/
                null, null, null);
        assertTrue(Registry.Desks.isEmpty());
        assertTrue(Registry.Workers.isEmpty());
        assertTrue(Registry.WorkersIds.isEmpty());


        //Nie doda, jeśli id nie określa typu pracownika
        Registry.AddBuilding("0", "Warszawa", "Wawelska",
                1, 1);

        Registry.AddWorker("a001", "Adam", "Nowak",
                20, 2, "0",
                "000", 100,
                /*nulls*/
                null, null, null);

        assertTrue(Registry.Workers.isEmpty());
        assertTrue(Registry.WorkersIds.isEmpty());


        //Tu doda poprawnie
        //Pracownik biurowy
        Registry.AddWorker("B001", "Adam", "Nowak",
                20, 2, "0",
                "000", 100,
                /*nulls*/
                null, null, null);

        assertTrue(Registry.WorkersIds.contains("B001"));

        Worker p = null;
        Iterator<Worker> i= Registry.Workers.iterator();
        while(i.hasNext()) p = i.next();

        assertEquals("B001", p.getId());
        assertEquals(200, p.getWorth(), 0);

        //Pracownik fizyczny
        Registry.AddWorker("F001", "Adam", "Nowakuń",
                30, 10, "0",
                /*nulls*/
                null, null,
                /*Tyoe specific*/
                90,
                /*nulls*/
                null, null);

        assertTrue(Registry.WorkersIds.contains("F001"));

        i = Registry.Workers.iterator();
        while(i.hasNext()) p = i.next();

        assertEquals("F001", p.getId());
        assertEquals(30, p.getWorth(), 0);

        //Pracownik biurowy
        Registry.AddWorker("H001", "Adam", "Nowakuń",
                25, 5, "0",
                /*nulls*/
                null, null,
                null,
                /*Type specific*/
                new MediumEfficiency(), 50.0);

        assertTrue(Registry.WorkersIds.contains("H001"));

        i = Registry.Workers.iterator();
        while(i.hasNext()) p = i.next();

        assertEquals("H001", p.getId());
        assertEquals(450, p.getWorth(), 0);
    }
    @Test
    public void AddMultipleWorkersTest(){
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Integer> experience = new ArrayList<>();
        ArrayList<String> buildingId = new ArrayList<>();
        ArrayList<String> deskId = new ArrayList<>();
        ArrayList<Integer> iq = new ArrayList<>();
        ArrayList<Integer> strength = new ArrayList<>();
        ArrayList<Efficiency> efficiency = new ArrayList<>();
        ArrayList<Double> fee = new ArrayList<>();

        id.add("B001");
        id.add("B002");
        id.add("F001");
        id.add("F002");
        id.add("H001");
        id.add("H002");

        name.add("Adam");
        name.add("Aadam");
        name.add("Aaadam");
        name.add("Aaaadam");
        name.add("Aaaaadam");
        name.add("Aaaaaadam");

        surname.add("Bo");
        surname.add("Boo");
        surname.add("Booo");
        surname.add("Boooo");
        surname.add("Booooo");
        surname.add("Boooooo");

        age.add(21);
        age.add(22);
        age.add(23);
        age.add(24);
        age.add(25);
        age.add(26);

        experience.add(2);
        experience.add(3);
        experience.add(4);
        experience.add(5);
        experience.add(6);
        experience.add(7);

        buildingId.add("0");
        buildingId.add("1");
        buildingId.add("1");
        buildingId.add("0");
        buildingId.add("1");
        buildingId.add("0");

        deskId.add("0");
        deskId.add("1");
        deskId.add(null);
        deskId.add(null);
        deskId.add(null);
        deskId.add(null);

        iq.add(150);
        iq.add(70);
        iq.add(null);
        iq.add(null);
        iq.add(null);
        iq.add(null);

        strength.add(null);
        strength.add(null);
        strength.add(50);
        strength.add(100);
        strength.add(null);
        strength.add(null);

        efficiency.add(null);
        efficiency.add(null);
        efficiency.add(null);
        efficiency.add(null);
        efficiency.add(new LowEfficiency());
        efficiency.add(new HighEfficiency());

        fee.add(10.0);
        fee.add(10.0);
        fee.add(10.0);
        fee.add(10.0);
        fee.add(30.5);
        fee.add(99.0);

        Registry.AddBuilding("0", "Warszawa", "Wawelska",
                1, 1);
        Registry.AddBuilding("1", "Mikołajki", "Wawelska",
                1, 1);

        Registry.AddMultipleWorkers(id, name, surname, age, experience, buildingId, deskId, iq, strength, efficiency, fee);

        assertFalse(Registry.Workers.isEmpty());
        assertFalse(Registry.WorkersIds.isEmpty());
        assertFalse(Registry.Desks.isEmpty());
        assertTrue(Registry.Workers.size() == Registry.WorkersIds.size());
        assertTrue(Registry.Workers.size() == 6);
        assertTrue(Registry.Desks.size() == 2);

        //Registry.Show();
        //Registry.ShowFromCity("Warszawa");
    }

    //Removing test
    @Test
    public void RemoveTest(){
        Registry.AddBuilding("0", "Warszawa", "Wawelska",
                1, 1);
        Registry.AddWorker("B001", "Adam", "Nowak",
                20, 2, "0",
                "000", 100,
                /*nulls*/
                null, null, null);
        Registry.AddWorker("F001", "Adam", "Nowakuń",
                30, 10, "0",
                /*nulls*/
                null, null,
                /*Tyoe specific*/
                90,
                /*nulls*/
                null, null);
        Registry.AddWorker("H001", "Adam", "Nowakuń",
                25, 5, "0",
                /*nulls*/
                null, null,
                null,
                /*Type specific*/
                new MediumEfficiency(), 50.0);

        assertFalse(Registry.Workers.isEmpty());
        assertFalse(Registry.WorkersIds.isEmpty());

        Registry.RemoveWorker("F001");
        assertFalse(Registry.WorkersIds.contains("F001"));
        Registry.RemoveWorker("H001");
        assertFalse(Registry.WorkersIds.contains("H001"));
        Registry.RemoveWorker("B001");
        assertTrue(Registry.WorkersIds.isEmpty());
        assertTrue(Registry.Workers.isEmpty());
    }

    //Sorting Tests
    @Test
    public void SortingTest(){
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Integer> experience = new ArrayList<>();
        ArrayList<String> buildingId = new ArrayList<>();
        ArrayList<String> deskId = new ArrayList<>();
        ArrayList<Integer> iq = new ArrayList<>();
        ArrayList<Integer> strength = new ArrayList<>();
        ArrayList<Efficiency> efficiency = new ArrayList<>();
        ArrayList<Double> fee = new ArrayList<>();

        id.add("B001");
        id.add("B002");
        id.add("F001");
        id.add("F002");
        id.add("H001");
        id.add("H002");

        name.add("Adam");
        name.add("Aadam");
        name.add("Aaadam");
        name.add("Aaaadam");
        name.add("Aaaaadam");
        name.add("Aaaaaadam");

        surname.add("Bo");
        surname.add("Do");
        surname.add("Co");
        surname.add("Go");
        surname.add("Ao");
        surname.add("Eo");

        age.add(21);
        age.add(22);
        age.add(23);
        age.add(24);
        age.add(25);
        age.add(26);

        experience.add(2);
        experience.add(3);
        experience.add(4);
        experience.add(5);
        experience.add(6);
        experience.add(7);

        buildingId.add("0");
        buildingId.add("1");
        buildingId.add("1");
        buildingId.add("0");
        buildingId.add("1");
        buildingId.add("0");

        deskId.add("0");
        deskId.add("1");
        deskId.add(null);
        deskId.add(null);
        deskId.add(null);
        deskId.add(null);

        iq.add(150);
        iq.add(70);
        iq.add(null);
        iq.add(null);
        iq.add(null);
        iq.add(null);

        strength.add(null);
        strength.add(null);
        strength.add(50);
        strength.add(100);
        strength.add(null);
        strength.add(null);

        efficiency.add(null);
        efficiency.add(null);
        efficiency.add(null);
        efficiency.add(null);
        efficiency.add(new LowEfficiency());
        efficiency.add(new HighEfficiency());

        fee.add(10.0);
        fee.add(10.0);
        fee.add(10.0);
        fee.add(10.0);
        fee.add(30.5);
        fee.add(99.0);

        Registry.AddBuilding("0", "Warszawa", "Wawelska",
                1, 1);
        Registry.AddBuilding("1", "Mikołajki", "Wawelska",
                1, 1);

        Registry.AddMultipleWorkers(id, name, surname, age, experience, buildingId, deskId, iq, strength, efficiency, fee);

        Registry.SortBySurname();

        Iterator<Worker> i = Registry.Workers.iterator();

        assertEquals("Ao", i.next().getSurname());
        assertEquals(6, Registry.Workers.size());

        Registry.SortByAge();

        Iterator<Worker> i1 = Registry.Workers.iterator();

        assertTrue(i1.next().getAge() == 21);
        assertEquals(6, Registry.Workers.size());

        Registry.SortByExperience();

        Iterator<Worker> i2 = Registry.Workers.iterator();

        assertTrue(i2.next().getExperience() == 2);
        assertEquals(6, Registry.Workers.size());

        Registry.SortByWorth();

        Iterator<Worker> i3 = Registry.Workers.iterator();

        assertTrue(i3.next().getWorth() <= i3.next().getWorth());
        assertEquals(6, Registry.Workers.size());



    }

}
