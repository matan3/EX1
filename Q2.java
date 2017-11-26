import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Q2 
{
			
	public boolean ReadDir(String dirPath,String destination) // read files from directory
	{
		File folder = new File(dirPath);
		File[] listOfFiles = folder.listFiles();

		List<Spot> listInput = new ArrayList<Spot>();  //input csv
		List<Row> listOutput = new ArrayList<Row>();   //output csv	
				
		ReadAndWriteCSV read = new ReadAndWriteCSV();
		ReadAndWriteCSV write = new ReadAndWriteCSV();
		CalculateQ2 C = new CalculateQ2();
		
		for (File file : listOfFiles) 
		{
			if (file.isFile() && file.getName().endsWith("csv"))
			{
				listInput = read.ReadFileIntoList2(file.getPath()); // read file into List				
				if(!(listInput.isEmpty()))
					C.Calculate(listInput,listOutput);          // creates the output from the input
			}
		}	
		if(listOutput.isEmpty())
			return false;
		else{
			write.WriteListIntoFile(listOutput,destination);
			return true;
		}

	}
	
	

}