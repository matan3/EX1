import java.util.ArrayList;
import java.util.List;

public class CopyListToList {
	
	public List<Row> CopyListToList1(List<Row> listOutput) {
		List<Row> listInput = new ArrayList<Row>();
		for(int i=0;i<listOutput.size();i++){
			Row row = new Row(listOutput.get(i).getElement(),listOutput.get(i).getHead());
			listInput.add(row);		
		}
		return listInput;
	}

}
