import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Random;


/*
Player class, with methods and variables associated with player
 */

public class Player {

    //instance variable

    //default attack and defence value
    private int baseAttack;
    private int baseDefence;

    private int attack;
    private int defence;

    private List<Gear> headGear = new ArrayList<>();
    private List<Gear> handGear = new ArrayList<>();
    private List<Gear> footGear = new ArrayList<>();
    private List<Gear> itemList = new ArrayList<>();
    private HashMap<String, Type> instanceMap = new HashMap<>();

    //static variables
    //Max counts of each gear for each player
    protected static final int HEAD_COUNT = 1;
    protected static final int HAND_COUNT = 2;
    protected static final int FOOT_COUNT = 2;
    private int headGearCount;
    private int handGearCount;
    private int footwearCount;


    //Player constructor with default attack and defence value
    public Player(int attack, int defence) {
        this.baseAttack = attack; //store base attack value
        this.baseDefence = defence; //store base defence value

        this.attack = attack;
        this.defence = defence;

        this.headGearCount = 0;
        this.handGearCount = 0;
        this.footwearCount = 0;

        instanceMap.put("HeadGear", HeadGear.class);
        instanceMap.put("HandGear", HandGear.class);
        instanceMap.put("FootGear", FootGear.class);

    }


    /*
    Method to keep track of available slots for each gear
     */
    private HashMap<String, Integer> getAvailableSlots() {
        HashMap<String, Integer> itemMap = new HashMap<>();

        itemMap.put("HeadGear", this.HEAD_COUNT - this.headGearCount);
        itemMap.put("HandGear", this.HAND_COUNT - this.handGearCount);
        itemMap.put("FootGear", this.FOOT_COUNT - this.footwearCount);

        return itemMap;

    }

    /*
    Method to select gear from the gearlist, based on the given selection criteria
     */
    public Gear addGear(List<Gear> gears) throws IllegalArgumentException{
        Gear selectedGear = null;

        if(gears.size()==0){
            throw new IllegalArgumentException("Adding Failed");
        }

        //type of gear: available slots
        HashMap<String, Integer> gearCounts = this.getAvailableSlots();

        HashMap<Type, Gear> typeMap = new HashMap<>();

        for (String key : gearCounts.keySet()) {
            //loop through all available gear types
            if (gearCounts.get(key) > 0) {

                Type gearType = this.instanceMap.get(key);
                for (Gear g : gears) {
                    if (g.getClass() == gearType) {
                        if (typeMap.containsKey(g.getClass())) {
                            int attackStrength = typeMap.get(g.getClass()).getAttack();
                            if (g.getAttack() > attackStrength) {
                                typeMap.put(g.getClass(), g);

                            } else if (g.getAttack() == attackStrength) {
                                int defenceStrength = typeMap.get(g.getClass()).getDefence();
                                if (g.getDefence() > defenceStrength) {
                                    typeMap.put(g.getClass(), g);
                                } else if (g.getDefence() == defenceStrength) {
                                    Random random = new Random();
                                    List<Gear> gearRandom = List.of(typeMap.get(g.getClass()), g);
                                    Gear randomGear = gearRandom.get(random.nextInt(gearRandom.size()));
                                    typeMap.put(randomGear.getClass(), randomGear);
                                }
                            }
                        } else {
                            typeMap.put(g.getClass(), g);
                        }
                    }
                }

            }

        }
        if (typeMap.isEmpty()) {
            selectedGear = selectGear(gears);
            addPowers(selectedGear.getAttack(), selectedGear.getDefence());
            gearFullHelper(selectedGear);
        } else {
            selectedGear = selectGear(typeMap);
            addPowers(selectedGear.getAttack(), selectedGear.getDefence());
            gearHelper(selectedGear);
        }

        return selectedGear;
    }

