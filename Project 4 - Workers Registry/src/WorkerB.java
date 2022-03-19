public class WorkerB extends Worker{
    //Type specific variables
    private String deskId;
    private Integer iq;

    public WorkerB(String id, String name, String surname,
                   Integer age, Integer experience, String buildingId,
                   String deskId, Integer iq) {
        super(id, name, surname, age, experience, buildingId);
        this.setDeskId(deskId);
        this.setIq(iq);

    }

    //Type specific setters
    public void setDeskId(String a){
        this.deskId = a;
    }
    public void setExperience(Integer a){
        super.setExperience(a);
        if(this.getIq() >= 70 && this.getIq() <= 150) this.calculateWorth();
    }
    public void setIq(Integer a){
        if(!(a >= 70 && a <= 150)) throw new IllegalArgumentException("Iq has to be in between 70 and 150");
        this.iq = a;
        if (this.getExperience() >= 0) this.calculateWorth();

    }

    //Type specific getters
    public Integer getIq(){
        if(this.iq == null) return 0;
        return this.iq;
    }
    public String getDeskId(){  return this.deskId;}


    //Override worth calculation
    @Override
    public void calculateWorth(){   this.setWorth((double) (this.getExperience() * this.getIq()));}

    public String toString(){
        return "Pracownik "+this.getId()+
                "\n"+this.getName()+" "+this.getSurname()+
                "\nWiek: "+this.getAge()+"\nLata doświadczenia w zawodzie: "+this.getExperience()+
                "\nPrzypisany do biurka "+this.getDeskId()+
                "\nIQ pracownika: "+this.getIq()+
                "\nWartość pracownika w firmie: "+this.getWorth();
    }
}
