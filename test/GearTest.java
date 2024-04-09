import org.junit.Test;

import static org.junit.Assert.*;



public class GearTest {

    Gear g = new HeadGear("Helmet","Fancy", 0,4);

    @Test
    public void testconstructorGear() {
        Gear g = new HeadGear("Helmet","Fancy", 0,4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testinvalidconstructorGear() {
        Gear g = new HeadGear("Helmet","", 0,4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testinvalidconstructoGear() {
        Gear g = new HeadGear("","Fancy", 0,4);
    }


    @Test
    public void getNoun() {
        assertEquals("Helmet",g.getNoun());
    }

    @Test
    public void getAdjective() {
        assertEquals("Fancy",g.getAdjective());
    }

    @Test
    public void getAttack() {
        assertEquals(0,g.getAttack());
    }

    @Test
    public void getDefence() {
        assertEquals(4,g.getDefence());
    }

}