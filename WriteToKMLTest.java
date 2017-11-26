import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WriteToKMLTest {

	@Test
	public void testcreate() {
		List<Row> listInput = new ArrayList<Row>();	
			List<Wifi> element = new ArrayList<Wifi>();	
		Wifi insert=new Wifi("","aa","","");
		element.add(insert);		
		Details general=new Details("2017-10-27 16:35:58","34.80987434","32.16767714","","","");
		Row csv = new Row(element,general);
		listInput.add(csv);
		WriteToKML kml=new WriteToKML();
		kml. createKMLFile(listInput);
		File k = new File("final.kml");
		boolean check=false;
		if(k.isFile()){
			check=true;
		
		}
		assertEquals(true, check);
	}
	}

