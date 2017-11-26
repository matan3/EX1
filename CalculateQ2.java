import java.util.ArrayList;
import java.util.List;

public class CalculateQ2 {
	
	public void Calculate(List<Spot> listInput,List<Row> output)
	{
		findMinSignal f=new findMinSignal();
		List<Wifi> element = new ArrayList<Wifi>();
		
		String locat = listInput.get(0).getLat()+listInput.get(0).getLon()+listInput.get(0).getAlt(); // unique geographic location
		String Time = listInput.get(0).getTime();
		
		int countWifi=0,j=0;  
		String count=""+countWifi;		
		
		for(int i=0;i<listInput.size();i++)
		{		
			if(listInput.get(i).getType().equals("WIFI")) // only wifi
			{			
				String currentLocat =  listInput.get(i).getLat()+listInput.get(i).getLon()+listInput.get(i).getAlt();			
				
				if(Time.equals(listInput.get(i).getTime()) && locat.equals(currentLocat)) // same date & locat
				{ 
					if(countWifi<10)
					{					
						countWifi++;
						Wifi insert=new Wifi(listInput.get(i).getMac(),listInput.get(i).getSSID(),listInput.get(i).getchanal(),listInput.get(i).getSignal());
						element.add(insert);
					}
					else  // only best 10 wifi
					{        				
						int minSignalIndex = f.findMinSignal1(element);  //get the index with the worst signal   	      										
						if(Integer.parseInt(listInput.get(i).getSignal()) > Integer.parseInt(element.get(minSignalIndex).getSignal()))
						{
							element.remove(minSignalIndex);
							Wifi insert=new Wifi(listInput.get(i).getMac(),listInput.get(i).getSSID(),listInput.get(i).getchanal(),listInput.get(i).getSignal());
							element.add(insert);      					
						} 
					}
				}
				else{    // new line
					
					List<Wifi> elementTemp = new ArrayList<Wifi>();
					while (!element.isEmpty()) {
						elementTemp.add(element.get(0));
						element.remove(0);
					}
					count=""+countWifi;
					Details general=new Details(listInput.get(j).getTime(),listInput.get(j).getLat(),listInput.get(j).getLon(),
							listInput.get(j).getAlt(),listInput.get(j).getID(),count);//put it in here make the first loop autmatcily					
					Row csv = new Row(elementTemp,general);
					output.add(csv);
					
					countWifi = 1; 					
					locat = listInput.get(i).getLat()+listInput.get(i).getLon()+listInput.get(i).getAlt(); // unique geographic location
					Time = listInput.get(i).getTime();
					j=i;
					
					Wifi insert=new Wifi(listInput.get(i).getMac(),listInput.get(i).getSSID(),listInput.get(i).getchanal(),listInput.get(i).getSignal());
					element.add(insert);
				}
			}
		}
		count=""+countWifi;   //  last line
		Details general=new Details(listInput.get(j).getTime(),listInput.get(j).getLat(),listInput.get(j).getLon(),
				listInput.get(j).getAlt(),listInput.get(j).getID(),count);//put it in here insert the last loop 
		
		Row csv = new Row(element,general);
		output.add(csv);	
	}

}
