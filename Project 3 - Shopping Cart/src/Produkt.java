public class Produkt {
    public String id;
    public String nazwa;
    public double cena;
    public double cenaPromocyjna;

    public Produkt(String id, String nazwa, double cena) {
        if (cena < 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.cena = cena;
        this.nazwa = nazwa;
        this.cenaPromocyjna = this.cena;
    }

    public void SortingCase() {
        this.cena = -1;
        this.cenaPromocyjna = -1;
    }

    public void SetAsFree(){
        this.cenaPromocyjna = 0;
    }

    public String ToString(){
        return "Produkt nr: "+this.id+"\nNazwa: "+this.nazwa+"\nCena: "+this.cena+"\nTwoja cena: "+this.cenaPromocyjna;
    }
}
