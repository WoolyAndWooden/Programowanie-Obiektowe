package organisms;

abstract class Herbivore extends Animal{

    public Herbivore(int positionx, int positiony) {
        super(positionx, positiony);
    }

    @Override
    void eat(Organism eatenOrganism){
        if(eatenOrganism instanceof Plant){
            eatenOrganism.beingEatenConsequences(this);
        }
    }

    @Override
    void beingEatenConsequences(Organism attackingOrganism) {
        if (this.getPower() <= attackingOrganism.getPower()){
            attackingOrganism.incPower(1);
            this.setAlive(false);
        }
    }
}
