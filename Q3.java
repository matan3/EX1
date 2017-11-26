import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Q3 {
	
	
	public void ReadFile(String srcPath) throws ParseException
	{
		File file = new File(srcPath);		
		ReadAndWriteCSV read = new ReadAndWriteCSV();
		
		List<Row> listInput = new ArrayList<Row>();  //input csv
		listInput = read.ReadFileIntoList3(file.getPath());
		List<Row> listOutput = new ArrayList<Row>();  //output csv		
				
		if(!listInput.isEmpty()){
			System.out.println("-------");
			Filter f = new Filter();
			listOutput = f.filter(listInput,listOutput);	
		}
		
		
		
		//write the kml file		
		WriteToKML kml=new WriteToKML();
		kml. createKMLFile(listOutput);
	}

	
}
