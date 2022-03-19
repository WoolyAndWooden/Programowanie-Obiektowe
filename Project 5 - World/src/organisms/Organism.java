package organisms;

abstract public class Organism {
    private int power;
    private int[] position;
    private int initiative;
    private int liveLength;
    private int powerToReproduce;
    private char sign;
    private boolean alive;
    private int movRange;
    private int reproducementRange;

    public Organism(int positionx, int positiony){
        this.setPosition(positionx, positiony);
        this.setAlive(true);
        this.initParams();
    }

    //setters
    public void setPower(int n){           this.power = n;}
    public void setPosition(int x, int y){ this.position = new int[] {x, y};}
    public void setInitiative(int n){      this.initiative = n;}
    public void setLiveLength(int n){      this.liveLength = n;}
    public void setPowerToReproduce(int n){this.powerToReproduce = n;}
    public void setSign(char n){           this.sign = n;}
    public void setAlive(boolean n){       this.alive = n;}
    public void setMovRange(int n){        this.movRange = n;}
    public void setReproducementRange(int n){this.reproducementRange = n;}
    public void incPower(int n){            this.power+=n;}
    //getters
    public int getPower(){                 return this.power;}
    public int[] getPosition(){            return this.position;}
    public int getInitiative(){            return this.initiative;}
    public int getLiveLength(){            return this.liveLength;}
    public int getPowerToReproduce(){      return this.powerToReproduce;}
    public char getSign(){                 return this.sign;}
    public boolean getAlive(){             return this.alive;}
    public int getMovRange(){              return this.movRange;}
    public int getReproducementRange(){    return this.reproducementRange;}

    //Actions of organisms
    abstract void move();
    abstract void action();
    abstract void initParams();
    abstract void reproduce();
    abstract void eat(Organism eatenOrganism);


    public boolean canReproduce(){        return this.getPower() >= this.getPowerToReproduce();}

    abstract void beingEatenConsequences(Organism attackingOrganism);
}
