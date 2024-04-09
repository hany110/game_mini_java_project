/*
Abstract Gear class to keep track of each gear and its properties
 */
public abstract class Gear implements IGear{
    //instance variables
    protected String gearNoun;
    protected String gearAdjective;
    protected int gearAttack;
    protected int gearDefence;


    //Gear constructor
    public Gear(String gearNoun, String gearAdjective, int gearAttack, int gearDefence)
    {
        this.gearNoun = gearNoun;
        this.gearAdjective = gearAdjective;
        this.gearAttack = gearAttack;
        this.gearDefence = gearDefence;

        if(gearNoun.isEmpty() || gearNoun == null)
        {
            throw new IllegalArgumentException("Gear Noun cannot be Empty or null");
        }
        if(gearAdjective.isEmpty() || gearAdjective == null)
        {
            throw new IllegalArgumentException("Gear Adjective cannot be Empty or null");
        }
    }

    /*
    Method to get the noun of a gear
     */
    @Override
    public String getNoun() {
        return this.gearNoun;
    }

    /*
    Method to get the adjective of a gear
     */
    @Override
    public String getAdjective() {
        return this.gearAdjective;
    }

    /*
    Method to get the attack strength of a gear
     */
    @Override
    public int getAttack() {
        return this.gearAttack;
    }

    /*
    Method to get the defence strength of a gear
     */
    @Override
    public int getDefence() {
        return this.gearDefence;
    }

    /*
    Abstract method to combine the names of the gears of same type
     */
    public abstract Gear combineName(Gear g);

}
