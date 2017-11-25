import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class findMinSignalTest {

	@Test
	public void test() {
		findMinSignal f=new findMinSignal();
		
		int k=-10;
		
			List<Wifi> element = new ArrayList<Wifi>();
			for (int j = 0; j < 10; j++) {	
		Wifi insert=new Wifi("fssf","gfdd","gfdd",""+k);
		element.add(insert);
		k-=10;
			}
		int minSignalIndex =f.findMinSignal1(element);
		assertEquals(0, minSignalIndex);
	}

}
