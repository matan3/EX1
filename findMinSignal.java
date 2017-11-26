import java.util.List;

public class findMinSignal {

	public int findMinSignal1(List<Wifi>  element){

		String Signal;
		int Signal2,min = 0,index = 0;

		for(int i=0;i<element.size();i++)
		{
			Signal = element.get(i).getSignal();			
			Signal2 = Integer.parseInt(Signal);
			if(min > Signal2)
			{
				min = Signal2;
				index = i;
			}
		}		
		return index;	
	}

}
