import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        Player p1 = new Player(0,0);
        Player p2 = new Player(0,0);

        HeadGear headGear1 = new HeadGear("Crown","Firefly",0,4);
        HeadGear headGear2 = new HeadGear("Helmet","Shining",0,6);
        HandGear handGear1 = new HandGear("Gloves","Titanium",8,0);
        HandGear handGear2 = new HandGear("WGloves","Peace",4,0);
        HandGear handGear3 = new HandGear("Mittens","Flaming",15,0);
        HandGear handGear4 = new HandGear("HandWarmers","Colorful",4,0);
        HandGear handGear5 = new HandGear("Palmers","Sparkly",9,0);
        FootGear footGear1 = new FootGear("Spikes", "Sharp", 9,3);
        FootGear footGear2 = new FootGear("Shoes", "Comfortable", 20,2);
        FootGear footGear3 = new FootGear("Chappal", "Simple", 12,1);
        FootGear footGear4 = new FootGear("Boots", "Warm", 3,8);
        FootGear footGear5 = new FootGear("RShoes", "Flying", 3,8);

        List<Gear> g = new ArrayList<>();
        g.add(headGear1);
        g.add(headGear2);
        g.add(handGear1);
        g.add(handGear2);
        g.add(handGear3);
        g.add(handGear4);
        g.add(handGear5);
        g.add(footGear1);
        g.add(footGear2);
        g.add(footGear3);
        g.add(footGear4);
        g.add(footGear5);

//        g.add(new HeadGear("helmet1", "asdf1", 0,4));
//        g.add(new HeadGear("helmet2", "asdf2", 0,5));
//        g.add(new HandGear("hand1", "blah1", 6,4));
//        g.add(new HandGear("hand2", "bals2", 8,3));
//        g.add(new HandGear("hand3", "blah1", 2,4));
//        g.add(new HandGear("hand4", "bals2", 3,3));
//        g.add(new FootGear("f1", "blah1", 9,3));
//        g.add(new FootGear("f2", "bals2", 20,2));
//        g.add(new FootGear("f3", "blah1", 12,1));
//        g.add(new FootGear("f4", "bals2", 3,8));
//        g.add(new HeadGear("helmet1", "asdf1", 0,0));
//        g.add(new HeadGear("helmet2", "asdf2", 0,0));
//        g.add(new HandGear("hand1", "blah1", 0,0));
//        g.add(new HandGear("hand2", "bals2", 0,0));
//        g.add(new HandGear("hand3", "blah1", 0,0));
//        g.add(new HandGear("hand4", "bals2", 0,0));
//        g.add(new FootGear("f1", "blah1", 0,0));
//        g.add(new FootGear("f2", "bals2", 0,0));
//        g.add(new FootGear("f3", "blah1", 0,0));
//        g.add(new FootGear("f4", "bals2", 0,0));
//        g.add(new FootGear("f45", "blah1", 0,0));
//        g.add(new FootGear("f46", "bals2", 0,0));
//        g.add(new FootGear("f3454", "blah1", 0,0));
//        g.add(new FootGear("f64", "bals2", 0,0));





        //Game g = new Game(p1,p2, List.of(headGear1,headGear2,handGear1,handGear2,handGear3,handGear4,footGear1,footGear2,footGear3,footGear4));
        Game g1 = new Game(p1,p2,g);
        g1.pickGearItems();


    }
}