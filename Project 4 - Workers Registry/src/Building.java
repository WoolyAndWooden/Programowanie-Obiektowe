import java.util.ArrayList;

public class Building {
    private String buildingId;
    private String cityName;
    private String streetName;
    private Integer numBuilding;
    private Integer numHouse;


    //Constructor
    public Building(String buildingId, String cityName, String streetName,
                    Integer numBuilding, Integer numHouse){
        if(Registry.BuildingsId.contains(buildingId)) throw new IllegalArgumentException("This building already exists in registry");
        this.setBuildingId(buildingId);
        this.setCityName(cityName);
        this.setStreetName(streetName);
        this.setNumBuilding(numBuilding);
        this.setNumHouse(numHouse);
    }
    //Setters
    public void setBuildingId(String a){    this.buildingId = a;}
    public void setCityName(String a){      this.cityName = a;}
    public void setStreetName(String a){    this.streetName = a;}
    public void setNumBuilding(Integer a){
        if(a < 1) throw new IllegalArgumentException("Building number must be 1 or higher");
        this.numBuilding = a;
    }
    public void setNumHouse(Integer a){
        if(a < 1) throw new IllegalArgumentException("House number must be 1 or higher");
        this.numHouse = a;
    }


    //Getters
    public String getBuildingId(){  return this.buildingId;}
    public String getCityName(){    return this.cityName;}
    public String getStreetName(){  return this.streetName;}
    public Integer getNumBuilding(){    return this.numBuilding;}
    public Integer getNumHouse(){       return this.numHouse;}

}
