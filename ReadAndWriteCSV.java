import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteCSV {
	
	public List<Spot> ReadFileIntoList2(String filePath)   //for Q2
	{
		List<Spot> listInput = new ArrayList<Spot>();	
				
		Scanner scan = null;
		File file = new File(filePath);
	    try{
	    	 scan = new Scanner(file);}	    
	    catch(FileNotFoundException e){
	        System.out.println(e.getMessage());}
	    	    
	    
	    String input = scan.nextLine();  // read head line
	    String[] temp = input.split(",");
	    if(!(temp[0].equals("WigleWifi-1.4")))  // check if its WigleWifi csv file
	    {
	    	System.out.println("The file isnt WigleWifi file");
	    	return listInput;	
	    }
	    
	    String ID = temp[2].substring(6);
        input = scan.nextLine(); // skip second line
 
        input = scan.nextLine();
        temp = input.split(",");
        if(temp[0].equals(""))   // check if the first line is empty
        {	
        	System.out.println("The file is empty");
        	return listInput;
        }
        Spot spot=new Spot(input,ID);      
        listInput.add(spot);	 
        
	    while(scan.hasNext())    // read all lines
	    {
	        input = scan.nextLine();
	        spot=new Spot(input,ID);      
	        listInput.add(spot);	         	               	        
	    }	   
	    scan.close();
	   
	    return listInput;	   
	}
	
	public List<Row> ReadFileIntoList3(String filePath)   //for Q3
	{
		List<Row> listInput = new ArrayList<Row>();	
				
		Scanner scan = null;
		File file = new File(filePath);
	    try{
	    	 scan = new Scanner(file);}	    
	    catch(FileNotFoundException e){
	        System.out.println(e.getMessage());}
	    	  
	    String input = scan.nextLine(); // skip head line
         
	    input = scan.nextLine();
        String[] temp = input.split(",");
        if(temp[0].equals(""))   // check if the first line is empty
        {	
        	System.out.println("The file is empty");
        	return listInput;
        }
        
	    while(scan.hasNext())    // read all lines
	    {
	        input = scan.nextLine();
	        temp = input.split(",");
	        List<Wifi> element = new ArrayList<Wifi>();
	        int count = Integer.parseInt(temp[5]);
	        int j = 6;
	        for(int i=0;i<count;i++){
	        	Wifi insert=new Wifi(temp[j+1],temp[j],temp[j+2],temp[j+3]);
				element.add(insert);
				j += 4;
	        }	        	
	        Details general=new Details(temp[0],temp[2],temp[3],temp[4],temp[1],temp[5]);        
	        Row row=new Row(element,general);      
	        listInput.add(row);	         	               	        
	    }	   
	    scan.close();	   
	    return listInput;	   
	}
	
	public void WriteListIntoFile(List<Row> listOutput,String destination)  //  write to csv
	{
		try{                         
        	FileWriter writer = new FileWriter(destination);          
        	 
        	writer.append("Time");
        	writer.append(',');
        	writer.append("ID");
        	writer.append(',');
        	writer.append("Lat");
        	writer.append(',');
        	writer.append("Lon");
        	writer.append(',');
        	writer.append("Alt");
        	writer.append(',');
        	writer.append("WI-FI");
        	      	
    		for(int i=1;i<=10;i++)
    		{
            	String s = ""+i;
            	writer.append(',');
            	writer.append("SSID"+s);
            	writer.append(',');
            	writer.append("MAC"+s);
            	writer.append(',');
            	writer.append("Frequncy"+s);
            	writer.append(',');
            	writer.append("Signal"+s);           	
    		}
    		writer.append('\n');
    		writer.flush();
    		
        	for(int i=0;i<listOutput.size();i++)
        	{
        		writer.append(listOutput.get(i).getHead().getTime());
        		writer.append(',');
        		writer.append(listOutput.get(i).getHead().getID());
        		writer.append(',');
        		writer.append(listOutput.get(i).getHead().getLat());
        		writer.append(',');
        		writer.append(listOutput.get(i).getHead().getLon());
        		writer.append(',');
        		writer.append(listOutput.get(i).getHead().getAlt());
        		writer.append(',');
        		writer.append(listOutput.get(i).getHead().getCount());
        		writer.append(',');
        	
        		
        		for (int j=0;j<listOutput.get(i).getElement().size();j++)
        		{
        			writer.append(listOutput.get(i).getElement().get(j).getSsid());
        			writer.append(',');
        			writer.append(listOutput.get(i).getElement().get(j).getMac());
        			writer.append(',');
        			writer.append(listOutput.get(i).getElement().get(j).getChanal());
        			writer.append(',');
        			writer.append(listOutput.get(i).getElement().get(j).getSignal());
        			writer.append(',');
        		}
    			
        		writer.append('\n');
        		writer.flush();
        	}
        	writer.close();
        }        
        catch(Exception e){
        	e.printStackTrace();}
             
	}

}