    /*
    Method to get the class instance of the selected gear type
    and add the selected gear into gear list.
    We also call the combinedGear method to join the name and adjective of gears of similar type
     */
    private void gearFullHelper(Gear selectedGear) {
        if (selectedGear instanceof HeadGear) {

            Gear combinedGear = selectedGear.combineName(headGear.get(0));
            itemList.remove(headGear.get(0));
            headGear.remove(headGear.get(0));
            headGear.add(combinedGear);
            itemList.add(combinedGear);

        } else if (selectedGear instanceof HandGear) {

            Gear combinedGear = selectedGear.combineName(handGear.get(0));
            itemList.remove(handGear.get(0));
            handGear.remove(handGear.get(0));
            handGear.add(combinedGear);
            itemList.add(combinedGear);

        } else if (selectedGear instanceof FootGear) {

            Gear combinedGear = selectedGear.combineName(footGear.get(0));
            itemList.remove(footGear.get(0));
            footGear.remove(footGear.get(0));
            footGear.add(combinedGear);
            itemList.add(combinedGear);
        }
    }

    /*
    Method to get class instance of selected gear type,
    add them to the list and increment the gear counter
     */
    private void gearHelper(Gear selectedGear) {
        if (selectedGear instanceof HeadGear) {
            headGearCount += 1;

            headGear.add(selectedGear);
            itemList.add(selectedGear);

        } else if (selectedGear instanceof HandGear) {
            handGearCount += 1;
            handGear.add(selectedGear);
            itemList.add(selectedGear);
        } else if (selectedGear instanceof FootGear) {
            footwearCount += 1;
            footGear.add(selectedGear);
            itemList.add(selectedGear);
        } else {
            throw new IllegalArgumentException("No gear picked!!");
        }
    }

    /*
    Method to get the best gear from the best of 3 types of gears(typeMap)
    from the Hashmap
     */
    private Gear selectGear(HashMap<Type, Gear> typeMap) {
        Gear selectedGear = null;

        for (Gear g : typeMap.values()) {
            if (selectedGear == null) {
                selectedGear = g;
            } else if (selectedGear.getAttack() < g.getAttack()) {
                selectedGear = g;
            } else if (selectedGear.getAttack() == g.getAttack()) {
                if (selectedGear.getDefence() < g.getDefence()) {
                    selectedGear = g;
                } else if (selectedGear.getDefence() == g.getDefence()) {
                    Random r = new Random();
                    List<Gear> gearRandom = List.of(selectedGear, g);
                    Gear randomGear = gearRandom.get(r.nextInt(gearRandom.size()));
                    selectedGear = randomGear;

                }
            }

        }
        return selectedGear;

    }

    /*
    Method to get the best gear from the gear list
     */

    private Gear selectGear(List<Gear> gears) {
        Gear selectedGear = null;
        for (Gear g : gears) {
            if (selectedGear == null) {
                selectedGear = g;
            } else if (selectedGear.getAttack() < g.getAttack()) {
                selectedGear = g;

            } else if (selectedGear.getAttack() == g.getAttack()) {
                if (selectedGear.getDefence() < g.getDefence()) {
                    selectedGear = g;
                } else if (selectedGear.getDefence() == g.getDefence()) {
                    Random r = new Random();
                    List<Gear> gearRandom = List.of(selectedGear, g);
                    Gear randomGear = gearRandom.get(r.nextInt(gearRandom.size()));
                    selectedGear = randomGear;

                }
            }

        }

        return selectedGear;

    }

    /*
    Method to get gear description for the gears of each player
     */

    public String getGearDescription(List<Gear> itemList) throws IllegalArgumentException{
        if(itemList.size() == 0){
            throw new IllegalArgumentException("Nothing to print in player gear list");
        }
        String returnString = "";
        for (Gear o : itemList) {
            returnString += o.getAdjective()+" "+ o.getNoun() + "\n";

        }
        return returnString;
    }


    /*
    Method to get attack strength of a player
     */
    public int getAttack() {
        return this.attack;
    }

    /*
    Method to get defence strength of a player
     */
    public int getDefence() {
        return this.defence;
    }

    /*
    Method to get inital attack strength of a player
     */
    public int getInitialAttack() {
        return this.baseAttack;
    }

    /*
    Method to get initial defence strength of a player
     */
    public int getInitialDefence() {
        return this.baseDefence;
    }


    /*
    Method to update the attack and defence strength of the player
    based on the new gear added
     */
    private void addPowers(int attack, int defence) {
        this.attack += attack;
        this.defence += defence;
    }


}