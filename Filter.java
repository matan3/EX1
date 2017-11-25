import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filter {
	
	public List<Row> filter(List<Row> listInput,List<Row> listOutput) throws ParseException 
	{
		Scanner reader = new Scanner(System.in);
		int filter;
		boolean firstTime=true;		
		CopyListToList copy=new CopyListToList();
		
		while(true)
		{
			System.out.println("Filter by: "); 
			System.out.println("Time press 1 , ID press 2 , Location press 3 , Exit press -1");	
			filter = reader.nextInt(); 
			
			if(filter == -1)
			{
				System.out.println("exit loop");				
				break;
			}
			if(!firstTime)  // if its not first time, input became the output and output became new list
			{
				if(!listInput.equals(listOutput)) 
					listInput = copy.CopyListToList1(listOutput);
				listOutput = new ArrayList<Row>();	
			}	
			switch (filter)  
			{
				case 1: {
					//In this case the user need to write the part of time he wants
					System.out.println("Enter the start time   (example:  28/10/2017  20:11:00)");
					String StartDate = reader.next();
					StartDate += reader.nextLine();
					System.out.println("Enter the end time     (example:  28/10/2017  20:32:00)");
					String EndDate = reader.next();	
					EndDate += reader.nextLine();	
					CalculateByTime time=new CalculateByTime();
					//send the list and the data the user wrote and set it up
					listOutput = time.CalculateByTime1(listInput,listOutput,StartDate,EndDate);
					break;
				}
				case 2: {
					//In this case the user need to write the name of id he wants
					System.out.println("Enter the ID");
					String ID = reader.next();					
					ID += reader.nextLine();
					CalculateByID id=new CalculateByID();
					//send the list and the data the user wrote and set it up
					listOutput =id.CalculateByID1(listInput,listOutput,ID);
					break;
				}
				case 3: {
					//In this case the user need to write the coordinate   he wants
					System.out.println("Enter the lon");
					double lon = reader.nextDouble();
					System.out.println("Enter the lat");
					double lat = reader.nextDouble();
					System.out.println("Enter the radius");
					double radius = reader.nextDouble();					
					CalculateByLocation loc=new CalculateByLocation();
					//send the list and the data the user wrote and set it up
					listOutput = loc.CalculateByLocation1(listInput,listOutput,lon,lat,radius);
					break;
				}
				default:
					System.out.println("please enter valid number");
			}					
			firstTime = false;									
			System.out.println();
		}				
		reader.close();			
		//ReadAndWriteCSV write = new ReadAndWriteCSV();
		//write.WriteListIntoFile(listOutput,"C:/output3.csv");	
		return listOutput;	
	}


}
