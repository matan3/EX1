import java.util.List;

public class MacQ3 {
	public void   Mac(List<Row> listInput){
		//this function run like bubble sort it's comparing every wifi and check if the mac equal.
		//If it's find out the mac is equal it's remove the wifi with the less signal
		for (int i = 0; i < listInput.size(); i++) {
			for (int j = 0; j < listInput.get(i).getElement().size(); j++) {//the first and the second loop define the locate of the wifi to compare
				for (int i2 = i; i2 < listInput.size(); i2++) {//Define the the another wifi to compare run from the next to the first wifi we define in i and j until the end
					int j2;
					if(i2==i)//check if it's compare on the same line
						j2 = j+1;
					else
						j2 = 0;
					while ( j2 < listInput.get(i2).getElement().size()) {

						if(listInput.get(i2).getElement().get(j2).getMac().equals(listInput.get(i).getElement().get(j).getMac())){//compare mac
							if(Integer.parseInt(listInput.get(i2).getElement().get(j2).getSignal())>//compare signal and remove the wifi with the less signal
							Integer.parseInt(listInput.get(i).getElement().get(j).getSignal())){
								listInput.get(i).getElement().remove(j);
								i2 = listInput.size();
								j--;
								break;
							}
							else
							{
								listInput.get(i2).getElement().remove(j2);
								j2--;
							}
						}
						j2++;
					}
				}
			}
		}
		
	}


}
