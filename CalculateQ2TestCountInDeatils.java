import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CalculateQ2TestCountInDeatils {

	@Test
	public void test() {
		ReadAndWriteCSV read = new ReadAndWriteCSV();
		List<Row> listInput = new ArrayList<Row>();  //input csv

		listInput = read.ReadFileIntoList3("C:/Users/Gilad Fuchs/workspace/Ex0/output3.csv");
		//this function check if the count wifi in Details equal to the num of wifi actually have in the list
		boolean check=true;
	Wifi insert=new Wifi("fssf","gfdd","gfdd","");
	//listInput.get(0).element.add(insert); 
		for (int i = 0; i < listInput.size(); i++) {
			if(listInput.get(i).element.size()!=Integer.parseInt(listInput.get(i).getHead().getCount())){
					check=false;
					System.out.println(i);
		}}
		assertEquals(true, check);
	}

}
