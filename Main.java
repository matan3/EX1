import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		String dirPath = "C:/Users/Gilad Fuchs/workspace/Ex0";
		String desPath = "C:/Users/Gilad Fuchs/workspace/Ex0/output2.csv";

		Q2 q2 = new Q2();          // read files from directory and write to file
		boolean b = q2.ReadDir(dirPath,desPath);
		if(b){
			String srcPath = "C:/Users/Gilad Fuchs/workspace/Ex0/output2.csv";		
			Q3 q3 = new Q3();
			q3.ReadFile(srcPath);     // read file -> filter by time&ID&location -> filter by MAC -> write to kml
		}
		
		
		
	}

}
