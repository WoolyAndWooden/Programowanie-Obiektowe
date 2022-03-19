public class Worker {
    //Variables
    private String id;
    private String name;
    private String surname;
    private Integer age;
    private Integer experience;
    private Double worth;
    private String buildingId;


    //Construct
    public Worker(String id, String name, String surname,
                  Integer age, Integer experience, String buildingId){
        //if(Registry.WorkersIds.contains(id)) throw new IllegalArgumentException("Worker with this Id already exists");
        //if(id.charAt(0) != 'B' || id.charAt(0) != 'F' || id.charAt(0) != 'H') throw new IllegalArgumentException("No such type of worker");
        this.setId(id);
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.setExperience(experience);
        this.setBuildingId(buildingId);
    }


    //Setters
    public void setId(String a){        this.id = a;}
    public void setName(String a){      this.name = a;}
    public void setSurname(String a){   this.surname = a;}
    public void setExperience(Integer a){
        if(a < 0) throw new IllegalArgumentException("Can't have negative experience");
        this.experience = a;
    }
    public void setAge(Integer a){
        if(a < 18) throw new IllegalArgumentException("Worker can't be younger than 18 yo");
        this.age = a;
    }
    public void setWorth(Double a){         this.worth = a;}
    public void setBuildingId(String a){    this.buildingId = a;}


    //Getters
    public String getId(){          return this.id;}
    public String getName(){        return this.name;}
    public String getSurname(){     return this.surname;}
    public Integer getExperience(){     return this.experience;}
    public Integer getAge(){            return this.age;}
    public Double getWorth(){       return this.worth;}
    public String getBuildingId(){  return this.buildingId;}


    //To override
    public void calculateWorth(){   this.setWorth(-1.0);}
}
