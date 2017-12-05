import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CalculateByIDTest {0000

	@Test
	public void test() {
		//check if it's insert id only by the Id request
		ReadAndWriteCSV read = new ReadAndWriteCSV();
		List<Row> listInput = new ArrayList<Row>();  //input csv

		listInput = read.ReadFileIntoList3("C:/Users/Gilad Fuchs/workspace/Ex0/output3.csv");
		CalculateByID id=new CalculateByID();
		List<Row> listOutput = new ArrayList<Row>(); 
		String ID="model=Lenovo PB2-690Y";//write the Id you want
		listOutput =id.CalculateByID1(listInput,listOutput,ID);//call the function and filter it
		int j=listOutput.size();//check the size after filter
		List<Row> temp = new ArrayList<Row>();
		temp=id.CalculateByID1(listOutput,temp,ID);//call the function again
		int k=temp.size();
		if(listOutput.get(0).getHead().getID().equals(ID))//check the first line cause usal it's only the content
			k++;
		assertEquals(j,k);
		
		
	}

}
