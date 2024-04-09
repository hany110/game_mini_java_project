import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {

    Player p1 = new Player(5, 3);
    Player p2 = new Player(10, 6);
    List<Gear> gearList = new ArrayList<>();  //gearList
    List<Gear> gearList2 = new ArrayList<>();  //gearList
    List<Gear> pl1 = new ArrayList<>();  //player 1 gearList



    @Before
    public void setUpClass() {

        HeadGear headGear1 = new HeadGear("Crown","Firefly",0,4);
        HeadGear headGear2 = new HeadGear("Helmet","Shining",0,6);
        HandGear handGear1 = new HandGear("Gloves","Titanium",8,0);
        HandGear handGear2 = new HandGear("WGloves","Peace",4,0);
        HandGear handGear3 = new HandGear("Mittens","Flaming",15,0);
        HandGear handGear4 = new HandGear("HandWarmers","Colorful",4,0);
        FootGear footGear1 = new FootGear("Spikes", "Sharp", 9,3);
        FootGear footGear2 = new FootGear("Shoes", "Comfortable", 20,2);
        FootGear footGear3 = new FootGear("Chappal", "Simple", 12,1);
        FootGear footGear4 = new FootGear("Boots", "Warm", 3,8);

        gearList.add(headGear1);
        gearList.add(headGear2);
        gearList.add(handGear1);
        gearList.add(handGear2);
        gearList.add(handGear3);
        gearList.add(handGear4);
        gearList.add(footGear1);
        gearList.add(footGear2);
        gearList.add(footGear3);
        gearList.add(footGear4);


        pl1.add(footGear3);

    }



    @Test
    public void addGear() {
        Gear best_gear = p1.addGear(gearList);
        assertEquals("Shoes", best_gear.getNoun());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addGearIllegal() {
        Gear best_gear = p1.addGear(gearList2);
    }


    @Test
    public void getGearDescription() {
        assertEquals("Simple Chappal" + "\n", p1.getGearDescription(pl1));
    }

    //returns the base attack of the player in game
    @Test
    public void getBaseAttack() {
        assertEquals(5, p1.getInitialAttack());
    }

    //returns the base defence of the player in game
    @Test
    public void getBaseDefence() {
        assertEquals(3, p1.getInitialDefence());
    }

    //returns the current attack of the player in game
    @Test
    public void getAttack() {
        Gear best_gear = p1.addGear(gearList);
        System.out.println(best_gear.getAttack());
        assertEquals(25, p1.getAttack());
    }

    //returns the current defence of the player in game
    @Test
    public void getDefence() {
        Gear best_gear = p1.addGear(gearList);
        System.out.println(best_gear.getDefence());
        assertEquals(5, p1.getDefence());
    }



}