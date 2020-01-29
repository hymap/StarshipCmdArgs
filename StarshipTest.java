package excercise;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class StarshipTest {
	
	@Test
	public void fromArgsTest() {
		Starship s = Starship.fromArgs(new String[] { "--shields", "7", "--warp", "5.2", "--crew", "kirk,uhura,mccoy" });
		        
		assertEquals(5.2, s.getWarp(), 0);
	    assertEquals(false, s.isCloak());
	    assertEquals(7, s.getShields());
	    assertEquals(3, s.getCrew().size());
	   
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void fromArgsexceptionTest() {
		 Starship s = Starship.fromArgs(new String[] { "--shields", "0", "--warp", "2.0", "--crew", "kirk,uhura,mccoy" });
		   
		 assertEquals(2, s.getWarp(), 0);
		 assertEquals(false, s.isCloak());
		 //assertEquals("IllegalArgumentException.class", s.getShields());
		 assertEquals(3, s.getCrew().size());
	}

}

