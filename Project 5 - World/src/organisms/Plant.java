package organisms;

import world.World;

abstract class Plant extends Organism{
    public Plant(int positionx, int positiony){
        super(positionx, positiony);
    }

    @Override
    void beingEatenConsequences(Organism attackingOrganism){
        attackingOrganism.incPower(1);
        this.setAlive(false);
    }
}
