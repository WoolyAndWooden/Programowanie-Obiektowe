public class WorkerF extends Worker{
    //Type specific variables
    private Integer strength;

    public WorkerF(String id, String name, String surname,
                   Integer age, Integer experience, String buildingId,
                   Integer strength) {
        super(id, name, surname, age, experience, buildingId);
        this.setStrength(strength);

    }

    //Type specific setters
    public void setStrength(Integer a){
        if(!(a > 0 && a <= 100)) throw new IllegalArgumentException("Strength has to be in between 1 and 100");
        this.strength = a;
        if (this.getExperience() >= 0 && this.getAge() >= 18) this.calculateWorth();
    }
    public void setAge(Integer a){
        super.setAge(a);
        if((this.getStrength() > 0 && this.getStrength() <= 100) && this.getExperience() > 0) this.calculateWorth();
    }
    public void setExperience(Integer a){
        super.setExperience(a);
        if((this.getStrength() > 0 && this.getStrength() <= 100) && this.getAge() >= 18) this.calculateWorth();
    }

    //Type specific getters
    public Integer getStrength(){
        if(this.strength == null) return 0;
        return this.strength;
    }


    //Override worth calculation
    @Override
    public void calculateWorth(){   this.setWorth((double) (this.getExperience() * (this.getStrength() / this.getAge())));}

    public String toString() {
        return "Pracownik " + this.getId() +
                "\n" + this.getName() + " " + this.getSurname() +
                "\nWiek: " + this.getAge() + "\nLata doświadczenia w zawodzie: " + this.getExperience() +
                "\nSiła fizyczna pracownika: " + this.getStrength() +
                "\nWartość pracownika w firmie: " + this.getWorth();
    }

}
