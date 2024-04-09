/*
HandGear class to keep track of player handgear
 */
public class HandGear extends Gear{

    //HandGear constructor
    public HandGear(String gearNoun, String gearAdjective, int gearAttack, int gearDefence) {
        super(gearNoun, gearAdjective, gearAttack, gearDefence);

    }

    /*
    Method to combine name and adjective
    if the player pick gear of same type
     */

    @Override
    public Gear combineName(Gear g) throws IllegalArgumentException{
        if(!(g instanceof HandGear)){
            throw new IllegalArgumentException("Gear not matching");
        }

        Gear gc = new HandGear(g.getAdjective()+" "+g.getNoun(), this.gearAdjective, g.getAttack() + this.getAttack(), g.getDefence() + this.getDefence());
        return gc;
    }

}
