import static org.junit.Assert.*;

import org.junit.Test;

public class HandGearTest {


  Gear gear = new HandGear("Helmet","Fancy", 0,4);

  //Remaining tests in Abstract Gear class
  //This same test for all child classes
  @Test
  public void combineName() {
    Gear gear1 = new HandGear("Windell","Strong", 0,2);
    Gear newGear = gear.combineName(gear1);
    assertEquals("Strong Windell",newGear.getNoun());
  }
}