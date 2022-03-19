import java.util.*;

public class Koszyk{
    public ArrayList<Produkt> produkty;
    public double wartosc;
    public double wartoscPromocyjna;
    public int iloscProduktow;
    private boolean over300Promo;
    private boolean freeMug;
    public boolean couponUsed;
    private String couponName;

    public Koszyk(){
        this.produkty = new ArrayList<Produkt>();
        this.wartosc = 0;
        this.wartoscPromocyjna = this.wartosc;
        this.iloscProduktow = 0;
        this.over300Promo = false;
        this.freeMug = false;
        this.couponUsed = false;
        this.couponName = "";
    }

    public void DodajProdukt(Produkt produkt){
        produkty.add(produkt);

        produkty.sort(Collections.reverseOrder(new DiscountPriceSort()));

        this.Promos();
    }

    //Część kodu na promocję
    private void Promos(){
        Freebies();
        this.wartoscPromocyjna = DiscountValue();
        if(couponUsed) this.ExecuteCoupon(this.couponName);
        if(!freeMug) {
            if (this.wartoscPromocyjna >= 200) {
                freeMug = true;
                this.produkty.add(new Produkt("000", "Kubek Firmowy", 0));
            }
        }
        if(!over300Promo){
            if(this.wartoscPromocyjna >= 300){
                this.wartoscPromocyjna *= 0.95;
            }
        }
    }

    private void Freebies(){
        int i = 0;
        while(this.produkty.get(i).cena == 0) i++;
        i = (this.produkty.size() - i) / 2;
        for(int j = 0; j < i; j++) this.produkty.get(this.produkty.size() - 1 - j).SetAsFree();
    }

    public void UseCoupon(String kupon){
        if(this.produkty.isEmpty()) throw new NullPointerException();
        if(!couponUsed) {
            for (String i : Kupon.kupony) {
                if (i == kupon) {
                    this.couponUsed = true;
                    this.ExecuteCoupon(kupon);
                }
            }
        }
        //Miejsce na informacje o nieprawidłowym kuponie
    }

    private void ExecuteCoupon(String kupon){
        Kupon.kupon30off(this);
    }

    //Część kodu na operacje na liście
    public Produkt Najdrozszy(){
        this.produkty.sort(Collections.reverseOrder(new PriceSort()));
        return this.produkty.get(0);
    }
    public Produkt NajdrozszyDiscount(){
        this.produkty.sort(Collections.reverseOrder(new DiscountPriceSort()));
        return this.produkty.get(0);
    }
    public ArrayList<Produkt> nNajdrozszy(int n){
        this.produkty.sort(Collections.reverseOrder(new PriceSort()));
        ArrayList<Produkt> max = new ArrayList<Produkt>();
        if(n >= this.produkty.size()){
            for(Produkt i: this.produkty) max.add(i);
            return max;
        }

        for(int i = 0; i < n; i++) max.add(this.produkty.get(i));
        return max;
    }
    public ArrayList<Produkt> nNajdrozszyDiscount(int n){
        this.produkty.sort(Collections.reverseOrder(new DiscountPriceSort()));
        ArrayList<Produkt> max = new ArrayList<Produkt>();
        if(n >= this.produkty.size()){
            for(Produkt i: this.produkty) max.add(i);
            return max;
        }
        for(int i = 0; i < n; i++) max.add(this.produkty.get(i));
        return max;
    }

    public Produkt Najtanszy(){
        this.produkty.sort(new PriceSort());
        return this.produkty.get(0);
    }
    public Produkt NajtanszyDiscount(){
        this.produkty.sort(new DiscountPriceSort());
        return this.produkty.get(0);
    }
    public ArrayList<Produkt> nNajtanszy(int n){
        this.produkty.sort(new PriceSort());
        ArrayList<Produkt> max = new ArrayList<Produkt>();
        if(n >= this.produkty.size()){
            for(Produkt i: this.produkty) max.add(i);
            return max;
        }

        for(int i = 0; i < n; i++) max.add(this.produkty.get(i));
        return max;
    }
    public ArrayList<Produkt> nNajtanszyDiscount(int n){
        this.produkty.sort(new PriceSort());
        ArrayList<Produkt> max = new ArrayList<Produkt>();
        for(Produkt i: this.produkty) max.add(i);
        if(n >= this.produkty.size()){
            max = this.produkty;
            return max;
        }

        for(int i = 0; i < n; i++) max.add(this.produkty.get(i));
        return max;
    }

    public void NameSortAsc(){
        this.produkty.sort(new NameSort());
    }
    public void NameSortDesc(){
        this.produkty.sort(Collections.reverseOrder(new NameSort()));
    }
    public double Value(){
        double x = 0;
        for(Produkt i: this.produkty) x += i.cena;
        return x;
    }
    public double DiscountValue(){
        double x = 0;
        for(Produkt i: this.produkty) x += i.cenaPromocyjna;
        if(over300Promo) x *= 0.95;
        return x;
    }

}
