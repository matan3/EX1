import java.util.List;

public class CalculateByLocation { //lon = x, lat = y
	
	public  List<Row> CalculateByLocation1(List<Row> listInput, List<Row> listOutput,  double Lon ,double Lat,double Radius) 
	{
		boolean find = true;
		for(int i=1;i<listInput.size();i++)
		{
			double currentLat = Double.parseDouble(listInput.get(i).getHead().getLat());  
			double currentLon = Double.parseDouble(listInput.get(i).getHead().getLon());			
			double distance = Math.sqrt(Math.pow(Lon - currentLon,2) + Math.pow(Lat - currentLat,2)); 
			// calclates distance between two points
			// d = sqrt((x1-x2)^2 + (y1-y2)^2)  
			if( distance <=  Radius)
			{				
				Row row = new Row(listInput.get(i).getElement(),listInput.get(i).getHead());
				listOutput.add(row);
				find = false;
			}			
		}	
		if(find){
			System.out.println("The filter didnt find this Location");
			return listInput;	
		}
		return listOutput;		
	}
}
