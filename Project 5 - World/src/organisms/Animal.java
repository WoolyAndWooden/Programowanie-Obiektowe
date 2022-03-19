package organisms;

import world.World;

abstract class Animal extends Organism{
    public Animal(int positionx, int positiony) {
        super(positionx, positiony);
    }

    @Override
    void beingEatenConsequences(Organism attackingOrganism) {
        if (this.getPower() < attackingOrganism.getPower()){
            attackingOrganism.incPower(1);
            this.setAlive(false);
        }
        else if (this.getPower() == attackingOrganism.getPower()) {
            this.setPower(this.getPower() / 2);
            attackingOrganism.setPower(attackingOrganism.getPower() / 2);
        }
    }
}
