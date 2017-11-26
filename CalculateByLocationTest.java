import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CalculateByLocationTest {

	@Test
	public void test() {
		ReadAndWriteCSV read = new ReadAndWriteCSV();
		List<Row> listInput = new ArrayList<Row>();  //input csv

		listInput = read.ReadFileIntoList3("C:/Users/Gilad Fuchs/workspace/Ex0/output3.csv");

		List<Row> listOutput = new ArrayList<Row>(); 
		//write the Coordinate  you want
		double lon = 0;//Enter the lon
		double lat = 0;//Enter the lat
		double radius =0;	//Enter the radius				
		CalculateByLocation loc=new CalculateByLocation();
		//send the list and the data the user wrote and set it up
		listOutput = loc.CalculateByLocation1(listInput,listOutput,lon,lat,radius);
		int j=listOutput.size();//check the size after filter
		List<Row> temp = new ArrayList<Row>();

		List<Wifi> element = new ArrayList<Wifi>();//insert first empty line cause the function check from the second line
		Wifi insert=new Wifi("","","","");
		element.add(insert);
		Details general=new Details("","","","","","");
		Row csv = new Row(element,general);
		listOutput.add(0, csv);

		temp= loc.CalculateByLocation1(listOutput,temp,lon,lat,radius);//call the function again
		int k=temp.size();
		assertEquals(j,k);
	}

}
