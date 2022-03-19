package organisms;

abstract class Carnivore extends Animal{

    public Carnivore(int positionx, int positiony) {
        super(positionx, positiony);
    }

    @Override
    void eat(Organism eatenOrganism){
        if(eatenOrganism instanceof Animal & this.getSign() != eatenOrganism.getSign()){
            eatenOrganism.beingEatenConsequences(this);
        }
    }
}
