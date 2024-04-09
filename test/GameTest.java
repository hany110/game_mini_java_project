import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {

    Player p1 = new Player(5, 3);
    Player p2 = new Player(10, 6);
    List<Gear> gearList = new ArrayList<>();  //gearList


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

    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor()
    {
        gearList.remove(0);
        Game game = new Game(p1,p2, gearList);
    }

    @Test
    public void pickGearItemsss()
    {
        Game game = new Game(p1,p2, gearList);
        assertEquals("Player 2 wins",game.pickGearItems());
    }

    @Test
    public void pickGearItems_v2()
    {

        Player p3 = new Player(30, 20);

        HeadGear headGear21 = new HeadGear("Tiara","Dark",0,8);
        HandGear handGear31 = new HandGear("Glove","Bright",23,0);
        FootGear footGear31 = new FootGear("Slider", "Cool", 9,5);
        FootGear footGear41 = new FootGear("totalfoot", "Smart", 7,2);

        gearList.add(headGear21);
        gearList.add(handGear31);
        gearList.add(footGear31);
        gearList.add(footGear41);

        Game game = new Game(p1,p3, gearList);
        assertEquals("Player 2 wins",game.pickGearItems());
    }

    @After //runs after every test
    public void Re_up(){
        Player p1 = new Player(5, 3);
        Player p2 = new Player(10, 6);
        List<Gear> gl = new ArrayList<>();  //gearList
    }


}
