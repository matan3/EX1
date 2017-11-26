import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WriteToKMLTestempty {

	@Test
	public void testempty() {
		List<Row> listInput = new ArrayList<Row>();	
		WriteToKML kml=new WriteToKML();
		kml. createKMLFile(listInput);
		File k = new File("final.kml");
		boolean check=true;
		if(k.isFile()){
			check=false;
		
		}
		assertEquals(true, check);
	}

}
