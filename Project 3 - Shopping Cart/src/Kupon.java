public class Kupon{
    public static String [] kupony = {"kupon30off"};

    public static void kupon30off(Koszyk koszyk){
        boolean brake = false;
        int i = 0;
        Produkt temp;
        while(!brake || i < koszyk.produkty.size()){
           temp = koszyk.produkty.get(i);
            if(temp.cena == temp.cenaPromocyjna && temp.cenaPromocyjna != 0){
                brake = true;
                temp.cenaPromocyjna = temp.cena * 0.7;
                koszyk.produkty.set(i, temp);
            }
            i++;
        }
        if(!brake) koszyk.couponUsed = false;
    }
}
