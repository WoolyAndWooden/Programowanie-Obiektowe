package organisms;

import world.World;

public class Grass extends Plant{

    public Grass(int positionx, int positiony) {
        super(positionx, positiony);
    }

    @Override
    void move() {

    }

    @Override
    void action() {

    }

    @Override
    void initParams() {
        this.setPower(0);
        this.setInitiative(0);
        this.setLiveLength(6);
        this.setPowerToReproduce(3);
        this.setSign('G');
    }

    @Override
    void reproduce() {

    }

    @Override
    void eat(Organism eatenOrganism) {

    }


}
