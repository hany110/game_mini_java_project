/*
FootGear class to keep track of player footgear
 */
public class FootGear extends Gear{

    //Footgear constructor
    public FootGear(String gearNoun, String gearAdjective, int gearAttack, int gearDefence) {
        super(gearNoun, gearAdjective, gearAttack, gearDefence);

    }


    /*
    Method to combine name and adjective
    if the player pick gear of same type
     */
    @Override
    public Gear combineName(Gear g) throws IllegalArgumentException{
        if(!(g instanceof FootGear)){
            throw new IllegalArgumentException("Gear not matching");
        }
        Gear gc = new FootGear(g.getAdjective()+" "+g.getNoun(), this.gearAdjective, g.getAttack() + this.getAttack(), g.getDefence() + this.getDefence());
        return gc;
    }


}


