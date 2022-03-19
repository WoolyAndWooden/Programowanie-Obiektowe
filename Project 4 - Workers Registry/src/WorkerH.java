public class WorkerH extends Worker{
    //Type specific variables
    private Efficiency efficiency;
    private Double fee;

    public WorkerH(String id, String name, String surname,
                   Integer age, Integer experience, String buildingId,
                   Efficiency efficiency, Double fee) {
        super(id, name, surname, age, experience, buildingId);
        this.setEfficiency(efficiency);
        this.setFee(fee);
    }

    //Type specific setters
    public void setEfficiency(Efficiency a){
        this.efficiency = a;
        if(this.getFee() >= 0 && this.getExperience() >= 0) this.calculateWorth();
    }
    public void setExperience(Integer a){
        super.setExperience(a);
        if(this.getFee() >= 0 && this.getEfficiency() != null) this.calculateWorth();
    }
    public void setFee(Double a){
        if(!(a >= 0)) throw new IllegalArgumentException("Fee can't be negative");
        this.fee = a;
        if (this.getExperience() >= 0 && this.getEfficiency() != null) this.calculateWorth();

    }

    //Type specific getters
    public Double getFee(){
        if(this.fee == null) return 0.0;
        return this.fee;
    }
    public Efficiency getEfficiency(){  return this.efficiency;}


    //Override worth calculation
    @Override
    public void calculateWorth(){   this.setWorth((double) (this.getExperience() * this.getEfficiency().getEfficiency()));}

    public String toString(){
        return "Pracownik "+this.getId()+
                "\n"+this.getName()+" "+this.getSurname()+
                "\nWiek: "+this.getAge()+"\nLata doświadczenia w zawodzie: "+this.getExperience()+
                "\nSkuteczność pracownika: "+this.getEfficiency().getEfficiencyKind()+
                "\nMarża pracownika: "+this.getFee()+
                "\nWartość pracownika w firmie: "+this.getWorth();
    }
}
